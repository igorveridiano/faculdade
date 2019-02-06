package Banco;

public class ContaEspecial extends Conta {
	private double Limite_Especial;
	public ContaEspecial() {
		this.setNumero(random.nextInt(999)+1) ;
		this.setSaldo(0);
		this.setLimite_Especial(5000);
		
	}
	@Override
	public void depositar(){
		System.out.println("Insira o valor a ser depositado");
		double valor=input.nextDouble();
		if (this.Limite_Especial==5000) {
			this.setSaldo(this.getSaldo()+valor);
			
		}
		else{
			this.Limite_Especial+=valor;
			if (this.Limite_Especial>5000) {
				double valor1 =this.Limite_Especial-5000;
				this.setSaldo(valor1);
			}
			
			
		}
	}
	
	@Override
	public boolean sacar(){
		System.out.println("Insira o valor a ser sacado");
		double valor =input.nextDouble();
		if (valor>this.getSaldo()+this.Limite_Especial) {
			System.out.println("Valor superior ao saldo e ao limite");
			return false;
		}
		else{
			if (valor>this.getSaldo()) {
				this.setSaldo(this.getSaldo()-valor);
				this.Limite_Especial+=this.getSaldo();
				this.setSaldo(0);
			}
			else{
				this.setSaldo(this.getSaldo()-valor);
			}
			return true;
		}
	}
	public double getLimite_Especial() {
		return Limite_Especial;
	}
	public void setLimite_Especial(double limite_Especial) {
		Limite_Especial = limite_Especial;
	}

}
