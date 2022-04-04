//CONEX�O COM O BANCO

package br.com.projetosaula.meusfilmes.cnn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Nesse passo ativamos o Maven, Clica com bot�o direito na pasta dp projeto >
	// Configure > alguma op��o com maven e
	// depois, entrar no arquivo do Maven para ver o passo seguinte

	// metodo statico ela pode ser acessada sem a necessidade de instanciar a classe
	// � necess�rio importar o Connection, e o get... � o nome da classe

	public static Connection getMySQLConnection() {

		// Try Cat para tratar as excess�es
		try {
			// ele vai carregar o drive para poder usar o conector, a Class foi pego no site -> https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
			Class.forName("com.mysql.cj.jdbc.Driver");

			// criando a connection(tipo o DB), e a ultima parte a gente passa o parametro
			// para logar (url, nome, senha)
			Connection cnn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/meusfilmes?useTimezone=true&serverTimezone=UTC&useSSL=false", "root",
					"admin");
			//tem q mudar o nome da URL, onde est� "meusfilmes?" informar o nome do banco. 
			
			
			//retorna a instancia de um objeto
			return cnn;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException cex) {
			cex.printStackTrace();
		}
		
		//para n�o dar dois return nos catch
		return null;
	}

}
