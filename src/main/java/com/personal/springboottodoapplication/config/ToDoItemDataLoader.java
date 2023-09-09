package com.personal.springboottodoapplication.config;

import com.personal.springboottodoapplication.model.TodoItem;
import com.personal.springboottodoapplication.repositories.ToDoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class ToDoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(ToDoItemDataLoader.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;
    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        logger.debug("load data method is getting started");
        if(toDoItemRepository.count() == 0) {
            toDoItemRepository.save(new TodoItem("save the time"));
            toDoItemRepository.save(new TodoItem("Drink water every 30 minutes"));
        }

        logger.info("Number of ToDoItem is {}",toDoItemRepository.count());
    }
}
