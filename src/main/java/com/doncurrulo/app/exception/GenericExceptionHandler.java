package com.doncurrulo.app.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.doncurrulo.app.utilidades.GenericResponse;
import com.doncurrulo.app.utilidades.Global;

@RestControllerAdvice
public class GenericExceptionHandler
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(Exception.class)
	public GenericResponse genericException(Exception ex)
	{
		return new GenericResponse("exception", -1, Global.OPERACION_ERRONEA, ex.getMessage());
	}
}