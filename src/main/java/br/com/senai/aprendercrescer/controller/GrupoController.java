/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;


import br.com.senai.aprendercrescer.dao.GrupoDao;
import br.com.senai.aprendercrescer.model.Grupo;
import java.util.ArrayList;


/**
 *
 * @author Caluan Baierle
 */
public class GrupoController {

    GrupoDao grupoDao;

    public GrupoController() {
        if (grupoDao == null) {
            grupoDao = new GrupoDao();
        }
    }

    public boolean insereGrupo(Grupo grupo) {

        if (grupo.getIdgrupo() != 0) {
            return grupoDao.updateGrupo(grupo);
        } else {
            return grupoDao.insereGrupo(grupo);
        }

    }

    public ArrayList<Grupo> getGrupos() {
        return grupoDao.getGrupos();
    }

    public boolean deleteGrupo(int id) {

        return grupoDao.deleteGrupo(id);
    }

}
