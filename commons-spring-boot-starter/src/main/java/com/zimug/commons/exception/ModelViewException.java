package com.zimug.commons.exception;

public class ModelViewException extends RuntimeException{

    //将Exception 转换为ModelViewException
    public static ModelViewException transfer(Throwable cause) {
        return new ModelViewException(cause);
    }

    private ModelViewException(Throwable cause) {
        super(cause);
    }
}