/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinereservationdbms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author NICK
 */
public class SeatingArrangement extends javax.swing.JFrame {

    /**
     * Creates new form SeatingArrangement
     */
    static JButton btn1;
    String[] prefix = {"A", "B", "C", "D", "E", "F"};
    String[] postfix = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42"};
    HashMap<String, JButton> buttonIDs = new HashMap<>();

    String[][] seatNumber = new String[6][42];
    ArrayList<String> allSeatSelected = new ArrayList<>();
    static int row_of_list = 0 ;
    static DefaultListModel listModel = new DefaultListModel() ;
    static int countPassenger = 0 ; 
    static First_page fp ;

    /**
     * Creates new form testFrame
     */
    public SeatingArrangement() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("SELECT YOUR SEAT");
        // add(panel) ;
        int range = 42;
        JButton[][] btn = new JButton[6][42]; // button of all seats 
        JLabel[] lbl = new JLabel[42];
        JLabel[] ABCDEFlabel = new JLabel[6];
        int count = 0;
        Dimension panelSize = null;
        JLabel tmpLabel = new JLabel();
        JLabel Background = new JLabel();
        // tmpLabel.setSize(2750, 544);
        tmpLabel.setBounds(0, 0, 2750, 380);
        Background.setBounds(0, 20, 2750, 300);
        //  tmpLabel.setBackground(new Color(50, 50, 50));

        tmpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airlinereservationdbms/AIRLINE_TOP_VIEW.png")));
        // tmpLabel.setBackground(Color.red);
        //tmpLabel.setOpaque(false);
        //tmpLabel.setOpaque(true);
        // panel.add(tmpLabel) ;
        Background.setOpaque(true);
        // Background.setBackground(Color.BLACK);
        tmpLabel.setVisible(true);
        Background.setVisible(true);

        int x = 600;
        int y = 60;
        int buttonIDcount = 0;
        int Random_Color_for_Seat_Booked;
        Random rand = new Random();
        //int countBtn = 0 ;
        JButton addBtnToHashmap;
        setAllSeatID();

