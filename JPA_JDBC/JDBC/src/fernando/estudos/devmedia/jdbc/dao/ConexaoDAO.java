package fernando.estudos.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoDAO {
	public static ResourceBundle config;
	
	private static ConexaoDAO conexao;
	
	private ConexaoDAO() {
		config = ResourceBundle.getBundle("config");
	}
    
	//PAdr�o Singleton. M�todo EST�TICO que retorna uma inst�ncia do objeto ConexaoDAO
	//Somente este m�todo pode dar um "new" e criar um objeto ConexaoDAO. 
	//Caso j� exista uma inst�ncia criada, ele retorna esta mesma inst�ncia. Assim, garante que somente uma inst�ncia ser� criado
	public static ConexaoDAO getInstance() {
		if (conexao == null) { //garante que a instancia seja �nica
			conexao = new ConexaoDAO();
		}
		return conexao; //Retorna a vari�vel est�tica conexao. Se for null, cria, sen�o retorna a j� existente.
	}
	
	//M�todo que conecta e retorna uma Connection
	public Connection getConnection() throws ClassNotFoundException, SQLException { //Jogou a exe��o "pra cima". Quem chamar o objeto � quem ter� que tratar.
		Class.forName(config.getString("fernando.estudos.devmedia.jdbc.mysql")); 
		return DriverManager.getConnection(config.getString("fernando.estudos.devmedia.jdbc.url.conexao"),
                config.getString("fernando.estudos.devmedia.jdbc.usuario"),
                config.getString("fernando.estudos.devmedia.jdbc.senha"));
	}		
}
