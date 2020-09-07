package com.todo.list.mytodolist.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.list.mytodolist.entity.Todo_list;
import com.todo.list.mytodolist.exception.TaskNotFoundException;
import com.todo.list.mytodolist.service.ToDoService;

@Controller
@RequestMapping("/todo")
public class TodoDetailsRestController {
	
	public ToDoService toDoService;

	@Autowired
   public TodoDetailsRestController(ToDoService toDoService)
 {  
		this.toDoService = toDoService;
	}
public String getCurrentUser()
{
	String username=null;
Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
if (principal instanceof UserDetails) {
  username = ((UserDetails)principal).getUsername();
} else {
   username = principal.toString();
}
        return username;
	}
	
	@GetMapping("/list")
	public String getTasks(Model model)
	{
		String user_name =getCurrentUser();
		List<Todo_list> taskList= toDoService.showitems(user_name);
		model.addAttribute("alltasks", taskList);
		
		return "tasks/task-list";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String addNewTask(@ModelAttribute("addList") Todo_list todo_list)
	{
		try
		{
		todo_list.setUpdate_dt(new Date());
		todo_list.setStatus(todo_list.getStatus());
		todo_list.setUsername(getCurrentUser());
		toDoService.saveNewTask(todo_list);
		}
		catch(Exception e)
		{
		throw new TaskNotFoundException("Task cannot be saved");	
		}
		return "redirect:/todo/list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Todo_list todo_list = new Todo_list();
		model.addAttribute("addList", todo_list);
		return "tasks/task-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("item_id") int item_id, Model model)
	{
		Todo_list to_dolist= toDoService.findById(item_id).get();
		model.addAttribute("addList",to_dolist);
		return "tasks/task-form";
	}
	
	@GetMapping("/delete")
	public String deleteTask(@RequestParam("item_id")int item_id)
	{
		Todo_list to_dolist= toDoService.findById(item_id).get();
		if(to_dolist ==null)
		{
			throw new TaskNotFoundException("Task not found");
		}
		toDoService.deleteATask(item_id);
		return "redirect:/todo/list";
	}	
	
	@ExceptionHandler(TaskNotFoundException.class)
	public String handleError(TaskNotFoundException e) {

	    return "showError.html";
	}
}
