package net.abhi.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		ModelAndView model=new ModelAndView("error");
				model.addObject("errorTitle","The Page Is Not Constructed!");
				model.addObject("errorDescription","The Page you are looking for is not available!");
				model.addObject("title","404 Error Page");
				return model;
		
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		ModelAndView model=new ModelAndView("error");
				model.addObject("errorTitle","Product not available!");
				model.addObject("errorDescription","The Product  you are looking for is not available right now!");
				model.addObject("title","Product Unavailable");
				return model;
		
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		ModelAndView model=new ModelAndView("error");
				model.addObject("errorTitle","Contact Your Administrator!");
				/*only to debbug our application*/
				StringWriter sw=new StringWriter();
				PrintWriter pw=new PrintWriter(sw);
				ex.printStackTrace(pw);
				model.addObject("errorDescription",sw.toString());
				model.addObject("title","Error");
				return model;
		
	}
}
