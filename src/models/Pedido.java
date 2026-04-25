package models;

import java.sql.Date;

public class Pedido {
    private int id;
    private String emailCliente;
    private Date fecha;
    
    public Pedido(String emailCliente, Date fecha) {
        this.id = 0;
        this.emailCliente = emailCliente;
        this.fecha = fecha;
    }
    
    public Pedido(int id, String emailCliente, Date fecha) {
        this.id = id;
        this.emailCliente = emailCliente;
        this.fecha = fecha;
    }

    public int getId() { 
    	return id; 
    }
    
    public void setId(int id) { 
    	this.id = id; 
    }
    
    public String getEmailCliente() { 
    	return emailCliente; 
    }
    
    public void setIdCliente(String emailCliente) { 
    	 this.emailCliente = emailCliente; 
    }
    
    public Date getFecha() { 
    	return fecha; 
    }
    
    public void setFecha(Date fecha) { 
    	this.fecha = fecha; 
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", idCliente=" + emailCliente + ", fecha=" + fecha + "]";
    }
}
