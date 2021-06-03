package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import Domain.Controller;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author c.mihai
 */
public class GUI_lista_comenzi extends javax.swing.JFrame {

    /**
     * Creates new form GUI.GUI_lista_comenzi
     */
    public GUI_lista_comenzi() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        //jList1 = new javax.swing.JList<>();
        jList1 = new JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        jPanel6.setBackground(new java.awt.Color(0, 204, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton18.setBackground(new java.awt.Color(0, 204, 153));
        jButton18.setText("Medicamente");
        jButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton19.setBackground(new java.awt.Color(0, 204, 153));
        jButton19.setText("Lista comenzi");
        jButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton19.setFocusable(false);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton20.setBackground(new java.awt.Color(0, 204, 153));
        jButton20.setText("LogOut");
        jButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("src/main/java/GUI/todo-list.png")); // NOI18N

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Denumire medicament", "Cantitate ceruta", "Cantitate disponibila"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jList1.setModel(new javax.swing.DefaultListModel<>());

        jScrollPane2.setViewportView(jList1);

        jButton1.setText("Accepta comanda");

        jButton2.setText("Onorat");

        jButton3.setText("Neonorat");

        jButton4.setText("Refuza comanda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jButton4)
                                                                .addGap(34, 34, 34)
                                                                .addComponent(jButton2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton3))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel1)))))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton3)
                                                        .addComponent(jButton4))))
                                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        jButton20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogOut();
            }
        });

        jList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listMouseClick();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAcceptOrder();
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRejectOrder();
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOnorat();
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNeonorat();
            }
        });

        jButton18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMedicamente();
            }
        });
    }// </editor-fold>

    private void onLogOut() {
        controller.initiateLogIn();
        dispose();
    }

    private void onMedicamente() {
        controller.onMedicamenteFarmButton(this.currentUser);
        dispose();
    }

    private void onAcceptOrder() {
        if (jList1.getSelectedIndex() != 0) {
            JOptionPane.showMessageDialog(this, "Comenzile trebuie acceptate in ordine!",
                    "Acceptare ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.currentOrderStatus.equals("In Asteptare")) {
            controller.modifyStatus(this.currentOrder, "In Lucru");
            this.currentOrderStatus = "In Lucru";
        }
        else {
            JOptionPane.showMessageDialog(this, "Aceasta comanda a fost deja acceptata!",
                    "Acceptare ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onRejectOrder() {
        if (this.currentOrderStatus.equals("In Asteptare")) {
            controller.modifyStatus(this.currentOrder, "Refuzata");
            this.currentOrderStatus = "Refuzata";
            updateList();
            emptyTabel();
        }
        else {
            JOptionPane.showMessageDialog(this, "Comanda aceasta a fost deja acceptata!",
                    "Refuzare ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onOnorat() {
        if (this.currentOrderStatus.equals("In Lucru")) {
            controller.modifyStatus(this.currentOrder, "Onorat");

            DefaultListModel model = (DefaultListModel) jList1.getModel();
            int selectedRowindex = jList1.getSelectedIndex();

            String row = model.getElementAt(selectedRowindex).toString();
            String[] rowSplit = row.split(", ");
            rowSplit = rowSplit[0].split(" : ");

            Object[][] data = controller.orderContent(Integer.parseInt(rowSplit[1]));

            for (Object[] datum : data) {
                int cant = (int) datum[1];
                String denumire = (String) datum[0];
                controller.updateCantitateMed(denumire, cant);
            }
            updateList();
            emptyTabel();
        }
        else {
            JOptionPane.showMessageDialog(this, "Prima data trebuie sa ACCEPTATI comanda!",
                    "ONORARE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onNeonorat() {
        if (this.currentOrderStatus.equals("In Lucru")) {
            controller.modifyStatus(this.currentOrder, "Neonorat");
            updateList();
            emptyTabel();
        }
        else {
            JOptionPane.showMessageDialog(this, "Prima data trebuie sa ACCEPTATI comanda!",
                    "NEONORARE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateList() {
        DefaultListModel lst = (DefaultListModel) jList1.getModel();
        lst.removeElementAt(jList1.getSelectedIndex());
    }

    private void listMouseClick() {
        DefaultListModel model = (DefaultListModel) jList1.getModel();
        int selectedRowindex = jList1.getSelectedIndex();

        String row = model.getElementAt(selectedRowindex).toString();
        String[] rowSplit = row.split(", ");
        rowSplit = rowSplit[0].split(" : ");


        Object[][] data = controller.orderContent(Integer.parseInt(rowSplit[1]));
        this.currentOrder = Integer.parseInt(rowSplit[1]);
        this.currentOrderStatus = controller.getStatusCommand(this.currentOrder);
        emptyTabel();

        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
        for (Object[] datum : data) {
            Object[] aux = {datum[0], datum[1], datum[2]};
            tbl.addRow(aux);
        }
    }

    private void emptyTabel() {
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
        tbl.setRowCount(0);
    }

    private void setOrders() {
        String[] data = controller.orderList();

        DefaultListModel model = (DefaultListModel) jList1.getModel();
        model.clear();
        for (String dat : data) {
            model.addElement(dat);
        }
    }

    public void setCurrentUser(int user) {
        this.currentUser = user;
    }

    public void show(GUI_lista_comenzi list) {
        list.pack();
        list.setOrders();
        list.setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private Controller controller = new Controller();
    private int currentUser;
    private String currentOrderStatus;
    private int currentOrder;
    // End of variables declaration//GEN-END:variables
}
