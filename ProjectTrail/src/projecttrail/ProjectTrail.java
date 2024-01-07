
package projecttrail;

//import java.awt.*;
//import java.awt.geom.*;
import javax.swing.*;

public class ProjectTrail
{

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Pernameg El-Rassam");
        f.setSize(800,800);
        
        Buttons pp = new Buttons();
        //FreeHand pp = new FreeHand();
        f.add(pp);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
