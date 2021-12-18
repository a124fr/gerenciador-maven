package br.com.empresa.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		empresas.add(empresa1);
		empresas.add(empresa2);
	}
		
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.empresas.add(empresa);
	}
	
	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = this.empresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				this.empresas.remove(emp);
				return;
			}
		}
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		
		for(Empresa empresa : this.empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}
	
}
