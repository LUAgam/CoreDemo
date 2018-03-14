package org.lua.exception;

public class ServiceException extends BaseRuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 99620137422110862L;

	public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
