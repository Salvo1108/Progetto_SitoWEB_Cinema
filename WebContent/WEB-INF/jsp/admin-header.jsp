<%@ page
	import="java.util.*,model.*,java.sql.*,java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/material-design-iconic-font.min.css" rel="stylesheet">
<link href="css/jquery.bxslider.css" rel="stylesheet">
<link href="css/cinema.css" rel="stylesheet">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.jcarousel.min.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<script src="js/cinema.js"></script>



<title>Amministratore ASR World Cinema</title>

</head>
<body>
	<header>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="AdminHome"><i
						class="zmdi zmdi-movie-alt zmdi-right-8"></i>ASR World Cinema</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="AdminHome"><i
								class="zmdi zmdi-home zmdi-right-8"></i>Home</a></li>
						<li><a href="AdminIncassoFilm"><i
								class="zmdi zmdi-movie zmdi-right-8"></i>Incassi Film</a></li>
						<li><a href="AdminClientiTop"><i
								class="zmdi zmdi-account-circle zmdi-right-8"></i>Clienti Top</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"><i
								class="zmdi zmdi-account-circle zmdi-right-8"></i>Spettacoli <i
								class="zmdi zmdi-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="admin-spettacoli.jsp">Aggiungi</a></li>
								<li><a href="admin-rspettacoli.jsp">Rimuovi</a></li>
							</ul></li>

						<li><a href="AdminGetPrenotazione"><i
								class="zmdi zmdi-assignment-check zmdi-right-8"></i>Prenotazioni</a></li>
						<li><a href="Logout"><i
								class="zmdi zmdi-close zmdi-right-8"></i>Esci</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>