/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Resposta;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class RespostaDaoBd implements InterfaceDao<Resposta>{

    @Override
    public void inserir(Resposta bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        Resposta r = new Resposta();
        r.setRespostaText(bean.getRespostaText());
        r.setVerdadeira(bean.isVerdadeira());
        
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deletar(Resposta bean) {        
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.remove(em.merge(bean));
        
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void atualizar(Resposta bean) {
        
    }

    @Override
    public List listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Resposta> listaResposta = em.createQuery("SELECT r FROM Resposta r").getResultList();
        em.close();
        return (listaResposta);        
    }
    
    public Resposta buscarPorID(Long id){
        EntityManager em = JpaUtil.getEntityManager();
        Resposta resposta = em.find(Resposta.class, id);
        em.close();
        return  (resposta);
    }
    
    
}
