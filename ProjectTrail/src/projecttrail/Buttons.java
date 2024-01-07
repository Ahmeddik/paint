/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttrail;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/*
 * @author asedd & sondos
 */

public class Buttons extends JPanel
{
    //Variables for the coordinates of the shape
    private int x1, x2, y1, y2;
    
    //variable from the GeneralShape type
    private GeneralShape shape;
    
    //Variable for the shape's color
    private Color current_color;
    
    //Varaibles for the state of the shape whether it's filled or boarder and drawn as solid line or dashedLine
    private boolean _fill,_dott;
    
    //to check the type of the Shape
    String flag = "freehand";
    
    //Array for the shapes
    ArrayList<GeneralShape> arr;
    
    //Color, eraser, undo and clear_screen buttons' names
    JButton red,blue,green,erase,clr,undo;
    
    //Check box for the ShapeFill state and the LineState names
    JCheckBox dott,solid;
    
    //Radio button for the shapes names
    ButtonGroup shapes;
    JRadioButton rec; 
    JRadioButton lin;
    JRadioButton ov;
    JRadioButton pen;

    //Shapes variables
    Ovals oval;
    Rectangles rect;
    Lines line;
    FreeHand freehand;
    FreeHand eraser;

    public Buttons()
    {
        this.setBackground(Color.white);
        this.setFocusable(true);
        
        arr=new ArrayList<>();
        /*==========================================*/
        shape=null;
        /*==========================================*/
        dott = new JCheckBox("Fill",false);
        solid = new JCheckBox("Dotted",false);
        /*==========================================*/
        shapes = new ButtonGroup();
        
        rec = new JRadioButton("Rectangle");
        lin = new JRadioButton("Line");
        ov = new JRadioButton("Oval");
        pen = new JRadioButton("Pencile");
        
        shapes.add(rec);
        shapes.add(lin);
        shapes.add(ov);
        shapes.add(pen);
        /*==========================================*/
        red = new JButton();
        red.setBackground(Color.red);
        red.setPreferredSize(new Dimension(30, 30));
        
        blue = new JButton();
        blue.setBackground(Color.BLUE);
        blue.setPreferredSize(new Dimension(30, 30));
        
        green = new JButton();
        green.setBackground(Color.GREEN);
        green.setPreferredSize(new Dimension(30, 30));
        
        erase = new JButton("Eraser");
        erase.setBackground(Color.CYAN);
        erase.setPreferredSize(new Dimension(80, 30));
        
        clr = new JButton("Clear All");
        clr.setBackground(Color.ORANGE);
        clr.setPreferredSize(new Dimension(100, 30));
        
        undo = new JButton("UnDo");
        undo.setBackground(Color.YELLOW);
        undo.setPreferredSize(new Dimension(70, 30));
//------------------------------------------------------------------------------
        this.add(rec);
        this.add(lin);
        this.add(ov);
        this.add(pen);
        
        this.add(red);
        this.add(blue);
        this.add(green);
        
        this.add(dott);
        
        this.add(solid);
        
        this.add(undo);
        this.add(erase);
        this.add(clr);
//------------------------------------------------------------------------------
        red.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
               current_color=Color.RED;
               System.out.println("red button pressed");
            }
        });
        
        blue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                current_color = Color.blue;
                System.out.println("blue button pressed");

            }
        });
        
        green.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                current_color = Color.GREEN;
                System.out.println("green button pressed");

            }
        });
        
        erase.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               flag="eraser";
               System.out.println("eraser button pressed");
           }
       });
        
        clr.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               arr.clear();
               repaint();
               System.out.println("Clear All button pressed");
           }
       });
        
        undo.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               if (!arr.isEmpty()) {
                    arr.remove(arr.size()-1);
                    repaint();
                }
               System.out.println("Undo button pressed");
           }
       });
//------------------------------------------------------------------------------
        rec.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                flag="Rectangle";
                System.out.println("rectangle button pressed");
            }
        });
        
        lin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                flag="Line";
                System.out.println("line button pressed");
            }
        });
        
        ov.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                flag="Oval";
                System.out.println("oval button pressed");
            }
        });
        
       pen.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               flag="freehand";
               System.out.println("penceil button pressed");
           }
       });
//------------------------------------------------------------------------------
        dott.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                 _dott= e.getStateChange() == ItemEvent.SELECTED;
                 System.out.println("dotted has been checked");
            }
        });
//------------------------------------------------------------------------------
        solid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                _fill= e.getStateChange() == ItemEvent.SELECTED;
                System.out.println("filled has been checked");
            }
        });
//------------------------------------------------------------------------------
        this.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                x1=e.getX();
                y1=e.getY();
                System.out.println("mouse pressed");
                
                switch(flag)
                {
                    case "Rectangle":
                        rect=new Rectangles(x1,y1,x1,y1,_fill,_dott,current_color);
                        break;
                    case "Line":
                        line=new Lines(x1,y1,x1,y1,_fill,_dott,current_color);
                    case "Oval":
                        oval=new Ovals(x1,y1,x1,y1,_fill,_dott,current_color);
                        break;
                    case "freehand":
                        freehand=new FreeHand(x1,y1,x1,y1,_fill,_dott,current_color);
                        break;
                    case "eraser":
                        eraser = new FreeHand(x1,y1,x1,y1,current_color);

                }
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                System.out.println("mouse released");
                
                switch(flag)
                {
                    case "Rectangle":
                        rect.setX2(x2);
                        rect.setY2(y2);
                        arr.add(rect);
                        rect=null;
                        break;
                    case "Line":
                        line.setX2(x2);
                        line.setY2(y2);
                        arr.add(line);
                        line=null;
                        break;
                    case "Oval":
                        oval.setX2(x2);
                        oval.setY2(y2);
                        arr.add(oval);
                        oval=null;
                        break;
                    case "freehand":
                        freehand.setX2(x2);
                        freehand.setY2(y2);
                        arr.add(freehand);
                        freehand=null;
                        break;
                    case "eraser":
                        eraser.setX2(x2);
                        eraser.setY2(y2);
                        arr.add(eraser);
                        eraser=null;
                        break;
                }
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
//------------------------------------------------------------------------------
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                System.out.println("mouse dragged");
                switch(flag)
                {
                    case "Rectangle":
                        rect.setX2(x2);
                        rect.setY2(y2);
                        break;
                    case "Line":
                        line.setX2(x2);
                        line.setY2(y2);
                        break;
                    case "Oval":
                        oval.setX2(x2);
                        oval.setY2(y2);
                        break;
                    case "freehand":
                        freehand.setX2(x2);
                        freehand.setY2(y2);
                        break;
                    case "eraser":
                        eraser.setX2(x2);
                        eraser.setY2(y2);
                        break;
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
//------------------------------------------------------------------------------
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(GeneralShape value:arr)
        {
            value.drawShape(g2d);
        }
        if(rect!=null)
        {
            rect.drawShape(g2d);
        }
        if(line!=null)
        {
            line.drawShape(g2d);
        }
        if(oval!=null)
        {
            oval.drawShape(g2d);
        }
        if(freehand!=null)
        {
            freehand.drawShape(g2d);
        }
        if(eraser!=null)
        {
            eraser.drawShape(g2d);
        }
    }
}
