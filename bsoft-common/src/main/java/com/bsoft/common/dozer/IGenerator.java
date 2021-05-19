package com.bsoft.common.dozer;

import com.bsoft.common.result.Result;
import com.bsoft.file.document.common.result.FileResult;
import com.bsoft.workflow.common.result.WFResult;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public interface IGenerator {
    /**
     * @Description: 单个对象的深度复制及类型转换，vo/domain , po
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:53:24
     */
    <T, S> T convert(S s, Class<T> clz);

    /**
     * @Description: list深度复制
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:54:08
     */
    <T, S> List<T> convert(List<S> s, Class<T> clz);

    /**
     * @Description: set深度复制
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:54:39
     */
    <T, S> Set<T> convert(Set<S> s, Class<T> clz);

    /**
     * @Description: 数组深度复制
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     * @author banjuer@outlook.com
     * @Time 2018年5月9日 下午3:54:57
     */
    <T, S> T[] convert(S[] s, Class<T> clz);

    /**
     * @Description: Result深度复制
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     * @author zhanglf
     * @Time 2019年12月16日 上午11:09:57
     */
    <T,S> Result<T> convert(Result<S> s,Class<T> clz);

    /**
     * @Description: Result深度复制 ---workflow
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     * @author zhanglf
     * @Time 2019年12月16日 上午11:09:57
     */
    <T, S> Result<T> convert(WFResult<S> s, Class<T> clz);

    /**
     * @Description: Result深度复制 ---file
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     * @author zy
     * @Time 2020年08月18日
     */
    <T, S> Result<T> convert(FileResult<S> s, Class<T> clz);
}
