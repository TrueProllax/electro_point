/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electropoint.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 200573
 */
@Entity
@Table(name = "sensor_put")
@NamedQueries({
    @NamedQuery(name = "SensorPut.findAll", query = "SELECT s FROM SensorPut s"),
    @NamedQuery(name = "SensorPut.findByIdSensorPut", query = "SELECT s FROM SensorPut s WHERE s.idSensorPut = :idSensorPut"),
    @NamedQuery(name = "SensorPut.findByDate", query = "SELECT s FROM SensorPut s WHERE s.date = :date")})
public class SensorPut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSensorPut")
    private Integer idSensorPut;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "machine", referencedColumnName = "idMachine")
    @ManyToOne
    private Machine machine;
    @JoinColumn(name = "sensor", referencedColumnName = "idSensor")
    @ManyToOne
    private Sensor sensor;

    public SensorPut() {
    }

    public SensorPut(Integer idSensorPut) {
        this.idSensorPut = idSensorPut;
    }

    public Integer getIdSensorPut() {
        return idSensorPut;
    }

    public void setIdSensorPut(Integer idSensorPut) {
        this.idSensorPut = idSensorPut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensorPut != null ? idSensorPut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorPut)) {
            return false;
        }
        SensorPut other = (SensorPut) object;
        if ((this.idSensorPut == null && other.idSensorPut != null) || (this.idSensorPut != null && !this.idSensorPut.equals(other.idSensorPut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "electropoint.entity.SensorPut[ idSensorPut=" + idSensorPut + " ]";
    }
    
}
