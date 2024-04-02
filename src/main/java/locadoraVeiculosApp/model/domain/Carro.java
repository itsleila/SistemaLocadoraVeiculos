package locadoraVeiculosApp.model.domain;

public class Carro extends Veiculo {
	private int qtdPorta;
	private int espacoInterno;
	private int capacidadePortaMalas;

	public Carro() {
	}

	
	public Carro(String marca, String modelo, int ano, double valor) {
		super(marca, modelo , ano, valor);
		this.qtdPorta = 4;
		this.espacoInterno = 5;
		this.capacidadePortaMalas = 63;
	}

	public Carro(String marca, String modelo, int ano, double valor, int qtdPorta, int espacoInterno,
			int capacidadePortaMalas) {
		super(marca, modelo, ano, valor);
		this.qtdPorta = qtdPorta;
		this.espacoInterno = espacoInterno;
		this.capacidadePortaMalas = capacidadePortaMalas;
	}

	public int getQtdPorta() {
		return qtdPorta;
	}

	public void setQtdPorta(int qtdPorta) {
		this.qtdPorta = qtdPorta;
	}

	public int getEspacoInterno() {
		return espacoInterno;
	}

	public void setEspacoInterno(int espacoInterno) {
		this.espacoInterno = espacoInterno;
	}

	public int getCapacidadePortaMalas() {
		return capacidadePortaMalas;
	}

	public void setCapacidadePortaMalas(int capacidadePortaMalas) {
		this.capacidadePortaMalas = capacidadePortaMalas;
	}

	@Override
	public String toString() {
		return super.toString()+ "\nQuantidade de portas: " + qtdPorta 
				+ "\nEspaço Interno: " + espacoInterno 
				+ "\nCapacidade Porta-Malas: " + capacidadePortaMalas;
	}

}
