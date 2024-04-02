package locadoraVeiculosApp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

import com.google.gson.Gson;

import locadoraVeiculosApp.model.domain.Endereco;
import locadoraVeiculosApp.model.domain.Funcionario;
import locadoraVeiculosApp.model.service.FuncionarioService;
import spark.Route;

public class FuncionarioController {

	private static Gson gson = new Gson();

	public static Route incluirFuncionario = (req, res) -> {
		Funcionario funcionario = new Gson().fromJson(req.body(), Funcionario.class);
		String cep = funcionario.getEndereco().getCep(); 
		Endereco endereco = getEnderecoFromAPI(cep);
		funcionario.setEndereco(endereco);
		FuncionarioService.incluir(funcionario);
		return "Funcionario " + funcionario + " foi incluído com sucesso!";
	};

	public static Route excluirFuncionario = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		Funcionario funcionario = FuncionarioService.obterFuncionario(index);
		FuncionarioService.excluir(index);
		return "Funcionario: " + funcionario + " foi excluido com sucesso!";
	};

	public static Route obterFuncionario = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		Funcionario funcionario = FuncionarioService.obterFuncionario(index);
		return "Funcionario: " + funcionario;
	};

	//public static Route obterListaFuncionarios = (req, res) -> {
		//return FuncionarioService.obterLista();
	//};

	 public static Route obterListaFuncionarios = (req, res) -> {
	        Collection<Funcionario> funcionarios = FuncionarioService.obterLista();
	        StringBuilder htmlBuilder = new StringBuilder();
	        htmlBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">");
	        htmlBuilder.append("<section class=\"best_section\">")
	                   .append("<div class=\"container\">")
	                   .append("<div class=\"book_now\">")
	                   .append("<div class=\"detail-box\">")
	                   .append("<h2>Funcionários</h2>")
	                   .append("<ul class=\"funcionarios-list\">");
	        for (Funcionario funcionario : funcionarios) {
	            htmlBuilder.append("<li>").append(funcionario.getNome()).append("</li>");
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
	
	
	private static Endereco getEnderecoFromAPI(String cep) {
		try {
			String url = "https://viacep.com.br/ws/" + cep + "/json/";

			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					return gson.fromJson(reader, Endereco.class);
				}
			} else {
				System.out.println("Erro ao obter o endereço. Código de resposta: " + responseCode);
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
