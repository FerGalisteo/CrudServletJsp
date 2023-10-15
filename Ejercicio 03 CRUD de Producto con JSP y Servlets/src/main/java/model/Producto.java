package model;

public class Producto {

	Integer id;
	String nombre;
	String descripcion;
	Integer peso;
	Integer stock;
	
	public Producto(){
		
	}

	public Producto(Integer id,String nombre, String descripcion, Integer peso, Integer stock) {

		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer i) {
		this.id = i;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", peso=" + peso
				+ ", stock=" + stock + "]";
	}
	
	

}
