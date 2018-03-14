package org.lua.exception;

/**
 * 数据访问权限不足
 */
public class DataAccessDeniedException extends BaseRuntimeException{


    /**
	 * 
	 */
	private static final long serialVersionUID = 2751979064536199044L;

	public DataAccessDeniedException() {
        super("无权数据访问");
    }
    
    public DataAccessDeniedException(String msg) {
        super(msg);
    }

    public DataAccessDeniedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
