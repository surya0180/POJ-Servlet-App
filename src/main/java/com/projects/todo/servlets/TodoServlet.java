package com.projects.todo.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.projects.todo.beans.TodoBean;
import com.projects.todo.dao.TodoDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class TodoServlet extends HttpServlet {
    private TodoDAO todoDAO;

    public TodoServlet() {
        this.todoDAO = new TodoDAO();
    }

    private void listTodos(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        List<TodoBean> todos = todoDAO.getAllTodos();
        req.setAttribute("todos", todos);
        int count = 0;
        for (int i = 0; i < todos.size(); i++) {
            count++;
        }
        resp.setHeader("Surya", todos.get(0).getTitle());
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo-list.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteTodo(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        todoDAO.deleteTodoByID(id);
        resp.sendRedirect("todo-list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // try {
        // List<TodoBean> todos = todoDAO.getAllTodos();
        // req.setAttribute("todos", todos);
        // int count = 0;
        // for (int i = 0; i < todos.size(); i++) {
        // count++;
        // }
        // String[] arr = new String[2];
        // arr[0] = "SURYA";
        // arr[1] = "TEJA";
        // req.setAttribute("name", arr);
        // resp.setHeader("Surya", todos.get(0).getTitle());
        // RequestDispatcher dispatcher = req.getRequestDispatcher("todo-list.jsp");
        // dispatcher.forward(req, resp);
        // } catch (Exception e) {
        // // TODO: handle exception
        // e.printStackTrace();
        // }
        req.setAttribute("name", "Vikki");
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo-list.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.deleteTodo(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
