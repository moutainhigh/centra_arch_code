package com.ai.opt.uniframe.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/demo")
public class DemoPageController {
	private static final Log LOG = LogFactory.getLog(DemoPageController.class);
    
    @RequestMapping("/demopage")
    public ModelAndView demopage() {
        return new ModelAndView("/demo/demopage");
    }
    @RequestMapping("/demoform")
    public ModelAndView demoform() {
    	return new ModelAndView("/demo/demoform");
    }
    

}
