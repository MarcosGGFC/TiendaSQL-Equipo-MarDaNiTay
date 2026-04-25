package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;

public class ClienteDAO {

    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        
        try (Connection conn = Conexion.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id"), 
                        rs.getString("nombre"), 
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
                            
                clientes.add(c);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    public boolean add(Cliente c) {
        
        String sql = "INSERT INTO clientes (nombre, email, telefono, direccion) VALUES (?,?,?,?)";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getTelefono());
            pstmt.setString(4, c.getDireccion());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public boolean update(Cliente c) {
        String sql = "UPDATE clientes SET nombre = ?, email = ?, telefono = ?, direccion = ? WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getTelefono());
            pstmt.setString(4, c.getDireccion());
            pstmt.setInt(5, c.getId());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}