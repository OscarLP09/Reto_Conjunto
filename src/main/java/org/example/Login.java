package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton loginBtn;
    private JButton exitBtn;
    private JTextField userTxt;
    private JPasswordField passwordTxt;
    private JPanel ventana;
    private JLabel infoTxt;

    public Login() {
        this.setContentPane(ventana);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTxt.getText();
                String pass = new String(passwordTxt.getPassword());

                System.out.println("Tocado");
                if (user.isEmpty() || pass.isEmpty()) {
                    infoTxt.setForeground(Color.RED);
                    infoTxt.setText("Necesita rellenar los campos");
                } else {
                    UsuarioDAO dao = new UsuarioDAO();
                    Usuario usuario = dao.validarUsuario(user, pass); // Obtiene el objeto Usuario

                    // Verifica si el objeto Usuario es null
                    if (usuario != null) {
                        int idUsuario = usuario.getId();
                        infoTxt.setForeground(Color.GREEN);
                        infoTxt.setText("Inicio de Sesión exitoso. ¡Bienvenido " + user + "!");
                        Copias_Usuario copiasUsuario = new Copias_Usuario(idUsuario); // Pasa el ID del usuario
                        copiasUsuario.setVisible(true);
                        dispose(); // Cierra la ventana de login
                    } else {
                        infoTxt.setForeground(Color.RED);
                        infoTxt.setText("Usuario o contraseña incorrectos");
                    }
                }
            }
        });

        if (!ConexionBD.testConnection()) {
            infoTxt.setForeground(Color.RED);
            infoTxt.setText("Error en la conexión a la base de datos");
            return;
        }


        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
