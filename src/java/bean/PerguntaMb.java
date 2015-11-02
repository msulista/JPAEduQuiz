/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceDao;
import dao.PerguntaDaoBd;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Pergunta;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@SessionScoped
public class PerguntaMb {

    /**
     * Creates a new instance of PerguntaMb
     */
    private Pergunta pergunta;
    private InterfaceDao perguntaDao;
    private DataModel listaPerguntas;
    
    public PerguntaMb() {
        this.pergunta = new Pergunta();
        this.perguntaDao = new PerguntaDaoBd();
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }    
    
    public DataModel retornaListaPerguntas(){
        List<Pergunta> lista = perguntaDao.listar();
        this.listaPerguntas = new ListDataModel(lista);
        
        return (listaPerguntas);
    }
    
    public void cadastraPergunta(){
        this.perguntaDao.inserir(pergunta);
    }
    
}
