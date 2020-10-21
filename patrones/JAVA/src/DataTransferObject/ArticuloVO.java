package DataTransferObject;

public class ArticuloVO {

	private int id;
	private String nombre;
	private double precio;
	private TipoIva iva;
	
	
	public ArticuloVO(int id, String nombre, double precio, TipoIva iva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public TipoIva getIva() {
		return iva;
	}


	public void setIva(TipoIva iva) {
		this.iva = iva;
	}
	
	public String toString() {
		return "id=" + id +", nombre="+nombre+", precio= "+precio+", iva= "+iva;
	}

}
