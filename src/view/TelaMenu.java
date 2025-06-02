package view;

import javax.swing.*;

public class TelaMenu extends JFrame {

    public TelaMenu() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnPaciente = new JButton("Cadastro de Pacientes");
        btnPaciente.setBounds(80, 50, 220, 30);
        add(btnPaciente);

        JButton btnAgendamento = new JButton("Agendar Consulta");
        btnAgendamento.setBounds(80, 100, 220, 30);
        add(btnAgendamento);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(80, 150, 220, 30);
        add(btnSair);

        btnPaciente.addActionListener(e -> {
            TelaCadastroPaciente tela = new TelaCadastroPaciente();
            tela.setVisible(true);
        });

        btnAgendamento.addActionListener(e -> {
            TelaAgendamento tela = new TelaAgendamento();
            tela.setVisible(true);
        });

        btnSair.addActionListener(e -> {
            dispose();
        });
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
