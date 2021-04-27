<%@ page import="java.util.*,model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ include file="header-utente.jsp"%>
<div class="panel-heading">
	<br>
	<h1 style="margin-left: 30px;">Storico Prenotazioni</h1>
	<br>
</div>
<div class="table-responsive"
	style="margin-left: 30px; margin-right: 30px;">
	<table class="table table-bordered table-striped">

		<tr class="active">
			<th class="text-center">Film</th>

			<th class="text-center">Data prenotazione</th>
			<th class="text-center">Tipo biglietto</th>
		</tr>
		<%
			ArrayList<AdminPrenotazioneUtentiBean> inc = (ArrayList<AdminPrenotazioneUtentiBean>) request
					.getAttribute("prenotazione");
			for (AdminPrenotazioneUtentiBean tmp : inc) {
		%>

		<tr>
			<td class="text-center" name="titolo"><%=tmp.getFilm().getTitolo()%></td>


			<td class="text-center" name="datapren"><%=tmp.getPrenotazione().getDataOraOperazione()%></td>
			<td class="text-center" name="prezzo"><%=tmp.getPrezzo().getTipo()%></td>
		</tr>
		<%
			}
		%>
		<tbody id="prenotazioni">

		</tbody>
	</table>
</div>
<br>
<br>
<br>
<br>
<br>
<br>

<%@ include file="footer.jsp"%>