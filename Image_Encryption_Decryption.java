package com.secure;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Image_Encryption_Decryption{

    public static void operate(int key){
        JFileChooser f=new JFileChooser();
        f.showOpenDialog(null);
        File file=f.getSelectedFile();
        //file FileInputStream
        try{
            FileInputStream fis=new FileInputStream(file);
            byte[] data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data){
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"You are Done");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField=new JTextField(10);

        f.setLayout(new FlowLayout());

        JButton button=new JButton();
        button.setText("OPEN IMAGE");

        button.addActionListener(e->{
            System.out.println("Button Clicked");
            String text=textField.getText();
            int key=Integer.parseInt(text);
            operate(key);
        });


        f.add(button);
        f.add(textField);
        f.setVisible(true);
    }
}
