package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;

public class UsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public Usuario autenticarUsuario(String email, String senha) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.setString(2, senha);

            rs = pstm.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPerfil(rs.getString("perfil"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e);
        }
        return usuario;
    }
}
