/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fabregas
 */
@MappedSuperclass
@Table(name = "pergunta")
public class Pergunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPergunta")
    private Integer idPergunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pergunta")
    private String pergunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pontuacao")
    private double pontuacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "materia")
    private String materia;
    @JoinColumn(name = "IdQuiz", referencedColumnName = "IdQuiz")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Quiz quiz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPergunta", fetch = FetchType.EAGER)
    private List<Resposta> respostaList;

    public Pergunta() {
    }

    public Pergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Pergunta(Integer idPergunta, String pergunta, double pontuacao, String materia) {
        this.idPergunta = idPergunta;
        this.pergunta = pergunta;
        this.pontuacao = pontuacao;
        this.materia = materia;
    }

    public Integer getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setIdQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Resposta> getRespostaList() {
        return respostaList;
    }

    public void setRespostaList(List<Resposta> respostaList) {
        this.respostaList = respostaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPergunta != null ? idPergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pergunta)) {
            return false;
        }
        Pergunta other = (Pergunta) object;
        if ((this.idPergunta == null && other.idPergunta != null) || (this.idPergunta != null && !this.idPergunta.equals(other.idPergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Pergunta[ idPergunta=" + idPergunta + " ]";
    }
    
}
