/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foo;
import java.awt.*;
import java.util.*;

/**
 *
 * @author g-pfeifer
 */

public class Freehand extends DrawItem {
    
    private java.util.List dots = new ArrayList();  // list of connect-the-dots (i.e. points)
    
    public Freehand( Point thisPoint, Color thisColor ) {
        super( thisPoint, thisColor );   // superclass has location and color instance variables
        dots.add( thisPoint );   // location is also the first point in the list
    }
    
    public void add( Point thisPoint ) {
        dots.add( thisPoint );   // adds a point to the end of the connect-the-dots list
    }
    
    public void draw( Graphics g ) {
        Iterator setOfPoints = dots.iterator();
        Point lastPoint = null;  // needed as for n points there are n-1 lines to draw…
        while ( setOfPoints.hasNext() ) {
            Point thisPoint = (Point) setOfPoints.next();
            if ( lastPoint != null ) {
                g.drawLine(lastPoint.x, lastPoint.y, thisPoint.x, thisPoint.y);
            }
            lastPoint = thisPoint; // update where the current last point is           
        }
    }   
}

