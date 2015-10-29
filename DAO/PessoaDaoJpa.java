
import entidade.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;

public class PessoaDaoJpa implements PessoaDao {
    

    @Override
    public void salvar(Pessoa p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (p.getId() == null) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Pessoa p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(p));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Pessoa pessoa = em.find(Pessoa.class, id);
        em.close();
        return (pessoa);
    }

    @Override
    public List<Pessoa> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Pessoa> listaPessoas = em.createQuery("SELECT p FROM Pessoa p").getResultList();
        em.close();
        return (listaPessoas);
    }

}
