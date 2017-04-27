package foo;
import java.awt.*;

/**
 *
 * @author jestell
 */
public class FilledRectangle extends DrawItem {
    
    private Point currentPoint;
    
    /** Creates a new instance of FilledRectangle */
    public FilledRectangle( Point thisPoint, Color thisColor ) {
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
        g.fillRect( xUpperLeft, yUpperLeft, width, height );
    }
    
}
