package cadastroee.model;

public class Movimento {
	private int idMovimento;
	private int quantidade;
	private char tipo;
	private float valorUnitario;
	private int idPessoa;
	private int idProduto;
	private int idUsuario;
	
	public Movimento() {
	}

	public Movimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}

	public Movimento(int idMovimento, int quantidade, char tipo, float valorUnitario) {
		this.idMovimento = idMovimento;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.valorUnitario = valorUnitario;
	}

	public int getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Movimento [idMovimento=" + idMovimento + "]";
	}
	
	
	
	
}
