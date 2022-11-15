package com.dev.shopserver.common.exception;

import com.dev.shopserver.common.Constants;
import org.springframework.http.HttpStatus;

public class ShopServerException extends Exception{

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public ShopServerException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus,
                               String message){
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    /**
     * HttpStatus의 코드를 반환한다.
     * ex) 400
     */
    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    /**
     * HttpStatus의 ResonPhrase를 반환한다.
     * ex) "Bad Request"
     */
    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
