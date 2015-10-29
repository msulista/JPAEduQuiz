/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceDao;
import dao.UsuarioDaoBd;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Quiz;
import model.Usuario;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@RequestScoped
public class ResultadoMb {

    /**
     * Creates a new instance of ResultadoMb
     */
    private Usuario usuario;
    private Quiz quiz;
    private InterfaceDao resuInterfaceDao;
    
    public ResultadoMb() {
    }  

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public void cadastraResultado(){
        
    }
}
