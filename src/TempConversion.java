
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//This program converts celsius to fahreinheit temperature and vice versa.

/**
 * ***************************************************************************
 * @author tofu.
 * 
 * @version 1.0b
 * ***************************************************************************
 */
public class TempConversion extends JFrame
{
    private JLabel celsiusLabel;
    private JLabel fahreinheitLabel;
        
    private JTextField celsiusTF;
    private JTextField fahreinheitTF;
    
    private CelsHandler celsiusHandler;
    private FahrHandler fahreinheitHandler;
    
    private static final int WIDTH = 550;
    private static final int HEIGHT = 60;
    private static double FTOC = 5.0 / 9.0;
    private static double CTOF = 9.0 / 5.0;
    private static final int OFFSET = 32;
    
public TempConversion()
{
    this.setIconImage(new 
        ImageIcon(getClass().getResource("logowilde1.png")).getImage()); 
    setTitle("Temperature Conversion");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(1, 4));
    
    celsiusLabel = new JLabel("Temp in Celcius >>>>", SwingConstants.CENTER);
    
    fahreinheitLabel = new JLabel("Temp in Fareinheit >>>>", SwingConstants.CENTER);
    
    celsiusTF = new JTextField(7);
    fahreinheitTF = new JTextField(7);
    
    pane.add(celsiusLabel);
    pane.add(celsiusTF);
    
    
    pane.add(fahreinheitLabel);
    pane.add(fahreinheitTF);
    
    
    celsiusHandler = new CelsHandler();
    fahreinheitHandler = new FahrHandler();
    
    celsiusTF.addActionListener(celsiusHandler);
    fahreinheitTF.addActionListener(fahreinheitHandler);
    
    setSize(WIDTH, HEIGHT);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
}

private class CelsHandler implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        double celsius, fahreinheit;
        
        celsius = Double.parseDouble(celsiusTF.getText());
        
        fahreinheit = celsius * CTOF + OFFSET;
        
        fahreinheitTF.setText("" + fahreinheit);
        
    }
}

private class FahrHandler implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        double celsius, fahreinheit;
        
        fahreinheit = Double.parseDouble(fahreinheitTF.getText());
        
        celsius = fahreinheit - OFFSET * FTOC;
        
        celsiusTF.setText("" + celsius);
        
    }
}

public static void main(String[]args)
{
    TempConversion tempConv = new TempConversion();
    
}
        
        
        
        
    }      