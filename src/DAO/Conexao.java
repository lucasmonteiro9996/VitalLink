package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conectaBD() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/vital_link?user=root&password=";
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            System.out.println("Erro na conexão: " + erro.getMessage());
        }

        return conn;
    }
}
