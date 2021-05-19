package com.bsoft.common.schoolMessage;

/**
 * 调用接口统一返回格式
 */
public class ResultJavaRegisterEntity {

    /**
     * 状态码
     */
    private int code;

    /**
     *
     */
    private int totalcount;

    /**
     * 成功执行后返回的数据(Json格式字符串)
     */
    private String data;

    /**
     * 成功执行后返回的数据(Json格式字符串)
     */
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultJavaRegisterEntity{" +
                "code=" + code +
                ", totalcount=" + totalcount +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
