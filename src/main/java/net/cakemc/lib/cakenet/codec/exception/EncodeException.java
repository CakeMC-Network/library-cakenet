package net.cakemc.lib.cakenet.codec.exception;

public class EncodeException extends Throwable {

	public EncodeException() {
	}

	public EncodeException(String message) {
		super(message);
	}

	public EncodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public EncodeException(Throwable cause) {
		super(cause);
	}

	public EncodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
