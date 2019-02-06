package pooaula1;

public class exercicio1 {

	public static void main(String[] args) {
		int i = 1, a = 1 , k = 0;
		float  s = 0, t = 0 ;
		for (; i <= 99;) {
			s = s + ( (float)i/ a);
			i = i + 2;
			a = a + 1;
		}
		System.out.println("resultado = " + s);
		i = 300;
		a = 15;
		t = t + ( (float)i / a);
		for (; i <= 1000 ;) {
			if (k == 0){
				t = t + ( (float)i / a);
				i = i + 50;
				a = a - 1;
				k = 1;
			}
			else {
				t = t - ( (float)i / a);
				i = i + 50;
				a = a - 1;
				k = 0;
			}
			
		}
		System.out.print("resultado = " + t);  
	}

}
