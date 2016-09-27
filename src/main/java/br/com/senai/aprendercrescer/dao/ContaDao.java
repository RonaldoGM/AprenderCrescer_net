/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Conta;
import br.com.senai.aprendercrescer.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class ContaDao {

    Statement st;

    public ContaDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }

    public Conta getContaByID(int id) {
        ResultSet rs;
        Conta conta;
        try {
            rs = st.executeQuery("SELECT  IDCONTA, DESCRICAO, TIPOCONTA,"
                    + "FROM CONTA WHERE IDCONTA = " + id);
            while (rs.next()) {
                conta = new Conta();
                conta.setIdconta(rs.getInt("IDUSUARIO"));
                conta.setDescricao(rs.getString("DESCRICAO"));
                conta.setTipoconta(rs.getString("TIPOCONTA"));
                conta.setValor(Float.parseFloat(rs.getString("SENHAUSUARIO")));
                return conta;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereConta(Conta conta) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDCONTA)+1, 1) AS IDCONTA FROM CONTA ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDCONTA");
            }
            conta.setIdconta(id);
            sql = "INSERT INTO conta( idconta, descricao, tipoconta, valor)"
                    + "VALUES (" + conta.getIdconta()
                    + " , '" + conta.getDescricao()
                    + "' , '" + conta.getTipoconta()
                    + "' , " + conta.getValor() + ")";

            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public boolean updateConta(Conta conta) {
        Date data = new Date();
        String sql = "UPDATE conta SET "
                + "idconta=" + conta.getIdconta() + ", "
                + "idgrupo= 0 , "
                + "descrica='" + conta.getDescricao() + "',"
                + "tipoconta='" + conta.getTipoconta() + "', "
                + "valor='" + conta.getValor() + "',"
                + "WHERE idconta= " + conta.getIdconta() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update :" + ex);
        }
        return false;
    }

    public ArrayList<Conta> getContas() {
        ResultSet rs;
        Conta conta;
        ArrayList<Conta> lista = new ArrayList<Conta>();
        try {
            rs = st.executeQuery("SELECT  IDCONTA, DESCRICAO, TIPOCONTA, VALOR FROM CONTA ");
            while (rs.next()) {
                conta = new Conta();
                conta.setIdconta(rs.getInt("IDCONTA"));
                conta.setDescricao(rs.getString("DESCRICAO"));
                conta.setTipoconta(rs.getString("TIPOCONTA"));
                conta.setValor(Float.parseFloat(rs.getString("VALOR")));
                lista.add(conta);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteConta(int id) {
        String sql = "DELETE FROM CONTA WHERE IDCONTA = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }

}
