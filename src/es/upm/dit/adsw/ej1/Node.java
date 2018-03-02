/*
@author Javier Sanchez Fernandez
@version 11-2-2018
 */
package es.upm.dit.adsw.ej1;
import java.lang.*;

public class Node {


    private String name;
    private int x;
    private int y;

    public Node(String name, int x, int y) throws IllegalArgumentException {
        if (name.equals(null) || x < 0 || y < 0) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    //pero que quieres que haga si lo que estasmo haciend estos dia
    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Node [name=" + name + ", x=" + x + ", y=" + y + "]";
    }

}

	

