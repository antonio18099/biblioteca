package com.dao;

/**
 *
 * @author Antonio Sanchez
 */
import config.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibroCategoriaDAO {

    private Connection conexion;
    private ConexionBD conexionBD;

    public LibroCategoriaDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    // Método para asociar un libro con una categoría
    public void asociarLibroCategoria(int libroId, int categoriaId) {
        String sql = "INSERT INTO libros_categorias (libro_id, categoria_id) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, libroId);
            statement.setInt(2, categoriaId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al asociar libro con categoría: " + e.getMessage());
        }
    }

    // Método para desasociar un libro de una categoría
    public void desasociarLibroCategoria(int libroId, int categoriaId) {
        String sql = "DELETE FROM libros_categorias WHERE libro_id = ? AND categoria_id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, libroId);
            statement.setInt(2, categoriaId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al desasociar libro de categoría: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
}
