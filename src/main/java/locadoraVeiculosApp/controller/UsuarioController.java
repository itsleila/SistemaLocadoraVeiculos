package locadoraVeiculosApp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

import com.google.gson.Gson;

import locadoraVeiculosApp.model.domain.Endereco;
import locadoraVeiculosApp.model.domain.Usuario;
import locadoraVeiculosApp.model.service.UsuarioService;
import spark.Route;

public abstract class UsuarioController implements Route{
	
	private static Gson gson = new Gson();
	public static Route incluirUsuario = (req, res) -> {
		Usuario usuario = new Gson().fromJson(req.body(), Usuario.class);
		String cep = usuario.getEndereco().getCep(); 
		Endereco endereco = getEnderecoFromAPI(cep);
		usuario.setEndereco(endereco);
		UsuarioService.adicionarUsuario(usuario);
		return "Usuario " + usuario.getNome() + ", foi incluído com sucesso!";
	};

	public static Route excluirUsuario = (req, res) -> {
		String email = String.valueOf(req.params("email"));
		Usuario usuario = UsuarioService.obterUsuario(email);
		UsuarioService.excluir(email);
		return "Usuario: " + usuario.getNome() + ", foi excluido com sucesso!";
	};

	public static Route obterUsuario = (req, res) -> {
		String email = String.valueOf(req.params("email"));
		Usuario usuario = UsuarioService.obterUsuario(email);
		return "Usuario:" + usuario;
	};

	 public static Route obterListaUsuarios = (req, res) -> {
	        Collection<Usuario> usuarios = UsuarioService.obterLista();
	        StringBuilder htmlBuilder = new StringBuilder();
	        htmlBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">");
	        htmlBuilder.append("<section class=\"best_section\">")
	                   .append("<div class=\"container\">")
	                   .append("<div class=\"book_now\">")
	                   .append("<div class=\"detail-box\">")
	                   .append("<h2>Usuarios</h2>")
	                   .append("<ul class=\"usuarios-list\">");
	        for (Usuario usuario : usuarios) {
	            htmlBuilder.append("<li>").append(usuario.getNome()).append("</li>");
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