package com.swordgroup.exception;

/**
 * <p>异常-余额不足.<br>
 *
 * @author menghao.
 * @version 2018/3/30.
 */
public class MoneyNotEnoughException extends Exception {

    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }

    public MoneyNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoneyNotEnoughException(Throwable cause) {
        super(cause);
    }
}
