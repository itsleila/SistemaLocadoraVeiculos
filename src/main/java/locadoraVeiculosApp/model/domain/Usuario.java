package locadoraVeiculosApp.model.domain;

public class Usuario {
	private String nome;
	private String email;
	private String telefone;
    private Endereco endereco;
	private Veiculo veiculo;
    
    
    public Usuario(String nome) {
		this.nome = nome;
    }
    public Usuario(String nome, String email, String telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public Usuario(String nome, String email, String telefone, Endereco endereco, Veiculo veiculo) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.veiculo = veiculo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	

	public Veiculo getVeiculo(){
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
    public String toString() {
        return "\nNome: " + nome + "\nEmail: " + email + "\nTelefone: " + telefone ;
    }
    
}
