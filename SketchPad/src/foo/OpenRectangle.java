/*
 * OpenRectangle.java
 * John K. Estell
 * Created on April 19, 2006, 9:45 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package foo;
import java.awt.*;

/**
 *
 * @author jestell
 */
public class OpenRectangle extends DrawItem {
    
    private Point currentPoint;
    
    /** Creates a new instance of OpenRectangle */
    public OpenRectangle( Point thisPoint, Color thisColor ) {
        super( thisPoint, thisColor );
        currentPoint = thisPoint;
    }
    
    public void add( Point thisPoint ) {
        currentPoint = thisPoint;
    }
    
    public void draw( Graphics g ) {
        int xStart = getItemLocation().x;
        int yStart = getItemLocation().y;
        int xUpperLeft = Math.min( currentPoint.x, xStart );
        int yUpperLeft = Math.min( currentPoint.y, yStart );
        int width = Math.abs( currentPoint.x - xStart );
        int height = Math.abs( currentPoint.y - yStart );
        g.drawRect( xUpperLeft, yUpperLeft, width, height );
    }
    
}
