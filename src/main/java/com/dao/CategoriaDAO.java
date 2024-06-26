package com.dao;

/**
 *
 * @author Antonio Sanchez
 */
import config.ConexionBD;
import model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection conexion;
    private ConexionBD conexionBD;

    public CategoriaDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    // Crear una nueva categoría
    public void crearCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, categoria.getNombre());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    categoria.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID de la categoría insertada.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    // Leer todas las categorías
    public List<Categoria> leerCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Categoria categoria = new Categoria(nombre, id);
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return categorias;
    }

    // Actualizar una categoría
    public void actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categorias SET nombre = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.setInt(2, categoria.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    // Eliminar una categoría
    public void eliminarCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    // Cerrar la conexión
    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
}
