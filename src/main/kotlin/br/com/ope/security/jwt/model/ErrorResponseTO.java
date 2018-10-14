package br.com.ope.security.jwt.model;

import org.springframework.http.HttpStatus;

import java.util.Date;


public class ErrorResponseTO {
	private final HttpStatus status;
	private final String message;
	private final ErrorCode errorCode;

	private final Date timestamp;

	protected ErrorResponseTO(final String message, final ErrorCode errorCode, HttpStatus status) {
		this.message = message;
		this.errorCode = errorCode;
		this.status = status;
		this.timestamp = new Date();
	}

	public static ErrorResponseTO of(final String message, final ErrorCode errorCode, HttpStatus status) {
		return new ErrorResponseTO(message, errorCode, status);
	}

	public Integer getStatus() {
		return status.value();
	}

	public String getMessage() {
		return message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}
}
