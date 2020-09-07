package com.todo.list.mytodolist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo_list")
public class Todo_list {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="item_id")
	private int item_id;
	
	@Column(name ="user_id")
	private int user_id;
	
	@Column(name ="username")
	 private String username;
	
	@Column(name ="description")
	
	private String description;
	
	@Column(name ="status")
	private String status;
	
	@Column(name ="create_dt")
	private Date create_dt;
	
	@Column(name ="update_dt")
	private Date update_dt;
	
	public Todo_list()
	{}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}

	public Date getUpdate_dt() {
		return update_dt;
	}

	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}

	public Todo_list(int item_id, int user_id, String username, String description, String status, Date create_dt,
			Date update_dt) {
		super();
		this.item_id = item_id;
		this.user_id = user_id;
		this.username = username;
		this.description = description;
		this.status = status;
		this.create_dt = create_dt;
		this.update_dt = update_dt;
	}

	@Override
	public String toString() {
		return "Todo_details [user_id=" + user_id + ", username=" + username + ", description=" + description
				+ ", status=" + status + ", create_dt=" + create_dt + ", update_dt=" + update_dt + "]";
	}

}
