package aula2;

public class exemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		a = 1;
		while (a <= 5) {
			b = 4;
			while (b > 0) {
				System.out.print(a + "," + b + "\n");
				b = b - 2;
			}
			a = a + 2;
		}
	}

}
