package locadoraVeiculosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import locadoraVeiculosApp.model.domain.Moto;

public class MotoService {
	
	private static Map<String, Moto> motos = new HashMap<String, Moto>();
	
	public static void incluir (Moto moto) {
        motos.put(moto.getModelo(), moto);
    }
	
	public static void excluir (String modelo) {
        motos.remove(modelo);
    }
	
	public static Collection <Moto> obterLista(){
		return motos.values();
	}
	
	public static Moto obterMoto(String modelo) {
        return motos.get(modelo);
    }

}
