package projecttrail;

import java.awt.*;
import static java.awt.Color.*;
import java.util.ArrayList;

public class  FreeHand extends GeneralShape
{
    private ArrayList<Integer>arrX= new ArrayList<Integer>();
    private ArrayList<Integer>arrY= new ArrayList<Integer>();
    
    private int penTipSize;
    public FreeHand(){
        
    }

    public FreeHand(int x1, int y1, int x2, int y2, boolean dash, boolean fill , Color c)
    {
        super(x1, y1, x2, y2, dash, fill, c);
        penTipSize=2;
    }
    
    public FreeHand(int x1, int y1, int x2, int y2,Color c)
    {
        super(x1, y1, x2, y2, false,false,c.white);
        penTipSize=15;
    }


   @Override
    public void drawShape(Graphics2D g2d)
    {
        
        if (getCurrentColor() == RED){
            g2d.setColor(Color.RED);
        } else if (getCurrentColor() == GREEN){
            g2d.setColor(Color.GREEN);
        } else if (getCurrentColor() == BLUE){
            g2d.setColor(Color.BLUE);
        } else if (getCurrentColor() == WHITE){
            g2d.setColor(Color.WHITE);
        } else{
            g2d.setColor(Color.BLACK);
        }
        
        
        arrX.add(getX2());
        arrY.add(getY2());
       
       if (getDash() == true) {
            Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);
        } else {
            g2d.setStroke(new BasicStroke(penTipSize));
        }
        for (int i = 0; i < arrX.size() - 1; i++) {
            g2d.drawLine(arrX.get(i), arrY.get(i), arrX.get(i + 1), arrY.get(i + 1));
        }
    }
}
