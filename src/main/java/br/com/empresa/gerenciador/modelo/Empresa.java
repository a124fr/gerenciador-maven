package br.com.empresa.gerenciador.modelo;

import java.time.LocalDate;

public class Empresa {

	private Integer id;
	private String nome;
	private LocalDate dataAbertura = LocalDate.now();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

}
