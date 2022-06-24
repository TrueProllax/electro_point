
package electropoint.desktop;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import electropoint.desktop.mainFrame;
import electropoint.property.PutUIManager;
import java.awt.Color;
import javax.swing.UIManager;

public class MainClass {


    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme());
            //UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme());
            //UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme());
            
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
        new PutUIManager();
        new mainFrame().setVisible(true);
    }
    
}
