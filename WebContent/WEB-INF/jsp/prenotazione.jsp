<%@ page
	import="java.util.*,model.*,java.sql.*,java.text.SimpleDateFormat"%>
<%@ include file="header-utente.jsp"%>
<div class="container">
	<div class="page-header">
		<%
		
		
		SpettacoloSalaOrario det = (SpettacoloSalaOrario) request.getAttribute("spetsalaora");
		ArrayList<Posto> listaposti = (ArrayList<Posto>) request.getAttribute("listaposti");
		
	
		%>
		<%
			SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
		%>
		<h1>
			Prenotazione
			<%=det.getFilm().getTitolo()%></h1>
		<span class="subtitle"><h3>
				Sala:<%=det.getSala().getIdSala()%>, spettacolo del
				<%=sf.format(det.getSpettacolo().getDataOra())%>
			</h3></span>
	</div>
	<div class="row">
		<div class="col-md-8">
			<div class="sala">
				<%
					int i = 0;
					for (Posto p : listaposti) {

						if (i % 12 == 0) {
				%>
				<button class="posto invisibile"></button>
				<%
					}
						if (p.getStato() == false) {
							i++;
				%>
				<button onclick="myFunction(this)" id="libero" class="posto libero"
					value="<%=p.getP().getRiga()%><%=p.getP().getColonna()%>"><%=p.getP().getRiga()%><%=p.getP().getColonna()%></button>
				<%
					} else if (p.getStato() == true) {
							i++;
				%>
				<button class="posto libero"
					style="background-color: #4682B4; color: red;" disabled><%=p.getP().getRiga()%><%=p.getP().getColonna()%></button>
				<%
					}
					}
				%>


			</div>

		</div>
		<script type="text/javascript">
			var count = 0;
			var x;
			var b;
			var array = [];
			var costo;
			var a;
			var scelta;
			var arrcosti = [];
			var i = 0;

			function myFunction(button) {
				b = button;
				array[count] = b;
				a = document.getElementById("scelta");
				x = $("#posti").text();
				$("#posti").text(
						x + "\n" + button.value + ":"
								+ a.options[a.selectedIndex].text + " ");
				x = x + "\n" + button.value;
				$(button).attr("disabled", true);
				$(button).css("background-color", "#4682B4");
				count += 1;
				document.getElementById("quantita").innerHTML = count;

				costo = document.getElementById("costo");

				scelta = a.options[a.selectedIndex].value;

				if (scelta == "1") {
					arrcosti[i] = 9;
					costo.innerHTML = Math.min(200, +costo.innerHTML + 9);
				} else if (scelta == "2") {
					arrcosti[i] = 6;
					costo.innerHTML = Math.min(200, +costo.innerHTML + 6);
				} else if (scelta == "3") {
					arrcosti[i] = 5;
					costo.innerHTML = Math.min(200, +costo.innerHTML + 5);
				} else if (scelta == "4") {
					arrcosti[i] = 5;
					costo.innerHTML = Math.min(200, +costo.innerHTML + 5);
				}
				i++;
			}

			function rimuovi() {
				$("#posti").text(x.substring(0, x.length - 3));
				x = $("#posti").text();
				count -= 1;
				document.getElementById("quantita").innerHTML = count;
				$(array[count]).attr("disabled", false);
				$(array[count]).css("background-color", "#cfd8dc");
				i--;
				costo.innerHTML = parseInt(costo.innerHTML) - arrcosti[i];

			}

			function confermacquisto() {
				let id =
		<%=det.getSpettacolo().getIdSpettacolo()%>
			;
				let id_sala =
		<%=det.getSala().getIdSala()%>
			;

				var posti = "";

				var url = "AggiungiCarrello?id=" + id + "&posti="
						+ $("#posti").text();

				window.location.href = url;

			}
		</script>

		<h1>Carrello</h1>
		<a href="DettaglioFilmUtenti?id=<%=det.getFilm().getIdFilm()%>"> <img
			src="<%=det.getFilm().getUriLocandina()%>"
			style="height: 115px; float: left;"></a>

		<div style="margin-left: 600px; padding-left: 265px; color: #0d355e">
			Quantità:<label name="quantita" id="quantita"></label> <br> Tipo
			Biglietto: <select id="scelta" name="scelta"><option
					value="1">Intero</option>
				<option value="2">Ridotto</option>
				<option value="3">Disabili</option>
				<option value="4">Militari</option></select> <br> Prezzo totale: <label
				id="costo" name="costo"></label> <br> Posti:
			<div col="1" id="posti" name="posti"></div>
			<br> <a href="#"><button onclick="confermacquisto()"
					style="color: #0d355e">Aggiungi al carrello</button></a>
		</div>

		<button onclick="rimuovi()" value="Rimuovi"
			style="margin-left: 110px; margin-top: 10px; color: #0d355e">Rimuovi</button>
	</div>
	<br> <br> <br> <br> <br> <br> <br> <br>
	<%@ include file="footer.jsp"%>