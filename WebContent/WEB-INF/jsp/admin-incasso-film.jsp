<%@ page import="java.util.*,model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ include file="admin-header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Incassi per film</h1>
	</div>
	<div class="table-responsive">
		<table class="table table-bordered table-striped">
			<tr class="active">
				<th>Film</th>
				<th class="text-center">IncassoTotale</th>
				<th class="text-center">Numero Spettacoli</th>
				<th class="text-center">Incasso medio</th>
			</tr>
			<%
				ArrayList<IncassoFilmBean> inc = (ArrayList<IncassoFilmBean>) request.getAttribute("incasso");
				for (IncassoFilmBean tmp : inc) {
			%>

			<tr>
				<td><%=tmp.getFilm().getTitolo()%></td>
				<td class="text-center"><%=tmp.getIncasso()%>€</td>
				<td class="text-center"><%=tmp.getNumSpett()%></td>
				<td class="text-center"><%=tmp.getIncassoMedio()%>€</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>

<%@ include file="admin-footer.jsp"%>