package br.com.gerenciador.modelo;

public class User {
	private String usuario;
	private String senha;
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
	public User(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}
	
}
