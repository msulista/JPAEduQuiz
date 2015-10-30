/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fabregas
 */
@MappedSuperclass
@Table(name = "resposta")
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdResposta")
    private Integer idResposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "resposta_text")
    private String respostaText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verdadeira")
    private boolean verdadeira;
    @JoinColumn(name = "IdPergunta", referencedColumnName = "IdPergunta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pergunta idPergunta;

    public Resposta() {
    }

    public Resposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Resposta(Integer idResposta, String respostaText, boolean verdadeira) {
        this.idResposta = idResposta;
        this.respostaText = respostaText;
        this.verdadeira = verdadeira;
    }

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
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

    public Pergunta getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Pergunta idPergunta) {
        this.idPergunta = idPergunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Resposta[ idResposta=" + idResposta + " ]";
    }
    
}
