<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cadastroee.model.Produto"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Produto> lista = (ArrayList<Produto>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
<link rel="icon" href="imagens/mercado.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>



	<div class="container ">
		<div class="row">
			<div class="col">
				<h1>Lista de Produtos</h1>

				<table class="table table-striped table-bordered">
					<thead class="thead-dark">
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Quantidade</th>
							<th>Preço</th>
							<th >Ações</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < lista.size(); i++) {
						%>
						<tr>
							<td><%=lista.get(i).getIdProduto()%></td>
							<td><%=lista.get(i).getNome()%></td>
							<td><%=lista.get(i).getQuantidade()%></td>
							<td><%=lista.get(i).getPrecoVenda()%></td>
							<td ><a
								href="alterar?idProduto=<%=lista.get(i).getIdProduto()%>"
								class="btn btn-primary btn-sm mr-1">Alterar</a> <a
								href="delete?idProduto=<%=lista.get(i).getIdProduto()%>"
								class="btn btn-danger btn-sm">Excluir</a></td>
						</tr>
						<%
						}
						if (lista.size() == 0) {
						%>
						<tr>
							<td colspan="5" class="no-products">Nenhum produto
								disponível.</td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>
				<a href="ProdutoDados.html" type="button" class="btn btn-primary">Novo
					Produto</a>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script type="scripts/confirmador.js"></script>
</body>
</html>