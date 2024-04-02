package locadoraVeiculosApp.controller;

import java.util.Collection;

import com.google.gson.Gson;

import locadoraVeiculosApp.model.domain.Carro;
import locadoraVeiculosApp.model.service.CarroService;
import spark.Route;

public class CarroController {

	public static Route incluirCarro = (req, res) ->{	
		Carro carro = new Gson().fromJson(req.body(), Carro.class);
		CarroService.incluir(carro);
		return "Carro: "+ carro +"\nfoi incluido com sucesso!";
	};
	
	public static Route excluirCarro = (req, res) ->{
		String modelo =  String.valueOf(req.params("modelo"));
		Carro carro = CarroService.obterCarro(modelo);
		CarroService.excluir(modelo);
		return "O carro"+ carro.getModelo() +" foi excluido com sucesso!";
	};
	
	public static Route obterCarro = (req, res) ->{
		String modelo =  String.valueOf(req.params("modelo"));
		Carro carro = CarroService.obterCarro(modelo);
		return "Carro: "+ carro;
	};

	public static Route obterListaCarros = (req, res) ->{
		  Collection<Carro> carros = CarroService.obterLista();
	        StringBuilder htmlBuilder = new StringBuilder();
	        htmlBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">");
	        htmlBuilder.append("<section class=\"best_section\">")
	                   .append("<div class=\"container\">")
	                   .append("<div class=\"book_now\">")
	                   .append("<div class=\"detail-box\">")
	                   .append("<h2>Carros</h2>")
	                   .append("<ul class=\"carros-list\">");
	        for (Carro carro : carros) {
	            htmlBuilder.append("<li>").append(carro.getModelo()).append("</li>");
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
