package locadoraVeiculosApp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import locadoraVeiculosApp.model.domain.Endereco;
import spark.Request;
import spark.Response;
import spark.Route;

public class EnderecoController {
    private static Gson gson = new Gson();

    public static Route qetAddress = (Request req, Response res) -> {
        String cep = req.params("cep");
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                Endereco endereco = gson.fromJson(reader, Endereco.class);
                return endereco.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return "Erro ao obter o endereço: " + e.getMessage();
            }
        } else {
            return "Erro ao obter o endereço. Código de resposta: " + responseCode;
        }
    };

}
