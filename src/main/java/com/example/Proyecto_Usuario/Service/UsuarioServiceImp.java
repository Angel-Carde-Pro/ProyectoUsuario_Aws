package com.example.Proyecto_Usuario.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Proyecto_Usuario.Dao.IUsuarioDao;
import com.example.Proyecto_Usuario.Model.Usuario;

@Service
public class UsuarioServiceImp  implements IUsuarioService{
   
	@Autowired
	private IUsuarioDao usuarioDao;
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> ListAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	 public Usuario findUsuarioById(Long id_usu) {
        return usuarioDao.findById(id_usu).orElse(null);
    }

	@Override
    @Transactional
    public Usuario updateUsuario(Long id_usu, Usuario usuario) {
        Usuario existingUsuario = usuarioDao.findById(id_usu).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setUsuario(usuario.getUsuario());
            existingUsuario.setContrasenia(usuario.getContrasenia());
            existingUsuario.setEmail(usuario.getEmail());
            existingUsuario.setUsu_estado(usuario.getUsu_estado());
            return usuarioDao.save(existingUsuario);
        }
        return null;
    }

	  @Override
	    @Transactional
	    public void deleteUsuario(Long id_usu) {
	        usuarioDao.deleteById(id_usu);
	    }

}
