/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Shabab
 */
public class Main {
    Ai ai;
    
    public Main()
    {
        ai = new Ai();
    }
    
    private void goUi()
    {
        JFrame frame = new JFrame("GadhaGasker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton sendButton = new JButton("SEND");
        JTextField field = new JTextField();
        field.setBounds(50,100, 200,30);
        frame.getContentPane().add(field, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        panel.add(sendButton);
        frame.getContentPane().add(panel, BorderLayout.EAST);
        
        JPanel middlePanel=new JPanel();
        JTextArea display = new JTextArea(16, 58);
        //display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        middlePanel.add(scroll);
        frame.getContentPane().add(middlePanel, BorderLayout.CENTER);
        String lineSeperator = System.lineSeparator();
            
        sendButton.addActionListener(e->{
            String input = field.getText();
            String inputText = "Human: " + input + lineSeperator;
            display.append(inputText);
            field.setText(null);
            
            String output = ai.getResponse(input);
            String outputText = "GadhaGasker: " + output + lineSeperator;
            display.append(outputText);
            frame.repaint();
            
        });
        
        String inputs[] = ai.getTableInputs();
        String alert = "GadhaGasker can respond to:" + lineSeperator;
        for(int c = 0; c < inputs.length; c++)
        {
            alert += (c + 1) + ". " + inputs[c] + lineSeperator;
        }
        
        
        JOptionPane.showMessageDialog(new JFrame(),
            alert);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 600);
        frame.setResizable(true);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main().goUi();
    }
}
