/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electropoint.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import electropoint.entity.Sensor;
import electropoint.entity.Supplier;
import electropoint.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 200573
 */
public class SupplierJpaController implements Serializable {

    public SupplierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Supplier supplier) {
        if (supplier.getSensorCollection() == null) {
            supplier.setSensorCollection(new ArrayList<Sensor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Sensor> attachedSensorCollection = new ArrayList<Sensor>();
            for (Sensor sensorCollectionSensorToAttach : supplier.getSensorCollection()) {
                sensorCollectionSensorToAttach = em.getReference(sensorCollectionSensorToAttach.getClass(), sensorCollectionSensorToAttach.getIdSensor());
                attachedSensorCollection.add(sensorCollectionSensorToAttach);
            }
            supplier.setSensorCollection(attachedSensorCollection);
            em.persist(supplier);
            for (Sensor sensorCollectionSensor : supplier.getSensorCollection()) {
                Supplier oldSupplierOfSensorCollectionSensor = sensorCollectionSensor.getSupplier();
                sensorCollectionSensor.setSupplier(supplier);
                sensorCollectionSensor = em.merge(sensorCollectionSensor);
                if (oldSupplierOfSensorCollectionSensor != null) {
                    oldSupplierOfSensorCollectionSensor.getSensorCollection().remove(sensorCollectionSensor);
                    oldSupplierOfSensorCollectionSensor = em.merge(oldSupplierOfSensorCollectionSensor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Supplier supplier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier persistentSupplier = em.find(Supplier.class, supplier.getIdSupplier());
            Collection<Sensor> sensorCollectionOld = persistentSupplier.getSensorCollection();
            Collection<Sensor> sensorCollectionNew = supplier.getSensorCollection();
            Collection<Sensor> attachedSensorCollectionNew = new ArrayList<Sensor>();
            for (Sensor sensorCollectionNewSensorToAttach : sensorCollectionNew) {
                sensorCollectionNewSensorToAttach = em.getReference(sensorCollectionNewSensorToAttach.getClass(), sensorCollectionNewSensorToAttach.getIdSensor());
                attachedSensorCollectionNew.add(sensorCollectionNewSensorToAttach);
            }
            sensorCollectionNew = attachedSensorCollectionNew;
            supplier.setSensorCollection(sensorCollectionNew);
            supplier = em.merge(supplier);
            for (Sensor sensorCollectionOldSensor : sensorCollectionOld) {
                if (!sensorCollectionNew.contains(sensorCollectionOldSensor)) {
                    sensorCollectionOldSensor.setSupplier(null);
                    sensorCollectionOldSensor = em.merge(sensorCollectionOldSensor);
                }
            }
            for (Sensor sensorCollectionNewSensor : sensorCollectionNew) {
                if (!sensorCollectionOld.contains(sensorCollectionNewSensor)) {
                    Supplier oldSupplierOfSensorCollectionNewSensor = sensorCollectionNewSensor.getSupplier();
                    sensorCollectionNewSensor.setSupplier(supplier);
                    sensorCollectionNewSensor = em.merge(sensorCollectionNewSensor);
                    if (oldSupplierOfSensorCollectionNewSensor != null && !oldSupplierOfSensorCollectionNewSensor.equals(supplier)) {
                        oldSupplierOfSensorCollectionNewSensor.getSensorCollection().remove(sensorCollectionNewSensor);
                        oldSupplierOfSensorCollectionNewSensor = em.merge(oldSupplierOfSensorCollectionNewSensor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = supplier.getIdSupplier();
                if (findSupplier(id) == null) {
                    throw new NonexistentEntityException("The supplier with id " + id + " no longer exists.");
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
            Supplier supplier;
            try {
                supplier = em.getReference(Supplier.class, id);
                supplier.getIdSupplier();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The supplier with id " + id + " no longer exists.", enfe);
            }
            Collection<Sensor> sensorCollection = supplier.getSensorCollection();
            for (Sensor sensorCollectionSensor : sensorCollection) {
                sensorCollectionSensor.setSupplier(null);
                sensorCollectionSensor = em.merge(sensorCollectionSensor);
            }
            em.remove(supplier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Supplier> findSupplierEntities() {
        return findSupplierEntities(true, -1, -1);
    }

    public List<Supplier> findSupplierEntities(int maxResults, int firstResult) {
        return findSupplierEntities(false, maxResults, firstResult);
    }

    private List<Supplier> findSupplierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Supplier.class));
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

    public Supplier findSupplier(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Supplier.class, id);
        } finally {
            em.close();
        }
    }

    public int getSupplierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Supplier> rt = cq.from(Supplier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
