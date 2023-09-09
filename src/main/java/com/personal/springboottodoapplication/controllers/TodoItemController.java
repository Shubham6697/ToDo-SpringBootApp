package com.personal.springboottodoapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoItemController {
    private final Logger log = LoggerFactory.getLogger(TodoItemController.class);

    @GetMapping("/")
    public ModelAndView index() {
        log.debug("request to GET index");
        return new ModelAndView("index");
    }
}
