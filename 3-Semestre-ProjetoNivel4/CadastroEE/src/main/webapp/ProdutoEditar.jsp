<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados do Produtos</title>
<link rel="icon" href="imagens/mercado.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<head>
<body>

	<div class="container ">
		<div class="row">
			<div class="col">

				<h1>Editar Produtos</h1>
				<form name="frmProduto" action="update">

					<div class="mb-3">
						<label for="nome" class="form-label">Id:</label> <input
							type="text" id="idProduto" name="idProduto"
							value="<%out.println(request.getAttribute("idProduto"));%>"
							required class="form-control" readonly>
					</div>
					<div class="mb-3">
						<label for="nome" class="form-label">Nome:</label> <input
							type="text" id="nome" name="nome"
							value="<%out.println(request.getAttribute("nome"));%>" required
							class="form-control">
					</div>

					<div class="mb-3">
						<label for="quantidade" class="form-label">Quantidade:</label> <input
							type="number" id="quantidade" name="quantidade"
							value="<%out.println(request.getAttribute("quantidade"));%>"
							required class="form-control">
					</div>

					<div class="mb-3">
						<label for="precoVenda" class="form-label">Preço de Venda:</label>
						<input type="number" id="precoVenda" name="precoVenda"
							value="<%out.println(request.getAttribute("valorVenda"));%>"
							required class="form-control">
					</div>

					<input type="submit" value="Salvar" class="btn btn-primary"
						onclick="validar()">
				</form>
			</div>
		</div>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>