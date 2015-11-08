/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Quiz;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class QuizDaoBd implements InterfaceDao<Quiz>{   

    @Override
    public void inserir(Quiz bean) {
        try{
                EntityManager em = JpaUtil.getEntityManager();
                em.getTransaction().begin();
                
               if(bean.getIdQuiz() == null){
                   em.persist(bean);
               }else{
                   em.merge(bean);
               }
                
                em.getTransaction().commit();
                em.close();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            
        }
       }

    @Override
    public void deletar(Quiz bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(bean));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Quiz quiz) {
        
    }      

    @Override
    public List<Quiz> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List listaQuiz;
        try{
            //listaQuiz = em.createQuery("SELECT q FROM Quiz q").getResultList();
            listaQuiz = em.createNativeQuery("Select * from quiz").getResultList();
            if (listaQuiz != null) {
                
            return listaQuiz;
            }else
                return null;
        }
        catch(Exception ex){
         throw ex;
         
        }
        finally{
        em.close();
        }
        
        
         
    }
        
    public Quiz buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Quiz quiz = em.find(Quiz.class, id);
        em.close();
        return (quiz);
    }
    
}
