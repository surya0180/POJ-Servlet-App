package com.projects.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projects.todo.beans.TodoBean;

public class TodoDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/todoapp?autoReconnect=true&useSSL=false";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "01800180";

    private static final String INSERT_TODO = "INSERT INTO TODOS" + " (title, summary) VALUES " + " (?, ?);";
    private static final String SELECT_TODO_BY_ID = "SELECT * FROM TODOS WHERE id=?;";
    private static final String SELECT_ALL_TODOS = "SELECT * FROM TODOS;";
    private static final String DELETE_TODO_BY_ID = "DELETE FROM TODOS WHERE id=?;";
    private static final String UPDATE_TODO_BY_ID = "UPDATE TODOS SET title=?, summary=?, iscompleted=? WHERE id=?;";

    protected Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void createTodo(TodoBean todo) throws SQLException {
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODO)) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getSummary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public boolean updateTodo(TodoBean todo) throws SQLException {
        boolean isUpdated = false;
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TODO_BY_ID)) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getSummary());
            preparedStatement.setInt(3, todo.isIscompleted() ? 1 : 0);
            preparedStatement.setInt(4, todo.getId());
            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public TodoBean getTodoByID(int id) throws SQLException {
        TodoBean todo = null;
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int todoId = rs.getInt("id");
                String title = rs.getString("title");
                String summary = rs.getString("summary");
                boolean isCompleted = rs.getBoolean("iscompleted");
                todo = new TodoBean(todoId, title, summary, isCompleted);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return todo;
    }

    public List<TodoBean> getAllTodos() throws SQLException {
        List<TodoBean> todos = new ArrayList<TodoBean>();
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int todoId = rs.getInt("id");
                String title = rs.getString("title");
                String summary = rs.getString("summary");
                boolean isCompleted = rs.getBoolean("iscompleted");
                todos.add(new TodoBean(todoId, title, summary, isCompleted));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return todos;
    }

    public boolean deleteTodoByID(int id) throws SQLException {
        boolean isDeleted = false;
        try (Connection connection = createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TODO_BY_ID)) {
            preparedStatement.setInt(1, id);
            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return isDeleted;
    }
}
