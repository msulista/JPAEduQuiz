import entidade.Pessoa;
import java.util.List;

public interface PessoaDao {
    public void remover(Pessoa p);
    public void salvar(Pessoa p);
    public Pessoa buscarPorId(Long id);
    public List<Pessoa> listar();                
}
