package locadoraVeiculosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import locadoraVeiculosApp.model.domain.Usuario;


public class UsuarioService {
	
	private static Map<String, Usuario> usuarios = new HashMap<String, Usuario>();


    public static void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }

    public static Usuario obterUsuario(String email) {
        return usuarios.get(email);
    }
    
    public static Collection <Usuario> obterLista(){
		return usuarios.values();
	}
    
    public static Usuario excluir (String email) {
		return usuarios.remove(email);
	}
	

}
