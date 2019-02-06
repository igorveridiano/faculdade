package Turma01;

public class exemplovetor {

	public static void main(String[] args) {
		int i;
		int [] vet = new int [10];
		for (i = 0 ; i < 10 ; i ++) {
			vet[i] = i + 1;
		}
		for (i = 9 ; i >= 0 ; i--){
			System.out.printf("%02d " , vet[i]);
		}
	}

}
