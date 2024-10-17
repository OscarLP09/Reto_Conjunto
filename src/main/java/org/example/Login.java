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
                if(user.isEmpty()|| pass.isEmpty()) {
                    infoTxt.setForeground(Color.RED);
                    infoTxt.setText("Necesita rellenar los campos");
                }
                UsuarioDAO dao = new UsuarioDAO();
                Usuario usuario = dao.validarUsuario(user, pass);

                if(usuario != null) {
                    infoTxt.setForeground(Color.GREEN);
                    infoTxt.setText("Inicio de Sesión exitoso. ¡Bienvenido " + user + "!");
                } else {
                    infoTxt.setForeground(Color.RED);
                    infoTxt.setText("Usuario o contraseña incorrectos");
                }
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }




}
