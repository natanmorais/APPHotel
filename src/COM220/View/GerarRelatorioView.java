/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.View;

import COM220.Control.ctrReserva;
import COM220.Model.Reserva;
import COM220.Utils.GerarRelatorio;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tiago
 */
public class GerarRelatorioView extends javax.swing.JFrame {

    public final GerarRelatorio relatorio = new GerarRelatorio();

    /**
     * Creates new form GerarRelatorioView
     */
    public GerarRelatorioView() {
        super("Gerar relatórios");
        initComponents();

        //define que a janela iniciará centralizado.
        setLocationRelativeTo(null);

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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        sDataInicial = new javax.swing.JSpinner();
        sDataFinal = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Report Card.png"))); // NOI18N
        jButton1.setText("RELATÓRIO DE RESERVAS CANCELADAS");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Report Card.png"))); // NOI18N
        jButton2.setText("RELATÓRIO DE RESERVAS NÃO PAGAS");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Report Card.png"))); // NOI18N
        jButton3.setText("RELATÓRIO DE RESERVAS A SEREM EFETIVADAS");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Report Card.png"))); // NOI18N
        jButton4.setText("RELATÓRIO DE RESERVAS");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        sDataInicial.setModel(new javax.swing.SpinnerDateModel());

        sDataFinal.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(sDataFinal))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ctrReserva controle = new ctrReserva();
        relatorio.GerarHTMLESalvarEmArquivo(new Modelo(controle.relatorioCancelados()));
        JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ctrReserva controle = new ctrReserva();
        relatorio.GerarHTMLESalvarEmArquivo(new Modelo(controle.relatorioNaoPagos()));
        JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ctrReserva controle = new ctrReserva();
        relatorio.GerarHTMLESalvarEmArquivo(new Modelo(controle.relatorioASerPagoHoje()));
        JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ctrReserva controle = new ctrReserva();
        relatorio.GerarHTMLESalvarEmArquivo(new Modelo(controle.relatorioPeriodo(
                ((Date) sDataInicial.getValue()).getTime(),
                ((Date) sDataFinal.getValue()).getTime())));
        JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso!");
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JSpinner sDataFinal;
    private javax.swing.JSpinner sDataInicial;
    // End of variables declaration//GEN-END:variables

    private class Modelo extends AbstractTableModel {

        private List<Reserva> reservas;

        public Modelo(List<Reserva> reservas) {
            this.reservas = reservas;
        }

        @Override
        public int getRowCount() {
            return reservas.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Reserva r = reservas.get(rowIndex);
            if (columnIndex == 1) {
                return new Date(r.getDataEntrada());
            } else if (columnIndex == 2) {
                return new Date(r.getDataSaida());
            } else if (columnIndex == 3) {
                return r.getQuartos().size();
            } else if (columnIndex == 4) {
                return r.getDesconto();
            } else if (columnIndex == 5) {
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
                return "Foi cancelada?";
            } else {
                return "Nome";
            }
        }

    }
}
