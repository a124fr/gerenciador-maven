package br.com.empresa.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	
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
		
		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("123");
		
		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("123");
		
		usuarios.add(u1);
		usuarios.add(u2);
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

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : this.usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}
	
}
