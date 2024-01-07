/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttrail;

import java.awt.*;
import static java.awt.Color.*;

/*
 * @author asedd & sondos
 */

public class Rectangles extends GeneralShape{
    
    private int x,y,Weidth,Hight;
//-----------------------------------------------------------
    public Rectangles(){
        
    }

    public Rectangles(int x1, int y1, int x2, int y2,boolean dash,boolean fill , Color c) {
        super(x1, y1, x2, y2, dash, fill, c);
    }
//-----------------------------------------------------------
    @Override
    public void drawShape(Graphics2D g2d)
    {
        
        if (getCurrentColor() == RED){
            g2d.setColor(Color.RED);
        } else if (getCurrentColor() == GREEN){
            g2d.setColor(Color.GREEN);
        } else if (getCurrentColor() == BLUE){
            g2d.setColor(Color.BLUE);
        } else {
            g2d.setColor(Color.BLACK);
        }
        
        x=Math.min(getX1(), getX2());
        y=Math.min(getY1(), getY2());
        Weidth=Math.abs(getX1() - getX2());
        Hight=Math.abs(getY1() - getY2());
        
        if (getFill() == true) {
            g2d.fillRect(x, y, Weidth,Hight);
        } else {
            if (getDash() == true) {
                Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g2d.setStroke(dashed);
            } else {
                g2d.setStroke(new BasicStroke(2));
            }
            g2d.drawRect(x, y, Weidth,Hight);
        }
    }
}
