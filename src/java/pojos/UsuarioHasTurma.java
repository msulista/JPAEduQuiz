/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 *
 * @author Fabregas
 */
@MappedSuperclass
@Table(name = "usuario_has_turma")
public class UsuarioHasTurma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasTurmaPK usuarioHasTurmaPK;

    public UsuarioHasTurma() {
    }

    public UsuarioHasTurma(UsuarioHasTurmaPK usuarioHasTurmaPK) {
        this.usuarioHasTurmaPK = usuarioHasTurmaPK;
    }

    public UsuarioHasTurma(int idUsuario, int idTurma) {
        this.usuarioHasTurmaPK = new UsuarioHasTurmaPK(idUsuario, idTurma);
    }

    public UsuarioHasTurmaPK getUsuarioHasTurmaPK() {
        return usuarioHasTurmaPK;
    }

    public void setUsuarioHasTurmaPK(UsuarioHasTurmaPK usuarioHasTurmaPK) {
        this.usuarioHasTurmaPK = usuarioHasTurmaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasTurmaPK != null ? usuarioHasTurmaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasTurma)) {
            return false;
        }
        UsuarioHasTurma other = (UsuarioHasTurma) object;
        if ((this.usuarioHasTurmaPK == null && other.usuarioHasTurmaPK != null) || (this.usuarioHasTurmaPK != null && !this.usuarioHasTurmaPK.equals(other.usuarioHasTurmaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.UsuarioHasTurma[ usuarioHasTurmaPK=" + usuarioHasTurmaPK + " ]";
    }
    
}
