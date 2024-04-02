package locadoraVeiculosApp.model.domain;

import java.util.ArrayList;
import java.util.List;


public class Locadora {
	private String nome;
	private String cnpj;
	private double taxaSeguro;
	private Funcionario funcionario;
	private List<Veiculo> veiculos;
	

	public Locadora(String nome, String cnpj, double taxaSeguro) {
	    this.nome = nome;
	    this.cnpj = cnpj;
	    this.taxaSeguro = taxaSeguro;
	    this.veiculos = new ArrayList<>();
	}

	public Locadora(String nome, String cnpj, Funcionario funcionario, double taxaSeguro) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.funcionario = funcionario;
		this.taxaSeguro = 0.0;
		this.veiculos = new ArrayList<>();
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public double getTaxaSeguro() {
		return taxaSeguro;
	}

	public void setTaxaSeguro(double taxaSeguro) {
		this.taxaSeguro = taxaSeguro;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nCnpj: " + cnpj + "\nTaxa de seguro: " + taxaSeguro;
	}

}