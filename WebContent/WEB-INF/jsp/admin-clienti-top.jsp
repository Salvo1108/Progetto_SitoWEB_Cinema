<%@ page import="java.util.*,model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ include file="admin-header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Lista clienti top</h1>
	</div>
	<div class="table-responsive">
		<table class="table table-bordered table-striped">
			<tr class="active">
				<th>Utente</th>
				<th class="text-center">Numero Prenotazioni</th>
				<th class="text-center">Totale spesa</th>
			</tr>
			<%
				ArrayList<SpesaUtenteBean> inc = (ArrayList<SpesaUtenteBean>) request.getAttribute("utenti");
				for (SpesaUtenteBean tmp : inc) {
			%>

			<tr>
				<td><%=tmp.getUt().getEmail()%></td>
				<td class="text-center"><%=tmp.getNumPrenotazioni()%></td>
				<td class="text-center"><%=tmp.getSpesaTot()%>€</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>


<%@ include file="admin-footer.jsp"%>