/*Guillermo Arredondo
 * 19 de octubre de 2020
 * PROBLEMA 2 CLASE ANEXADA A CANVAS PRODUCTO
 */
public class Producto {
	private String nombre;	
	private String marca;
	private double precio;
	private String depto;
	private boolean conDescuento;
	
	public Producto(String nombre, String marca, double precio, String depto, boolean conDescuento) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.depto = depto;
		this.conDescuento = conDescuento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public double getPrecio() {
		return precio;
	}

	public String getDepto() {
		return depto;
	}

	public boolean isConDescuento() {
		return conDescuento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public void setConDescuento(boolean conDescuento) {
		this.conDescuento = conDescuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public int compareTo(Producto otro){
		return nombre.compareTo(otro.nombre);
	}

	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nProducto de nombre: "+nombre);
		cad.append("\n             marca: "+marca);
		cad.append("\n            precio: "+precio);
		cad.append("\n             depto: "+depto);
		cad.append("\n      conDescuento: "+conDescuento);
		return cad.toString();
	}

}
