package common;

import enums.CodeMsgEnums;

import java.io.Serializable;

/**
 * @author tong.luo
 * @description BaseRet
 * @date 2021/5/7 17:00
 */
public class BaseRet<T> implements Serializable {
    private static final long serialVersionUID = 6744232898823589861L;
    private T data;
    private Integer code;
    private String msg;

    public BaseRet() {
        code = CodeMsgEnums.SYS_SUCCESS.getCode();
        msg = CodeMsgEnums.SYS_SUCCESS.getMsg();
    }

    public BaseRet(T t, Integer code, String msg) {
        this.data = t;
        this.code = code;
        this.msg = msg;
    }

    public BaseRet(T t) {
        this.data = t;
        code = CodeMsgEnums.SYS_SUCCESS.getCode();
        msg = CodeMsgEnums.SYS_SUCCESS.getMsg();
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
