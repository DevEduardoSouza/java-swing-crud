/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.facade;

import com.mycompany.model.bean.Aluno;

/**
 *
 * @author Eduardo
 */
public class AlunoFacadeImpl implements AlunoFacade{

    @Override
    public boolean verificarCampos(Aluno aluno) {
        return aluno != null && !aluno.getFirstName().isEmpty() && !aluno.getLastName().isEmpty() && 
                !aluno.getUserName().isEmpty() &&
                !aluno.getEmail().isEmpty() &&
                !aluno.getPhone().isEmpty() &&
                !aluno.getMatricula().isEmpty();
    }
    
}
