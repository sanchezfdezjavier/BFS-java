package es.upm.dit.adsw.ej2;

import java.lang.*;

public class Link {

    private String src; // source node
    private String dst; // destination node
    private int weight; //edge's weight

    public Link(String src, String dst, int weight) throws IllegalArgumentException {
        if (src==null || dst==null || weight < 0) {
            throw new IllegalArgumentException();
        }
        this.src = src;
        this.dst = dst;
        this.weight = weight;

    }

    public String getSrc() {
        return this.src;
    }

    public String getDst() {
        return this.dst;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Link [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
    }

}

