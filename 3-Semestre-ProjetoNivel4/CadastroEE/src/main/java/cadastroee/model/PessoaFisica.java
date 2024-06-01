package cadastroee.model;

public class PessoaFisica extends Pessoa {
	private int idPessoa;
	private String cpf;
	private Pessoa pessoa;

	public PessoaFisica() {
	}

	public PessoaFisica(int idPessoa) {
		super();
		this.idPessoa = idPessoa;
	}

	public PessoaFisica(int idPessoa, String cpf, Pessoa pessoa) {
		super();
		this.idPessoa = idPessoa;
		this.cpf = cpf;
		this.pessoa = pessoa;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [idPessoa=" + idPessoa + ", cpf=" + cpf + ", pessoa=" + pessoa + "]";
	}

}
