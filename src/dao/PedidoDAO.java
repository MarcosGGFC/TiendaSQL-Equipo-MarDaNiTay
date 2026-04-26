package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Pedido;

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
                        rs.getInt("id_cliente"), 
                        rs.getDate("fecha"),
                        rs.getInt("cantidad"),
                        rs.getInt("id_Producto")
                );
                            
                pedidos.add(p);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pedidos;
    }
    
    public boolean add(Pedido p) {
        String sql = "INSERT INTO pedidos (id_cliente, fecha, cantidad, id_Producto) VALUES (?,?,?,?)";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, p.getIdCliente());
            pstmt.setDate(2, p.getFecha());
            pstmt.setInt(3, p.getCantidad());
            pstmt.setInt(4, p.getIdProducto());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public boolean update(Pedido p) {
        String sql = "UPDATE pedidos SET id_cliente = ?, fecha = ?, cantidad= ?, id_Producto = ? WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, p.getIdCliente());
            pstmt.setDate(2, p.getFecha());
            pstmt.setInt(3, p.getCantidad());
            pstmt.setInt(4, p.getIdProducto());
            pstmt.setInt(5, p.getId());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, id);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}