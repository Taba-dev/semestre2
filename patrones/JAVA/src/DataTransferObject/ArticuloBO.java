package DataTransferObject;

import java.util.ArrayList;
import java.util.List;

public class ArticuloBO {

	private List<ArticuloVO> articulos;
	public ArticuloBO() {
		articulos = new ArrayList<>();
		ArticuloVO art1 = new ArticuloVO(0, "Azucar", 35F, TipoIva.MINIMO);
		ArticuloVO art2 = new ArticuloVO(1, "jABON", 42F, TipoIva.MINIMO);
		ArticuloVO art3 = new ArticuloVO(2, "Leche", 38F, TipoIva.EXENTO);
		articulos.add(art1);
		articulos.add(art2);
		articulos.add(art3);
			
	}
	
	public void eliminarArticulo(ArticuloVO articulo) {
		articulos.remove(articulo.getId());
		System.out.println("Articulo "+articulo.getId()+ " -- "+articulo.getNombre()+" eliminado satisfactoriamente.");
	}
	
	public List<ArticuloVO> obtenerArticulos(){
		return articulos;
	}
	
	public ArticuloVO obtenerArticulo(int id) {
		return articulos.get(id);
	}
	
	public void actualizarArticulo(ArticuloVO articulo) {
		articulos.get(articulo.getId()).setNombre(articulo.getNombre());
		articulos.get(articulo.getId()).setPrecio(articulo.getPrecio());
		articulos.get(articulo.getId()).setIva(articulo.getIva());
		System.out.println("Articulo id: "+articulo.getId()+" actualizado satisfactoriamente.");
		
	}
	
	
}
