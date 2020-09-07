package com.todo.list.mytodolist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.list.mytodolist.entity.Todo_list;

public interface TodoRepository extends JpaRepository<Todo_list, Integer>{
	List<Todo_list> findByusername(String user);
}
