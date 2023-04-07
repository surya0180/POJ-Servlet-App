<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!-- <html>
  <head>
    <title>Todo Application</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <header>
      <nav
        class="navbar navbar-expand-md navbar-dark"
        style="background-color: tomato"
      >
        <div>
          <a href="" class="navbar-brand"> Todo App </a>
        </div>

        <ul class="navbar-nav">
          <li>
            <a href="<%=request.getContextPath()%>/" class="nav-link">Todos</a>
          </li>
        </ul>
      </nav>
    </header>
    <br />
    <c:out value="HEY THERE" />
    <div class="row">

      <div class="container">
        <h3 class="text-center">List of Todos</h3>
        <hr />
        <div class="container text-left">
          <a href="<%=request.getContextPath()%>/form" class="btn btn-success"
            >Add New Todo</a
          >
        </div>
        <br />
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Summary</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="todo" items="${todos}">
              <c:out value="${todo}" />
              <tr>
                <td><c:out value="${todo.id}" /></td>
                <td><c:out value="${todo.title}" /></td>
                <td><c:out value="${todo.summary}" /></td>
                <td><c:out value="${todo.iscompleted}" /></td>
                <td>
                  <a href="edit?id=<c:out value='${todo.id}' />">Edit</a>
                  &nbsp;&nbsp;&nbsp;&nbsp;
                  <a href="delete?id=<c:out value='${todo.id}' />">Delete</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html> -->

<html>
  <head>
    <title>Error</title>
  </head>
  <body>
    <center>
      <h2>
        <!-- <c:forEach var="nm" items="${arr}">
          <c:out value="${nm}" />
          <tr>
            <td><c:out value="${todo.id}" /></td>
            <td><c:out value="${todo.title}" /></td>
            <td><c:out value="${todo.summary}" /></td>
            <td><c:out value="${todo.iscompleted}" /></td>
            <td>
              <a href="edit?id=<c:out value='${todo.id}' />">Edit</a>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <a href="delete?id=<c:out value='${todo.id}' />">Delete</a>
            </td>
          </tr>
        </c:forEach> -->
        <c:out value="${name}" />
        Surya
      </h2>
    </center>
  </body>
</html>
