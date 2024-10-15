package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JPanel Login;
    private JPasswordField contrasenaTxt;
    private JTextField usuarioTxt;
    private JButton iniciosesionBtn;
    private JButton registroBtn;

    public login() {
    this.setTitle("Peliculas");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(Login);
    this.setSize(300,500);
    this.setLocationRelativeTo(null);


        iniciosesionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tocado");

            }
        });
    }
}
