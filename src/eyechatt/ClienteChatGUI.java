/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyechatt;

import com.google.gson.Gson;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastian
 */
public class ClienteChatGUI extends javax.swing.JFrame {

   private Socket socket;
    private DataOutputStream dout;
    private DataInputStream din;
    private Gson gson;
    
    
    public ClienteChatGUI() {
        initComponents();
        setTitle("Chat");
        init();
        jTextArea1Pant.setEditable(false);
        

        
        
    }
    private void init() {
        gson = new Gson();
    }
    
    protected void conectar() throws IOException {
       
       socket = new Socket(jTextField1.getText(), Integer.parseInt(jLabel2.getText()));
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());
        jTextArea1Pant.append("-------------------Conectado!------------------------\n");
        new Thread(() -> {
            try {
                recibirInformacion();
            } catch (IOException ex) {
               Logger.getLogger(ClienteLoginnGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    protected void recibirInformacion() throws IOException {
        while (true) {
            
            String info = din.readUTF();
            Mensaje m = gson.fromJson(info, Mensaje.class);
            mostrarMensajesRecibidos(m);
        }
    }
  
  
    protected void mostrarMensajesRecibidos(Mensaje m) {
        jTextArea1Pant.append(String.format("[%s]--> %s", m.getEnviadoPor(), m.getMensaje())+"\n"); //original
        jTextArea1Pant.append(String.format("[%s]--[%s]---> %s", m.getEnviadoPor(),m.getEnviadoA(), m.getMensaje())+"\n");
    }
    
    protected void enviarMensaje() throws IOException {
        //Mensaje m =new Mensaje(RecibirNombre.getText(), jLabel2.getText(),jTextField1.getText(), new Date());
        Mensaje m =new Mensaje(RecibirNombre.getText(), jLabel2.getText(),jTextField1.getText(), new Date());
        dout.writeUTF(gson.toJson(m));
        dout.flush();
       jTextField1.setText("");
    }
       
  

    protected void desconectars() throws IOException {
        socket.close();
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1Pant = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1enviar = new javax.swing.JButton();
        RecibirNombre = new javax.swing.JLabel();
        jButton2connect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1desconec = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jList1.setBackground(new java.awt.Color(204, 255, 204));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jTextArea1Pant.setColumns(20);
        jTextArea1Pant.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea1Pant.setRows(5);
        jScrollPane2.setViewportView(jTextArea1Pant);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1enviar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1enviar.setText("Enviar");
        jButton1enviar.setToolTipText("");
        jButton1enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1enviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1enviarMouseExited(evt);
            }
        });
        jButton1enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1enviarActionPerformed(evt);
            }
        });

        RecibirNombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        RecibirNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eyechatt/eye1copy.png"))); // NOI18N

        jButton2connect.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2connect.setText("Conectar");
        jButton2connect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2connectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2connectMouseExited(evt);
            }
        });
        jButton2connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2connectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("puerto:");

        jButton1desconec.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1desconec.setText("Desconectar");
        jButton1desconec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1desconecActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Servidor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RecibirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1desconec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2connect, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1desconec, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RecibirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1enviarActionPerformed
       try {
           enviarMensaje();
       } catch (IOException ex) {
           Logger.getLogger(ClienteChatGUI.class.getName()).log(Level.SEVERE, null, ex);
          
       }
       
    }//GEN-LAST:event_jButton1enviarActionPerformed

    private void jButton1enviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1enviarMouseEntered
    
    }//GEN-LAST:event_jButton1enviarMouseEntered

    private void jButton1enviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1enviarMouseExited
       
    }//GEN-LAST:event_jButton1enviarMouseExited

    private void jButton2connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2connectActionPerformed

        try {
            conectar();
            jButton2connect.setEnabled(false);
            jButton1desconec.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(ClienteChatGUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_jButton2connectActionPerformed

    private void jButton2connectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2connectMouseExited

    }//GEN-LAST:event_jButton2connectMouseExited

    private void jButton2connectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2connectMouseEntered

    }//GEN-LAST:event_jButton2connectMouseEntered

    private void jButton1desconecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1desconecActionPerformed

        try {
            desconectars();
        } catch (IOException ex) {
            Logger.getLogger(ClienteChatGUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        jButton2connect.setEnabled(true);
        jButton1desconec.setEnabled(false);

    }//GEN-LAST:event_jButton1desconecActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteChatGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel RecibirNombre;
    private javax.swing.JButton jButton1desconec;
    protected javax.swing.JButton jButton1enviar;
    private javax.swing.JButton jButton2connect;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea1Pant;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
