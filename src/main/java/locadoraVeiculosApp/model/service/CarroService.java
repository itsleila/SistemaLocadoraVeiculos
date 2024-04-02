package locadoraVeiculosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import locadoraVeiculosApp.model.domain.Carro;

public class CarroService {
	
	private static Map<String, Carro> carros = new HashMap<String, Carro>();
	
	public static void incluir (Carro carro) {
        carros.put(carro.getModelo(), carro);
    }
	
	public static void excluir (String modelo) {
        carros.remove(modelo);
    }
	
	public static Collection <Carro> obterLista(){
		return carros.values();
	}
	
	public static Carro obterCarro(String modelo) {
        return carros.get(modelo);
    }

}
