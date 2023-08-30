package com.doncurrulo.app.exception;

import org.hibernate.JDBCException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.doncurrulo.app.utilidades.GenericResponse;
import com.doncurrulo.app.utilidades.Global;

import static com.doncurrulo.app.utilidades.Global.*;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpecificExceptionHandler
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(JDBCException.class)
	public GenericResponse sqlException(JDBCException ex)
	{
		return new GenericResponse("sql-exception", -1, Global.OPERACION_ERRONEA, ex.getMessage());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public GenericResponse validException(MethodArgumentNotValidException ex)
	{
		return new GenericResponse("valid-exception", RPTA_ERROR, OPERACION_ERRONEA, ex.getMessage());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(FileStorageException.class)
	public GenericResponse fileStorageException(FileStorageException ex)
	{
		return new GenericResponse("file-storage-exception", RPTA_ERROR, OPERACION_ERRONEA, ex.getMessage());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(MyFileNotFoundException.class)
	public GenericResponse myFileNotFoundException(MyFileNotFoundException exception)
	{
		return new GenericResponse("my-file-not-found-exception", RPTA_ERROR, OPERACION_INCORRECTA, exception.getCause());
	}
}