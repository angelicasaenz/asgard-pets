package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService(){
        this.usuarios = new ArrayList<>();
    }

    // Registrar usuario

    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    // Buscar por cédula

    public Usuario buscarCedula(String cedula){
        for(Usuario u : usuarios){
            if (u.getCedula().equals(cedula)){
                return u;
            }
        }
        return  null;
    }

    // Mostrar usuarios

    public void mostrarUsuarios(){
        if (usuarios.isEmpty()){
            System.out.println("\nAún no hay usuarios registrados.");
        }else {
            for(Usuario u : usuarios){
                System.out.println(u);
            }
        }
    }


}
