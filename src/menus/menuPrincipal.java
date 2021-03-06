/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import inicirobot.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import libraries.BattleWindow;
import libraries.SimulatorRobot;

/**
 *
 * @author rbarberan
 */
public class menuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form menuPrincipal
     */
    public menuPrincipal() {

        initComponents();
        setLocationRelativeTo(null);

        String sDirectorio = "src\\resources\\robots";
        File f = new File(sDirectorio);
        DefaultListModel listModelTotalRobots = new DefaultListModel();
        DefaultListModel listModelSelectedRobots = new DefaultListModel();

        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File fichero : ficheros) {
                listModelTotalRobots.addElement(fichero.getName());
                this.totalRobots.setModel(listModelTotalRobots);
            }

        } else {
            System.out.println("error en menu principal source");
        }

        this.selectedRobots.setModel(listModelSelectedRobots);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scene = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        answer1 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedRobots = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        totalRobots = new javax.swing.JList();
        addRobot = new javax.swing.JButton();
        removeRobot = new javax.swing.JButton();
        removeAllRobots = new javax.swing.JButton();
        addAllRobot = new javax.swing.JButton();
        answer2 = new javax.swing.JLabel();
        answer3 = new javax.swing.JLabel();
        answer4 = new javax.swing.JLabel();
        answer5 = new javax.swing.JLabel();
        desertRadio = new javax.swing.JRadioButton();
        forestRadio = new javax.swing.JRadioButton();
        spacialRadio = new javax.swing.JRadioButton();
        theme = new javax.swing.JLabel();
        answer6 = new javax.swing.JLabel();
        numOfBullets = new javax.swing.JComboBox();
        numOfRounds = new javax.swing.JComboBox();
        numOfLifes = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        title.setText("Batalla de robots!");

        answer1.setText("Quins robots vols?");

        send.setText("Som-hi!");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(selectedRobots);

        totalRobots.setToolTipText("");
        jScrollPane2.setViewportView(totalRobots);

        addRobot.setText(">");
        addRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRobotActionPerformed(evt);
            }
        });

        removeRobot.setText("Eliminar");
        removeRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRobotActionPerformed(evt);
            }
        });

        removeAllRobots.setText("Buidar");
        removeAllRobots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllRobotsActionPerformed(evt);
            }
        });

        addAllRobot.setText("All >");
        addAllRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllRobotActionPerformed(evt);
            }
        });

        answer2.setText("Quin tema vols?");

        answer3.setText("Num de bales per robot");

        answer4.setText("Rondes");

        answer5.setText("Vides per robot");

        scene.add(desertRadio);
        desertRadio.setText("Desert");
        desertRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desertRadioActionPerformed(evt);
            }
        });

        scene.add(forestRadio);
        forestRadio.setText("Forest");
        forestRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forestRadioActionPerformed(evt);
            }
        });

        scene.add(spacialRadio);
        spacialRadio.setText("Spacial");
        spacialRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spacialRadioActionPerformed(evt);
            }
        });

        theme.setText("Ningun");

        answer6.setText("Tema seleccionat:");

        numOfBullets.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30", "40", "50" }));

        numOfRounds.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        numOfLifes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20" }));

        scene.add(jRadioButton1);
        jRadioButton1.setText("Sea");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answer1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addAllRobot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addRobot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removeAllRobots, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeRobot, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(send)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(answer4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(answer3)
                                            .addComponent(answer5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(numOfBullets, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numOfRounds, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numOfLifes, 0, 85, Short.MAX_VALUE))))
                                .addGap(33, 33, 33)))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(answer2)
                                .addComponent(desertRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(forestRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spacialRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(answer6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(theme, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(answer1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(addRobot)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(addAllRobot))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(removeRobot)
                        .addGap(18, 18, 18)
                        .addComponent(removeAllRobots)
                        .addGap(36, 36, 36)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numOfBullets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answer3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(answer4)
                            .addComponent(numOfRounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(answer5)
                            .addComponent(numOfLifes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(answer2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(desertRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forestRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spacialRadio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(theme)
                    .addComponent(answer6))
                .addGap(22, 22, 22)
                .addComponent(send)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed

        if (this.selectedRobots.getModel().getSize() != 0) {

            String themeWindow = this.theme.getText();
            Integer rounds = Integer.parseInt(this.numOfRounds.getSelectedItem().toString());
            Integer lifes = Integer.parseInt(this.numOfLifes.getSelectedItem().toString());
            Integer bullets = Integer.parseInt(this.numOfBullets.getSelectedItem().toString());

            Game game = new Game(themeWindow, rounds, lifes, bullets, (DefaultListModel) this.selectedRobots.getModel());

            try {
                ArrayList<SimulatorRobot> rb = game.deploy();
                this.setVisible(false);
                BattleWindow battleWindow = new BattleWindow(rb, themeWindow);

            } catch (Exception e) {
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tens que seleccionar algun robot");
        }

    }//GEN-LAST:event_sendActionPerformed

    private void addRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRobotActionPerformed

        DefaultListModel listAux = (DefaultListModel) this.selectedRobots.getModel();
        listAux.addElement(this.totalRobots.getSelectedValue());
        this.selectedRobots.setModel(listAux);


    }//GEN-LAST:event_addRobotActionPerformed

    private void removeRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRobotActionPerformed

        DefaultListModel listAux = (DefaultListModel) this.selectedRobots.getModel();
        listAux.removeElement(this.selectedRobots.getSelectedValue());
        this.selectedRobots.setModel(listAux);

    }//GEN-LAST:event_removeRobotActionPerformed

    private void removeAllRobotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllRobotsActionPerformed

        DefaultListModel listAux = new DefaultListModel();
        this.selectedRobots.setModel(listAux);

    }//GEN-LAST:event_removeAllRobotsActionPerformed

    private void addAllRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllRobotActionPerformed

        DefaultListModel listAux = (DefaultListModel) this.selectedRobots.getModel();

        for (int i = 0; i < this.totalRobots.getModel().getSize(); i++) {
            listAux.addElement(this.totalRobots.getModel().getElementAt(i));
        }

        this.selectedRobots.setModel(listAux);

    }//GEN-LAST:event_addAllRobotActionPerformed

    private void desertRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desertRadioActionPerformed
        this.theme.setText("Desert");
    }//GEN-LAST:event_desertRadioActionPerformed

    private void forestRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forestRadioActionPerformed
        this.theme.setText("Forest");
    }//GEN-LAST:event_forestRadioActionPerformed

    private void spacialRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spacialRadioActionPerformed
        this.theme.setText("Spacial");
    }//GEN-LAST:event_spacialRadioActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        this.theme.setText("Sea");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new menuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAllRobot;
    private javax.swing.JButton addRobot;
    private javax.swing.JLabel answer1;
    private javax.swing.JLabel answer2;
    private javax.swing.JLabel answer3;
    private javax.swing.JLabel answer4;
    private javax.swing.JLabel answer5;
    private javax.swing.JLabel answer6;
    private javax.swing.JRadioButton desertRadio;
    private javax.swing.JRadioButton forestRadio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox numOfBullets;
    private javax.swing.JComboBox numOfLifes;
    private javax.swing.JComboBox numOfRounds;
    private javax.swing.JButton removeAllRobots;
    private javax.swing.JButton removeRobot;
    private javax.swing.ButtonGroup scene;
    private javax.swing.JList selectedRobots;
    private javax.swing.JButton send;
    private javax.swing.JRadioButton spacialRadio;
    private javax.swing.JLabel theme;
    private javax.swing.JLabel title;
    private javax.swing.JList totalRobots;
    // End of variables declaration//GEN-END:variables
}
