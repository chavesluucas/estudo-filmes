package br.com.projetosaula.meufilmes.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projetosaula.meusfilmes.beans.Filme;
import br.com.projetosaula.meusfilmes.cnn.ConnectionFactory;

public class FilmeDAO {

	public FilmeDAO() { super(); }

	//vai ser nossa consulta no banco
	private static final String SQL_LIST_FILMES = "SELECT * FROM filme;";
	
	//List abaixo é uma interface, pede uma classe generica, colocamos o Filme do pacote benas
	public List<Filme> getListFilmes(){
		
		//criando a lista que vai armazenar os filmes
		List<Filme> listaFilmes = new ArrayList<Filme>();
		
		try {
			
			//conectando no banco
			Connection cnn = ConnectionFactory.getMySQLConnection();
			//preparando a consulta no banco
			PreparedStatement pStm = cnn.prepareStatement(SQL_LIST_FILMES);
			//recebendo os dados
			ResultSet rs = pStm.executeQuery();
			
			//para pegar a info
			
			//enquanto tiver objeto, continue 'next()'
			while(rs.next()) {
				//criando o objeto filme
				Filme filme = new Filme(rs.getInt("id"),
										rs.getString("titulo"),
										rs.getString("genero"),
										rs.getInt("restricao"), 
										rs.getBoolean("favorito"));
				
				//agora vamos adicionar tudo no objeto que criamos
				listaFilmes.add(filme);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFilmes;
	}
	
}
