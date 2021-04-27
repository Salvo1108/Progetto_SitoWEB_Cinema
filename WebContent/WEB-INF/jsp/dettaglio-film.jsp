<%@ page import="java.util.*,model.*"%>
<%if (request.getSession()==null) {%>
	<%@ include file="header.jsp"%>
<%} else { %>
		<%@ include file="header.jsp"%>
<%} %>
<div class="container">
	<div class="page-header">
		<%
			FilmBean film = (FilmBean) request.getAttribute("dettagliofilm");
		%>
		<h1><%=film.getTitolo()%></h1>
	</div>
	<div class="row">
		<div id="1" class="col-md-3">
			<img class="media-object thumbnail" src="<%=film.getUriLocandina()%>"
				alt="locandina" style="height: 400px">
		</div>
		<div id="2" class="col-md-9">
			<p>
				<strong>Regista: </strong><%=film.getRegista()%></p>
			<p>
				<strong>Genere: </strong><%=film.getGenere()%></p>
			<p>
				<strong>Durata: </strong><%=film.getDurata()%>minuti
			</p>
			<p>
				<strong>Trama: </strong><%=film.getTrama()%></p>
			<p>
				<strong>Programmazione</strong>
			</p>
			<%
				List<SpettacoloBean> spec = (List<SpettacoloBean>) request.getAttribute("dettagliorario");
				for (SpettacoloBean lspec : spec) {
			%>
			<ul>
				<li><%=lspec.getTimeStamp()%></li>
			</ul>
			<%
				}
			%>
		</div>
	</div>

	<p>
	<h4>
		<strong>Trailer</strong>
	</h4>
	</p>
	<iframe width="560" height="315" src="<%=film.getUrlTrailer()%>"
		frameborder="0"
		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</div>
<%@ include file="footer.jsp"%>