<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<link href="css/material-design-iconic-font.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">


<div class="container" align="center">
	<div class="page-header">
		<h2 class="form-signin-heading">PAGAMENTO ANDATO A BUON FINE </h2>
		<a href="AreaUtente?utente=<%=request.getSession().getAttribute("user")%>"><button
				class="btn btn-lg btn-primary btn-block"
				style="width: 150px;">Home</button></a>
	</div>
<% request.getSession().removeAttribute("carrello"); %>
	<br>
	<br>
	<br>
	<br>
	<br>
</div>
