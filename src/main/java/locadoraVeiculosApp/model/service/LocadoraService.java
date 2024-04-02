package locadoraVeiculosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import locadoraVeiculosApp.model.domain.Locadora;

public class LocadoraService {
private static Map<String, Locadora> locadoras = new HashMap<String, Locadora>();
	
	public static void incluir (Locadora locadora) {
        locadoras.put(locadora.getCnpj(), locadora);
    }
	
	public static void excluir (String cnpj) {
        locadoras.remove(cnpj);
    }
	
	public static Collection <Locadora> obterLista(){
		return locadoras.values();
	}
	
	public static Locadora obterLocadora(String cnpj) {
        return locadoras.get(cnpj);
    }
}
