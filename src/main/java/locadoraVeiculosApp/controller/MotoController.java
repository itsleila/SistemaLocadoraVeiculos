package locadoraVeiculosApp.controller;

import java.util.Collection;

import com.google.gson.Gson;

import locadoraVeiculosApp.model.domain.Moto;
import locadoraVeiculosApp.model.service.MotoService;
import spark.Route;

public class MotoController {

	public static Route incluirMoto = (req, res) ->{	
		Moto moto = new Gson().fromJson(req.body(), Moto.class);
		MotoService.incluir(moto);
		return "Moto"+ moto +", foi incluido com sucesso!";
	};
	
	public static Route excluirMoto = (req, res) ->{
		String modelo =  String.valueOf(req.params("modelo"));
		Moto moto = MotoService.obterMoto(modelo);
		MotoService.excluir(modelo);
		return "Moto: "+moto +", foi excluido com sucesso!";
	};
	
	public static Route obterMoto = (req, res) ->{
		String modelo =  String.valueOf(req.params("modelo"));
		Moto moto = MotoService.obterMoto(modelo);
		return "Moto: "+ moto;
	};

	public static Route obterListaMotos = (req, res) ->{
		Collection<Moto> motos = MotoService.obterLista();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">");
        htmlBuilder.append("<section class=\"best_section\">")
                   .append("<div class=\"container\">")
                   .append("<div class=\"book_now\">")
                   .append("<div class=\"detail-box\">")
                   .append("<h2>Motos</h2>")
                   .append("<ul class=\"motos-list\">");
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
