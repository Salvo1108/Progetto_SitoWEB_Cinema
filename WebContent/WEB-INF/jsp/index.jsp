<%@ page import="java.util.*,model.*"%>
<%@ include file="header.jsp"%>
<body>
	<ul class="bxslider">
		<%
			List<FilmBean> lfilm = (List<FilmBean>) request.getAttribute("listaslide");
			for (FilmBean film : lfilm) {
		%>
		<li><a href="DettaglioFilm?id=<%=film.getIdFilm()%>">
				<div class="cover"
					style="background-image:url(<%=film.getFotoSlide()%>);">
					<div class="cover-text">
						<div class="container">
							<h1><%=film.getTitolo()%>
								<small><%=film.getRegista()%> &middot; <%=film.getAnno()%>
									&middot; <%=film.getGenere()%> &middot; <%=film.getDurata()%>min</small>
							</h1>
						</div>
					</div>
				</div>
		</a></li>

		<%
			}
		%>
	</ul>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<p>
					<strong>ASR World Cinema S.r.l.</strong> offre ai propri clienti
				</p>
				<br>
				<div>
					<img alt="cinema a 2 euro" src="img/2euro.jpg" height="300"
						width="500">
				</div>
				<p>Promozione non valida con acquisto online.</p>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Listino prezzi</div>
					<div class="panel-body">
						<ul>
							<%
								List<PrezzoBean> lprezzi = (List<PrezzoBean>) request.getAttribute("listaprezzi");
								for (PrezzoBean prezzo : lprezzi) {
							%>
							<li><strong><%=prezzo.getTipo()%></strong> € <%=prezzo.getPrezzo()%>0</li>

							<%
								}
							%>
						</ul>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">Dove siamo?</div>
					<div class="panel-body">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3021.6069573365417!2d14.790096515269292!3d40.770668679325645!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bc5a579fb2a69%3A0x8fdc82da37557976!2sUniversit%C3%A0+degli+Studi+di+Salerno!5e0!3m2!1sit!2sit!4v1561033647672!5m2!1sit!2sit"
							width="335" height="290" frameborder="0" style="border: 0"
							allowfullscreen></iframe>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</div>
				</div>
			</div>
			<br>
			<br>
			<br>
		</div>
	</div>
</body>
<%@ include file="footer.jsp"%>