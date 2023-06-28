/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.service;

import com.mycompany.model.bean.Aluno;
import com.mycompany.model.dao.AlunoDAO;

/**
 *
 * @author Eduardo
 */
public class SeviceImpl implements Service{
    private AlunoDAO alunoDAO;

    public SeviceImpl(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }
    

    @Override
    public boolean cadastraNovoAluno(Aluno aluno) {
        alunoDAO.save(aluno);
        return true;
    }
    
}
