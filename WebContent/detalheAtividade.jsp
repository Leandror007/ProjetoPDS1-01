<%@ page import="dominio.Atividade"%>
<%@ page import="dominio.Participante"%>
<%@ page import="dominio.Participacao"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Simulado 3 - PDS1">
<meta name="author" content="Aparício Pedrosa Franco Junior">
<link rel="icon" href="../../favicon.ico">
<title>Detalhes do Atividade</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="css/starter-template.css" rel="stylesheet">

	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Atividade Detalhado</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Início</a></li>
					<li><a href="#">Opções</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<%
		Atividade x = (Atividade) request.getAttribute("atividade");
		List<Participacao> participacao = (List<Participacao>) request.getAttribute("detalhados");
	%>

	<div style="margin-top: 100px" class="container">


		<h3>Detalhes da Atividade</h3>
		<table class="table table-bordered">
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Preço</th>
			</tr>

			<tr>
				<td><%=x.getCodAtividade()%></td>
				<td><%=x.getNome()%></td>
				<td><%=x.getPreco()%></td>
			</tr>

		</table>
		<br />

		<h3>Participantes</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Data de Pagamento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${detalhados}" var="x">
					<tr>

						<td>${x.getParticipante().getCodParticipante()}</td>
						<td>${x.getParticipante().getNome()}</td>
						<td>${x.getDataPagamento()}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
