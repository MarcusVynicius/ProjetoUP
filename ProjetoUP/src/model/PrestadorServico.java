package model;

public class PrestadorServico {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private String descricao;
	private Servico servico;
	private String senha;
	
	public PrestadorServico() {
		this.servico = new Servico();
		
		
	}
	
	public PrestadorServico(String nome,String cpf,String endereco,String telefone,String email) {
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setTelefone(telefone);
		setEmail(email);
		

}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Servico getServico() {
		return servico;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}

	
}