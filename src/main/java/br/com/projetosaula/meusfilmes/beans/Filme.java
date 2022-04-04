//ESSE É IGUAL O PACOTE DTO


package br.com.projetosaula.meusfilmes.beans;

import java.io.Serializable;

//implements vamos serealizar
public class Filme implements Serializable {
	
	//Ele vai pegar o serialVersion e vai criar um hach (uma identificação para nosso código)
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int id;
	private String titulo;
	private String genero;
	private int restricao;
	private boolean favorito;
	
	//Metodos (sempre abrir com public + nome da classe + () + { }, esse esta vazio para caso precise estanciar um construtor vazio 
	public Filme() { }
	
	
	//Metodos (sempre abrir com public + nome da classe + () + { }
	public Filme(int id, String titulo, String genero, int restricao, boolean favorito){
		
		//o this.id é id dessa classe que recebe o idParametro
		// this.id = idParam (ID paramentro, é quando recebemos uma info de fora da classe)
		
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.restricao = restricao;
		this.favorito = favorito;
	}
 
	
	
	//como ta mandando a informação, precisa passar o parametro
	public void setId(int id) {
		this.id = id;
	}

	//como ta pegando, n precisa passar parametro
	public int getId() {
		return this.id;
	}

	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getRestricao() {
		return restricao;
	}

	public void setRestricao(int restricao) {
		this.restricao = restricao;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
}
