package com.todo.list.mytodolist.service;

import java.util.List;
import java.util.Optional;

import com.todo.list.mytodolist.entity.Todo_list;

public interface ToDoService {

	public List<Todo_list> showitems(String username); 
	 public Optional<Todo_list> findById(int id);
	 public void saveNewTask(Todo_list todo_list);
	 public void deleteATask(int item_id);
	 public void getCurrentUser();
}
