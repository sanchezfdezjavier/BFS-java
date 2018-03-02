/*
@author Javier Sanchez Fernandez
@version 11-2-2018
 */

package es.upm.dit.adsw.ej1;

import java.util.*;

public class Graph {

    private LinkedList<Link> edges = new LinkedList<Link>();
    private LinkedList<Node> nodes = new LinkedList<Node>();

    public Graph() {


    }

    public void addLink(Link link) {
        this.edges.add(link);
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void addLink2D(String a, String b, int w) throws Exception {
        this.edges.add(new Link(a, b, w));
        this.edges.add(new Link(b, a, w));

    }

    //comprobar si esta bien
    public Link getLink(Node src, Node dst) {
        String nodeSrc = src.getName();
        String nodeDst = dst.getName();
        Link resultado = null;

        for (int i = 0; i < edges.size(); i++) {
            if (nodeSrc.equals(edges.get(i).getSrc()) &&
                    nodeDst.equals(edges.get(i).getDst())) {
                resultado = this.edges.get(i);
            }
        }
        return resultado;

    }

    public LinkedList<Link> getLinks() {
        return this.edges;
    }

    public LinkedList<Link> getLinks(Node node) {
        String nodeName = node.getName();
        LinkedList<Link> resultado=new LinkedList<>();

        for (int i = 0; i < this.edges.size(); i++) {
            String srcName = this.edges.get(i).getSrc();
            if (srcName.equals(nodeName)) {
                resultado.add(this.edges.get(i));
            }
        }
        return resultado;
    }

    public Node getNode(String name) {
        String nodeName;
        Node resultado = null;
        for (int i = 0; i < this.nodes.size(); i++) {
            nodeName = this.nodes.get(i).getName();
            if (nodeName.equals(name)) {
                resultado= this.nodes.get(i);
            }
        }
        return resultado;
    }

    public LinkedList<Node> getNodes() {
    		return this.nodes;
    }

    //en bfs no es necesario
    public int getWeight(LinkedList<Node> path) {

        int resultado = 0;
        for (int i = 0; i < path.size()-1; i++) {
            if(this.getLink(path.get(i), path.get(i+1)).equals(null)){
                return -1;
            }
            Node src= path.get(i);
            Node dst= path.get(i+1);
            Link edge= this.getLink(src, dst);
            int weight= edge.getWeight();

            resultado+= weight;
        }
        return resultado;
    }
}






