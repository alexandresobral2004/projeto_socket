package Application;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Client {
  public static void main(String[] args) {
         // TODO Auto-generated method stub
         MarcoCliente mimarco = new MarcoCliente();
         mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
 }

 class MarcoCliente extends JFrame{
   
  private static final long serialVersionUID = 1L;
  public MarcoCliente(){
         setBounds(600,300,280,350);
         LaminaMarcoCliente milamina = new LaminaMarcoCliente();
         add(milamina);
         setVisible(true);
         }
 }

 class LaminaMarcoCliente extends JPanel{
     /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public LaminaMarcoCliente(){
         JLabel texto = new JLabel("CLIENTE");
         add(texto);
         campo1 = new JTextField(20);
         add(campo1);
         miboton = new JButton("Enviar");
         EnviaTexto mievento = new EnviaTexto();
         miboton.addActionListener(mievento);
         add(miboton);
         System.out.println("testando git");
     }
  private class EnviaTexto implements ActionListener{
     
  public void actionPerformed(ActionEvent e) {
     //System.out.println(campo1.getText());
   try {
    Socket misocket = new Socket("192.168.1.104", 9999);
    DataOutputStream flujo_saida = new DataOutputStream(misocket.getOutputStream());
    flujo_saida.writeUTF(campo1.getText());
    flujo_saida.close();
    
    
   } catch (UnknownHostException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   } catch (IOException e1) {
    // TODO Auto-generated catch block
    System.out.println(e1.getMessage());
   }
     }
    }
    private JTextField campo1;
    private JButton miboton;
     
 }