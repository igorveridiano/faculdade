package primeirosExercicios;

public class QuocienteFormatado {

	public static void main(String[] args) {
        double a, b, q;
        int z;
        z = 43;
        a = 10;
        b = 3;
        q = a/b;
        System.out.println("\nQuociente:" + q);
        System.out.printf("Quociente = %6.2f",a);
        System.out.printf("\nQuociente = %8.4f",q);
        System.out.printf("\nQuociente = %08.2f",q);
        System.out.printf("\n\nValor de z:%1d",z);
        System.out.printf("\nValor de z:%4d",z);
        System.out.printf("\nValor de z:%04d",z);
	}

}
