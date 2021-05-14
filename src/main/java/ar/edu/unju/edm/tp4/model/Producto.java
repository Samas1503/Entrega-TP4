package ar.edu.unju.edm.tp4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PRODUCTOS")
@Component
public class Producto {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private int codProducto;
	@Column
    private String nombre;
	@Column
    private String marca;
	@Column
    private double precio;
	@Column
    private int stock;
    public Producto() {
    }
    public Producto(String nombre, String marca, double precio, int stock, int codProducto) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.codProducto = codProducto;
    }
    @Override
    public String toString() {
        return "Producto [codProducto=" + codProducto + ", " + (marca != null ? "marca=" + marca + ", " : "")
                + (nombre != null ? "nombre=" + nombre + ", " : "") + "precio=" + precio + ", stock=" + stock + "]";
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getCodProducto() {
        return codProducto;
    }
    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codProducto;
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + stock;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) obj;
        if (codProducto != other.codProducto) {
            return false;
        }
        if (marca == null) {
            if (other.marca != null) {
                return false;
            }
        } else if (!marca.equals(other.marca)) {
            return false;
        }
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (stock != other.stock) {
            return false;
        }
        return true;
    }
}