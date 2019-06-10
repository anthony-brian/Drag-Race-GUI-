import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import javax.swing.JOptionPane ;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Foo{

  public static void main(String[] args) {

    JFrame f = new JFrame("Car Picker");
    f.setSize(500, 500);
    f.setLocation(300,200);
    //f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE) ;
    
    
    final JTextArea textArea = new JTextArea(1000, 1000);
    
    
    f.getContentPane().add(BorderLayout.CENTER, textArea);
    
    
    final JButton button = new JButton("Nissan 370Z");
    final JButton button2 = new JButton("Mazda MX-5");
    
    
    f.getContentPane().add(BorderLayout.EAST, button);
    f.getContentPane().add(BorderLayout.SOUTH, button2) ;
    
    JFrame frame = new JFrame("Closer Test");
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 
    
 
    // frame.setVisible( true );
    
    
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("You chose Nissan 370Z\n");
            //f.setDefaultCloseOperation(JFrame.HIDE) ;
        }
    }
    );
    button2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("You chose Mazda MX-5\n");

        }
    }
    );
    
    f.addWindowListener( new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            
            JFrame frame = (JFrame)e.getSource();
 
            int result = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to exit the application?",
                "Exit Application",
                JOptionPane.YES_NO_OPTION);
 
            if (result == JOptionPane.YES_OPTION)
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    }
    );

    f.setVisible(true);

  }

}