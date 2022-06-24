/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electropoint.controller;

import electropoint.entity.SensorPut;
import electropoint.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 200573
 */
public class SensorPutJpaController implements Serializable {

    public SensorPutJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SensorPut sensorPut) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sensorPut);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SensorPut sensorPut) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sensorPut = em.merge(sensorPut);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sensorPut.getIdSensorPut();
                if (findSensorPut(id) == null) {
                    throw new NonexistentEntityException("The sensorPut with id " + id + " no longer exists.");
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
            SensorPut sensorPut;
            try {
                sensorPut = em.getReference(SensorPut.class, id);
                sensorPut.getIdSensorPut();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sensorPut with id " + id + " no longer exists.", enfe);
            }
            em.remove(sensorPut);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SensorPut> findSensorPutEntities() {
        return findSensorPutEntities(true, -1, -1);
    }

    public List<SensorPut> findSensorPutEntities(int maxResults, int firstResult) {
        return findSensorPutEntities(false, maxResults, firstResult);
    }

    private List<SensorPut> findSensorPutEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SensorPut.class));
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

    public SensorPut findSensorPut(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SensorPut.class, id);
        } finally {
            em.close();
        }
    }

    public int getSensorPutCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SensorPut> rt = cq.from(SensorPut.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
