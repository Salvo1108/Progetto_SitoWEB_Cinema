<%@ page import="java.util.*,model.*,java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ include file="header-utente.jsp"%>
<div class="panel-heading">
	<br>
	<h1 style="margin-left: 30px;">Carrello</h1>
	<br>
</div>
<div class="table-responsive"
	style="margin-left: 30px; margin-right: 30px;">
	<table class="table table-bordered table-striped">

		<tr class="active">
			<th class="text-center">Film</th>
			<th class="text-center">Sala e Ora</th>
			<th class="text-center">Prezzo</th>
			<th class="text-center">Posti	</th>
			<th class="text-center">Elimina</th>
		</tr>
		<% SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
		CarrelloSession car = (CarrelloSession)request.getSession().getAttribute("carrello");
		ArrayList<CarrelloSession.Prenotazione> prenotazioni= car.getPrenotazioni();
		int i=0;
			for(CarrelloSession.Prenotazione p: prenotazioni) {
				
		%>

		<tr>
			<td class="text-center" name="film"><%=p.getTitolofilm()%></td>
			<td class="text-center" name="sala">sala<%=p.getSala().getIdSala() + " " + sf.format(p.getSpettacolo().getDataOra())%></td>
			<td class="text-center" name="prezzobiglietto"><%=p.getPrezzo()%></td>
			<td class="text-center" name="posti"><%
				for(CarrelloSession.Posto posto : p.getPosti()){
			%><%=posto.getIdposto() + " (" + posto.getPrezzo() + " Euro)" %>		
			<%	 }
			%></td>
			<td class="text-center"><a
				href="RimuoviDalCarrello?index=<%=i%>"><img
					src="img/x.png" width="20px" height="20px"></a></td>
		</tr>
		<%i++;} %>
		<tbody id="prenotazioni">
		<h3  class="text-center">Prezzo totale: <%= car.getPrezzoTot() %> euro</h3>

		</tbody>
	</table>
	
	<a href="DatiPagameto"><button
				class="btn btn-lg btn-primary btn-block" type="submit"
				style="width: 215px;">Completa Acquisto</button></a>
	
	
</div>
<br>
<br>
<br>
<br>
<br>
<br>

<%@ include file="footer.jsp"%>