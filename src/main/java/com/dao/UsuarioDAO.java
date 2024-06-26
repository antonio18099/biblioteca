/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

/**
 *
 * @author Antonio Sanchez
 */
import config.ConexionBD;
import model.Usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conexion;
    private ConexionBD conexionBD;

    public UsuarioDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    // Método para crear un nuevo usuario
    public void crearUsuario(Usuarios usuario) {
        String sql = "INSERT INTO usuarios (nombre, email, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getTelefono());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID del usuario insertado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    // Método para leer todos los usuarios
    public List<Usuarios> leerUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                Usuarios usuario = new Usuarios(id, nombre, email, telefono);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return usuarios;
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(Usuarios usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ?, telefono = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getTelefono());
            statement.setInt(4, usuario.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
}
