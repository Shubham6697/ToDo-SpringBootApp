package com.personal.springboottodoapplication.controllers;

import com.personal.springboottodoapplication.model.TodoItem;
import com.personal.springboottodoapplication.repositories.ToDoItemRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import java.time.Instant;

@Controller
public class TodoItemController {
    private final Logger log = LoggerFactory.getLogger(TodoItemController.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        log.debug("request to GET index ");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItem",toDoItemRepository.findAll());
        return modelAndView;
    }

    @PostMapping("todo/{id}")
    public String updateToDoItem(@PathVariable long id, @Valid TodoItem todoItem, BindingResult result, Model model){
        if(result.hasErrors()) {
            todoItem.setId(id);
            log.debug("Error encountered while updating todo");
            return "update-todo-item";
        }
        todoItem.setUpdateTime(Instant.now());
        toDoItemRepository.save(todoItem);
        log.debug("Update Sucessfully redirecting the page");
        return "redirect:/";
    }

    @PostMapping("/todo")
    public String addToDoItem(@Valid TodoItem todoItem, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-todo-item";
        }


        toDoItemRepository.save(new TodoItem(todoItem.getNoteDesc()));
        log.debug("Added Sucessfully redirecting the page");
        return "redirect:/";
    }
}
