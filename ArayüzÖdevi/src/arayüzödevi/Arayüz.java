
package arayüzödevi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class  Arayüz {
    JFrame jf;
    JButton kayitButonu,listeleButonu;
    JLabel l1,l2;
    JTextArea t1;

    
    public Arayüz () throws IOException{
       
        File f = new File("metin.txt");
        FileWriter fw = new FileWriter(f);
        
        
        jf = new JFrame("Nesne TabanlÄ± prog. ödevi");
        
        l1 = new JLabel("Kaydetmek istediginiz veri");
        l1.setBounds(10, 20, 250, 20);
        
        t1 = new JTextArea();
        t1.setBounds(10, 40, 400, 100);
        
        kayitButonu = new JButton("Kaydet");
        kayitButonu.setBounds(10, 200, 100, 30);
        
        l2 = new JLabel();
        l2.setBounds(10, 200, 400, 400);
        
        
        listeleButonu = new JButton("Listele");
        listeleButonu.setBounds(150, 200, 100, 30);
        
        kayitButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fw.write(t1.getText());
                    fw.flush();
                    
                } catch (IOException ex) {
                    Logger.getLogger(Arayüz.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        
        
        listeleButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    Scanner scan = new Scanner(f);
                    String listelenecekVeri = "";
                    while(scan.hasNextLine()){
                      listelenecekVeri += scan.nextLine();
                      l2.setText(listelenecekVeri);
                     }
                    
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Arayüz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        jf.add(listeleButonu);
        jf.add(l2);
        jf.add(l1);
        jf.add(t1);
        jf.add(kayitButonu);
        jf.setLayout(null);
        jf.setSize(500,700);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
    
    
}

    

