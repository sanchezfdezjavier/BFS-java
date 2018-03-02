/*
@author Javier Sanchez Fernandez
@version 11-2-2018
 */
package es.upm.dit.adsw.ej1;

import java.util.*;

public class BFS {

    private Graph graph;
    private LinkedList<Node> queue = new LinkedList<>();
    private LinkedList<Node> visited = new LinkedList<>();
    private LinkedList<Node> adjacent = new LinkedList<>();

    public BFS(Graph graph) {
        this.graph = graph;
    }

    //para comprobar la adyacencia
    public boolean isAdj(Node src, Node dst) {

        LinkedList<Link> nodeLinks = this.graph.getLinks(src);
        for (int i = 0; i < nodeLinks.size(); i++) {
            if (nodeLinks.get(i).getSrc().equals(src) &&
                    nodeLinks.get(i).getDst().equals(dst)) {
                return true;
            }
        }
        return false;
    }

    public boolean isVisited(Node node) {
        if (this.visited.contains(node)) {
            return true;
        }
        return false;
    }

    public List<Node> serach(Node src, Node dst) {

        List<Node> result = new LinkedList<>();
        this.queue.addFirst(src);                            //añado a la cola el nodo origen
        result.add(queue.getFirst());                       //añado al resultado el nodo origen
        this.visited.add(src);                               //añado a la lista de visitados el nodo origen

        int aux = -1;                                   //variable auxiliar que voy a usar en el while

        while (!this.queue.isEmpty()) {                      //is the queue empty? if dont --> go ahead
            aux += 1;

            Node dnode = queue.pollFirst();             //dequeue the first element from de queue

            if (!this.isVisited(this.graph.getNodes().get(aux)) && this.isAdj(dnode, this.graph.getNodes().get(aux))) {
                this.queue.addFirst(this.graph.getNodes().get(aux));
                this.visited.add(this.graph.getNodes().get(aux));
                result.add(this.graph.getNodes().get(aux));
            }

        }

        return result;

    }

}

