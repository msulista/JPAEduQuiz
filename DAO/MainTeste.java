
import entidade.Pessoa;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lhries
 */
public class MainTeste {

    public static void main(String[] args) {
        
        
    }

    public static void inserir() {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String email = JOptionPane.showInputDialog("Email: ");
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setEmail(email);

        PessoaDao dao = new PessoaDaoJpa();
        dao.salvar(pessoa);
        JOptionPane.showMessageDialog(null, pessoa.getNome() + 
                " cadastrado com sucesso");
    }

    public static void remover() {
        Pessoa pessoa = procurar();
        if (pessoa == null) {
            JOptionPane.showMessageDialog(null, "ID nao encontrado!");
        } else {
            PessoaDao dao = new PessoaDaoJpa();
            dao.remover(pessoa);
            JOptionPane.showMessageDialog(null, pessoa.getNome() + 
                    " removido com sucesso!");
        }
    }

    public static void atualizar() {
        Pessoa pessoa = procurar();
        if (pessoa == null) {
            JOptionPane.showMessageDialog(null, "ID nao encontrado!");
        } else {
            PessoaDao dao = new PessoaDaoJpa();
            String nome = JOptionPane.showInputDialog("Nome: ");
            String email = JOptionPane.showInputDialog("Email: ");
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            dao.salvar(pessoa);
            JOptionPane.showMessageDialog(null, pessoa.getNome() + 
                    " atualizado com sucesso");
        }

    }

    public static void listarTodos() {
        PessoaDao dao = new PessoaDaoJpa();

        List<Pessoa> listaPessoas = dao.listar();

        String pessoas = "";
        for (Pessoa p : listaPessoas) {
            pessoas+= p.getNome()+" - "+p.getEmail()+"\n";
        }
        
        JOptionPane.showMessageDialog(null, "Lista de Pessoas: \n"+pessoas);
    }

    public static void visualizar() {
        Pessoa pessoa = procurar();
        JOptionPane.showMessageDialog(null, 
                pessoa.getNome() + " - " + pessoa.getEmail());
    }

    private static Pessoa procurar() {
        Long id = Long.valueOf(JOptionPane.showInputDialog("Id: "));

        PessoaDao dao = new PessoaDaoJpa();
        Pessoa pessoa = dao.buscarPorId(id);

        return (pessoa);
    }
}
