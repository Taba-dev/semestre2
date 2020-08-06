package singletonIndividual;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r1 = Robot.getInstancia();
		
		r1.setNombreRobot("Charrua Power");
		r1.setCantidadVidasRobot((byte)4);
		
		System.out.println(r1);
		
		Robot r2 = Robot.getInstancia();
		System.out.println(r2);
		
		r2.setCantidadVidasRobot((byte)10);
		System.out.println("-----");
		System.out.println(r1);
		System.out.println(r2);
		
	}

}
