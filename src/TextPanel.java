import javax.swing.JPanel ;
import javax.swing.JTextArea ;
import java.awt.BorderLayout ;
import javax.swing.JScrollPane ;

public class TextPanel extends JPanel {
    private JTextArea textArea ;

    public TextPanel() {

        // assign instance variable
        textArea = new JTextArea() ;

        // assign a layout manager
        setLayout(new BorderLayout()) ;

        // add the text area to the layout manager (text area, position)
        add(new JScrollPane(textArea), BorderLayout.CENTER) ;
    }

    public void appendText(String text) {
        textArea.append(text) ;
    }
}

