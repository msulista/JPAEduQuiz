/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Usuario;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class UsuarioDaoBd implements InterfaceDao<Usuario>{  
    

    @Override
    public void inserir(Usuario bean) {
            
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            try{ 
                Usuario usuario = new Usuario();
                usuario.setNome(bean.getNome());
                usuario.setTelefone(bean.getTelefone());
                usuario.setEmail(bean.getEmail());
                usuario.setSenha(bean.getSenha());
                
                em.getTransaction().commit();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            finally{
                em.close();
            }
        
    }

    @Override
    public void deletar(Usuario bean) {
    
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(bean));
        em.getTransaction().commit();
        em.close();        
    }

    @Override
    public void atualizar(Usuario bean) {
    
       
    }

    @Override
    public List listar() {
        
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> listaUsuario = em.createQuery("SELECT p FROM Usuario u").getResultList();
        em.close();
        return (listaUsuario);
    }
}
