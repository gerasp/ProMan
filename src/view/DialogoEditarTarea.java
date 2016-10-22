/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import model.Task;
import persistence.SQLiteAddTask;
import persistence.SQLiteEditTask;
import persistence.SQLiteRemoveTask;

/**
 *
 * @author Zabai Armas
 */
public class DialogoEditarTarea extends javax.swing.JDialog {

        private Task task;
    /**
     * Creates new form DialogoAñadirTarea
     */
    public DialogoEditarTarea(java.awt.Frame parent, boolean modal, Task task) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        
        this.task = task;
        
        Name.setText(task.getNombre());
        Description.setText("");
        InitialDate.setDate(new Date());
        FinalDate.setDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameInfo = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        DescriptionInfo = new javax.swing.JLabel();
        Description = new javax.swing.JTextField();
        IniDateInfo = new javax.swing.JLabel();
        FinDateInfo = new javax.swing.JLabel();
        InitialDate = new org.jdesktop.swingx.JXDatePicker();
        FinalDate = new org.jdesktop.swingx.JXDatePicker();
        EditButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir tarea");
        setResizable(false);

        NameInfo.setText("Nombre:");

        DescriptionInfo.setText("Descripción:");

        IniDateInfo.setText("Fecha inicio:");

        FinDateInfo.setText("Fecha final:");

        EditButton.setText("Editar Tarea");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IniDateInfo)
                            .addComponent(NameInfo)
                            .addComponent(DescriptionInfo))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InitialDate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                                .addComponent(FinalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Name)
                            .addComponent(Description))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 204, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FinDateInfo)
                            .addComponent(EditButton))
                        .addGap(207, 207, 207))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameInfo)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DescriptionInfo)
                    .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IniDateInfo)
                    .addComponent(InitialDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinDateInfo)
                    .addComponent(FinalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(EditButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // TODO add your handling code here:
        int duration = (int) ((FinalDate.getDate().getTime() - InitialDate.getDate().getTime()) / (1000*60*60*24));
        int priority = 0;
        SQLiteEditTask.editTask(task.getId(), Name.getText(), duration, priority, task.getIdProyecto());
        
        this.dispose();
    }//GEN-LAST:event_EditButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Description;
    private javax.swing.JLabel DescriptionInfo;
    private javax.swing.JButton EditButton;
    private javax.swing.JLabel FinDateInfo;
    private org.jdesktop.swingx.JXDatePicker FinalDate;
    private javax.swing.JLabel IniDateInfo;
    private org.jdesktop.swingx.JXDatePicker InitialDate;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NameInfo;
    // End of variables declaration//GEN-END:variables
}
