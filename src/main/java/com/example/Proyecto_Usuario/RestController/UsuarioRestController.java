package com.example.Proyecto_Usuario.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.Proyecto_Usuario.Model.Usuario;
import com.example.Proyecto_Usuario.Service.IUsuarioService;
import com.example.Proyecto_Usuario.Service.S3Service;




@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usSer;
	
	@Autowired
	private S3Service s3Service;
	
	@GetMapping("/lista-usuarios")
	public List<Usuario> listarUsuarios() {
	    return usSer.ListAll()
	            .stream()
	            .peek(usuario -> {
	                usuario.setImagenURL(s3Service.getObjectURL(usuario.getImagenPATH()));
	                usuario.setPdfURL(s3Service.getObjectURL(usuario.getPdfPATH()));
	            })
	            .collect(Collectors.toList());
	}
	
	@GetMapping("/find-usuario-id/{id}")
	public Usuario findUsuarioById(@PathVariable("id") Long id_usuario) {
		return usSer.findUsuarioById(id_usuario);
	}
	
	
	
	@PostMapping("/save-usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		usSer.saveUsuario(usuario);
		usuario.setImagenURL(s3Service.getObjectURL(usuario.getImagenPATH()));
		usuario.setPdfURL(s3Service.getObjectURL(usuario.getPdfPATH()));
		return usuario;
	}
	
	@PutMapping("/update-usuario/{id}")
	public Usuario updateUsuario(@RequestBody Usuario usuario,@PathVariable("id") Long id_usuario) {
		Usuario usDB = usSer.findUsuarioById(id_usuario);

		usDB.setUsuario(usuario.getUsuario());
		
		usDB.setContrasenia(usuario.getContrasenia());
		
		usDB.setEmail(usuario.getEmail());
		
		usDB.setUsu_estado(usuario.getUsu_estado());
		
		return usSer.saveUsuario(usDB);
	}
	
	@DeleteMapping("/delete-usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUsuario(@PathVariable("id") Long id_usuario) {
		usSer.deleteUsuario(id_usuario);
	}
}