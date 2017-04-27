/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foo;
import java.awt.*;

public class Star extends DrawItem {
    // inner radius is the distance from the center to an interior vertex,
    // as a fraction of the distance to an exterior vertex (i.e. a star point)
       private final static double INNER_RADIUS_FRACTION = 
           Math.sin(0.1 * Math.PI)/Math.sin(0.7 * Math.PI);
 
    // star arc is the angle (in radians) between two adjacent points of a star
    private final static double STAR_ARC = 72.0 * (Math.PI / 180.0);
    
    private Point currentPoint;     // current location of the cursor
    private Polygon thisStar;       // polygon contains list of (x,y) coordinates 
    
    /** Creates a new instance of Star */
    public Star( Point thisPoint, Color thisColor ) {
        super( thisPoint, thisColor );   // superclass has center location and color variables
           currentPoint = thisPoint;	
    }
    
    public void add( Point thisPoint ) {
        currentPoint = thisPoint;  // indicates location of first point of the star
    }
    
    public void draw( Graphics g ) {
        // get the location of the center point
        int xCenter = getItemLocation().x;
        int yCenter = getItemLocation().y;
        
        thisStar = new Polygon();  // create the new polygon of (x,y) coordinates
        
        // use the difference in x and y values between starting and current location
        // to determine the angle of rotation of the star (with zero degrees being a
        // vector along the positive x-axis), the distance from the center to the current
        // location of the cursor, and the distance from the center to an interior vertex.
        int dx = currentPoint.x - xCenter;  
        int dy = currentPoint.y - yCenter;  
        int outerRadius = (int) Math.sqrt( (double) ( dx * dx + dy * dy ) );
        int innerRadius = (int) ( INNER_RADIUS_FRACTION * (double) outerRadius );
        
        // note than the arctangent returns a value in the range [-pi/2,+pi/2]
        // so if the vector formed by the current cursor location relative to the
        // center is in quadrants II or III, then theta must be adjusted accordingly.
        double theta = Math.atan( (double) dy / (double) dx );
        if ( dx < 0 ) { // then not in quadrant I or IV
            if ( dy < 0 )
                theta += Math.PI; // adjust from quadrant IV to quadrant II
            else
                theta -= Math.PI; // adjust from quadrant I to quadrant III
        }
        
        // create the set of adjacent points in the polygon (like connect-the-dots) by use of
        // trigonometry - theta indicates offset angle from zero degrees (which would be
        // directly to the right of the center point) that the cursor is currently located at.
        for ( int i = 0; i < 5; i++ ) {
            int xOuter = xCenter + (int) (outerRadius * Math.cos( i * STAR_ARC + theta ));
            int yOuter = yCenter + (int) (outerRadius * Math.sin( i * STAR_ARC + theta ));
            int xInner = xCenter + (int) (innerRadius * Math.cos( (i+0.5) * STAR_ARC + theta ));
            int yInner = yCenter + (int) (innerRadius * Math.sin( (i+0.5) * STAR_ARC + theta ));
            thisStar.addPoint( xOuter, yOuter );
            thisStar.addPoint( xInner, yInner );
        }
        g.fillPolygon( thisStar );  // finally, render the image!
    }
    
}
