package conversaoDeImagens;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;




public class Main {

	private static Scanner leia;
	private static Scanner input;
	private static Runnable conversor;
	
	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		String diretorio1, diretorio2, nome, tipo;
		int a = 1, i = 0, largura1, altura1, largura2, altura2, verificador1, verificador2;
		do {
			System.out.println("1-Converter varias imagens a partir de uma pasta: ");
			System.out.println("2-Converter imagem especifica: ");
			System.out.print("3-Sair: ");
			verificador1 = input.nextInt();
			switch (verificador1){
			case 1:
				System.out.print("Diretorio das imagens a serem convertidas: ");
				diretorio1 = leia.nextLine();
				System.out.print("Diretorio onde as imagens convertidas vão ser salvas: ");
				diretorio2 = leia.nextLine();
				Conversor converter1 = new Conversor();
				File file1 = new File(diretorio1);
				for (File file2 : file1.listFiles()) {
					try {
						conversor = new Conversor(file2);
						BufferedImage imagem = ImageIO.read(file2);
						largura1 = imagem.getWidth() / 2;
						altura1 = imagem.getHeight() / 2;
						largura2 = largura1 + largura1;
						altura2 = altura1 + altura1;
						Runnable conversor1 = new Conversor(0,0,largura1,altura1);
						Thread thread1 = new Thread(conversor1);
						Runnable conversor2 = new Conversor(largura1,0,largura2,altura1);
						Thread thread2 = new Thread(conversor2);
						Runnable conversor3 = new Conversor(0,altura1,largura1,altura2);
						Thread thread3 = new Thread(conversor3);
						Runnable conversor4 = new Conversor(largura1,altura1,largura2, altura2);
						Thread thread4 = new Thread(conversor4);
						thread1.start();
						thread2.start();
						thread3.start();
						thread4.start();
						try {
							thread1.join();
							thread2.join();
							thread3.join();
							thread4.join();
						} catch (InterruptedException e) {
						}
						converter1 = (Conversor) conversor;
						converter1.Converter(diretorio2 + "\\imagem" + a + ".jpg");
						} catch (IOException e) {
						}
					System.out.println("Imagem " + a + " concluida");
					a++;
				}
				break;
			case 2:
				System.out.print("Quantas imagens especificas quer converter: ");
				verificador2 = input.nextInt();
				do {
					System.out.print("Diretorio da imagem a ser convertida: ");
					diretorio1 = leia.nextLine();
					System.out.print("Nome da imagem a ser convertida: ");
					nome = leia.nextLine();
					System.out.print("Tipo da imagem a ser convertida: ");
					tipo = leia.nextLine();
					System.out.print("Diretorio onde a imagem convertida vai ser salva: ");
					diretorio2 = leia.nextLine();
					Conversor converter2 = new Conversor();
					File file3 = new File(diretorio1);
					for (File file4 : file3.listFiles()) {
						if (file4.getName().equals(nome + "." + tipo)){
							try {
								conversor = new Conversor(file4);
								BufferedImage imagem = ImageIO.read(file4);
								largura1 = imagem.getWidth() / 2;
								altura1 = imagem.getHeight() / 2;
								largura2 = largura1 + largura1;
								altura2 = altura1 + altura1;
								Runnable conversor1 = new Conversor(0,0,largura1,altura1);
								Thread thread1 = new Thread(conversor1);
								Runnable conversor2 = new Conversor(largura1,0,largura2,altura1);
								Thread thread2 = new Thread(conversor2);
								Runnable conversor3 = new Conversor(0,altura1,largura1,altura2);
								Thread thread3 = new Thread(conversor3);
								Runnable conversor4 = new Conversor(largura1,altura1,largura2, altura2);
								Thread thread4 = new Thread(conversor4);
								thread1.start();
								thread2.start();
								thread3.start();
								thread4.start();
								try {
									thread1.join();
									thread2.join();
									thread3.join();
									thread4.join();
								} catch (InterruptedException e) {
								}
								converter2 = (Conversor) conversor;
								converter2.Converter(diretorio2 + "\\imagem" + a + ".jpg");
								} catch (IOException e) {
								}
							System.out.println("Imagem " + a + " concluida");
							a++;
							break;
							}
						}
					i++;
				} while (i < verificador2);
				break;
			case 3:
				System.out.println("Saindo");
				verificador1 = 0;
				break;	
			}
		} while (verificador1 != 0);		
	}
}
