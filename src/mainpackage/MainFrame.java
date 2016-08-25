package mainpackage;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.qrcode.*;
import java.io.*;
import javax.swing.JOptionPane;
public class MainFrame extends javax.swing.JFrame {
    public MainFrame() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() 
    {
        jLabel1 = new javax.swing.JLabel();
        textbox1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QR Code Generator");
        setBounds(new java.awt.Rectangle(500, 300, 0, 0));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QR Code Generator");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 30, 210, 30);

        textbox1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        textbox1.setToolTipText("Type Anything.");
        getContentPane().add(textbox1);
        textbox1.setBounds(50, 90, 300, 50);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 180, 140, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainpackage/white.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 400, 300);

        getAccessibleContext().setAccessibleDescription("Generates Barcode of Any String");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String s=textbox1.getText();
    if(textbox1.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null,  " Please Enter Any Text");
    }
    else{
        try
     {
         
        BitMatrix bm=new QRCodeWriter().encode(s,BarcodeFormat.QR_CODE,500,500);
        MatrixToImageWriter.writeToStream(bm,"png",new FileOutputStream(new File("Barcode.png")));
  JOptionPane.showMessageDialog(null,  " Barcode Generated");
System.exit(1);
     }
     catch(WriterException | IOException e)
     {
             JOptionPane.showMessageDialog(null,  " Please Enter Any Text");
     }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,  " Please Enter Any Text");
        }
        //</editor-fold>

        /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textbox1;
    // End of variables declaration//GEN-END:variables
}