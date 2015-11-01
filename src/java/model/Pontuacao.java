/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

/**
 *
 * @author Fabregas
 */
@MappedSuperclass
@Table(name = "pontuacao")
public class Pontuacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPontuacao")
    private Integer idPontuacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pontuacao")
    private double pontuacao;
    @JoinColumn(name = "IdQuiz", referencedColumnName = "IdQuiz")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Quiz idQuiz;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario idUsuario;

    public Pontuacao() {
    }

    public Pontuacao(Integer idPontuacao) {
        this.idPontuacao = idPontuacao;
    }

    public Pontuacao(Integer idPontuacao, double pontuacao) {
        this.idPontuacao = idPontuacao;
        this.pontuacao = pontuacao;
    }

    public Integer getIdPontuacao() {
        return idPontuacao;
    }

    public void setIdPontuacao(Integer idPontuacao) {
        this.idPontuacao = idPontuacao;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Quiz getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Quiz idQuiz) {
        this.idQuiz = idQuiz;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPontuacao != null ? idPontuacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pontuacao)) {
            return false;
        }
        Pontuacao other = (Pontuacao) object;
        if ((this.idPontuacao == null && other.idPontuacao != null) || (this.idPontuacao != null && !this.idPontuacao.equals(other.idPontuacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Pontuacao[ idPontuacao=" + idPontuacao + " ]";
    }
    
}
