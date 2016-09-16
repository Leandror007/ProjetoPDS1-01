
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Prova 3">
<meta name="author" content="Aparício Pedrosa Franco Junior">
<link rel="icon" href="../../favicon.ico">
<title>Formulário</title>

<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/starter-template.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../js/ie-emulation-modes-warning.js"></script>

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
				<a class="navbar-brand" href="#">Formulário de Precos</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					 <li><a href="informarPreco.jsp">Formulário de Preços</a></li>
					<li><a href="#">Opções</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div style="margin-top: 100px" class="container">




		<form action="<%=request.getContextPath()%>/cadParticipante/CadastrarParticipante" method="post">
			
			<div class="form-group">
				<label for="exampleInputPassword1">Codigo Participante</label> 
				<input name="codParticipante" type="text" class="form-control" id="codParticipante" readonly="readonly" value="${part.codParticipante}">
				
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">Nome</label> 
				<input name="nome" type="text" class="form-control" id="nome" placeholder="DataFinal" value="${part.nome}">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
			
			<a href="../index.html" class="btn btn-default">Cancelar</a>
		</form>





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
	<script src="../js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../js/ie10-viewport-bug-workaround.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
