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
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Todo App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Todos</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="form" method="post">
					<caption>
						<h2>
									Add Todo
						</h2>
					</caption>
					
					<c:if test="${todo != null}">
						<input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Todo Title</label> <input type="text"
							value="<c:choose>
								<c:when test='${todo.title == null}'>
									<c:out value='' />
								</c:when>    
								<c:otherwise>
									<c:out value='${todo.title}' />
								</c:otherwise>
							</c:choose>" class="form-control"
							name="title" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Todo Summary</label> <input type="text"
							value="<c:choose>
								<c:when test='${todo.summary == null}'>
									<c:out value='' />
								</c:when>    
								<c:otherwise>
									<c:out value='${todo.summary}' />
								</c:otherwise>
							</c:choose>" class="form-control"
							name="summary">
					</fieldset>

					<c:if test="${todo != null}">
						<fieldset class="form-group">
							<label>Status</label> <input type="text"
								value="<c:out value='${todo.iscompleted}' />" class="form-control"
								name="iscompleted">
						</fieldset>
					</c:if>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>