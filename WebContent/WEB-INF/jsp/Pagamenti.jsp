<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ include file="header-utente.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Pagamento</h1>
	</div>
	<br>
	<form action="PagamentoFinale" method="post">
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>Nome</label> <input type="text" class="form-control"
						name="nome" placeholder="Nome" required="required">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Cognome</label> <input type="text" class="form-control"
						name="cognome" placeholder="Cognome" required="required">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Indirizzo</label> <input type="text" class="form-control"
						name="indirizzo" placeholder="Indirizzo" required="required">
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<label>Città</label> <input type="text" class="form-control"
							name="citta" placeholder="Citta" required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>CAP</label> <input type="text" class="form-control"
							name="cap" placeholder="CAP" required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Numero Della Carta</label> <input type="text" class="form-control"
							name="cap" placeholder="Numero Della Carta" required="required">
					</div>

				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Data Di Scadenza</label> <input type="text" class="form-control"
							name="cap" placeholder="Scadenza" required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>CVV2</label> <input type="text" class="form-control"
							name="cap" placeholder="CVV2" required="required">
					</div>
				</div>
				
				
				<div align="center">
			<button type="submit" class="btn btn-primary">Conferma Acquisto</button>
		</div>
				
	</form>
	<br>
</div>
<br>
<br>
<br>
<br>
<br>
<br>


<%@ include file="footer.jsp"%>