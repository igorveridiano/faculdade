package modelVo;

public class PersonVo {

	private int cpf;
	private String name;

	public PersonVo(int cpf, String name) {
		this.setCpf(cpf);
		this.setName(name);
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
