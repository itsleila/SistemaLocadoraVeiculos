package locadoraVeiculosApp.controller;


import java.util.Collection;

import com.google.gson.Gson;

import locadoraVeiculosApp.model.domain.Carro;
import locadoraVeiculosApp.model.domain.Moto;
import locadoraVeiculosApp.model.domain.Veiculo;
import locadoraVeiculosApp.model.service.CarroService;
import locadoraVeiculosApp.model.service.MotoService;
import locadoraVeiculosApp.model.service.VeiculoService;
import spark.Route;

public class VeiculoController {
	

    public static Route incluirVeiculo = (req, res) -> {  
        Veiculo veiculo = new Gson().fromJson(req.body(), Veiculo.class);
        VeiculoService.adicionarVeiculo(veiculo);
        return "Veiculo: "+ veiculo +", foi incluido com sucesso!";
    };
    
    public static Route excluirVeiculo = (req, res) -> {
        String modelo = String.valueOf(req.params("modelo"));
        Veiculo veiculo = VeiculoService.obterVeiculo(modelo);
        VeiculoService.excluirVeiculo(modelo);
        return "Veiculo: "+ veiculo +", foi excluido com sucesso!";
    };
    
    public static Route obterVeiculo = (req, res) -> {
        String modelo = String.valueOf(req.params("modelo"));
        Veiculo veiculo = VeiculoService.obterVeiculo(modelo);
        return "Veiculo: "+ veiculo;
    };

    public static Route obterListaVeiculos = (req, res) -> {
        Collection<Carro> carros = CarroService.obterLista();
        Collection<Moto> motos = MotoService.obterLista();

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">");
        htmlBuilder.append("<section class=\"best_section\">")
                   .append("<div class=\"container\">")
                   .append("<div class=\"book_now\">")
                   .append("<div class=\"detail-box\">")
                   .append("<h2>Veículos</h2>")
                   .append("<ul class=\"veiculos-list\">");
        for (Carro carro : carros) {
            htmlBuilder.append("<li>").append(carro.getModelo()).append("</li>");
        }
        for (Moto moto : motos) {
            htmlBuilder.append("<li>").append(moto.getModelo()).append("</li>");
        }

        htmlBuilder.append("</ul>")
                   .append("</div>")
                   .append("<div class=\"btn-box\">")
                   .append("<a href=\"/\" class=\"btn-home\">Home</a>")
                   .append("</div>")
                   .append("</div>")
                   .append("</div>")
                   .append("</section>");

        return htmlBuilder.toString();
    };
}
