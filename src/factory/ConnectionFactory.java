package factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuário do mysql
	public static String USERNAME = "root";
	
	//senha do banco
	public static String PASSWORD = "";
	
	//Caminho, porta e o nome do banco de dados
	public static String DATABASE_URL = "jdbc:mysql://127.0.0.1/db_usuario";
	
	public static Connection createConnecionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		/*
		 * Conexão com o banco de dados
		 */
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
		}
	
		public static void main (String[] args) throws Exception {
			// Recuperar conexão
			Connection con = createConnecionToMySQL();
			
			if(con !=null) {
				System.out.println("Conexão obetida com sucesso!");
				con.close();
			}
		}
	
	}

