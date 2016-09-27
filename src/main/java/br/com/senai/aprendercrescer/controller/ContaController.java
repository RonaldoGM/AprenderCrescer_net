/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.ContaDao;
import br.com.senai.aprendercrescer.model.Conta;
import br.com.senai.aprendercrescer.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Senai
 */
public class ContaController {
    ContaDao contaDao;

    public ContaController() {
        if (contaDao == null) {
            contaDao = new ContaDao();
        }
    }

    public boolean insereConta(Conta conta) {

        if (conta.getIdconta()!= 0) {
            return contaDao.updateConta(conta);
        } else {
            return contaDao.insereConta(conta);
        }
    }

    public ArrayList<Conta> getContas() {
        return contaDao.getContas();
    }

    public boolean deleteContas(int id) {
        return contaDao.deleteConta(id);
    }
    
    
}
