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
    private Point itemLocation;
    private Color itemColor;
    
    public DrawItem( Point thisLocation, Color thisColor ){
        this.itemColor = thisColor;
        this.itemLocation = thisLocation;
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
