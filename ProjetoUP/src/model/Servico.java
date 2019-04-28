package model;
public class Servico {
	private String id;
	private String nome;
	private String descricao;
	
	public Servico() {
		
	}
	public Servico(String id, String nome, String descricao) {
		setId(id);
		setNome(nome);
		setDescricao(descricao); 
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}