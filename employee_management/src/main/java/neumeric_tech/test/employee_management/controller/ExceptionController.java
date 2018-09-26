package neumeric_tech.test.employee_management.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView handleEmpNotFoundError(HttpServletRequest req, EmployeeNotFoundException ex) {
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
}
