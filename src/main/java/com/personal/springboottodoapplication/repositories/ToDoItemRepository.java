package com.personal.springboottodoapplication.repositories;

import com.personal.springboottodoapplication.model.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface ToDoItemRepository extends CrudRepository<TodoItem, Long> {
}
