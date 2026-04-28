package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Env;

public class Conexion {
	
	private static final String URL = Env.get("DB_HOST")+":"+Env.get("DB_PORT")
										+"/"+Env.get("DB_NAME");
	private static final String USER = Env.get("DB_USER");
	private static final String PASSWORD = Env.get("DB_PASSWORD");
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(SQLException e) {
			System.err.println("No se ha conectado a la base de datos: \n"+e.getMessage());
		}
		return conn;
	}
}
