package org.lua.exception;

public class DuplicateTokenException extends BaseRuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7434328686622036487L;

	public DuplicateTokenException(String msg) {
        super(msg);
    }

    public DuplicateTokenException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
