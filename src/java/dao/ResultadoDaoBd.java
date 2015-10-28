/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Resultado;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class ResultadoDaoBd implements InterfaceDao<Resultado>{

    @Override
    public void inserir(Resultado bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        Resultado resultado = new Resultado();
        resultado.setPontuacao(bean.getPontuacao());
        
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deletar(Resultado bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.remove(em.merge(bean));
        
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Resultado bean) {
        
    }

    @Override
    public List listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Resultado> listaResultados = em.createQuery("SELECT r FROM Resultado r").getResultList();
        em.close();
        return (listaResultados);
    }
    
    public Resultado buscaPorId(Long id){
        EntityManager em = JpaUtil.getEntityManager();
        Resultado resultado = em.find(Resultado.class, id);
        em.close();
        return (resultado);
    }
    
    
    
}
