package com.te.mailwebapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.mailwebapp.customexp.MailException;

@ControllerAdvice
public class MailControllerAdvice {

	@ExceptionHandler(MailException.class)
	public String handleExp(MailException exception,HttpServletRequest req ) {
		req.setAttribute("errMsg", exception.getMessage());
		return "empLogin";
	}// 

}
