<%@ page
	import="java.util.*,model.*,java.sql.*,java.text.SimpleDateFormat"%>

<%@ include file="header-utente.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Spettacoli</h1>
	</div>
	<%
		SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
	%>
	<table class="table table-striped">
		<tbody>
			<%
				ArrayList<Timestamp> ldat = (ArrayList<Timestamp>) request.getAttribute("date");
				ArrayList<ArrayList<FilmBean>> lfilm = (ArrayList<ArrayList<FilmBean>>) request.getAttribute("listafilm");
				int i = 0;
				for (ArrayList<FilmBean> film : lfilm) {
			%>
			<tr>
				<td>

					<h3>
						<strong><%=sf.format(ldat.get(i))%></strong>
					</h3> <%
 	for (FilmBean film1 : film) {
 %>
					<div class="row" style="float: left; margin-left: 30px;">
						<div class="panel panel-default"
							style="width: 300px; float: left;">
							<img src="<%=film1.getUriLocandina()%>"
								style="height: 115px; float: left;">
							<h5>
								<strong>&nbsp;&nbsp;<%=film1.getTitolo()%>
								</strong>
							</h5>
							<p>
								&nbsp;<a
									href="PrenotazioneServlet?id=<%=film1.getIdFilm()%>&data=<%=ldat.get(i)%>">
									Prenota</a>
							</p>
						</div>

					</div> <%
 	}
 %>
				</td>
			</tr>

			<%
				i++;
				}
			%>
		</tbody>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</div>
<%@ include file="footer.jsp"%>