        try {
            for (int i = 0; i < 6; i++) {
                ABCDEFlabel[i] = new JLabel();
                for (int j = 0; j < 42; j++) {
                    //     btn[i][j].putClientProperty("id", "btn1");
                    buttonIDcount++;
                    btn[i][j] = new JButton();
                    addBtnToHashmap = btn[i][j];
                    buttonIDs.put(seatNumber[i][j], addBtnToHashmap);
                    btn[i][j].setBounds(x, y, 30, 25);
                    Random_Color_for_Seat_Booked = rand.nextInt(2);
                    if (Random_Color_for_Seat_Booked == 0) {
                        btn[i][j].setBackground(new Color(204, 204, 204));

                    } else {
                        btn[i][j].setBackground(new Color(97, 157, 236));
                    }
                    btn[i][j].setVisible(true);
                    panel.add(btn[i][j]);

                    //       panel.setVisible(false);
                    //       scrollPane.setVisible(false);
                    panelSize = panel.getSize();
                    x += 47;
                    if ((j + 1) / 6 == 7) {
                        ABCDEFlabel[i].setText(prefix[i] + " ");
                        ABCDEFlabel[i].setBounds(570, y, 25, 25);
                        ABCDEFlabel[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
                        ABCDEFlabel[i].setForeground(Color.BLACK);
                        ABCDEFlabel[i].setVisible(true);
                        panel.add(ABCDEFlabel[i]);
                        x = 600;
                        y += 40;
                        //btn[i][j].setK

                    }
                    if (y >= 128 && count < 42) {
                        count++;
                        // y = 230 ;
                        lbl[j] = new JLabel();
                        lbl[j].setText(count + "");
                        lbl[j].setBounds(x + 6, y + 30, 25, 25);
                        lbl[j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
                        lbl[j].setForeground(Color.BLACK);
                        lbl[j].setVisible(true);
                        panel.add(lbl[j]);
                    }

                }
                if (y == 180) {
                    y += 20;

                }
            }
            panel.add(tmpLabel);

        } catch (Exception e) {
            System.out.println("THIS : " + e);
        }
        int c = 0;
        Component[] components = panel.getComponents();
        for (Component com : components) {
            if (com instanceof JButton) {
                c++;

            }
        }
        System.out.println();
        panel.add(Background);
        seatClicked();

    }

    public void SeatingArrangement(First_page temp)
    {
        fp = temp ;
    }
    public void seatClicked() {
        Component[] components = panel.getComponents();
        JButton btn;

        for (Component comp : components) {
            if (comp instanceof JButton ) {
                btn = (JButton) comp;
                //btn1 = btn ;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //JButton jb =  ; 
                //        if(countPassenger < fp.totalPassenger){
                        if (comp.getBackground().equals(new Color(102, 255, 102)) ) {
                            String temp;
                            temp = checkBtn((JButton) comp);
                            if(checkSeat(temp))
                            {   String temp1 ;
                                temp1 = temp ;
                                int tempNum = Integer.parseInt(temp.substring(1)) ;
                                
                                if(tempNum <= 14)
                                {
                                    temp += "\t\t- FRONT" ;
                                }
                                if(tempNum >= 15 && tempNum <= 28)
                                {
                                    temp += "\t\t- MIDDLE" ;
                                }
                                if(tempNum >= 29 && tempNum <= 42)
                                {
                                    temp += "\t\t- BACK" ;
                                }
                                listModel.removeElement(temp) ;
                                temp = temp1 ;
                                allSeatSelected.remove(temp) ;
                                countPassenger-- ;
                                
                                
                                
                            }
                            comp.setBackground(new Color(204, 204, 204));

                        } else if (!comp.getBackground().equals(new Color(97, 157, 236))  && countPassenger < fp.totalPassenger) {
                            String temp;
                            temp = checkBtn((JButton) comp);
                            seatSelectedlbl.setText(temp);
                            comp.setBackground(new Color(102, 255, 102));
                            if (!checkSeat(temp)) {
                                String temp1 ;
                                temp1 = temp ;
                                int tempNum = Integer.parseInt(temp.substring(1)) ;
                                allSeatSelected.add(temp);
                                countPassenger++ ;
                                
                                
                                if(tempNum <= 14)
                                {
                                    temp += "\t\t- FRONT" ;
                                }
                                if(tempNum >= 15 && tempNum <= 28)
                                {
                                    temp += "\t\t- MIDDLE" ;
                                }
                                if(tempNum >= 29 && tempNum <= 42)
                                {
                                    temp += "\t\t- BACK" ;
                                }
                                listModel.addElement(temp);
                                SelectedSeatList.setModel(listModel);
                                row_of_list++ ;
                                temp = temp1 ;
                                
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog( SeatingArrangement.this ,"SELECT ONLY " + fp.totalPassenger+ " PASSENGERS");
                        }
                        

                        //  System.out.println("BUTTON CLICKED : " + buttonIDs.);
                    }
                });
            }
            
            
        }
    }

    public boolean checkSeat(String temp) {
        for (String seat : allSeatSelected) {
            if (seat.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    public String checkBtn(JButton btn) {
        Object[] tempKeyArray = new Object[buttonIDs.size()];
        tempKeyArray = buttonIDs.keySet().toArray();
        for (int i = 0; i < buttonIDs.size(); i++) {

            if (btn == buttonIDs.get(tempKeyArray[i])) {
                return (String) tempKeyArray[i];

            }

        }
        return null;
    }

    public void setAllSeatID() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 42; j++) {
                seatNumber[i][j] = prefix[i] + postfix[j];
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        proceedBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SelectedSeatList = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        seatSelectedlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 830));

        panel.setPreferredSize(new java.awt.Dimension(2800, 375));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Arial Nova Light", 1, 24)); // NOI18N
        jLabel1.setText("SELECT SEAT");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setBackground(new java.awt.Color(97, 157, 236));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Nova Cond", 1, 11)); // NOI18N
        jLabel2.setText("SEAT BOOKED");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Nova Cond", 1, 11)); // NOI18N
        jLabel3.setText("SEAT AVAILIBILITY");

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Nova Cond", 1, 11)); // NOI18N
        jLabel4.setText("SEAT SELECTED");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(8, 8, 8)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(8, 8, 8)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(19, 19, 19)))))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        proceedBtn.setBackground(new java.awt.Color(0, 0, 0));
        proceedBtn.setForeground(new java.awt.Color(255, 255, 255));
        proceedBtn.setText("PROCEED");
        jPanel2.add(proceedBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Nova", 1, 18)); // NOI18N
        jLabel6.setText("YOU SELECTED ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        SelectedSeatList.setBackground(new java.awt.Color(204, 255, 255));
        SelectedSeatList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SelectedSeatList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(SelectedSeatList);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 90));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Nova", 1, 18)); // NOI18N
        jLabel5.setText("SEAT NUMBER :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, -1, -1));

        seatSelectedlbl.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        seatSelectedlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(seatSelectedlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 39, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(SeatingArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeatingArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeatingArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeatingArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeatingArrangement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> SelectedSeatList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel;
    private javax.swing.JButton proceedBtn;
    private javax.swing.JLabel seatSelectedlbl;
    // End of variables declaration//GEN-END:variables
}
