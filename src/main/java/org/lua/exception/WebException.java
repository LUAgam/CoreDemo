package org.lua.exception;

public class WebException extends BaseRuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3921296174349777852L;

	public WebException(String msg) {
        super(msg);
    }

    public WebException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
