<%@ page import="java.util.*,model.*"%>
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
			<th class="text-center">Posto</th>
			<th class="text-center">Sala</th>
			<th class="text-center">Prezzo biglietto</th>
			<th class="text-center">Elimina</th>
			
		</tr>
		

		<tr>
			<td class="text-center" name="film"></td>
			<td class="text-center" name="posti"></td>
			<td class="text-center" name="sala"></td>
			<td class="text-center" name="prezzobiglietto"></td>
			<td class="text-center"></td>
		</tr>

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