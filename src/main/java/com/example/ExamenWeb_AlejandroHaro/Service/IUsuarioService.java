package com.example.ExamenWeb_AlejandroHaro.Service;

import java.util.List;

import com.example.ExamenWeb_AlejandroHaro.Model.Usuario;



public interface IUsuarioService {
	public List<Usuario> ListAll();

	public Usuario saveUsuario(Usuario usuario);

	public Usuario findUsuarioById(Long id_usu);
	public Usuario updateUsuario(Long id_usu, Usuario usuario);

    public void deleteUsuario(Long id_usu);
}
