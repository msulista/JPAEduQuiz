/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceDao;
import dao.PerguntaDaoBd;
import dao.QuizDaoBd;
import dao.RespostaDaoBd;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Pergunta;
import model.Quiz;
import model.Resposta;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@SessionScoped
public class GeradorDeTabelaMb {
    private Quiz quiz;
    private InterfaceDao quizDao;
    private Pergunta pergunta;
    private InterfaceDao perguntaDao;
    private Resposta resposta;
    private InterfaceDao respostaDao;

    /**
     * Creates a new instance of GeradorDeTabelaMb
     */
    public GeradorDeTabelaMb() {
        this.quiz = quiz;
        this.quizDao = new QuizDaoBd();
        this.pergunta = pergunta;
        this.perguntaDao = new PerguntaDaoBd();
        this.resposta = resposta;
        this.respostaDao = new RespostaDaoBd();
    }
    
    public void criaTabelas(){      
      Pergunta pergunta = new Pergunta();
      pergunta.setPontuacao(1.0);
      pergunta.setMateria("Teste");
      
      Resposta resposta1 = new Resposta();
      resposta1.setRespostaText("resp1");
      resposta1.setVerdadeira(true);
      
      Resposta resposta2 = new Resposta();
      resposta2.setRespostaText("resp2");
      resposta2.setVerdadeira(false);
      
      Resposta resposta3 = new Resposta();
      resposta3.setRespostaText("resp3");
      resposta3.setVerdadeira(false);
      
      Resposta resposta4 = new Resposta();
      resposta4.setRespostaText("resp4");
      resposta4.setVerdadeira(false);
      
      Quiz quiz = new Quiz();
      quiz.setEstado(true);
      quiz.setNome("Quiz1");
      
      quizDao.inserir(quiz);
    }
}
