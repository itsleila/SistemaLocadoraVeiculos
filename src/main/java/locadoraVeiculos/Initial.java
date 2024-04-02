package locadoraVeiculos;
import locadoraVeiculosApp.controller.CarroController;
import locadoraVeiculosApp.controller.FuncionarioController;
import locadoraVeiculosApp.controller.LocadoraController;
import locadoraVeiculosApp.controller.MotoController;
import locadoraVeiculosApp.controller.UsuarioController;
import locadoraVeiculosApp.controller.VeiculoController;
import spark.Spark;

public class Initial {
    public static void main(String[] args) {
        Spark.port(8080);
        Spark.staticFileLocation("/public");

		/// index
		Spark.get("/", (req, res) -> {
			return Initial.class.getResourceAsStream("/index.html");
		});

		/// usuario
		Spark.get("/usuario/lista", UsuarioController.obterListaUsuarios);
		Spark.get("/usuario/:email", UsuarioController.obterUsuario);
		Spark.post("/usuario/incluir", UsuarioController.incluirUsuario);
		Spark.delete("/usuario/:email/excluir", UsuarioController.excluirUsuario);
		
		/// funcionario
		Spark.get("/funcionario/lista", FuncionarioController.obterListaFuncionarios);
		Spark.get("/funcionario/:id", FuncionarioController.obterFuncionario);
		Spark.post("/funcionario/incluir", FuncionarioController.incluirFuncionario);
		Spark.delete("/funcionario/:id/excluir", FuncionarioController.excluirFuncionario);

		/// carro
		Spark.post("/carro/incluir", CarroController.incluirCarro);
		Spark.get("/carro/lista", CarroController.obterListaCarros);
		Spark.get("/carro/:modelo", CarroController.obterCarro);
		Spark.delete("/carro/:modelo/excluir", CarroController.excluirCarro);

		/// moto
		Spark.post("/moto/incluir", MotoController.incluirMoto);
		Spark.get("/moto/lista", MotoController.obterListaMotos);
		Spark.get("/moto/:modelo", MotoController.obterMoto);
		Spark.delete("/moto/:modelo/excluir", MotoController.excluirMoto);
		
		
		/// veiculos
		Spark.get("/veiculo/lista", VeiculoController.obterListaVeiculos);

		/// locadora
		Spark.post("/locadora/incluir", LocadoraController.incluirLocadora);
		Spark.get("/locadora/lista", LocadoraController.obterListaLocadoras);
		Spark.get("/locadora/:cnpj", LocadoraController.obterLocadora);
		Spark.delete("/locadora/:cnpj/excluir", LocadoraController.excluirLocadora);
		
	}
}
