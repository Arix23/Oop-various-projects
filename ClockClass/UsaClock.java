public class UsaClock {
	public static void main(String[] args) {
		Clock gda = new Clock();
		Clock tij = new Clock();
		gda.printTime();
		tij.printTime();
		tij.setTime(524,231,23);
		tij.printTime();
		gda.setTime(23,59,59);
		System.out.println("Hola");
		gda.printTime();
		gda.incrementSeconds();
		gda.printTime();
		Clock ny = new Clock(0,0,0);
		System.out.println("Holadenuevo");
		boolean xd = gda.equals(ny);
		System.out.println(xd);
		ny.incrementSeconds();
		xd = gda.equals(ny);
		System.out.println(xd);
		ny.makeCopy(gda);
		ny.printTime();
		System.out.println(ny.equals(gda));
	}
}