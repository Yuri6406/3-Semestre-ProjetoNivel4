package cadastroee.controller;

import java.io.IOException;
import java.util.ArrayList;

import cadastroee.conection.DAO;
import cadastroee.model.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Conection", "/main", "/insert", "/alterar", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Produto produto = new Produto();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else if (action.equals("/alterar")) {
			listaProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar Produto
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obj que irá receber os dados Produto
		ArrayList<Produto> lista = dao.listaProdutos();
		// Encamindo a lista ao doc ProdutoLista.jsp
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("ProdutoLista.jsp");
		rd.forward(request, response);
	}

	// Novo Produto
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String quantidadeStr = request.getParameter("quantidade");
		String precoVendaStr = request.getParameter("precoVenda");

		try {
			int quantidade = Integer.parseInt(quantidadeStr);
			float precoVenda = Float.parseFloat(precoVendaStr);

			produto.setNome(nome);
			produto.setQuantidade(quantidade);
			produto.setPrecoVenda(precoVenda);
		} catch (NumberFormatException e) {
			System.out.println("Operação não realizada");
		}
		dao.inserirProduto(produto);

		response.sendRedirect("main");
	}

	// Editar Produto
	protected void listaProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebendo o id do produto que será alterado
		String idProduto = request.getParameter("idProduto");
		// Setando a variável Produto
		int idProd = Integer.parseInt(idProduto);
		produto.setIdProduto(idProd);
		// Executando o método selecionarProduto
		dao.selecionarProduto(produto);

		// Setando os atributos do formulário com o conteúdo
		request.setAttribute("idProduto", produto.getIdProduto());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("quantidade", produto.getQuantidade());
		request.setAttribute("precoVenda", produto.getPrecoVenda());
		// Encaminhar ao documento ProdutoDados.jsp
		RequestDispatcher rd = request.getRequestDispatcher("ProdutoEditar.jsp");
		rd.forward(request, response);
	}

	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setando a variável Produto
		String idProdutoStr = request.getParameter("idProduto");
		int idProduto = Integer.parseInt(idProdutoStr);

		String nome = request.getParameter("nome");

		String quantidadeStr = request.getParameter("quantidade");
		int quantidade = Integer.parseInt(quantidadeStr);

		String precoVendaStr = request.getParameter("precoVenda");
		float precoVenda = Float.parseFloat(precoVendaStr);

		produto.setIdProduto(idProduto);
		produto.setNome(nome);
		produto.setQuantidade(quantidade);
		produto.setPrecoVenda(precoVenda);

		// Executando o méto auterarProduto
		dao.alterarProduto(produto);
		// Redirecionando para o ducumento ProdutoLista.jsp(atualizando as alterações)
		response.sendRedirect("main");

	}

	// Removendo um produto
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idProdutoStr = request.getParameter("idProduto");
		int idProduto = Integer.parseInt(idProdutoStr);
		// Setando a variável Produto
		produto.setIdProduto(idProduto);
		// Execultando o método deletarProduto (DAO) passando o objeto produto
		dao.deletarProduto(produto);
		// Redirecionando para o ducumento ProdutoLista.jsp(atualizando as alterações)
		response.sendRedirect("main");
	}
}
