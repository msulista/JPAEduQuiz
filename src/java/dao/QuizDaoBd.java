/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Quiz;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class QuizDaoBd implements InterfaceDao<Quiz>{
    
   
   
    private Session sessao;
    private Transaction trans;

    @Override
    public void inserir(Quiz quiz) {
        try{
                EntityManager em = JpaUtil.getEntityManager();
                em.getTransaction().begin();
                
                Quiz q = new Quiz();
                q.setInicio(quiz.getInicio());
                q.setTermino(quiz.getTermino());
                q.setTempoResposta(quiz.getTempoResposta());
                q.setPublicado(quiz.isPublicado());
                
                em.getTransaction().commit();
                em.close();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            sessao.close();
        }
       }

    @Override
    public void deletar(Quiz quiz) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(quiz));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Quiz quiz) {
        
    }      

    @Override
    public List<Quiz> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Quiz> listaQuiz = em.createQuery("SELECT p FROM Quiz q").getResultList();
        em.close();
        return (listaQuiz);
         
    }
        
    public Quiz buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Quiz quiz = em.find(Quiz.class, id);
        em.close();
        return (quiz);
    }
    
}
