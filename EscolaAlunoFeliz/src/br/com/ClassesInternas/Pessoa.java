package br.com.ClassesInternas;

public class Pessoa {
	private String nome;
	private String cpf;
	private String telefone;
	private String endere�o;
	
	public Pessoa(String nome, String cpf, String telefone, String endere�o) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endere�o = endere�o;
	}
	
	public Pessoa(){};
	
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	
	
}
