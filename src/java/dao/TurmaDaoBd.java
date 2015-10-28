/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Turma;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class TurmaDaoBd implements InterfaceDao<Turma>{

    @Override
    public void inserir(Turma bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        Turma turma = new Turma();
        turma.setNome(bean.getNome());
        turma.setMateria(bean.getMateria());
        turma.setQtdAlunos(bean.getQtdAlunos());
        turma.setAlunos(bean.getAlunos());
        
        em.getTransaction().commit();
        em.close();        
    }

    @Override
    public void deletar(Turma bean) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.remove(em.merge(bean));
        
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void atualizar(Turma bean) {
        
    }

    @Override
    public List listar() {
        EntityManager em = JpaUtil.getEntityManager();
        
        List<Turma> listaTurma = em.createQuery("SELECT t FROM Turma t").getResultList();
        
        em.close();
        return (listaTurma);
    }
    
    public Turma buscaPorId(Long id){
        EntityManager em = JpaUtil.getEntityManager();
        Turma turma = em.find(Turma.class, id);
        em.close();
        return (turma);
    }
}
