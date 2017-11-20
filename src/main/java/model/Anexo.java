/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinicius
 */
@Entity
@Table(name = "Anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anexo.findAll", query = "SELECT a FROM Anexo a")
    , @NamedQuery(name = "Anexo.findByIdanexo", query = "SELECT a FROM Anexo a WHERE a.idanexo = :idanexo")
    , @NamedQuery(name = "Anexo.findByNome", query = "SELECT a FROM Anexo a WHERE a.nome = :nome")
    , @NamedQuery(name = "Anexo.findByLink", query = "SELECT a FROM Anexo a WHERE a.link = :link")})
public class Anexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idanexo")
    private Integer idanexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "link")
    private String link;
    @JoinColumn(name = "taskid", referencedColumnName = "idtask")
    @ManyToOne(optional = false)
    private Task taskid;

    public Anexo() {
    }

    public Anexo(Integer idanexo) {
        this.idanexo = idanexo;
    }

    public Anexo(Integer idanexo, String nome, String link) {
        this.idanexo = idanexo;
        this.nome = nome;
        this.link = link;
    }

    public Integer getIdanexo() {
        return idanexo;
    }

    public void setIdanexo(Integer idanexo) {
        this.idanexo = idanexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Task getTaskid() {
        return taskid;
    }

    public void setTaskid(Task taskid) {
        this.taskid = taskid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanexo != null ? idanexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anexo)) {
            return false;
        }
        Anexo other = (Anexo) object;
        if ((this.idanexo == null && other.idanexo != null) || (this.idanexo != null && !this.idanexo.equals(other.idanexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dashboardtasks.Anexo[ idanexo=" + idanexo + " ]";
    }
    
}
