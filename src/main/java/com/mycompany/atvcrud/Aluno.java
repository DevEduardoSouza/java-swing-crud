/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atvcrud;

import java.awt.Image;

/**
 *
 * @author Eduardo
 */
public class Aluno extends Usuario{
    private String matricula;

    public Aluno(String matricula, Image foto, String userName, String firstName, String lastName, String email, String phone) {
        super(foto, userName, firstName, lastName, email, phone);
        this.matricula = matricula;
    }

    public Aluno(String matricula, String userName, String senha) {
        super(userName, senha);
        this.matricula = matricula;
    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    

   
    
    
}
