<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
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
        style="background-color: darkolivegreen"
      >
        <div>
          <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Todo App </a>
        </div>
      </nav>
    </header>
    <br />
    <div class="row">
      <div class="container">
        <h3>List of Todos</h3>
        <hr style="width: 2em"/>
        <div class="container text-left">
          <a href="<%=request.getContextPath()%>/new-form" class="btn btn-info"
            >Add New Todo</a
          >
        </div>
        <br />
        <c:if test="${todos.size() == 0}">
          <div class="text-center">
            <h4>Nothing to do.</h4>
          </div>
        </c:if>
        <div class="d-flex" style="gap: 1em;flex-wrap: wrap">
          <c:forEach var="todo" items="${todos}">
            <div class="card" style="width: 18rem;">
              <div class="card-body">
                <h5 class="card-title">${todo.title}</h5>
                <h6 class="card-subtitle mb-2 text-muted"><b>Status: </b> ${todo.iscompleted}</h6>
                <p class="card-text">${todo.summary}</p>
                <a href="edit-form?id=<c:out value='${todo.id}' />" class="btn btn-secondary">Edit</a>
                <a href="delete?id=<c:out value='${todo.id}' />" class="btn btn-danger">Delete</a>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </body>
</html>
