/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.model.bean.Aluno;
import com.mycompany.model.dao.AlunoDAO;
import com.mycompany.view.render.TableActionCellEditor;
import com.mycompany.view.render.TableActionCellRender;
import com.mycompany.view.render.TableActionEvent;
import com.mycompany.view.render.TableHeaderRenderer;
import com.mycompany.view.render.TablePerfilCellRender;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Eduardo de Souza
 */
public final class Dashboard extends javax.swing.JFrame {
    Color cor = new Color(110, 92, 194, 255);
    AlunoDAO dao = new AlunoDAO();
        
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        preencherJtable();
        setImagens();
        confuguracaoTable();
        jlbNomeUserLogado.setText("<html>Olá, " + "<br>" + "Eduardo</html>");
        jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getColumnModel().getTotalColumnWidth(), 40));     
    }
    
    
    
    //método vai pegar todas as infromações do banco de dados e preencher a jtable
    public void preencherJtable(){
        for(Aluno aluno: dao.findAll()){
            //Criando um Object com os dados do usuário de cadastro
            Object[] usuarios = { "foto" ,aluno.getId(), aluno.getUserName(),  aluno.getFirstName(), aluno.getLastName(),  aluno.getEmail(), aluno.getPhone(), aluno.getMatricula() };
             // adiciona o array de usuários à JTable
            DefaultTableModel dtmUsuarios = (DefaultTableModel) Dashboard.this.getjTable1().getModel();
            dtmUsuarios.addRow(usuarios);
        }
    }
    
    //método para passar os dados para -> setImageApp
    public void setImagens(){
        
        TableActionEvent event;
        event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                boolean isOnEdit = true; 
                System.out.println("Editar " + row);
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaCadastro(Dashboard.this, row, isOnEdit).setVisible(true);
                     }
                });   
            }

            @Override
            public void onDelete(int row) {
                if(jTable1.isEditing())
                    jTable1.getCellEditor().stopCellEditing();
                
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                long id = (Long) model.getValueAt(row, 1);

                dao.remove(id);
                
                model.removeRow(row);
            }

            @Override
            public void onView(int row) {
                System.out.println("ver " + row);
            }
        };
                
        //Colocando meu Jpanel renderizados com botões na suas collumn
        jTable1.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new TablePerfilCellRender());
        jTable1.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
        
        
        
        //Vai remover as divisores das colunas
        jTable1.setShowGrid(false);
        //Vai remover as divisorias e as bordas do cabeçalho
        TableCellRenderer baseRenderer = jTable1.getTableHeader().getDefaultRenderer();
        jTable1.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(baseRenderer));
        
 
        
        int widthPadrao = 15;
        int heigthPadrao = 15;
        String srcPadrao = "src\\main\\java\\com\\mycompany\\imgs\\";
        
        setImageApp(lblIconePerfil, srcPadrao + "user.png", widthPadrao, heigthPadrao);
        setImageApp(lblIconUser, srcPadrao + "group.png", widthPadrao, heigthPadrao);
        setImageApp(menuHamburg, srcPadrao + "menu.png", 20, 20);
        setImageApp(lblNoti, srcPadrao + "notificacaoBlack.png", 18, 18);
        setImageApp(jlbAvatar, srcPadrao + "avatar01.png", 30, 30);
        setImageApp(jbtnAddUser, srcPadrao + "adicionar-amigo.png", widthPadrao, heigthPadrao);
        setImageApp(jlbAnalises, srcPadrao + "analitica.png", widthPadrao, heigthPadrao);
        setImageApp(jlbConfi, srcPadrao + "engrenagem.png", widthPadrao, heigthPadrao);
    }
    
    //Metódos para adicionar imagens na tela
    public void setImageApp(JLabel localImg, String src, int width, int height){
        //Removendo o texto do label
        localImg.setText("");
        
        ImageIcon icon = new ImageIcon(src);
        Image img = icon.getImage();
        
        Image novaImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon novoIcon = new ImageIcon(novaImg);
        localImg.setIcon(novoIcon);
    }
    public void setImageApp(JButton localImg, String src, int width, int height){
        ImageIcon icon = new ImageIcon(src);
        Image img = icon.getImage();
        
        Image novaImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon novoIcon = new ImageIcon(novaImg);
        localImg.setIcon(novoIcon);
    }
    public void confuguracaoTable(){
        //Mudando a direção do conteúdo
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, centerRenderer);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIconePerfil = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIconUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbAnalises = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbConfi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        menuHamburg = new javax.swing.JLabel();
        lblNoti = new javax.swing.JLabel();
        jlbAvatar = new javax.swing.JLabel();
        jlbNomeUserLogado = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jbtnAddUser = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtValorBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(57, 196, 222));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(50, 54, 69));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administração");

        lblIconePerfil.setText("jLabel2");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Perfil");

        lblIconUser.setText("jLabel3");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuários");

        jlbAnalises.setText("jLabel5");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Analises");

        jlbConfi.setText("jLabel6");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Configurações");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblIconePerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblIconUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbAnalises)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbConfi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIconePerfil)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIconUser)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbAnalises)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbConfi)
                    .addComponent(jLabel7))
                .addContainerGap(465, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        menuHamburg.setText("jLabel4");

        lblNoti.setText("jLabel4");

        jlbAvatar.setText("jLabel4");

        jlbNomeUserLogado.setText("Olá, ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuHamburg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNoti, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbAvatar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbNomeUserLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(menuHamburg, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNoti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbAvatar)
                        .addComponent(jlbNomeUserLogado)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Gerenciamento de usuários");

        jbtnAddUser.setBackground(new java.awt.Color(57, 196, 222));
        jbtnAddUser.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jbtnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAddUser.setText("Add User");
        jbtnAddUser.setBorderPainted(false);
        jbtnAddUser.setFocusPainted(false);
        jbtnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddUserActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(57, 196, 222));
        jButton1.setText("ALUNOS");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("USER");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtValorBusca.setText("Buscar aluno(ID)");
        txtValorBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorBuscaActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(57, 196, 222));
        btnBuscar.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtValorBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnAddUser)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jbtnAddUser)
                    .addComponent(txtValorBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        jTable1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTable1.setForeground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Foto", "ID", "User Name", "First Name", "Last Name", "Email", "Phone", "Matricula", "Ações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(50);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(231, 251, 255));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(8).setMinWidth(120);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbtnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddUserActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro(Dashboard.this).setVisible(true);
            }
        });
    }//GEN-LAST:event_jbtnAddUserActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Aluno aluno;
        long id = Long.parseLong( txtValorBusca.getText() );
        aluno = dao.findById(id);
        
        if(aluno != null){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ResultadoBusca(aluno).setVisible(true);
                }
            });
        }else{
            JOptionPane.showMessageDialog(null,
        "Houve um problema ao procurar o aluno:\n\n '", //mensagem
        "Erro de busca", // titulo da janela 
        JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtValorBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorBuscaActionPerformed

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnAddUser;
    private javax.swing.JLabel jlbAnalises;
    private javax.swing.JLabel jlbAvatar;
    private javax.swing.JLabel jlbConfi;
    private javax.swing.JLabel jlbNomeUserLogado;
    private javax.swing.JLabel lblIconUser;
    private javax.swing.JLabel lblIconePerfil;
    private javax.swing.JLabel lblNoti;
    private javax.swing.JLabel menuHamburg;
    private javax.swing.JTextField txtValorBusca;
    // End of variables declaration//GEN-END:variables
}
