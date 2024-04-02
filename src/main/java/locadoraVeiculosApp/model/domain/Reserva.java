package locadoraVeiculosApp.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Reserva {
	private double taxaSeguro;
	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private Veiculo veiculo;

	public Reserva() {
	}

	public Reserva(double taxaSeguro, LocalDateTime dataInicial, LocalDateTime dataFinal, Veiculo veiculo) {
		super();
		this.taxaSeguro = taxaSeguro;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.veiculo = veiculo;
	}

	public boolean criarReserva(Veiculo veiculo, LocalDateTime dataInicial, LocalDateTime dataFinal,
			List<Reserva> reservas) {
		if (verificaConflito(veiculo, dataInicial, dataFinal, reservas)) {
			System.out.println("Conflito de reserva encontrado. Não foi possível criar a reserva.");
			return false;
		}

		veiculo.marcarComoIndisponivel(dataInicial, dataFinal);
		System.out.println("Reserva criada com sucesso!");

		return true;
	}

	private boolean verificaConflito(Veiculo veiculo, LocalDateTime dataInicial, LocalDateTime dataFinal,
			List<Reserva> reservas) {
		for (Reserva reservaExistente : reservas) {
			if (reservaExistente.getVeiculo().equals(veiculo)) {
				if (dataInicial.isBefore(reservaExistente.getDataFinal())
						&& dataFinal.isAfter(reservaExistente.getDataInicial())) {
					return true;
				}
			}
		}
		return false;
	}

	public double getTaxaSeguro() {
		return taxaSeguro;
	}

	public void setTaxaSeguro(double taxaSeguro) {
		this.taxaSeguro = taxaSeguro;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

}
