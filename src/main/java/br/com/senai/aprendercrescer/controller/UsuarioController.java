/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;


import br.com.senai.aprendercrescer.dao.UsuarioDao;
import br.com.senai.aprendercrescer.model.Usuario;
import java.util.ArrayList;


/**
 *
 * @author Caluan Baierle
 */
public class UsuarioController {

    UsuarioDao usuarioDao;

    public UsuarioController() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
    }

    public boolean insereUsuario(Usuario usuario) {

        if (usuario.getIdUsuario() != 0) {
            return usuarioDao.updateUsuario(usuario);
        } else {
            return usuarioDao.insereUsuario(usuario);
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    public boolean deleteUsuario(int id) {
        return usuarioDao.deleteUsuario(id);
    }

    public Usuario validaLogin(Usuario usuario){
    
      return  usuarioDao.validaLogin(usuario);
    }
    
}
