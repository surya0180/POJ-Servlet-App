package com.projects.todo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.projects.todo.beans.TodoBean;
import com.projects.todo.dao.TodoDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class TodoUpdateServlet extends HttpServlet {
    private TodoDAO todoDAO;

    public TodoUpdateServlet() {
        this.todoDAO = new TodoDAO();
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        req.setAttribute("todo", null);
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TodoBean todo = todoDAO.getTodoByID(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("todo-form.jsp");
        req.setAttribute("todo", todo);
        dispatcher.forward(req, resp);
    }

    private void createTodo(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        TodoBean newTodo = new TodoBean(title, summary, false);
        todoDAO.createTodo(newTodo);
        String location = req.getContextPath();
        resp.sendRedirect(location + "/");
    }

    private void updateTodo(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        boolean isCompleted = req.getParameter("iscompleted") == "true";

        TodoBean todo = new TodoBean(id, title, summary, isCompleted);
        todoDAO.updateTodo(todo);
        resp.sendRedirect("todo-list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // String action = req.getParameter("action");
            // resp.addHeader("Surya", action);
            // if (action.equals("add")) {
            this.showNewForm(req, resp);
            // } else {
            // this.showEditForm(req, resp);
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.createTodo(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.updateTodo(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
