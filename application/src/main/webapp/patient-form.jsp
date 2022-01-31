<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Add Patient </a>
			</div>

		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${patient != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${patient == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${patient != null}">
            			Edit Patient
            		</c:if>
						<c:if test="${patient == null}">
            			Add New Patient
            		</c:if>
					</h2>
				</caption>

				<c:if test="${patient != null}">
					<input type="hidden" name="id" value="<c:out value='${patient.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First name</label> <input type="text"
						value="<c:out value='${patient.firstname}' />" class="form-control"
						name="firstname" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Last name</label> <input type="text"
						value="<c:out value='${patient.lastname}' />" class="form-control"
						name="lastname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Doctor name</label> <input type="text"
						value="<c:out value='${patient.docname}' />" class="form-control"
						name="docname">
				</fieldset>

				<fieldset class="form-group">
					<label>Speciality</label> <input type="text"
						value="<c:out value='${patient.speciality}' />" class="form-control"
						name="speciality">
				</fieldset>
                <fieldset class="form-group">
					<label>Rapport</label> <input type="text"
						value="<c:out value='${patient.rapport}' />" class="form-control"
						name="rapport">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>