/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author g-pfeifer
 */
public class Circle extends DrawItem{
    private Point currentPoint;
    
    /** Creates a new instance of OpenRectangle */
    public Circle( Point thisPoint, Color thisColor ) {
        super( thisPoint, thisColor );
        currentPoint = thisPoint;
    }
    
    public void add( Point thisPoint ) {
        currentPoint = thisPoint;
    }
    
    public void draw( Graphics g ) {
        int xStart = getItemLocation().x;
        int yStart = getItemLocation().y;
        int radius = (int)Math.sqrt((int)(Math.abs(currentPoint.x - xStart)*Math.abs(currentPoint.x - xStart))+ (int) Math.abs(currentPoint.y - yStart)*Math.abs(currentPoint.y - yStart));
        int xUpperLeft = ( xStart - radius);
        int yUpperLeft = ( yStart - radius );
        //int radius = (int) Math.sqrt( ())
        
        
        g.drawOval( xUpperLeft, yUpperLeft, (radius)*2, (radius*2) );
        
    }
    
}