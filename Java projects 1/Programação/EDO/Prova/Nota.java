package Prova;

public class Nota {
		private double nota1;
		private double nota2;
		private double media;
		private Turma turma;
		
		public Nota(double nota1, double nota2,Turma turma) {

			this.turma=turma;
			this.nota1 = nota1;
			this.nota2 = nota2;
			this.media = (nota1*0.4+nota2*0.6);
		}
		public Turma getTurma() {
			return turma;
		}
		public void setTurma(Turma turma) {
			this.turma = turma;
		}
		public double getNota1() {
			return nota1;
		}
		public void setNota1(double nota1) {
			this.nota1 = nota1;
		}
		public double getNota2() {
			return nota2;
		}
		public void setNota2(double nota2) {
			this.nota2 = nota2;
		}
		public double getMedia() {
			return media;
		}
		public void setMedia(double media) {
			this.media = media;
		}
}
