/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.View;

import COM220.Control.ctrPagamento;
import COM220.Control.ctrReserva;
import COM220.Model.Reserva;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tiago
 */
public class ReservasView extends javax.swing.JFrame {

    private final ctrReserva controle = new ctrReserva();
    private final ReservasView.ReservaAdapter adapter;
    
    /**
     * Creates new form ReservasView
     */
    public ReservasView() {
        initComponents();
        //define que a janela iniciará centralizado.
        setLocationRelativeTo(null);

        adapter = new ReservasView.ReservaAdapter(controle);
        tbReservas.setModel(adapter);
        
        new ctrPagamento().passouDoPrazo();
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbReservas = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDescancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(633, 459));

        tbReservas.setAutoCreateRowSorter(true);
        tbReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbReservas);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plus.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Minus.png"))); // NOI18N
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thumbs Down.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnDescancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thumb Up.png"))); // NOI18N
        btnDescancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)
                        .addGap(48, 48, 48)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemover)
                            .addComponent(btnCancelar)
                            .addComponent(btnDescancelar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        new AddReserva(controle, adapter);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        for (int row : tbReservas.getSelectedRows()) {
            controle.RemoverReserva(adapter.getValueAt(row).getCodigo());
        }
        adapter.fireTableDataChanged();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        for (int row : tbReservas.getSelectedRows()) {
            controle.cancelarReserva(adapter.getValueAt(row).getCodigo(), true);
        }
        adapter.fireTableDataChanged();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDescancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescancelarActionPerformed
        for (int row : tbReservas.getSelectedRows()) {
            controle.cancelarReserva(adapter.getValueAt(row).getCodigo(), false);
        }
        adapter.fireTableDataChanged();
    }//GEN-LAST:event_btnDescancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDescancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbReservas;
    // End of variables declaration//GEN-END:variables

    public class ReservaAdapter extends AbstractTableModel {

        private ctrReserva controle;

        public ReservaAdapter(ctrReserva controle) {
            this.controle = controle;
        }
        
        @Override
        public int getRowCount() {
           return controle.listarTodasReservas().size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }
        
        public Reserva getValueAt(int rowIndex){
            return this.controle.listarTodasReservas().get(rowIndex);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Reserva r = getValueAt(rowIndex);
            if (columnIndex == 1) {
                return new Date( r.getDataEntrada() );
            } else if (columnIndex == 2) {
                return new Date( r.getDataSaida() );
            } else if(columnIndex == 3){
                return r.getQuartos().size();
            } else if(columnIndex == 4){
                return r.getDesconto();
            }else if(columnIndex == 5){
               return r.getCancelada() ? "SIM" : "NAO";
            } else {
                return r.getCliente().getNome();
            }
        }

        @Override
        public String getColumnName(int column) {
            if (column == 1) {
                return "Data de entrada";
            } else if (column == 2) {
                return "Data de saída";
            } else if (column == 3) {
                return "Número de quartos";
            } else if (column == 4) {
                return "Desconto";
            } else if (column == 5) {
                return "Cancelada?";
            } else {
                return "Nome";
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }
}
