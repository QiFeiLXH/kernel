package com.bsoft.common.aop;

import com.bsoft.common.annotation.ManyTransaction;
import com.bsoft.common.spring.SpringContextUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Stack;

/*
 * @author  hy
 * @date  2020/4/15 17:25
 * @description
 */
@Aspect
@Configuration
public class TransactionAop {
    final Logger logger = LogManager.getLogger(TransactionAop.class);


    @Pointcut("@annotation(com.bsoft.common.annotation.ManyTransaction)")
    public void CustomTransaction() {
    }


    @Pointcut("execution(* com.bsoft.*.manager..*.*(..))")
    public void execudeManager() {
    }


    @Around(value = "CustomTransaction()&&execudeManager()&&@annotation(annotation)")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint, ManyTransaction annotation) throws Throwable {
        Stack<PlatformTransactionManager> platformTransactionManagerStack = new Stack<PlatformTransactionManager>();
        Stack<TransactionStatus> transactionStatuStack = new Stack<TransactionStatus>();

        try {

            if (!openTransaction(platformTransactionManagerStack, transactionStatuStack, annotation)) {
                return null;
            }

            Object ret = thisJoinPoint.proceed();

            commit(platformTransactionManagerStack, transactionStatuStack);

            return ret;
        } catch (Throwable e) {

            rollback(platformTransactionManagerStack, transactionStatuStack);

            logger.error(String.format("MultiTransactionalAspect, method:%s-%s occors error:",
                    thisJoinPoint.getTarget().getClass().getSimpleName(), thisJoinPoint.getSignature().getName()), e);
            throw e;
        }
    }

    /**
     * 开启事务处理方法
     *
     * @param platformTransactionManagerStack
     * @param transactionStatuStack
     * @param multiTransactional
     * @return
     */
    private boolean openTransaction(Stack<PlatformTransactionManager> platformTransactionManagerStack,
                                    Stack<TransactionStatus> transactionStatuStack, ManyTransaction multiTransactional) {

        String[] transactionMangerNames = multiTransactional.value();
        if (multiTransactional.value().length == 0) {
            return false;
        }

        for (String beanName : transactionMangerNames) {
            PlatformTransactionManager platformTransactionManager = (PlatformTransactionManager) SpringContextUtil.getBean(beanName);
            TransactionStatus transactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
            transactionStatuStack.push(transactionStatus);
            platformTransactionManagerStack.push(platformTransactionManager);
        }
        return true;
    }

    /**
     * 提交处理方法
     * @param platformTransactionManagerStack
     * @param transactionStatuStack
     */
    private void commit(Stack<PlatformTransactionManager> platformTransactionManagerStack,
                        Stack<TransactionStatus> transactionStatuStack) {
        while (!platformTransactionManagerStack.isEmpty()) {
            platformTransactionManagerStack.pop().commit(transactionStatuStack.pop());
        }
    }

    /**
     * 回滚处理方法
     * @param platformTransactionManagerStack
     * @param transactionStatuStack
     */
    private void rollback(Stack<PlatformTransactionManager> platformTransactionManagerStack,
                          Stack<TransactionStatus> transactionStatuStack) {
        while (!platformTransactionManagerStack.isEmpty()) {
            platformTransactionManagerStack.pop().rollback(transactionStatuStack.pop());
        }
    }

}
