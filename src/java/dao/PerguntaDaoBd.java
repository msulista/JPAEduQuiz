/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Pergunta;
import model.Quiz;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class PerguntaDaoBd implements InterfaceDao<Pergunta>{

    @Override
    public void inserir(Pergunta bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        if(bean.getIdPergunta() == null){
            em.persist(bean);
        }else{
            em.merge(bean);
        }       

        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void deletar(Pergunta bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(bean));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Pergunta bean) {
        
    }

    @Override
    public List<Pergunta> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Pergunta> listPergunta = em.createQuery("SELECT p FROM Pergunta p").getResultList();
        em.close();
        return (listPergunta);
    }
    
    public Pergunta buscarPorId(Long id){
        EntityManager em = JpaUtil.getEntityManager();
        Pergunta pergunta = em.find(Pergunta.class, id);
        em.close();
        return (pergunta);
    }
    
    public List<Pergunta> listaPerguntaQuiz(Quiz q){
        EntityManager em = JpaUtil.getEntityManager();
        List<Pergunta> perguntas = em.createNativeQuery("SELECT * FROM Pergunta where idQuiz = "+q.getIdQuiz()).getResultList();
        return perguntas;
    }
}
