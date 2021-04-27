<%@ page import="java.util.*,model.*"%>
<%@ include file="header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>In programmazione</h1>
	</div>
	<%
		List<FilmBean> lfilm = (List<FilmBean>) request.getAttribute("listafilm");
		for (FilmBean film : lfilm) {
		
	%>
	<div class="media">
		<div class="media-left">
			<a href="DettaglioFilm?id=<%=film.getIdFilm()%>"><img
				class="media-object thumbnail" src="<%=film.getUriLocandina()%>"
				alt="<%=film.getTitolo()%>" style="height: 200px"></a>
		</div>
		<div class="media-body">
			<h3 class="media-heading">
				<a href="DettaglioFilm?id=<%=film.getIdFilm()%>"><%=film.getTitolo()%></a>
				<small><%=film.getRegista()%> &middot; <%=film.getAnno()%>
					&middot; <%=film.getGenere()%> &middot; <%=film.getDurata()%>min</small>
			</h3>
			<p><%=film.getMetaTrama()%>...<a
					href="DettaglioFilm?id=<%=film.getIdFilm()%>">[vedi dettagli]</a>
			</p>
			<h4>
				Programmazione&nbsp;<a href="./SpettacoliServlet">[vedi]</a>
			</h4>
		</div>
		<%
			}
		%>
		<br>
		<br>
		<br> <br>
		<br>
		<br>

	</div>
	<%@ include file="footer.jsp"%>