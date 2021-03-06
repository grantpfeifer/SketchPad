/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package foo;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;


/**
 *
 * @author grant
 */
public abstract class DrawItem {
    public static final int FREEHAND = 1;
    public static final int LINE = 2;
    public static final int OPEN_RECTANGLE = 3;
    public static final int FILLED_RECTANGLE = 4;
    public static final int STAR = 5;
    public static final int CIRCLE = 6;
    
    
    private Point   itemLocation;
    private Color   itemColor;
            
    public DrawItem( Point thisLocation, Color thisColor ){
        this.itemColor = thisColor;
        this.itemLocation = thisLocation;
    }
    
    public String toString() {
        int rgb = getItemColor().getRGB() & 0x00FFFFFF;                     // line 2
        StringBuffer hex = new StringBuffer( Integer.toHexString( rgb ) );  // line 3
        while ( hex.length() < 6 )                                          // line 4
            hex.insert( 0, '0' );                                            // line 5
        return "<html><font color=\"#" + hex.toString() + "\">"
                + this.getClass().getName().substring(4) + "</font></html>";
    }
    
    public Point getItemLocation(){
        return this.itemLocation;
    }
    
    public void setItemLocation( Point p ){
        this.itemLocation = p;
    }
    
    public Color getItemColor(){
        return this.itemColor;
    }
    
    public void setItemColor( Color c ){
        this.itemColor = c;
    }
    
    public abstract void draw( Graphics g );
    public abstract void add( Point p );
    
}
