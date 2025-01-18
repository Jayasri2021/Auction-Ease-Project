package com.ACS560.AuctionEase.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuctionEaseException 
{
	    /**
	     * Generic exception handler for all other exceptions not specifically handled.
	     * Responds with HTTP 500 (Internal Server Error) and a friendly error message.
	     *
	     * @param ex The thrown {@link Exception}.
	     * @return A {@link ResponseEntity} with HTTP 500 status and a generic error message.
	     */
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handle(Exception ex) 
	    {
	        ex.printStackTrace();
	        return ResponseEntity.internalServerError().body("");
	    }
}
