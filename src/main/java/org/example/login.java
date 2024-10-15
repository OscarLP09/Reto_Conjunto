package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Componentes de la interfaz gráfica

public class login extends JFrame {
    private JPanel Login;
    private JPasswordField contrasenaTxt;
    private JTextField usuarioTxt;
    private JButton iniciosesionBtn;
    private JButton salirBtn;
    private JLabel usuarioLbl;
    private JLabel contrasenaLbl;

    // Configuración de la ventana
    public login() {
    this.setTitle("Peliculas");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(Login);
    this.setSize(300,500);
    this.setLocationRelativeTo(null);

        // Inicialización de los componentes
        JLabel usuarioLbl = new JLabel("Usuario: ");
        JLabel contrasenaLbl = new JLabel("Contraseña: ");
        usuarioTxt = new JTextField();
        contrasenaTxt = new JPasswordField();
        iniciosesionBtn = new JButton("Iniciar Sesión");
        salirBtn = new JButton("Salir");




        iniciosesionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el nombre de usuario del campo de texto
                String username = usuarioTxt.getText();
                // Obtiene la contraseña del campo de contraseña
                String password = new String(contrasenaTxt.getPassword());

                System.out.println("Usuario ingresado: " + username);
                System.out.println("Contraseña ingresada: " + password);

                // Verificar que los campos no estén vacíos
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Llamar al método validateLogin y pasarle los parámetros username y password
                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login exitoso. Bienvenido " + username);
                    dispose();  // Cierra la ventana de login
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Acción que realiza el botón salir
        salirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Método para realizar la verificación de login
        public boolean validateLogin(String username, String password){
            boolean isValid = false;
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            try {
                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/tu_base_de_datos"; // Cambia esta URL a tu configuración de MySQL
                String user = "root"; // Usuario de tu base de datos
                String pass = "password"; // Contraseña de tu base de datos

                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexión a la base de datos exitosa");

                // Consulta SQL para validar usuario y contraseña
                String sql = "SELECT * FROM Usuario WHERE nombre_usuario = ? AND contraseña = ?";
                pst = conn.prepareStatement(sql);
                String username = usuarioTxt.getText();
                String password = contrasenaTxt.getText();

                pst.setString(1, username);  // Asigna el nombre de usuario al primer parámetro
                pst.setString(2, password);  // Asigna la contraseña al segundo parámetro

                // Ejecuta la consulta
                rs = pst.executeQuery();

                // Si se encuentra un resultado, las credenciales son válidas
                if (rs.next()) {
                    System.out.println("Usuario encontrado en la base de datos");
                    isValid = true;
                } else {
                    System.out.println("Usuario o contraseña incorrectos");
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // Muestra cualquier excepción en la consola
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pst != null) pst.close();
                    if (conn != null) conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            return isValid;
        }


    }
}
