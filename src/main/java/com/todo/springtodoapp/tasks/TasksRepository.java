package com.todo.springtodoapp.tasks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends CrudRepository<Task, Integer> {

}
