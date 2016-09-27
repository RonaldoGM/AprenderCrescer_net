/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.GrupoController;
import br.com.senai.aprendercrescer.model.Grupo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Senai
 */
@Path("/grupo")
public class GrupoWs {

    @GET
    @Path("/getgrupos")
    @Produces("application/json")
    public Response getGrupo() {
        try {
            GrupoController grupoController;
            grupoController = new GrupoController();
            ArrayList<Grupo> lista = grupoController.getGrupos();
            JSONObject retorno = new JSONObject();
            JSONObject jGrupo;

            for (Grupo grupo : lista) {

                jGrupo = new JSONObject();
                jGrupo.put("idGrupo", grupo.getIdgrupo());
                jGrupo.put("tipousuario", grupo.getTipousuario());
                jGrupo.put("descricaogrupo", grupo.getDescricaogrupo());
                retorno.put("grupo" + grupo.getIdgrupo(), jGrupo.toString());
            }
            return Response.status(500).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            System.out.println("Erro:" + ex);
            return Response.status(200).entity(
                    "{erro : \"" + ex + "\"}").build();
        }
    }

    @POST
    @Path("/setgrupo")
     @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setGrupo(InputStream dadoServ) {
        //String Builder 
        StringBuilder requisicaofinal = new StringBuilder();
        String teste = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadoServ));
            String requisicao = null;

            while ((requisicao = in.readLine()) != null) {
                requisicaofinal.append(requisicao);
                teste = teste + requisicao;
            }
            System.out.println(requisicaofinal.toString());
            JSONObject resposta = new JSONObject(requisicaofinal.toString());
            Grupo grupo = new Grupo();
          //  grupo.setIdgrupo(resposta.getInt("idgrupo"));
            grupo.setTipousuario(resposta.getString("tipousuario"));
            grupo.setDescricaogrupo(resposta.getString("descricaogrupo"));
            new GrupoController().insereGrupo(grupo);
            Response.status(200).entity(
                    grupo.toString()).build();

        } catch (Exception ex) {

            return Response.status(501).
                    entity(ex.toString()).build();
        }
        return null;
    }
}
