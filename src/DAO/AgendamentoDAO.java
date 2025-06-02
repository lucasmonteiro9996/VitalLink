package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Agendamento;

public class AgendamentoDAO {
    Connection conn;
    PreparedStatement pstm;

    public void cadastrarAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (id_paciente, data_consulta, hora_consulta, observacoes) VALUES (?, ?, ?, ?)";
        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, agendamento.getIdPaciente());
            pstm.setString(2, agendamento.getDataConsulta());
            pstm.setString(3, agendamento.getHoraConsulta());
            pstm.setString(4, agendamento.getObservacoes());

            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println("Erro ao agendar consulta: " + e);
        }
    }
}
