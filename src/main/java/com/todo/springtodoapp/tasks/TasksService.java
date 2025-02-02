package com.todo.springtodoapp.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.springtodoapp.tasks.exceptions.descSizeOverflowException;
import com.todo.springtodoapp.tasks.exceptions.emptyDescException;
import com.todo.springtodoapp.tasks.exceptions.emptyTitleException;
import com.todo.springtodoapp.tasks.exceptions.titleSizeOverflowException;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    private final int TITLE_MAX_SIZE = 255;
    private final int DESC_MAX_SIZE = 65535;
    private final int TITLE_EMPTY = 0;
    private final int DESC_EMPTY = 0;

    private final String TITLE_MAX_SIZE_ERR_MSG = "Title size shouldn't exceed 255 characters";
    private final String DESC_MAX_SIZE_ERR_MSG = "Description size shouldn't exceed 65,535 characters";

    private final String TITLE_EMPTY_ERR_MSG = "Title shouldn't be empty";
    private final String DESC_EMPTY_ERR_MSG = "Description shouldn't be empty";

    public Iterable<Task> findAll() {
        return tasksRepository.findAll();
    }

    public Task save(String title, String desc) {

        if (title.length() == TITLE_EMPTY) {
            throw new emptyTitleException(TITLE_EMPTY_ERR_MSG);
        }

        if (title.length() > TITLE_MAX_SIZE) {
            throw new titleSizeOverflowException(TITLE_MAX_SIZE_ERR_MSG);
        }

        if (desc.length() == DESC_EMPTY) {
            throw new emptyDescException(DESC_EMPTY_ERR_MSG);
        }

        if (desc.length() > DESC_MAX_SIZE) {
            throw new descSizeOverflowException(DESC_MAX_SIZE_ERR_MSG);
        }

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(desc);

        tasksRepository.save(task);

        return task;

    }

    public Task put(Integer id, String title, String desc) {

        Task task = tasksRepository.findById(id).orElseThrow();

        if (title.length() == TITLE_EMPTY) {
            throw new emptyTitleException(TITLE_EMPTY_ERR_MSG);
        }

        if (title.length() > TITLE_MAX_SIZE) {
            throw new titleSizeOverflowException(TITLE_MAX_SIZE_ERR_MSG);
        }

        if (desc.length() == DESC_EMPTY) {
            throw new emptyDescException(DESC_EMPTY_ERR_MSG);
        }

        if (desc.length() > DESC_MAX_SIZE) {
            throw new descSizeOverflowException(DESC_MAX_SIZE_ERR_MSG);
        }

        task.setTitle(title);
        task.setDescription(desc);
        tasksRepository.save(task);

        return task;

    }

    public void delete(Integer id) {

        Task task = tasksRepository.findById(id).orElseThrow();
        tasksRepository.delete(task);

    }
}