/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceDao;
import dao.PerguntaDaoBd;
import dao.QuizDaoBd;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Pergunta;
import model.Quiz;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@SessionScoped
public class QuizMb {

    /**
     * Creates a new instance of QuizMb
     */
    private Quiz quiz = new Quiz();
    private QuizDaoBd quizDao = new QuizDaoBd();
    private DataModel listaQuizes;
    private PerguntaDaoBd perguntaDao;
    
    public QuizMb(){
        
    }
   
    public DataModel retornaListaDeQuiz() {       
        List<Quiz> lista = quizDao.listar();
        listaQuizes = new ListDataModel(lista); 
        perguntaDao = new PerguntaDaoBd();
         return listaQuizes;        
    }
    
    //coisas do objeto Quiz

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public String adicionaPergunta(Quiz quiz){
        Pergunta pergunta = new Pergunta();
        pergunta.setIdQuiz(quiz);
        return "cadastroPergunta?faces-redirect=true";
    }
    public void cadastraQuiz(){
        this.quizDao.inserir(quiz);
        quiz = new Quiz();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.quiz);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuizMb other = (QuizMb) obj;
        if (!Objects.equals(this.quiz, other.quiz)) {
            return false;
        }
        return true;
    }
    
}
