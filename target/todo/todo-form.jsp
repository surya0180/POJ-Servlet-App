<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<title>Todo Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: darkolivegreen">
			<div>
				<a href="<%=request.getContextPath()%>/" class="navbar-brand"> Todo App </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="TodoServlet" method="post">
					<caption>
						<h2>Add Todo</h2>
					</caption>
					<c:if test="${todo != null}">
						<input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
					</c:if>
					<fieldset class="form-group">
						<label>Todo Title</label>
						<input
							type="text"
							value="${todo == null ? "" : todo.title}"
							class="form-control"
							name="title"
							required="required"
						>
					</fieldset>

					<fieldset class="form-group">
						<label>Todo Summary</label>
						<input
							type="text"
							value="${todo == null ? "" : todo.summary}"
							class="form-control"
							name="summary"
						>
					</fieldset>

					<c:if test="${todo != null}">
						<fieldset class="form-group">
							<label>Status</label>
							<select class="form-select" aria-label="Completion status" name="iscompleted">
								<option ${todo.iscompleted == false ? 'selected' : ''} value="0">Incomplete</option>
								<option ${todo.iscompleted == true ? 'selected' : ''} value="1">Completed</option>
							</select>
						</fieldset>
					</c:if>

					<button type="submit" class="btn btn-info">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>