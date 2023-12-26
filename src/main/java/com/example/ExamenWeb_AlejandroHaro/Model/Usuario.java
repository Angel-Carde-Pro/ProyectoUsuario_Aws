package com.example.ExamenWeb_AlejandroHaro.Model;

import java.io.Serializable;

//import javax.persistence.*;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter

@Entity 
@Data
@NoArgsConstructor

public class Usuario implements Serializable {

	private static final long serialVersionUID = 4342051221624286849L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long usu_cod;
	
	private String usuario;
	private String email;
	private String contrasenia;

	private Boolean usu_estado;
    @Transient
	private String imagenURL;
	
	private String imagenPATH;
	
	@Transient
	private String pdfURL;
	
	private String pdfPATH;
	public Long getUsu_cod() {
		return usu_cod;
	}

	public void setUsu_cod(Long usu_cod) {
		this.usu_cod = usu_cod;
	}



	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getUsu_estado() {
		return usu_estado;
	}
	


	

	public void setUsu_estado(Boolean usu_estado) {
		this.usu_estado = usu_estado;
	}

}