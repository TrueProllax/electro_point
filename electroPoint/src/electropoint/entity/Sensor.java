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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 200573
 */
@Entity
@Table(name = "sensor")
@NamedQueries({
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s"),
    @NamedQuery(name = "Sensor.findByIdSensor", query = "SELECT s FROM Sensor s WHERE s.idSensor = :idSensor"),
    @NamedQuery(name = "Sensor.findByType", query = "SELECT s FROM Sensor s WHERE s.type = :type"),
    @NamedQuery(name = "Sensor.findByModel", query = "SELECT s FROM Sensor s WHERE s.model = :model"),
    @NamedQuery(name = "Sensor.findByCode", query = "SELECT s FROM Sensor s WHERE s.code = :code"),
    @NamedQuery(name = "Sensor.findByAccuracyCoordinates", query = "SELECT s FROM Sensor s WHERE s.accuracyCoordinates = :accuracyCoordinates"),
    @NamedQuery(name = "Sensor.findByAdditionally", query = "SELECT s FROM Sensor s WHERE s.additionally = :additionally")})
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSensor")
    private Integer idSensor;
    @Column(name = "type")
    private String type;
    @Column(name = "model")
    private String model;
    @Column(name = "code")
    private String code;
    @Column(name = "accuracyCoordinates")
    private String accuracyCoordinates;
    @Column(name = "additionally")
    private String additionally;
    @OneToMany(mappedBy = "sensor")
    private Collection<SensorPut> sensorPutCollection;
    @JoinColumn(name = "supplier", referencedColumnName = "idSupplier")
    @ManyToOne
    private Supplier supplier;

    public Sensor() {
    }

    public Sensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public Integer getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccuracyCoordinates() {
        return accuracyCoordinates;
    }

    public void setAccuracyCoordinates(String accuracyCoordinates) {
        this.accuracyCoordinates = accuracyCoordinates;
    }

    public String getAdditionally() {
        return additionally;
    }

    public void setAdditionally(String additionally) {
        this.additionally = additionally;
    }

    public Collection<SensorPut> getSensorPutCollection() {
        return sensorPutCollection;
    }

    public void setSensorPutCollection(Collection<SensorPut> sensorPutCollection) {
        this.sensorPutCollection = sensorPutCollection;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensor != null ? idSensor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.idSensor == null && other.idSensor != null) || (this.idSensor != null && !this.idSensor.equals(other.idSensor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "electropoint.entity.Sensor[ idSensor=" + idSensor + " ]";
    }
    
}
