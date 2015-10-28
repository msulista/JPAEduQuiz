/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author marcus.rodrigues
 */
@Entity
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String respostaText;
    private boolean verdadeira;
    @JoinColumn(name = "idPergunta", referencedColumnName = "idPergunta")
    @OneToOne(optional = false, fetch = FetchType.EAGER)    
    private Pergunta idPergunta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespostaText() {
        return respostaText;
    }

    public void setRespostaText(String respostaText) {
        this.respostaText = respostaText;
    }

    public boolean isVerdadeira() {
        return verdadeira;
    }

    public void setVerdadeira(boolean verdadeira) {
        this.verdadeira = verdadeira;
    }

    public Pergunta getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Pergunta idPergunta) {
        this.idPergunta = idPergunta;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Resposta[ id=" + id + " ]";
    }
    
}
