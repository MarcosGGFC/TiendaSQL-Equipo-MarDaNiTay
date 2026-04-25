package dao;

import java.util.List;
import java.util.ArrayList;
import models.Pedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class PedidoDAO {

    public List<Pedido> getAll() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        
        try (Connection conn = Conexion.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Pedido p = new Pedido(
                        rs.getInt("id"), 
                        rs.getString("emailCliente"), 
                        rs.getDate("fecha")
                );
                            
                pedidos.add(p);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pedidos;
    }
    
    public boolean add(Pedido p) {
        String sql = "INSERT INTO pedidos (id_cliente, fecha) VALUES (?,?)";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, p.getEmailCliente());
            pstmt.setDate(2, p.getFecha());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public boolean update(Pedido p) {
        String sql = "UPDATE pedidos SET id_cliente = ?, fecha = ? WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, p.getEmailCliente());
            pstmt.setDate(2, p.getFecha());
            pstmt.setInt(3, p.getId());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(String email) {
        String sql = "DELETE FROM pedidos WHERE email = ?";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, email);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}