package Herança;

public class Menu {

	public static void main(String[] args) {
		Empregado e = new Empregado("Andre" , 700);
		e.imprimir();
		
		Gerente a = new Gerente("Carlos", 4500, "TI");
		a.imprimir();
		a.setDepto("Inovação");
		a.imprimir();
	}

}
