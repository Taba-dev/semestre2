package singletonGrupal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("Pepe", 12345678, Status.ACTIVO);
		
		Casino c1 = Casino.getInstancia();
		c1.setNombreCasino("El casino de Pepe");
		c1.setNombreResponsable(p1);
		
		System.out.println(c1);
	}

}
