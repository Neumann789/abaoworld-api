package com.fz.abaoworld.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.fz.abaoworld.controller")  
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{  
  
    public JsonpAdvice() {  
  
        super("callback","jsonp");  
    }  
} 