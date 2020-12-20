/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Member_Print extends javax.swing.JFrame {

    /**
     * Creates new form Member_Print
     */
    public int id;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st;

    public Member_Print() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public Member_Print(int id) {
        initComponents();
        this.id = id;

//      id = 2;
        conn = databaseConnection.connectdb();
        String query = "SELECT * \n"
                + "From userinfo\n"
                + "WHERE UserID='" + id + "'";
        String C_query = "SELECT COUNT(UserID)\n"
                + "FROM userinfo\n"
                + "WHERE UserID!=6";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            String name1 = rs.getString("FirstName") + " " + rs.getString("LastName");
            name.setText(name1);

            M_Quan.setText(rs.getString("MealQuan"));
            G_Cost.setText(rs.getString("Send_money"));
            T_M_Cost.setText(rs.getString("MealCost"));
            double n = rs.getDouble(("Net_amount"));
            
            if (n < 0) {
                N_Cost.setForeground(Color.red);
                N_Cost.setText(rs.getString("Net_amount"));
            } else {
                N_Cost.setText(rs.getString("Net_amount"));
            }
            rs = st.executeQuery(C_query);
            rs.next();
            int c = rs.getInt(1);

            String U_query = "SELECT * FROM userinfo WHERE userID='"+id+"'"; //own
            rs = st.executeQuery(U_query);
            rs.next();
            double owner_add_Cost = rs.getDouble("A_Cost");
            
            String Q_sum ="SELECT SUM(A_Cost),COUNT(UserID) FROM userinfo WHERE Userid!=6"; ///total
            rs = st.executeQuery(Q_sum);
            rs.next();
            double add_Total = rs.getDouble(1);
            double T_member =rs.getDouble(2);
            
           double per_add_Cost=add_Total/T_member;
           
           double net_Add_own_cost = owner_add_Cost - per_add_Cost;
           
           if(net_Add_own_cost<0)
           {
               A_P_Cost.setForeground(Color.red);
               A_P_Cost.setText(Double.toString(net_Add_own_cost));
           }
           else
           {
                 A_P_Cost.setText(Double.toString(net_Add_own_cost));
           }
            
           double total = n+net_Add_own_cost;
           
           if(total<0)
           {  
               pay1.setForeground(Color.red);
               pay1.setText("You have to Pay " + Double.toString(total));
           }
           else 
           {
                pay1.setText("You will get back     " + Double.toString(total));
           }
            
           
            
         
            
          
            
            

        } catch (Exception e) {
            System.out.println(e);
        }

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
        Pay = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pay1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        M_Quan = new javax.swing.JLabel();
        G_Cost = new javax.swing.JLabel();
        T_M_Cost = new javax.swing.JLabel();
        N_Cost = new javax.swing.JLabel();
        A_P_Cost = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Pay.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setText("Name:");

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel5.setText("Meal Quantity:");

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel6.setText("Given Meal Cost:");

        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel7.setText("Total Meal Cost:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel8.setText("Net Cost:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("................................................................................................................................................................................................................");

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel11.setText("Additional Per Cost");

        pay1.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        pay1.setText("You  Have to Pay");

        name.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        name.setText("0");

        M_Quan.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        M_Quan.setText("0");

        G_Cost.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        G_Cost.setText("0");

        T_M_Cost.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        T_M_Cost.setText("0");

        N_Cost.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        N_Cost.setText("0");

        A_P_Cost.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        A_P_Cost.setText("0");

        javax.swing.GroupLayout PayLayout = new javax.swing.GroupLayout(Pay);
        Pay.setLayout(PayLayout);
        PayLayout.setHorizontalGroup(
            PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PayLayout.createSequentialGroup()
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PayLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name)
                            .addComponent(A_P_Cost)
                            .addComponent(N_Cost)
                            .addComponent(G_Cost)
                            .addComponent(M_Quan)
                            .addComponent(T_M_Cost)))
                    .addGroup(PayLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PayLayout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(pay1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        PayLayout.setVerticalGroup(
            PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PayLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name))
                .addGap(45, 45, 45)
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(M_Quan))
                .addGap(44, 44, 44)
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(G_Cost))
                .addGap(43, 43, 43)
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(T_M_Cost))
                .addGap(46, 46, 46)
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(N_Cost))
                .addGap(46, 46, 46)
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(A_P_Cost))
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(pay1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(40, 40, 40)
                .addComponent(print)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(print))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        
        Dashboard_admin d = new Dashboard_admin();
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here: 
        print p = new print();
        p.printRecord(Pay);
    }//GEN-LAST:event_printActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Member_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member_Print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A_P_Cost;
    private javax.swing.JButton Back;
    private javax.swing.JLabel G_Cost;
    private javax.swing.JLabel M_Quan;
    private javax.swing.JLabel N_Cost;
    private javax.swing.JPanel Pay;
    private javax.swing.JLabel T_M_Cost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pay1;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
