package es.upm.dit.adsw.ej2;

public class Node {

    private final String name;
    private final int x;
    private final int y;

    public Node(String name, int x, int y) throws IllegalArgumentException {
        if (name==null || x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.x = x;
        this.y = y;
    }


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
