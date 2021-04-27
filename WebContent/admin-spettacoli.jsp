<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ include file="WEB-INF/jsp/admin-header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Aggiungi spettacolo</h1>
	</div>
	<br>
	<form action="AdminSpettacolo" method="post">
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>Titolo film</label> <input type="text" class="form-control"
						name="titolo" placeholder="titolo" required="required">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Genere film</label> <input type="text" class="form-control"
						name="genere" placeholder="genere" required="required">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Regista film</label> <input type="text" class="form-control"
						name="regista" placeholder="regista" required="required">
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<label>Durata</label> <input type="text" class="form-control"
							name="durata" placeholder="durata" required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>URL Trailer</label> <input type="text" class="form-control"
							name="trailer" placeholder="trailer" required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Locandina</label> <input type="text" class="form-control"
							name="locandina" placeholder="locandina" required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Anno</label> <input type="text" class="form-control"
							name="anno" placeholder="anno" required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Inserirla nelle slide? (1 si, 0 no)</label> <input
							type="text" class="form-control" name="slide" placeholder="slide"
							required="required">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Immagine Slide</label> <input type="text"
							class="form-control" name="imgslide" placeholder="imgslide">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Sala spettacolo</label> <input type="text"
							class="form-control" name="sala" placeholder="sala"
							required="required">
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Trama</label>
					<textarea class="form-control" name="trama" placeholder="trama"
						required="required" style="width: 210px; height: 200px"></textarea>
				</div>
			</div>


			<div class="col-md-3">

				<div class="form-group">
					<label>In Programmazione: Data</label> <input type="text"
						class="form-control" placeholder="data" name="data"
						required="required">
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Ora</label> <input type="text" class="form-control"
						placeholder="ora" name="ora" required="required">
				</div>
			</div>

		</div>

		<div align="center">
			<button type="submit" class="btn btn-primary">Aggiungi</button>
		</div>
		<br>
		<br>
	</form>
	<br>
</div>
<br>
<br>
<br>
<br>
<br>
<br>


<%@ include file="WEB-INF/jsp/admin-footer.jsp"%>