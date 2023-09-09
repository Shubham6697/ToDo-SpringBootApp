package com.personal.springboottodoapplication.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.CloseableThreadContext;

import java.time.Instant;

@Entity
@Table(name="todo_item")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String noteDesc;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private Instant createTime;

    @Getter
    @Setter
    private Instant updateTime;


    public TodoItem() {
    }

    public TodoItem(String noteDesc) {
        this.noteDesc = noteDesc;
        this.complete = false;
        this.createTime = Instant.now();
        this.updateTime = Instant.now();
    }

    @Override
    public String toString() {
        /*return "TodoItem{" +
                "id=" + id +
                ", noteDesc='" + noteDesc + '\'' +
                ", complete=" + complete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
        */
        return String.format("TodoItem{ id = %d, noteDesc = '%s', complete = '%s', createTime = '%s', updateTime = '%s'}",
                id, noteDesc, complete, createTime, updateTime);
    }


}
