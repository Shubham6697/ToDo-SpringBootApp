package com.personal.springboottodoapplication.controllers;

import com.personal.springboottodoapplication.model.TodoItem;
import com.personal.springboottodoapplication.repositories.ToDoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TodoFormController {
    private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model){
        TodoItem todoItem = toDoItemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("TodoItem id: "+ id + "not found or not valid"));
        model.addAttribute("todo",todoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable long id, Model model){
        TodoItem todoItem = toDoItemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("TodoItem id: "+ id + "not found or not valid"));
        toDoItemRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/create-todo")
    public String addTodoItem(TodoItem todoItem){
        return "add-todo-item";
    }
}
