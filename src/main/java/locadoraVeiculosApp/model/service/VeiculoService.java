package locadoraVeiculosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import locadoraVeiculosApp.model.domain.Veiculo;

public class VeiculoService {
    private static Map<String, Veiculo> veiculos = new HashMap<>();

    public static void adicionarVeiculo(Veiculo veiculo) {
        veiculos.put(veiculo.getModelo(), veiculo);
    }

    public static void excluirVeiculo(String modelo) {
        veiculos.remove(modelo);
    }

    public static Collection<Veiculo> obterListaVeiculos() {
        return veiculos.values();
    }

    public static Veiculo obterVeiculo(String modelo) {
        return veiculos.get(modelo);
    }
}