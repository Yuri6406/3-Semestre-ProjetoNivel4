package cadastroee.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cadastroee.model.Produto;

public class DAO {

	// Driver
	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://127.0.0.1:3306/loja?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "root6406";

	// Conexão
	private Connection connectar() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/** CREATE **/
	public void inserirProduto(Produto produto) {
		String create = "insert into produto (nome,quantidade,precoVenda) value(?,?,?)";

		try {
			// Abrir a conexão
			Connection conn = connectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			// Substituir os parametros(?)
			pst.setString(1, produto.getNome());
			pst.setInt(2, produto.getQuantidade());
			pst.setFloat(3, produto.getPrecoVenda());

			// Executar a query
			pst.executeUpdate();

			// Encerrar Conexão
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/** READ **/
	public ArrayList<Produto> listaProdutos() {
		ArrayList<Produto> produtos = new ArrayList<>();
		String read = "select * from produto order by nome";
		try {

			// Abrir a conexão
			Connection conn = connectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			// Enquanto houver Produto será execuçtado o laço
			while (rs.next()) {
				// Var de apoio que recebem os dados do banco
				int idProduto = rs.getInt(1);
				String nome = rs.getString(2);
				int quantidade = rs.getInt(3);
				float precoVenda = rs.getFloat(4);
				// Populandp o ArrayList
				produtos.add(new Produto(idProduto, nome, quantidade, precoVenda));
			}
			conn.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** UPDATE **/
	// Seleionando o produto
	public void selecionarProduto(Produto produto) {
		String read = "select * from produto where idProduto = ?";
		try {
			// Abrir a conexão
			Connection conn = connectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(read);
			pst.setLong(1, produto.getIdProduto());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				// Setando as variáveis de produto
				produto.setIdProduto(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setQuantidade(rs.getInt(3));
				produto.setPrecoVenda(rs.getFloat(4));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Editando o produto
	public void alterarProduto(Produto produto) {
		String create = "update produto set nome=?,quantidade=?,precoVenda=? where idProduto=?";
		try {
			// Abrir a conexão
			Connection conn = connectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, produto.getNome());
			pst.setInt(2, produto.getQuantidade());
			pst.setFloat(3, produto.getPrecoVenda());
			pst.setInt(4, produto.getIdProduto());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** DELETE **/

	public void deletarProduto(Produto produto) {
		String delete = "delete from produto where idProduto=?";
		try {
			// Abrir a conexão
			Connection conn = connectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setInt(1, produto.getIdProduto());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
