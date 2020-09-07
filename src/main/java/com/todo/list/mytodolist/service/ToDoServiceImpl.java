package com.todo.list.mytodolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.list.mytodolist.dao.TodoRepository;
import com.todo.list.mytodolist.entity.Todo_list;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private TodoRepository todoRepository;
	
	
	@Override

	public List<Todo_list> showitems(String username) {
		
		return todoRepository.findByusername(username);
	}

	@Override
	
	public Optional<Todo_list> findById(int id) {
		
		return todoRepository.findById(id);
	}

	@Override

	public void saveNewTask(Todo_list todo_list) {
		todoRepository.save(todo_list);
		
	}

	@Override
	
	public void deleteATask(int item_id) {
		Optional<Todo_list> todo = todoRepository.findById(item_id);
		if (todo.isPresent()) {
			todoRepository.delete(todo.get());
		}
	}

	@Override

	public void getCurrentUser() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
