package br.com.ClassesInternas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solicitacao {
	private String codigo;
	private String tipo;
	private String data;
	private String cpfAluno;
	private String codigoDisciplina;
	
	public Solicitacao(String codigo, String tipo, String data, String cpfAluno, String codigoDisciplina) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.data = data;
		this.cpfAluno = cpfAluno;
		this.codigoDisciplina = codigoDisciplina;
	}

	public Solicitacao(String tipo, String cpfAluno, String codigoDisciplina) {
		this.tipo = tipo;
		this.cpfAluno = cpfAluno;
		this.codigoDisciplina = codigoDisciplina;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data=new Date();
		this.data = sdf.format(data);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	
	
}
