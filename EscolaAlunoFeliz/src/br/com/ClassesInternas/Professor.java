package br.com.ClassesInternas;

import java.util.ArrayList;

public class Professor extends Pessoa {
	private Double valorHora;
	//Codigo professor começa com 970
	private String codigo;
	private String formacao;
	private String usuario;
	private String senha;
	private ArrayList<Disciplina> disciplinas;
	
	public Professor(String nome, String cpf, String telefone, String endereço, Double valorHora, String codigo, String formacao, String usuario, String senha){
		super(nome, cpf, telefone, endereço); 
		this.valorHora = valorHora;
		this.codigo = codigo;
		this.formacao = formacao;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Professor(String nome, String cpf, String telefone, String endereço, String codigo) {
		super(nome, cpf, telefone, endereço);
		this.codigo = codigo;
	}



	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getValorHora() {
		return valorHora;
	}
	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
