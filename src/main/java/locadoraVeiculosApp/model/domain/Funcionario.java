package locadoraVeiculosApp.model.domain;

public class Funcionario {
	private Integer id;
	
	private String nome;
    private String cargo;
    private double salario;
    private String email;
    private String telefone;
    private Endereco endereco;
    
    
    public Funcionario() {}
    

	public Funcionario(String nome, String cargo, double salario, Endereco endereco) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.endereco = endereco;
	}
	
	

	public Funcionario(String nome, String cargo, double salario, String email, String telefone,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
        String enderecoStr = (endereco != null) ? endereco.toString() : "Endereço não especificado";
        return "\n id: " + id + "\nNome: " + nome + "\nCargo: " + cargo + "\nSalario: " + salario +
                "\nEmail: " + email + "\nTelefone: " + telefone + "\nEndereco: " + enderecoStr + "\n" ;
    }
	
	

}
