package org.jeecg.modules.demo.dzzz.dataExchange.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常信息
 */
@Data
@Slf4j
public class YwException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public YwException() {
        super();
    }

    public YwException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public YwException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public YwException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorMsg = errorMsg;
    }

    public YwException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
