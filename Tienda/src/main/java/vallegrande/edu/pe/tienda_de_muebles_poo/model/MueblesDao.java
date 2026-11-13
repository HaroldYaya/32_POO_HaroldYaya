package vallegrande.edu.pe.tienda_de_muebles_poo.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class MueblesDao {

    public void registrar(Muebles m) {
        String sql = "INSERT INTO muebles (nombre, categoria, material, color, dimensiones, precio, stock) "
                + "VALUES (?,?,?,?,?,?,?)";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getCategoria());
            ps.setString(3, m.getMaterial());
            ps.setString(4, m.getColor());
            ps.setString(5, m.getDimensiones());
            ps.setDouble(6, m.getPrecio());
            ps.setInt(7, m.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo registrar: " + e.getMessage(), e);
        }
    }

    public ObservableList<Muebles> listar() {
        ObservableList<Muebles> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM muebles ORDER BY id_producto";
        try (Connection cn = Conexion.obtener();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Muebles(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getString("material"),
                        rs.getString("color"),
                        rs.getString("dimensiones"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo conectar/consultar MySQL: " + e.getMessage(), e);
        }
        return lista;
    }

    public void actualizar(Muebles m) {
        String sql = "UPDATE muebles SET nombre=?, categoria=?, material=?, color=?, "
                + "dimensiones=?, precio=?, stock=? WHERE id_producto=?";
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getCategoria());
            ps.setString(3, m.getMaterial());
            ps.setString(4, m.getColor());
            ps.setString(5, m.getDimensiones());
            ps.setDouble(6, m.getPrecio());
            ps.setInt(7, m.getStock());
            ps.setInt(8, m.getId());
            if (ps.executeUpdate() == 0) {
                throw new IllegalArgumentException("El mueble no existe.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar: " + e.getMessage(), e);
        }
    }

    public void eliminar(int id) {
        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement("DELETE FROM muebles WHERE id_producto=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo eliminar: " + e.getMessage(), e);
        }
    }
}
