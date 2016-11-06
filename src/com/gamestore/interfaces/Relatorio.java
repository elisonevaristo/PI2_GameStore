/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.interfaces;

import com.gamestore.main.GameStore;
import com.gamestore.models.ItemRelatorio;
import com.gamestore.services.ServicoPedido;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roger
 */
public class Relatorio extends javax.swing.JPanel {

    GameStore parent;
    ServicoPedido servico;
    
    /**
     * Creates new form Relatorio
     * @param parent
     * @param servico
     */
    public Relatorio(GameStore parent, ServicoPedido servico) {
        initComponents();
        this.parent = parent;
        this.servico = servico;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        scrollPanePedidos = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        radio24Horas = new javax.swing.JRadioButton();
        radio1Semana = new javax.swing.JRadioButton();
        radioMensal = new javax.swing.JRadioButton();
        radioPeriodo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboPlataforma = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        textProduto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        botaoGerarRelatorio = new javax.swing.JButton();
        labelTotalVendas = new javax.swing.JLabel();
        textDataInicial = new javax.swing.JFormattedTextField();
        textDataFinal = new javax.swing.JFormattedTextField();

        jTextField3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Plataforma");

        jComboBox1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "Playstation 4", "XBox One", "Playstation 3", "XBox 360", "Wii", "Wii U" }));

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("Categoria");

        jComboBox4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Console", "Jogo", "Acessório" }));

        setBackground(new java.awt.Color(255, 255, 255));

        tablePedidos.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Pedido Nº", "Cliente", "Produto", "Quantidade", "Data", "Valor Unitário", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanePedidos.setViewportView(tablePedidos);

        radio24Horas.setBackground(new java.awt.Color(255, 255, 255));
        radio24Horas.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        radio24Horas.setText("24 horas");

        radio1Semana.setBackground(new java.awt.Color(255, 255, 255));
        radio1Semana.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        radio1Semana.setText("1 semana");

        radioMensal.setBackground(new java.awt.Color(255, 255, 255));
        radioMensal.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        radioMensal.setText("Mensal");

        radioPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        radioPeriodo.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        radioPeriodo.setText("Periodo de");

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel1.setText("até");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Plataforma");

        comboPlataforma.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "PC", "Playstation 4", "XBox One", "Playstation 3", "XBox 360", "Wii", "Wii U" }));

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel13.setText("Categoria");

        comboCategoria.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Console", "Jogo", "Acessório" }));

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Produto");

        textProduto.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel9.setText("Agrupar por");

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRadioButton5.setText("Produto");

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRadioButton6.setText("Dia");

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRadioButton7.setText("Semana");

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRadioButton8.setText("Quinzena");

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRadioButton9.setText("Categoria");

        jRadioButton10.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRadioButton10.setText("Plataforma");

        botaoGerarRelatorio.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        botaoGerarRelatorio.setText("GERAR RELATÓRIO");
        botaoGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioActionPerformed(evt);
            }
        });

        labelTotalVendas.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        labelTotalVendas.setText("TOTAL DE VENDAS DO PERÍODO: R$ 2380,00");

        try {
            textDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            textDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanePedidos)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(radio1Semana)
                        .addGap(18, 18, 18)
                        .addComponent(radioMensal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(radio24Horas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTotalVendas)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(radioPeriodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPlataforma, 0, 175, Short.MAX_VALUE)
                            .addComponent(textDataInicial))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCategoria, 0, 169, Short.MAX_VALUE)
                            .addComponent(textDataFinal)))
                    .addComponent(textProduto))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jRadioButton5))
                            .addComponent(jRadioButton9)
                            .addComponent(jRadioButton10))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio24Horas)
                    .addComponent(radio1Semana)
                    .addComponent(radioMensal)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(radioPeriodo)
                                    .addComponent(jLabel1)
                                    .addComponent(textDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(comboPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(textProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton9)
                            .addComponent(jRadioButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanePedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(labelTotalVendas)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioActionPerformed
        try
        {                        
            List<ItemRelatorio> pedidos = servico.ObterRelatorio(textDataInicial.getText(), textDataFinal.getText(), comboPlataforma.getSelectedItem().toString(), comboCategoria.getSelectedItem().toString(), textProduto.getText());
            DefaultTableModel model = (DefaultTableModel) tablePedidos.getModel();
            model.setRowCount(0);

            int size = pedidos.size();        

            for (int i = 0; i < size; i++){
                ItemRelatorio pro = pedidos.get(i);
                if (pro != null) {
                    Object[] row = new Object[7];
                    row[0] = pro.getPedidoId();
                    row[1] = pro.getClienteNome();
                    row[2] = pro.getProdutoNome();
                    row[3] = pro.getQuantidade();
                    row[4] = pro.getData();
                    row[5] = pro.getValorUnitario();
                    row[6] = pro.getValorTotal();
                    model.addRow(row);                
                }            
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Não foi possível exibir o relatório.");
        }
    }//GEN-LAST:event_botaoGerarRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerarRelatorio;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboPlataforma;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel labelTotalVendas;
    private javax.swing.JRadioButton radio1Semana;
    private javax.swing.JRadioButton radio24Horas;
    private javax.swing.JRadioButton radioMensal;
    private javax.swing.JRadioButton radioPeriodo;
    private javax.swing.JScrollPane scrollPanePedidos;
    private javax.swing.JTable tablePedidos;
    private javax.swing.JFormattedTextField textDataFinal;
    private javax.swing.JFormattedTextField textDataInicial;
    private javax.swing.JTextField textProduto;
    // End of variables declaration//GEN-END:variables
}
