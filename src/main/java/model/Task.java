/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Anexo;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinicius
 */
@Entity
@Table(name = "Task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
    , @NamedQuery(name = "Task.findByIdtask", query = "SELECT t FROM Task t WHERE t.idtask = :idtask")
    , @NamedQuery(name = "Task.findByNome", query = "SELECT t FROM Task t WHERE t.nome = :nome")
    , @NamedQuery(name = "Task.findByDescricao", query = "SELECT t FROM Task t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "Task.findByPrioridade", query = "SELECT t FROM Task t WHERE t.prioridade = :prioridade")
    , @NamedQuery(name = "Task.findBySubmetido", query = "SELECT t FROM Task t WHERE t.submetido = :submetido")
    , @NamedQuery(name = "Task.findByFinalizado", query = "SELECT t FROM Task t WHERE t.finalizado = :finalizado")
    , @NamedQuery(name = "Task.findByStatus", query = "SELECT t FROM Task t WHERE t.status = :status")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtask")
    private Integer idtask;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prioridade")
    private short prioridade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "submetido")
    private String submetido;
    @Size(max = 50)
    @Column(name = "finalizado")
    private String finalizado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskid")
    private Collection<Anexo> anexoCollection;

    public Task() {
    }

    public Task(Integer idtask) {
        this.idtask = idtask;
    }

    public Task(Integer idtask, String nome, String descricao, short prioridade, String submetido, String status) {
        this.idtask = idtask;
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.submetido = submetido;
        this.status = status;
    }

    public Integer getIdtask() {
        return idtask;
    }

    public void setIdtask(Integer idtask) {
        this.idtask = idtask;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(short prioridade) {
        this.prioridade = prioridade;
    }

    public String getSubmetido() {
        return submetido;
    }

    public void setSubmetido(String submetido) {
        this.submetido = submetido;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Anexo> getAnexoCollection() {
        return anexoCollection;
    }

    public void setAnexoCollection(Collection<Anexo> anexoCollection) {
        this.anexoCollection = anexoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtask != null ? idtask.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.idtask == null && other.idtask != null) || (this.idtask != null && !this.idtask.equals(other.idtask))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dashboardtasks.Task[ idtask=" + idtask + " ]";
    }
    
}
