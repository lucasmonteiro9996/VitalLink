package view;

import dao.AgendamentoDAO;
import javax.swing.*;
import model.Agendamento;

public class TelaAgendamento extends JFrame {

    public TelaAgendamento() {
        setTitle("Agendamento de Consulta");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblIdPaciente = new JLabel("ID do Paciente:");
        lblIdPaciente.setBounds(30, 30, 120, 25);
        add(lblIdPaciente);

        JTextField txtIdPaciente = new JTextField();
        txtIdPaciente.setBounds(150, 30, 250, 25);
        add(txtIdPaciente);

        JLabel lblData = new JLabel("Data (AAAA-MM-DD):");
        lblData.setBounds(30, 70, 150, 25);
        add(lblData);

        JTextField txtData = new JTextField();
        txtData.setBounds(180, 70, 220, 25);
        add(txtData);

        JLabel lblHora = new JLabel("Hora (HH:MM):");
        lblHora.setBounds(30, 110, 120, 25);
        add(lblHora);

        JTextField txtHora = new JTextField();
        txtHora.setBounds(150, 110, 250, 25);
        add(txtHora);

        JLabel lblObs = new JLabel("Observações:");
        lblObs.setBounds(30, 150, 100, 25);
        add(lblObs);

        JTextField txtObs = new JTextField();
        txtObs.setBounds(150, 150, 250, 25);
        add(txtObs);

        JButton btnAgendar = new JButton("Agendar");
        btnAgendar.setBounds(150, 200, 100, 30);
        add(btnAgendar);

        btnAgendar.addActionListener(e -> {
            Agendamento agendamento = new Agendamento();
            agendamento.setIdPaciente(Integer.parseInt(txtIdPaciente.getText()));
            agendamento.setDataConsulta(txtData.getText());
            agendamento.setHoraConsulta(txtHora.getText());
            agendamento.setObservacoes(txtObs.getText());

            AgendamentoDAO dao = new AgendamentoDAO();
            dao.cadastrarAgendamento(agendamento);

            JOptionPane.showMessageDialog(null, "Consulta agendada!");
            dispose();
        });
    }
}
