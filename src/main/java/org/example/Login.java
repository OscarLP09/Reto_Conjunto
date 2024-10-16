package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton loginBtn;
    private JButton exitBtn;
    private JTextField userTxt;
    private JPasswordField passwordTxt;
    private JPanel ventana;

    public Login() {
        this.setContentPane(ventana);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tocado");
            }
        });
    }




}
