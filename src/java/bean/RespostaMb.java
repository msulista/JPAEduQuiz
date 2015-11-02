/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.RespostaDaoBd;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Pergunta;
import model.Resposta;

/**
 *
 * @author Fabregas
 */
@ManagedBean
@SessionScoped
public class RespostaMb {

    private Resposta resposta;
    private RespostaDaoBd respostaDao;
    
    public RespostaMb() {
        resposta = new Resposta();
        respostaDao = new RespostaDaoBd();
    }    
    
    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public void cadastraRespostaFalsa(){
        this.resposta.setPergunta(new Pergunta(1));
        this.resposta.setVerdadeira(false);
        this.respostaDao.inserir(resposta);
    }
//    public void cadastraRespostaVerdadeira(Pergunta pergunta){
//        this.resposta.setPergunta(pergunta);
//        this.resposta.setVerdadeira(true);
//        this.respostaDao.inserir(resposta);
//    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.resposta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RespostaMb other = (RespostaMb) obj;
        if (!Objects.equals(this.resposta, other.resposta)) {
            return false;
        }
        return true;
    }
    
    
}
