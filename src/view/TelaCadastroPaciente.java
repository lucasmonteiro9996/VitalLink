package view;

import dao.PacienteDAO;
import javax.swing.*;
import model.Paciente;

public class TelaCadastroPaciente extends JFrame {

    public TelaCadastroPaciente() {
        setTitle("Cadastro de Pacientes");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 100, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 30, 250, 25);
        add(txtNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(30, 70, 100, 25);
        add(lblCpf);

        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(150, 70, 250, 25);
        add(txtCpf);

        JLabel lblData = new JLabel("Data de Nascimento:");
        lblData.setBounds(30, 110, 150, 25);
        add(lblData);

        JTextField txtData = new JTextField("AAAA-MM-DD");
        txtData.setBounds(180, 110, 220, 25);
        add(txtData);

        JLabel lblTel = new JLabel("Telefone:");
        lblTel.setBounds(30, 150, 100, 25);
        add(lblTel);

        JTextField txtTel = new JTextField();
        txtTel.setBounds(150, 150, 250, 25);
        add(txtTel);

        JLabel lblEnd = new JLabel("Endereço:");
        lblEnd.setBounds(30, 190, 100, 25);
        add(lblEnd);

        JTextField txtEnd = new JTextField();
        txtEnd.setBounds(150, 190, 250, 25);
        add(txtEnd);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 240, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            Paciente paciente = new Paciente();
            paciente.setNome(txtNome.getText());
            paciente.setCpf(txtCpf.getText());
            paciente.setDataNascimento(txtData.getText());
            paciente.setTelefone(txtTel.getText());
            paciente.setEndereco(txtEnd.getText());

            PacienteDAO dao = new PacienteDAO();
            dao.cadastrarPaciente(paciente);

            JOptionPane.showMessageDialog(null, "Paciente cadastrado!");
            dispose();
        });
    }
}
