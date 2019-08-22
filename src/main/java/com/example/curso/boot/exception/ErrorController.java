package com.example.curso.boot.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

	public static final String DEFAULT_ERROR_VIEW = "error";

	private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exceptionThrowable(final HttpServletRequest request , final Throwable throwable, Exception ex, final Model model) {
		logger.info("Throwable Occured:: URL="+request.getRequestURL());
		logger.error("Exception during execution of SpringSecurity application", throwable);
		
		String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");

		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		model.addAttribute("error", errorMessage);
		model.addAttribute("message", errorMessage);

		return DEFAULT_ERROR_VIEW;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public String DataIntegrityViolationException(final HttpServletRequest request, final Throwable throwable, final Exception ex,  final Model model){
		logger.info("DataIntegrityViolationException Occured:: URL="+request.getRequestURL());
		logger.error("Exception during execution of SpringSecurity application", throwable);

		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		model.addAttribute("error", "Dados Duplicados");
		model.addAttribute("message", ex.getMessage());

		return DEFAULT_ERROR_VIEW;
	}

	@ExceptionHandler(SQLException.class)
	public String sqlLException(HttpServletRequest request, final Throwable throwable, final Exception ex, final Model model){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		logger.error("Exception during execution of SpringSecurity application", throwable);

		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		model.addAttribute("error", ex.getMessage());
		model.addAttribute("message", ex.getMessage());

		return DEFAULT_ERROR_VIEW;
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void IOException(final HttpServletRequest request,  final Throwable throwable, final Exception ex,  final Model model){

		logger.info("DataIntegrityViolationException Occured:: URL="+request.getRequestURL());
		logger.error("Exception during execution of SpringSecurity application", throwable);

		model.addAttribute("status", HttpStatus.NOT_FOUND);
		model.addAttribute("error", ex.getMessage());
		model.addAttribute("message", ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(HttpServletRequest request, final Throwable throwable, final Exception ex, final Model model){
		logger.info("Exception Occured:: URL="+request.getRequestURL());
		logger.error("Exception during execution of SpringSecurity application", throwable);
		
		String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");

		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		model.addAttribute("error", errorMessage);
		model.addAttribute("message",errorMessage);

		return DEFAULT_ERROR_VIEW;
	}


	//IllegalArgumentException
	// EmptyResultDataAccessException 
	// DataIntegrityViolationException
	//org.hibernate.exception.ConstraintViolationException



	//	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	//	@ExceptionHandler(IOException.class)
	//	public void handleIOException(){
	//		logger.error("IOException handler executed");
	//		//returning 404 error code
	//	}

}