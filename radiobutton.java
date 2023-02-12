package sprint0;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class radiobutton extends sprint0
{
  public static void main(String[] args) {
    JFrame f = new JFrame("sprint0");
    f.setSize(300, 150);
    f.setLocation(200, 200);
    f.addWindowListener(new WindowAdapter( ) {
      public void windowClosing(WindowEvent we) { System.exit(0); }
    });

    JPanel entreePanel = new JPanel( );
    final ButtonGroup entreeGroup = new ButtonGroup( );
    JRadioButton radioButton;
    entreePanel.add(radioButton = new JRadioButton("rb1"));
    radioButton.setActionCommand("rb1");
    entreeGroup.add(radioButton);
    entreePanel.add(radioButton = new JRadioButton("rb"));
    radioButton.setActionCommand("rb");
    entreeGroup.add(radioButton);
    entreePanel.add(radioButton = new JRadioButton("rb3", true));
    radioButton.setActionCommand("rb3");
    entreeGroup.add(radioButton);
    
    final JPanel condimentsPanel = new JPanel( );
    condimentsPanel.add(new JCheckBox("box1"));
    condimentsPanel.add(new JCheckBox("box2"));
    condimentsPanel.add(new JCheckBox("box3"));
    
    JPanel orderPanel = new JPanel( );
    JButton orderButton = new JButton("click me");
    orderPanel.add(orderButton);
    
    Container content = f.getContentPane( );
    content.setLayout(new GridLayout(3, 1));
    content.add(entreePanel);
    content.add(condimentsPanel);
    content.add(orderPanel);
    
    orderButton.addActionListener(new ActionListener( ) {
      public void actionPerformed(ActionEvent ae) {
        String entree = 
          entreeGroup.getSelection().getActionCommand( );
        System.out.println(entree + " sandwich");
        Component[] components = condimentsPanel.getComponents( );
        for (int i = 0; i < components.length; i++) {
          JCheckBox cb = (JCheckBox)components[i];
          if (cb.isSelected( ))
            System.out.println("With " + cb.getText( ));
        }
      }
    });
    
    f.setVisible(true);
  }
}
