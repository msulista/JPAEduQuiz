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
import model.Quiz;
import model.Resposta;

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
    private PerguntaDaoBd perguntaDao;
    private DataModel listaPerguntas;
    private String respostas[];
    private Quiz quiz;
    
    public PerguntaMb() {
        this.respostas = new String[4];
        this.pergunta = new Pergunta();
        this.quiz = new Quiz();
        this.perguntaDao = new PerguntaDaoBd();        
    }

    public String[] getRespostas() {
        return respostas;
    }

    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }
    
    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }    
    
    
    
    public void cadastraPergunta(){
        cadastraResposta();
        this.perguntaDao.inserir(pergunta);
        pergunta = new Pergunta();
    }
    
    public String carregarQuiz(Quiz q){
         this.quiz = q;
         
         return "responderQuiz?faces-redirect=true";
    }
    public DataModel retornaListaPerguntas(){
        List<Pergunta> lista = perguntaDao.listaPerguntaQuiz(this.quiz);
        this.listaPerguntas = new ListDataModel(lista);
        
        return (listaPerguntas);
    }
   
    
    public void cadastraResposta(){
        for (int i = 0; i < 4; i++) {
            if(i == 0){
               Resposta resposta = new Resposta();
               resposta.setRespostaText(this.respostas[0]);
               resposta.setVerdadeira(true);
               this.pergunta.adicionaResposta(resposta);
            }else{
                Resposta resposta = new Resposta();
                resposta.setRespostaText(this.respostas[i]);
                resposta.setVerdadeira(false);
                this.pergunta.adicionaResposta(resposta);
            }
        }
    }
    
}
