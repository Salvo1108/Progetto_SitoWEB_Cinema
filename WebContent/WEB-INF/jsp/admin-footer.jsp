<%@page contentType="text/html" pageEncoding="UTF-8"%>

<footer class="navbar-fixed-bottom">

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<span class="footer-brand">ASR World Cinema</span><br> <i
					class="zmdi zmdi-pin zmdi-hc-fw zmdi-right-4"></i>Via Giovanni
				Paolo II, 84084 Fisciano ITA<br> <i
					class="zmdi zmdi-email zmdi-hc-fw zmdi-right-4"></i>info@asrcinema.it<br>
				<i class="zmdi zmdi-phone zmdi-hc-fw zmdi-right-4"></i>+39 389 09
				61725
			</div>
			<div class="col-md-6">
				<span class="text-right">Copyright &copy; 2019 ASR Cinema.
					Tutti i diritti riservati.</span>
			</div>
		</div>
	</div>
</footer>


<script>
	$('.input-daterange').datepicker({
		format : "dd/mm/yyyy"
	});
</script>
<c:if
	test="${pageContext.request.servletPath == '/jsp/dettaglio-spettacolo.jsp'}">
	<script>
		$(document).ready(function() {
			updatePostiAdmin(id_spettacolo);
		});
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})
	</script>
</c:if>
</body>

