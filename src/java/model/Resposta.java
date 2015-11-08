/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fabregas
 */
@Embeddable
public class Resposta{
    @Basic(optional = false)
    @NotNull
    @Column(name = "resposta_text")
    private String respostaText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verdadeira")
    private boolean verdadeira;

    public Resposta() {
    }


    public Resposta(Integer idResposta, String respostaText, boolean verdadeira) {
        this.respostaText = respostaText;
        this.verdadeira = verdadeira;
    }


    public String getRespostaText() {
        return respostaText;
    }

    public void setRespostaText(String respostaText) {
        this.respostaText = respostaText;
    }

    public boolean getVerdadeira() {
        return verdadeira;
    }

    public void setVerdadeira(boolean verdadeira) {
        this.verdadeira = verdadeira;
    }


//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idResposta != null ? idResposta.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Resposta)) {
//            return false;
//        }
//        Resposta other = (Resposta) object;
//        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "model.Resposta[ idResposta=" + idResposta + " ]";
//    }
    
}
