<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="WEB-INF/jsp/admin-header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Rimuovi spettacolo</h1>
	</div>
	<br>
	<form action="AdminRSpettacolo" method="post">
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>Titolo film</label> <input type="text" class="form-control"
						name="titolo" placeholder="titolo" required="required">
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
			<br>
			<button type="submit" class="btn btn-primary">Rimuovi</button>
		</div>
		<br>
		<br>
	</form>
</div>

<%@ include file="WEB-INF/jsp/admin-footer.jsp"%>