/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fabregas
 */
@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdQuiz")
    private Integer idQuiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "termino")
    @Temporal(TemporalType.DATE)
    private Date termino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tempo_resposta")
    @Temporal(TemporalType.TIME)
    private Date tempoResposta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuiz", fetch = FetchType.EAGER)
    private List<Pontuacao> pontuacaoList;
   // @JoinColumn(name = "IdTurma", referencedColumnName = "IdTurma")
   // @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Transient
    private Turma turma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuiz", fetch = FetchType.EAGER)
    private List<Pergunta> perguntaList;

    public Quiz() {
    }

    public Quiz(Integer idQuiz) {
        this.idQuiz = idQuiz;
    }

    public Quiz(Integer idQuiz, Date inicio, Date termino, Date tempoResposta, boolean estado) {
        this.idQuiz = idQuiz;
        this.inicio = inicio;
        this.termino = termino;
        this.tempoResposta = tempoResposta;
        this.estado = estado;
    }

    public Integer getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Integer idQuiz) {
        this.idQuiz = idQuiz;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public Date getTempoResposta() {
        return tempoResposta;
    }

    public void setTempoResposta(Date tempoResposta) {
        this.tempoResposta = tempoResposta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Pontuacao> getPontuacaoList() {
        return pontuacaoList;
    }

    public void setPontuacaoList(List<Pontuacao> pontuacaoList) {
        this.pontuacaoList = pontuacaoList;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setIdTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Pergunta> getPerguntaList() {
        return perguntaList;
    }

    public void setPerguntaList(List<Pergunta> perguntaList) {
        this.perguntaList = perguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuiz != null ? idQuiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.idQuiz == null && other.idQuiz != null) || (this.idQuiz != null && !this.idQuiz.equals(other.idQuiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quiz[ idQuiz=" + idQuiz + " ]";
    }
    
}
