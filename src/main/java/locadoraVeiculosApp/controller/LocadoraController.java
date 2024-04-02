package locadoraVeiculosApp.controller;

import java.util.Collection;

import com.google.gson.Gson;

import locadoraVeiculosApp.model.domain.Locadora;
import locadoraVeiculosApp.model.service.LocadoraService;
import spark.Route;

public class LocadoraController {
	public static Route incluirLocadora = (req, res) -> {
	    Locadora locadora = new Gson().fromJson(req.body(), Locadora.class);
	    LocadoraService.incluir(locadora);
	    return "Locadora: " + locadora.getNome() + "\nfoi incluída com sucesso!";
	};

	public static Route excluirLocadora = (req, res) -> {
		String cnpj = String.valueOf(req.params("cnpj"));
		Locadora locadora = LocadoraService.obterLocadora(cnpj);
		LocadoraService.excluir(cnpj);
		return "A locadora: " + locadora + " foi excluido com sucesso!";
	};

	public static Route obterLocadora = (req, res) -> {
		String cnpj = String.valueOf(req.params("cnpj"));
		Locadora locadora = LocadoraService.obterLocadora(cnpj);
		return "Locadora: " + locadora;
	};

	public static Route obterListaLocadoras = (req, res) -> {
		Collection<Locadora> locadoras = LocadoraService.obterLista();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">");
        htmlBuilder.append("<section class=\"best_section\">")
                   .append("<div class=\"container\">")
                   .append("<div class=\"book_now\">")
                   .append("<div class=\"detail-box\">")
                   .append("<h2>Locadoras</h2>")
                   .append("<ul class=\"locadoras-list\">");
        for (Locadora locadora : locadoras) {
            htmlBuilder.append("<li>").append(locadora.getNome()).append("</li>");
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