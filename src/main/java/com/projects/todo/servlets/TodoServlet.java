package com.projects.todo.servlets;

import java.io.IOException;
import java.util.List;

import com.projects.todo.beans.TodoBean;

import com.projects.todo.services.TodoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class TodoServlet extends HttpServlet {
    private final TodoService todoService;

    public TodoServlet() {
        this.todoService = new TodoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatch = null;
        String location = req.getContextPath();
        try {
            String path = req.getServletPath();
            switch (path) {
                case "/new-form":
                    dispatch = req.getRequestDispatcher("todo-form.jsp");
                    dispatch.forward(req, resp);
                    break;
                case "/edit-form":
                    TodoBean todo = todoService.getTodoByID(req, resp);
                    req.setAttribute("todo", todo);
                    dispatch = req.getRequestDispatcher("todo-form.jsp");
                    dispatch.forward(req, resp);
                    break;
                case "/delete":
                    boolean status = todoService.deleteTodoByID(req, resp);
                    req.setAttribute("status", status);
                    resp.sendRedirect(location+"/");
                    break;
                default:
                    List<TodoBean> todos = todoService.getAllTodos();
                    req.setAttribute("todos", todos);
                    dispatch = req.getRequestDispatcher("todo-list.jsp");
                    dispatch.forward(req, resp);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String location = req.getContextPath();
            String id = req.getParameter("id");
            if(id != null) {
                this.doPut(req, resp);
                return;
            }
            boolean status = todoService.createTodo(req, resp);
            req.setAttribute("status", status);
            resp.sendRedirect(location+"/");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String location = req.getContextPath();
            boolean status = todoService.updateTodo(req, resp);
            req.setAttribute("status", status);
            resp.sendRedirect(location + "/");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
