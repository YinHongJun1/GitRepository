package com.mashibing.json;

/**
 * @Auther:yhj
 * @Date:2022/8/10 - 08 - 10 - 20:31
 * @Description: com.mashibing.result 用于返回给前端的数据类型
 * @version: 1.0
 *
 */
public class Common {
    private String message;
    private Integer code;
    private Object result;

    public Common() {
    }

    public Common(Object result) {
        this.result = result;
    }

    public Common(String message, Integer code, Object result) {
        this.message = message;
        this.code = code;
        this.result = result;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Common{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", result=" + result +
                '}';
    }
}
