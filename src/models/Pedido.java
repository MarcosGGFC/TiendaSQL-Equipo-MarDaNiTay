package models;

import java.sql.Date;

public class Pedido {
    private int id;
    private int idCliente;
    private Date fecha;
    private int cantidad;
    private int id_Producto;
    
    public Pedido(int idCliente, Date fecha, int cantidad, int id_Producto) {
        this.id = 0;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id_Producto = id_Producto;
    }
    
    public Pedido(int id, int idCliente, Date fecha, int cantidad, int idProducto) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id_Producto = idProducto;
    }

    public int getId() { 
    	return id; 
    }
    
    public void setId(int id) { 
    	this.id = id; 
    }
    
    public int getIdCliente() { 
    	return idCliente; 
    }
    
    public void setIdCliente(int idCliente) { 
    	 this.idCliente = idCliente; 
    }
    
    public Date getFecha() { 
    	return fecha; 
    }
    
    public void setFecha(Date fecha) { 
    	this.fecha = fecha; 
    }
    
    public int getCantidad() { 
    	return cantidad; 
    }
    
    public void setCantidad(int cantidad) { 
    	this.cantidad = cantidad; 
    }
    
    public int getIdProducto() { 
    	return id_Producto; 
    }
    
    public void setIdProducto(int idProducto) { 
    	 this.id_Producto = idProducto; 
    }

    @Override
    public String toString() {
        return "Pedido [id= " + id + ", idCliente= " + idCliente + ", fecha= " + fecha + "cantidad= " + cantidad + "idProducto= " + id_Producto + "]";
    }
}
