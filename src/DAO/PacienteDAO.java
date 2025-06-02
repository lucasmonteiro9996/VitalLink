package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Paciente;

public class PacienteDAO {
    Connection conn;
    PreparedStatement pstm;

    public void cadastrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nome, cpf, data_nascimento, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getCpf());
            pstm.setString(3, paciente.getDataNascimento());
            pstm.setString(4, paciente.getTelefone());
            pstm.setString(5, paciente.getEndereco());

            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar paciente: " + e);
        }
    }
}
