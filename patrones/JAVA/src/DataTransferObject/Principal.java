package DataTransferObject;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArticuloBO articulo = new ArticuloBO();
		
		articulo.obtenerArticulos().forEach(System.out::println);
		
		System.out.println("****");
		ArticuloVO artaux = articulo.obtenerArticulo(0);
		artaux.setNombre("Azucarlito x 1Kg.");
		articulo.actualizarArticulo(artaux);
		
		System.out.println("****");
		artaux=articulo.obtenerArticulo(0);
		System.out.println(artaux);
		
		System.out.println("****");
		artaux=articulo.obtenerArticulo(0);
		articulo.eliminarArticulo(artaux);
		
		articulo.obtenerArticulos().forEach(System.out::println);
		
	}

}


