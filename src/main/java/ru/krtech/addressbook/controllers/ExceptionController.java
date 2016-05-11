package ru.krtech.addressbook.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by m.filippov on 11.05.16
 */
@Controller
public class ExceptionController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error");
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Throwable exception = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        mav.addObject("status", status.toString());
        mav.addObject("exception", exception);
        return mav;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
