package cn.edu.swpu.cins.dataCastle.exception;

/**
 * Created by miaomiao on 17-10-7.
 */
public class DataCastleException extends RuntimeException {
    public DataCastleException() {
        super();
    }

    public DataCastleException(String message) {
        super(message);
    }

    public DataCastleException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataCastleException(Throwable cause) {
        super(cause);
    }

    protected DataCastleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
