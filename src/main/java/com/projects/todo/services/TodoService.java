package com.projects.todo.services;

import com.projects.todo.beans.TodoBean;
import com.projects.todo.dao.TodoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

public class TodoService {
    private final TodoDAO todoDAO;

    public TodoService() {
        todoDAO = new TodoDAO();
    }

    public List<TodoBean> getAllTodos() {
        List<TodoBean> todos = null;
        try {
            todos = todoDAO.getAllTodos();
            return todos;
        } catch(SQLException e) {
            e.printStackTrace();
            return todos;
        }
    }

    public TodoBean getTodoByID(HttpServletRequest req, HttpServletResponse resp) {
        TodoBean todo = null;
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            todo = todoDAO.getTodoByID(id);
            return todo;
        } catch(SQLException e) {
            e.printStackTrace();
            return todo;
        }
    }

    public boolean createTodo(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        TodoBean newTodo = new TodoBean(title, summary, false);
        try {
            todoDAO.createTodo(newTodo);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTodo(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        boolean isCompleted = req.getParameter("iscompleted").equals("1");
        try {
            TodoBean todo = new TodoBean(id, title, summary, isCompleted);
            return todoDAO.updateTodo(todo);
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTodoByID(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            return todoDAO.deleteTodoByID(id);
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
