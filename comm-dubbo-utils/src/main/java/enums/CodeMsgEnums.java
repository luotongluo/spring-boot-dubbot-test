package enums;

/**
 * @author tong.luo
 * @description codeEnums
 * @date 2021/5/7 17:16
 */
public enum CodeMsgEnums {
    SYS_SUCCESS(200, "操作成功"),
    SYS_ERR403(403, "操作失败"),
    SYS_ERR500(500, "系统异常"),
    ;
    private Integer code;
    private String msg;

    CodeMsgEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
