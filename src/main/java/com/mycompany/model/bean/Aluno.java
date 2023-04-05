/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Random;


/**
 *
 * @author Eduardo de Souza
 */
@Entity
@Table(name="Alunos")
public class Aluno extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String matricula;

    public Aluno(String matricula,  String userName, String firstName, String lastName, String email, String phone) {
        super( userName, firstName, lastName, email, phone);
        this.matricula = matricula;
    }

    public Aluno(String matricula, String userName, String senha) {
        super(userName, senha);
        this.matricula = matricula;
    }

    public Aluno() {
    }
    
    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", matricula=" + matricula + '}';
    }
    
    
    // Método para gerar uma pessoa aleatória
    public static Aluno gerarPessoa() {
        Random random = new Random();
        String[] firstNames = {"Lucas", "Mariana", "Pedro", "Juliana", "Gustavo", "Ana", "Felipe", "Larissa", "Rafael", "Carla", "Thiago", "Isabela", "Rodrigo", "Marina", "Bruno", "Camila", "Leandro", "Bianca", "Diego", "Gabriela", "Vinícius", "Fernanda", "Eduardo", "Márcia", "Renato", "Cintia", "André", "Júlia", "Alexandre", "Luana", "Victor", "Renata"};
        String[] lastNames = {"Silva", "Souza", "Oliveira", "Ferreira", "Santos", "Gomes", "Pereira", "Almeida", "Rodrigues", "Costa", "Martins", "Sampaio", "Andrade", "Barbosa", "Mendes", "Freitas", "Lima", "Araújo", "Monteiro", "Sousa", "Cavalcante", "Carvalho", "Nascimento", "Mendes", "Fernandes", "Ribeiro", "Cardoso", "Gonçalves", "Teixeira", "Cruz", "Farias", "Pires"};
        String[] telefones = {"(11) 91234-5678", "(21) 98765-4321", "(31) 99876-5432", "(41) 98765-1234", "(51) 91234-5678", "(61) 99876-5432", "(71) 98765-1234", "(81) 91234-5678"};
        String[] emails = {"@gmail.com", "@hotmail.com", "@yahoo.com", "@outlook.com", "@uol.com.br", "bol.com.br", "@globo.com", "@ig.com"};
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String userName = firstName + "_" + lastName;
        String telefone = telefones[random.nextInt(telefones.length)];
        String email = (firstName + lastName + emails[random.nextInt(emails.length)]).toLowerCase();
        
        String matricula = "";
        for (int i = 0; i < 2; i++) {
            matricula += letras[random.nextInt(letras.length)];
            matricula += random.nextInt(10000);
        }
        
        Aluno pessoa = new Aluno(matricula, userName, firstName, lastName, email, telefone);
        return pessoa;
    }
}
