/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atvcrud;

import com.mycompany.view.Dashboard;

/**
 *
 * @author Eduardo de Souza
 */
public class AtvCRUD {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
 
    }
}
