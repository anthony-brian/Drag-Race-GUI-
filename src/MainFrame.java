import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static int WIDTH = 1980 ;
    private static int LENGTH = 1020 ;

    private JTextArea textArea ;


    public MainFrame() {
        super("Drag Racing Game") ;
        setSize(WIDTH, LENGTH) ;
        setVisible(true) ;

        // Set the layout of the MainFrame
        setLayout(new BorderLayout()) ;

        // Initialization
        textArea = new JTextArea() ;
    }
}
