/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Pontuacao;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class PontuacaoDaoBd implements InterfaceDao<Pontuacao>{

    @Override
    public void inserir(Pontuacao bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        Pontuacao resultado = new Pontuacao();
        resultado.setPontuacao(bean.getPontuacao());
        
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deletar(Pontuacao bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.remove(em.merge(bean));
        
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Pontuacao bean) {
        
    }

    @Override
    public List listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Pontuacao> listaPontos = em.createQuery("SELECT p FROM Pontuacao p").getResultList();
        em.close();
        return (listaPontos);
    }
    
    public Pontuacao buscaPorId(Long id){
        EntityManager em = JpaUtil.getEntityManager();
        Pontuacao pontuacao = em.find(Pontuacao.class, id);
        em.close();
        return (pontuacao);
    }
    
    
    
}
