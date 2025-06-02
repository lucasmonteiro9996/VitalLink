package view;

import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        javax.swing.JLabel lblEmail = new javax.swing.JLabel("Email:");
        lblEmail.setBounds(50, 50, 80, 25);
        add(lblEmail);

        javax.swing.JTextField txtEmail = new javax.swing.JTextField();
        txtEmail.setBounds(130, 50, 200, 25);
        add(txtEmail);

        javax.swing.JLabel lblSenha = new javax.swing.JLabel("Senha:");
        lblSenha.setBounds(50, 100, 80, 25);
        add(lblSenha);

        javax.swing.JPasswordField txtSenha = new javax.swing.JPasswordField();
        txtSenha.setBounds(130, 100, 200, 25);
        add(txtSenha);

        javax.swing.JButton btnLogin = new javax.swing.JButton("Entrar");
        btnLogin.setBounds(130, 160, 100, 30);
        add(btnLogin);

        btnLogin.addActionListener((var e) -> {
            String email = txtEmail.getText();
            String senha = new String(txtSenha.getPassword());

            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.autenticarUsuario(email, senha);

            if (usuario != null) {
                new TelaMenu().setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha inválidos!");
            }
        });
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
