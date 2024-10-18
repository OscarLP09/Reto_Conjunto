package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Usuario validarUsuario(String nombre_usuario, String contraseña) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            con = ConexionBD.getConnection();

            ps = con.prepareStatement("SELECT * FROM USUARIO WHERE nombre_usuario = ? AND contraseña = ?"); {
            ps.setString(1, nombre_usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                    usuario.setContraseña(rs.getString("contraseña"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(rs!=null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
