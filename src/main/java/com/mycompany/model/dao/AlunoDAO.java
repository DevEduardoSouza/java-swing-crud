/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.dao;

import com.mycompany.connection.ConnectionFactory;
import com.mycompany.model.bean.Aluno;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo de Souza
 */
public class AlunoDAO {
    
    public Aluno save(Aluno aluno){
        EntityManager em = new ConnectionFactory().getConnection();
        
//        Verificar se deu tudo certo, caso tem algum erro vamos desfazer -> usando o rollback()
        try {
            em.getTransaction().begin();
             // a diferença entre update e save -> no update passa um ID
            if(aluno.getId() == null){
                em.persist(aluno);
                em.getTransaction().commit();
            }else{
                //se eu setar o id cai aqui e vai fazer o update
                em.merge(aluno);
                System.out.println("Dados atuallizado: ");
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println("Erro -> roolback");
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        
        return aluno;
    }
    
    public Aluno findById(Long id){
        EntityManager em = new ConnectionFactory().getConnection();
        Aluno aluno = null;
        
        try {
            aluno = em.find(Aluno.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
             em.close();
        }
        return aluno;
    }
    
    public List<Aluno> findAll(){
       EntityManager em = new ConnectionFactory().getConnection();
       List<Aluno> alunos = null;
       
        try {
            alunos = em.createQuery("from Aluno").getResultList();
        } catch (Exception e) {
            System.err.println(e);
            
        }finally{
            em.close();
        }
        if (alunos == null) {
            alunos = new ArrayList<>();
        }
        
        
        return alunos;
    }
    
    public Aluno remove(Long id){
        EntityManager em = new ConnectionFactory().getConnection();
        Aluno aluno = null;
        try {
            aluno = em.find(Aluno.class, id);
           em.getTransaction().begin();
           em.remove(aluno);
           em.getTransaction().commit();
           
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
            
        }finally{
            em.close();
        }
        return aluno;
    }
   
    
}
