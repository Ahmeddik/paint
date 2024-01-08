/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttrail;

import javax.swing.*;

/*
 * @author asedd & sondos
 */

public class ProjectTrail
{

    public static void main(String[] args) {
        JFrame f = new JFrame();
        
        f.setTitle("Pernameg El-Rassam By A.Seddik & Sondos");
        f.setSize(800,800);
        f.setLocation(50, 50);
        f.setResizable(false);
      
        Buttons panel = new Buttons();
        f.add(panel);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
