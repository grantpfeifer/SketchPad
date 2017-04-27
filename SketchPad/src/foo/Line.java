package foo;
import java.awt.*;

/**
 *
 * @author g-pfeifer
 */
public class Line extends DrawItem {
    
    private Point currentPoint;
    
    /** Creates a new instance of Line */
    public Line( Point thisPoint, Color thisColor ) {
        super( thisPoint, thisColor );
        currentPoint = thisPoint;
    }
    
    public void add( Point thisPoint ) {
        currentPoint = thisPoint;
    }
    
    public void draw( Graphics g ) {
        int xStart = getItemLocation().x;
        int yStart = getItemLocation().y;
        g.drawLine( xStart, yStart, currentPoint.x, currentPoint.y );
    }
    
}