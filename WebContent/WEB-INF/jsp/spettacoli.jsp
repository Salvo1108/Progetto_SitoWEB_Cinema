<%@ page
	import="java.util.*,model.*,java.text.SimpleDateFormat, java.sql.*"%>
<%@ include file="header.jsp"%>
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
							style="width: 300px; float: left; ">
							<img src="<%=film1.getUriLocandina()%>"
								style="height: 115px; width:78px; float: left;">
							<h5 >
								<strong>&nbsp;&nbsp;<%=film1.getTitolo()%>
								</strong> <br><br><br>
								<span style="font-size:12px;">&nbsp;Per prenotare un posto effettua il <a href="login.html">login</a>  &nbsp;o <a href="registrazione.html">registrati</a>.</span>
							</h5>

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