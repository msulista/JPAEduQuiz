/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fabregas
 */
@Embeddable
public class UsuarioHasTurmaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTurma")
    private int idTurma;

    public UsuarioHasTurmaPK() {
    }

    public UsuarioHasTurmaPK(int idUsuario, int idTurma) {
        this.idUsuario = idUsuario;
        this.idTurma = idTurma;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idTurma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasTurmaPK)) {
            return false;
        }
        UsuarioHasTurmaPK other = (UsuarioHasTurmaPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idTurma != other.idTurma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.UsuarioHasTurmaPK[ idUsuario=" + idUsuario + ", idTurma=" + idTurma + " ]";
    }
    
}
