package locadoraVeiculosApp.model.domain;

public class Moto extends Veiculo {

	private String tipoCombustivel;
	private int cilindradas;
	private boolean partidaEletrica;

	
	public Moto() {}
	
//	public Moto(String marca, String modelo) {
//		super(marca, modelo);
//		this.tipoCombustivel = "Gasolina";
//		this.cilindradas = 78;
//		this.partidaEletrica = true;
//	}

	public Moto (String marca, String modelo, int ano, double valor,String tipoCombustivel, int cilindradas, boolean partidaEletrica) {
		super(marca, modelo, ano, valor);
		this.tipoCombustivel = tipoCombustivel;
		this.cilindradas = cilindradas;
		this.partidaEletrica = partidaEletrica;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	public boolean isPartidaEletrica() {
		return partidaEletrica;
	}

	public void setPartidaEletrica(boolean partidaEletrica) {
		this.partidaEletrica = partidaEletrica;
	}

	@Override
	public String toString() {
		return super.toString()+ "\nTipo Combustivel: " + tipoCombustivel 
				+ "\nCilindradas: " + cilindradas 
				+ "\nPartida Eletrica: " + partidaEletrica;
	}
}
