package view;

import controller.ControllerEstoque;
import controller.ControllerEstoqueProdutoUsuario;
import controller.ControllerProduto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelEstoque;
import model.ModelEstoqueProdutoUsuario;
import model.ModelProduto;
import model.ModelSessaoUsuario;
import sistema.Mensagens;
import util.Formatador;

/**
 *
 * @author gustavo
 */
public class ViewEstoque extends javax.swing.JFrame {

    private ModelProduto modelProduto = new ModelProduto();
    private ArrayList<ModelProduto> listaModelProdutos = new ArrayList<>();
    private final ControllerProduto controllerProduto = new ControllerProduto();
    private ModelEstoque modelEstoque = new ModelEstoque();
    private final ControllerEstoqueProdutoUsuario controllerEstoqueProdutoUsuario = new ControllerEstoqueProdutoUsuario();
    private ArrayList<ModelEstoqueProdutoUsuario> listaModelEstoqueProdutoUsuarios = new ArrayList<>();
    private final Formatador formatador = new Formatador();
    private final ControllerEstoque controllerEstoque = new ControllerEstoque();
    private DefaultTableModel tabela;
    private TableRowSorter<TableModel> sorter;
    private final Formatador FORMATADOR = new Formatador();

    public ViewEstoque() {
        initComponents();
        listarProdutos();
        setLocationRelativeTo(null);
        carregarMovimentacoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEstoque = new javax.swing.JPanel();
        jcbTipoMovimentacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jsQuantidade = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jtfValor = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEstoque = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbDescricao = new javax.swing.JComboBox<>();
        jtfPesquisa = new javax.swing.JTextField();
        jcbPesquisa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de estoque");
        setResizable(false);

        jcbTipoMovimentacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENTRADA", "SAÍDA" }));

        jLabel1.setText("Tipo de movimentação:");

        jLabel2.setText("Descrição do produto");

        jsQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel3.setText("Valor");

        jbSalvar.setBackground(new java.awt.Color(0, 153, 102));
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/icons8-salvar-20.png"))); // NOI18N
        jbSalvar.setText("Executar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jtEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Data", "Descrição produto", "Quantidade", "Valor", "Resposável"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtEstoque);
        if (jtEstoque.getColumnModel().getColumnCount() > 0) {
            jtEstoque.getColumnModel().getColumn(0).setMinWidth(80);
            jtEstoque.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtEstoque.getColumnModel().getColumn(0).setMaxWidth(80);
            jtEstoque.getColumnModel().getColumn(1).setMinWidth(100);
            jtEstoque.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtEstoque.getColumnModel().getColumn(1).setMaxWidth(100);
            jtEstoque.getColumnModel().getColumn(3).setMinWidth(80);
            jtEstoque.getColumnModel().getColumn(3).setPreferredWidth(80);
            jtEstoque.getColumnModel().getColumn(3).setMaxWidth(80);
            jtEstoque.getColumnModel().getColumn(4).setMinWidth(80);
            jtEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
            jtEstoque.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Movimentações do estoque");

        jLabel5.setText("Quantidade");

        jcbDescricao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDescricao.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDescricaoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyReleased(evt);
            }
        });

        jcbPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIPO", "DATA", "DESCRIÇÃO DO PRODUTO", "RESPONSÁVEL" }));
        jcbPesquisa.setSelectedIndex(2);

        jLabel7.setText("Texto para pesquisa");

        jLabel8.setText("Pesquisar por");

        javax.swing.GroupLayout jpEstoqueLayout = new javax.swing.GroupLayout(jpEstoque);
        jpEstoque.setLayout(jpEstoqueLayout);
        jpEstoqueLayout.setHorizontalGroup(
            jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpEstoqueLayout.createSequentialGroup()
                        .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jcbDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfValor)
                            .addGroup(jpEstoqueLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 67, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpEstoqueLayout.createSequentialGroup()
                        .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPesquisa)
                            .addGroup(jpEstoqueLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jcbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jpEstoqueLayout.setVerticalGroup(
            jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEstoqueLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jbSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        modelEstoque = new ModelEstoque();
        modelProduto = new ModelProduto();

        try {
            modelEstoque.setEstData(formatador.formatarData(new java.util.Date(System.currentTimeMillis())));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ViewEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        modelProduto = controllerProduto.getProdutoController(jcbDescricao.getSelectedItem().toString());
        try {
            modelEstoque.setEstPreco(formatador.converterVirgulaParaPonto(jtfValor.getText()));
        } catch (Exception e) {
            modelEstoque.setEstPreco(0);
        }
        modelEstoque.setEstQuantidade((int) jsQuantidade.getValue());
        modelEstoque.setEstTipoMov(jcbTipoMovimentacao.getSelectedIndex());
        modelEstoque.setEstIdProd(modelProduto.getProId());
        modelEstoque.setEstIdUsu(ModelSessaoUsuario.codigo);

        if (controllerEstoque.salvarEstoqueController(modelEstoque)) {
            JOptionPane.showMessageDialog(this, Mensagens.getMessage("EST_MOVIENTACAO"), Mensagens.getMessage("INFO"), JOptionPane.INFORMATION_MESSAGE);
            carregarMovimentacoes();
        } else {
            JOptionPane.showMessageDialog(this, Mensagens.getMessage("EST_ERRO_MOVIENTACAO"), Mensagens.getMessage("ERRO"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jcbDescricaoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDescricaoPopupMenuWillBecomeInvisible
        if (this.jcbDescricao.isPopupVisible()) {
            modelProduto = controllerProduto.getProdutoController(jcbDescricao.getSelectedItem().toString());
            this.jtfValor.setText(String.valueOf(modelProduto.getProValor()));
        }
    }//GEN-LAST:event_jcbDescricaoPopupMenuWillBecomeInvisible

    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        this.pesquisar();
    }//GEN-LAST:event_jtfPesquisaKeyReleased

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEstoque().setVisible(true);
            }
        });
    }

    private void pesquisar() {
        this.sorter = new TableRowSorter<>(tabela);
        this.jtEstoque.setRowSorter(this.sorter);

        String text = jtfPesquisa.getText();
        String text2 = jtfPesquisa.getText().toUpperCase();

        switch (jcbPesquisa.getSelectedIndex()) {
            case 0:
                //tipo
                sorter.setRowFilter(RowFilter.regexFilter(text, 0));
                sorter.setRowFilter(RowFilter.regexFilter(text2, 0));
                break;
            case 1:
                //data
                sorter.setRowFilter(RowFilter.regexFilter(text, 1));
                sorter.setRowFilter(RowFilter.regexFilter(text2, 1));
                break;
            case 2:
                //descricao
                sorter.setRowFilter(RowFilter.regexFilter(text, 2));
                sorter.setRowFilter(RowFilter.regexFilter(text2, 2));
                break;
            case 3:
                //responsavel
                sorter.setRowFilter(RowFilter.regexFilter(text, 5));
                sorter.setRowFilter(RowFilter.regexFilter(text2, 5));
                break;
            default:
                break;
        }
    }

    private void listarProdutos() {
        listaModelProdutos = controllerProduto.getListaProdutoController();
        jcbDescricao.removeAllItems();
        for (int i = 0; i < listaModelProdutos.size(); i++) {
            jcbDescricao.addItem(listaModelProdutos.get(i).getProDescricao());
        }
    }

    private void carregarMovimentacoes() {
        listaModelEstoqueProdutoUsuarios = controllerEstoqueProdutoUsuario.getListaEstoqueController();

        tabela = (DefaultTableModel) jtEstoque.getModel();
        tabela.setNumRows(0);
        String movimentacao = "";
        int cont = listaModelEstoqueProdutoUsuarios.size();
        for (int i = 0; i < cont; i++) {
            if (listaModelEstoqueProdutoUsuarios.get(i).getModelEstoque().getEstTipoMov() == 0) {
                movimentacao = "ENTRADA";
            } else {
                movimentacao = "SAÍDA";
            }
            tabela.addRow(new Object[]{
                movimentacao,
                formatador.formatarDataBR(listaModelEstoqueProdutoUsuarios.get(i).getModelEstoque().getEstData()),
                listaModelEstoqueProdutoUsuarios.get(i).getModelProduto().getProDescricao(),
                listaModelEstoqueProdutoUsuarios.get(i).getModelEstoque().getEstQuantidade(),
                listaModelEstoqueProdutoUsuarios.get(i).getModelEstoque().getEstPreco(),
                listaModelEstoqueProdutoUsuarios.get(i).getModelUsuario().getUsuNome()
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbDescricao;
    private javax.swing.JComboBox<String> jcbPesquisa;
    private javax.swing.JComboBox<String> jcbTipoMovimentacao;
    private javax.swing.JPanel jpEstoque;
    private javax.swing.JSpinner jsQuantidade;
    private javax.swing.JTable jtEstoque;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables
}
