package Threads;

public class TesteCalculadora {

	public static void main(String[] args) {
		int array[]={1,2,3,4,5};
		MinhaThreadSoma t1=new MinhaThreadSoma("Thread#1",array);
		MinhaThreadSoma t2=new MinhaThreadSoma("Thread#2",array);
		//saida incorreta porque as threads nao tao sincronizadas,tem mais de uma thread acessando o mesmo metado,alterando a soma
		
	}

}
