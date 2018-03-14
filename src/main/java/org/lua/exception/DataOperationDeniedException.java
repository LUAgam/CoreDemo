package org.lua.exception;

/**
 * 数据操作无权
 */
public class DataOperationDeniedException extends BaseRuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3275570605990909374L;

	public DataOperationDeniedException() {
        super("无效数据操作");
    }
    
    public DataOperationDeniedException(String msg) {
        super(msg);
    }

    public DataOperationDeniedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
