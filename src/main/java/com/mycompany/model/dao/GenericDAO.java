/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.dao;

import com.mycompany.atvcrud.connection.ConnectionFactory;
import com.mycompany.atvcrud.entities.AbstractEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;

import java.util.List;
/**
 *
 * @author Eduardo
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class GenericDAO<T extends AbstractEntity> {
    
     protected static EntityManager em;
    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }
    public T getById(Long id) {
        EntityManager em = new ConnectionFactory().getConnection();
        return (T) em.find(getTypeClass(), id);
    }

    public void save(T entity){
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();

            if(entity.getId() == null){
                em.persist(entity);
                em.getTransaction().commit();
            }else{

                em.merge(entity);
                System.out.println("Dados atuallizado: ");
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println("Erro -> roolback");
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public List<T> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        return em.createQuery(("From " + getTypeClass().getName())).getResultList();
    }

    public T remove(Long id){

        T entity = null;
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            entity = (T) em.find(getTypeClass(), id);
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();

        }finally{
            em.close();
        }
        return entity;
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        return clazz;
    }
    
}
