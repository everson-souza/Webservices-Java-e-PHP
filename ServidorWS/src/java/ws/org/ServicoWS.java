/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.org;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author evers
 */
@WebService(serviceName = "ServicoWS")
public class ServicoWS {
    ArrayList<Candidato> candidatos = new ArrayList<>();
    ArrayList<Vaga> vaga = new ArrayList<>();
    boolean ctrl = false;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "cadastroCandidato")
    public String cadastroCandidato(@WebParam(name = "cpf") String cpf, @WebParam(name = "nome") String nome, @WebParam(name = "contato") String contato, @WebParam(name = "area") String area, @WebParam(name = "cargaHoraria") Double cargaHoraria, @WebParam(name = "salario") Double salario) {
        //Cadastra o candidato passando codigo, nome, contato, area, carga horaria e salario
        Candidato _candidato = new Candidato();                
        _candidato.cpf = cpf;
        _candidato.nome = nome;
        _candidato.contato = contato;
        _candidato.area = area;
        _candidato.cargaHoraria = cargaHoraria;
        _candidato.salario = salario;
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i).cpf.equals(_candidato.cpf)){
                candidatos.get(i).nome          = _candidato.nome;
                candidatos.get(i).contato       = _candidato.contato;
                candidatos.get(i).area          = _candidato.area;
                candidatos.get(i).cargaHoraria  = _candidato.cargaHoraria;
                candidatos.get(i).salario       = _candidato.salario;
                ctrl = true;
            }
        }
        if(!ctrl){
            candidatos.add(_candidato);
            return("Candidato cadastrado com sucesso!");
        }else{
            return("Candidato alterado com suecesso!");
        }
            
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "cadastraVaga")
    public String cadastraVaga(@WebParam(name = "codigo") int codigo, @WebParam(name = "nome") String nome, @WebParam(name = "contato") String contato, @WebParam(name = "area") String area, @WebParam(name = "cargaHoraria") Double cargaHoraria, @WebParam(name = "salario") Double salario) {
        //Cadastra a vaga passando codigo, nome, contato, area, carga horaria e salario
        Vaga _vaga = new Vaga();
        _vaga.codigo = codigo;
        _vaga.nome = nome;
        _vaga.contato = contato;
        _vaga.area = area;
        _vaga.cargaHoraria = cargaHoraria;
        _vaga.salario = salario;
        
        for(int i = 0; i < vaga.size(); i++){
            if(vaga.get(i).codigo == _vaga.codigo){
                vaga.get(i).nome         = _vaga.nome;
                vaga.get(i).contato      = _vaga.contato;
                vaga.get(i).area         = _vaga.area;
                vaga.get(i).cargaHoraria = _vaga.cargaHoraria;
                vaga.get(i).salario      = _vaga.salario;
                ctrl = true;
            }
        }
        if(!ctrl){
            vaga.add(_vaga);
            return("Vaga cadastrada com sucesso!");
        }else{
            return("Vaga  alterada com sucesso!");
        }
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "consultaCandidato")
    public String consultaCandidato(@WebParam(name = "area") String area) {
        //Consulta candidato
        //Passa area como parâmetro
        //Retorna um json
        ArrayList<Candidato> _candidato = new ArrayList<>();
        
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i).area.equals(area)){
                _candidato.add(candidatos.get(i));
            }
        }
        String json = new Gson().toJson(_candidato);
        return json;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "consultaVaga")
    public String consultaVaga(@WebParam(name = "area") String area, @WebParam(name = "salario") Double salario) {
        //Consulta candidato
        //Passa area e salario como parâmetro
        //Retorna um json
        ArrayList<Vaga> _vaga = new ArrayList<>();
        
        for(int i = 0; i < vaga.size(); i++){
            if(vaga.get(i).area.equals(area) && vaga.get(i).salario <= salario){
                _vaga.add(vaga.get(i));
            }
        }
        String json = new Gson().toJson(_vaga);
        return json;
    }

    
}
