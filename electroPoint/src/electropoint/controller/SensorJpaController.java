/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electropoint.controller;

import electropoint.entity.Sensor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import electropoint.entity.Supplier;
import electropoint.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 200573
 */
public class SensorJpaController implements Serializable {

    public SensorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sensor sensor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplier = sensor.getSupplier();
            if (supplier != null) {
                supplier = em.getReference(supplier.getClass(), supplier.getIdSupplier());
                sensor.setSupplier(supplier);
            }
            em.persist(sensor);
            if (supplier != null) {
                supplier.getSensorCollection().add(sensor);
                supplier = em.merge(supplier);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sensor sensor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sensor persistentSensor = em.find(Sensor.class, sensor.getIdSensor());
            Supplier supplierOld = persistentSensor.getSupplier();
            Supplier supplierNew = sensor.getSupplier();
            if (supplierNew != null) {
                supplierNew = em.getReference(supplierNew.getClass(), supplierNew.getIdSupplier());
                sensor.setSupplier(supplierNew);
            }
            sensor = em.merge(sensor);
            if (supplierOld != null && !supplierOld.equals(supplierNew)) {
                supplierOld.getSensorCollection().remove(sensor);
                supplierOld = em.merge(supplierOld);
            }
            if (supplierNew != null && !supplierNew.equals(supplierOld)) {
                supplierNew.getSensorCollection().add(sensor);
                supplierNew = em.merge(supplierNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sensor.getIdSensor();
                if (findSensor(id) == null) {
                    throw new NonexistentEntityException("The sensor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sensor sensor;
            try {
                sensor = em.getReference(Sensor.class, id);
                sensor.getIdSensor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sensor with id " + id + " no longer exists.", enfe);
            }
            Supplier supplier = sensor.getSupplier();
            if (supplier != null) {
                supplier.getSensorCollection().remove(sensor);
                supplier = em.merge(supplier);
            }
            em.remove(sensor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sensor> findSensorEntities() {
        return findSensorEntities(true, -1, -1);
    }

    public List<Sensor> findSensorEntities(int maxResults, int firstResult) {
        return findSensorEntities(false, maxResults, firstResult);
    }

    private List<Sensor> findSensorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sensor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sensor findSensor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sensor.class, id);
        } finally {
            em.close();
        }
    }

    public int getSensorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sensor> rt = cq.from(Sensor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
