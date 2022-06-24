/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electropoint.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 200573
 */
@Entity
@Table(name = "machine")
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m"),
    @NamedQuery(name = "Machine.findByIdMachine", query = "SELECT m FROM Machine m WHERE m.idMachine = :idMachine"),
    @NamedQuery(name = "Machine.findByName", query = "SELECT m FROM Machine m WHERE m.name = :name")})
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMachine")
    private Integer idMachine;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "machine")
    private Collection<SensorPut> sensorPutCollection;

    public Machine() {
    }

    public Machine(Integer idMachine) {
        this.idMachine = idMachine;
    }

    public Integer getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(Integer idMachine) {
        this.idMachine = idMachine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<SensorPut> getSensorPutCollection() {
        return sensorPutCollection;
    }

    public void setSensorPutCollection(Collection<SensorPut> sensorPutCollection) {
        this.sensorPutCollection = sensorPutCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMachine != null ? idMachine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.idMachine == null && other.idMachine != null) || (this.idMachine != null && !this.idMachine.equals(other.idMachine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "electropoint.entity.Machine[ idMachine=" + idMachine + " ]";
    }
    
}
