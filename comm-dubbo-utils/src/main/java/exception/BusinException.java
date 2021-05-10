package exception;

/**
 * @author tong.luo
 * @description BusinException
 * @date 2021/5/10 16:12
 */
public class BusinException extends RuntimeException {
    private static final long serialVersionUID = 4025782561140400336L;

    private Integer code;
    private String msg;

    public BusinException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = 403;
    }

    public BusinException(String msg, Integer code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

}
