/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.View;

import COM220.Control.ctrQuarto;
import COM220.Model.Quarto;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tiago
 */
public class QuartosView extends javax.swing.JFrame {

    private final ctrQuarto controle = new ctrQuarto();
    private final QuartoAdapter adapter;

    /**
     * Creates new form QuartosView
     */
    public QuartosView() {
        super("Quartos");
        initComponents();

        //define que a janela iniciará centralizado.
        setLocationRelativeTo(null);

        adapter = new QuartosView.QuartoAdapter(controle);
        tbQuartos.setModel(adapter);

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
        tbQuartos = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbQuartos.setAutoCreateRowSorter(true);
        tbQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbQuartos);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        new AddQuarto(controle, adapter);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        for (int row : tbQuartos.getSelectedRows()) {
            controle.RemoverQuarto(adapter.getValueAt(row).getNumero());
        }
        adapter.fireTableDataChanged();
    }//GEN-LAST:event_btnRemoverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbQuartos;
    // End of variables declaration//GEN-END:variables

    public class QuartoAdapter extends AbstractTableModel {

        private ctrQuarto controle;

        public QuartoAdapter(ctrQuarto controle) {
            this.controle = controle;
        }

        @Override
        public int getRowCount() {
            return controle.listaDeQuartos().size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }
        
        public Quarto getValueAt(int rowIndex) {
            return controle.listaDeQuartos().get(rowIndex);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Quarto q = getValueAt(rowIndex);
            if (columnIndex == 1) {
                return q.getPreco();
            } else if (columnIndex == 2) {
                return q.getDescricao();
            } else {
                return q.getNumero();
            }
        }

        @Override
        public String getColumnName(int column) {
            if (column == 1) {
                return "Preço";
            } else if (column == 2) {
                return "Descrição";
            } else {
                return "Número";
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }
    }
}
