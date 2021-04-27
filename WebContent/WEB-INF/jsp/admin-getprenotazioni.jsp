<%@ page import="java.util.*,model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ include file="admin-header.jsp"%>
<div class="panel-heading">
	<br>
	<h1 style="margin-left: 30px;">Prenotazioni</h1>
	<br>
</div>
<div class="table-responsive"
	style="margin-left: 30px; margin-right: 30px;">
	<table class="table table-bordered table-striped">

		<tr class="active">
			<th class="text-center">Film</th>
			<th class="text-center">Data programmazione</th>
			<th class="text-center">Sala</th>
			<th class="text-center">Posto</th>
			<th class="text-center">Utente</th>
			<th class="text-center">Data prenotazione</th>
			<th class="text-center">Tipo biglietto</th>

			<th class="text-center">Elimina</th>
		</tr>
		<%
			ArrayList<AdminPrenotazioneUtentiBean> inc = (ArrayList<AdminPrenotazioneUtentiBean>) request.getAttribute("info");
			for (AdminPrenotazioneUtentiBean tmp : inc) {
		%>

		<tr>
			<td class="text-center" name="titolo"><%=tmp.getFilm().getTitolo()%></td>
			<td class="text-center" name="dataspet"><%=tmp.getSpettacolo().getTimeStamp()%>
			<td class="text-center" name="nomesala"><%=tmp.getSala().getNome()%></td>
			<td class="text-center" name="posto"><%=tmp.getPosto().getRiga()%><%=tmp.getPosto().getColonna()%></td>
			<td class="text-center" name="email"><%=tmp.getUtente().getEmail()%></td>
			<td class="text-center" name="datapren"><%=tmp.getPrenotazione().getDataOraOperazione()%></td>
			<td class="text-center" name="prezzo"><%=tmp.getPrezzo().getTipo()%></td>
			<td class="text-center"><a
				href="AdminRimuoviPrenotazione?id=<%=tmp.getPrenotazione().getIdPrenotazione()%>"><img
					src="img/x.png" width="20px" height="20px"></a></td>
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

<%@ include file="admin-footer.jsp"%>