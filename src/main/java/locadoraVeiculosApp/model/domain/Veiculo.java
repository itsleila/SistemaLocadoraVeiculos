package locadoraVeiculosApp.model.domain;

import java.time.LocalDateTime;

public class Veiculo {
	private String marca;
    private String modelo;
    private int ano;
    private double valor;
    private boolean disponivel = true;
    
    public Veiculo() {}
    
 
    
	public Veiculo(String marca, String modelo, int ano, double valor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}
	
	
	public void marcarComoIndisponivel(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        if (dataFinal.isBefore(dataInicial)) {
            System.out.println("Erro: Data final da reserva é anterior à data inicial.");
        }
        if (!disponivel) {
            System.out.println("Erro: O veículo já está indisponível para reservas.");
        }
        this.disponivel = false;
        System.out.println("Veículo marcado como indisponível para reservas.");
    }

	
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
    
	@Override
    public String toString() {
        return "\nMarca: " + marca + "\nModelo: " + modelo + "\nAno: " + ano + "\nValor: " + valor  ;
    }
    
}