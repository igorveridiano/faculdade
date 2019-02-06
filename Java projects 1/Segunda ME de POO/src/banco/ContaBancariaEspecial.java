package banco;

public class ContaBancariaEspecial extends ContaEspecial {

	public ContaBancariaEspecial(int numeroAgencia, int numeroConta, String nomeCliente, int senhaCliente, int cpf,
			double saldo, double limiteChequeEspecial) {
		super(numeroAgencia, numeroConta, nomeCliente, senhaCliente, cpf, saldo, limiteChequeEspecial);
	}

}
