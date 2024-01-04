package com.example.Proyecto_Usuario.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.Proyecto_Usuario.Model.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
