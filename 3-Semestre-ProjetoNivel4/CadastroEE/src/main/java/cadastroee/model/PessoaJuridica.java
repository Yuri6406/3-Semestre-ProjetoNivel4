package cadastroee.model;

public class PessoaJuridica extends Pessoa {
	private int idPessoa;
	private String cnpj;
	private Pessoa pessoa;

	public PessoaJuridica() {
	}

	public PessoaJuridica(int idPessoa) {
		super();
		this.idPessoa = idPessoa;
	}

	public PessoaJuridica(int idPessoa, String cnpj, Pessoa pessoa) {
		super();
		this.idPessoa = idPessoa;
		this.cnpj = cnpj;
		this.pessoa = pessoa;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [idPessoa=" + idPessoa + ", cnpj=" + cnpj + ", pessoa=" + pessoa + "]";
	}

}
