package net.cakemc.networking.codec.exception;

public class HandlerException extends Throwable {

	public HandlerException() {
	}

	public HandlerException(String message) {
		super(message);
	}

	public HandlerException(String message, Throwable cause) {
		super(message, cause);
	}

	public HandlerException(Throwable cause) {
		super(cause);
	}

	public HandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
