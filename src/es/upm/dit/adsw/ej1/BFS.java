package es.upm.dit.adsw.ej2;

/*
@author Javier Sánchez Fernández
@version 7-3-2017
codigo modificado de https://stackoverflow.com
 */
//REVISAR 'getUnvisitedChild'.
import java.util.*;

public class BFS {

    private Graph graph;

    public BFS(Graph graph){
        this.graph= graph;
    }

    public List<Node> search(Node src, Node dst){

        Queue<Node> queue= new LinkedList<>();
        Set<Node> visited= new HashSet<>();
        Map<Node, Node> predecessors= new HashMap<>();
        List<Node> shortestPath= new ArrayList<>();
        boolean found= false;
        queue.add(src);

        while(!queue.isEmpty()){
            Node nextNode= queue.peek();
            found= nextNode.getName().equals(dst.getName());

            if(found){
                break;
            }
            visited.add(nextNode);
            Node child= this.getUnvisitedChild(nextNode, visited);  //fallo
            if(child== null){
                queue.poll();
            }else{
                queue.add(child);
                visited.add(child);
                predecessors.put(child, nextNode);
                found= child.getName().equals(dst.getName());
                if(found){
                    break;
                }

            }
        }
        if(found){
            Node node= dst;
            while(node!=null){
                shortestPath.add(node);
                node= predecessors.get(node);
            }
            Collections.reverse(shortestPath);
        }
        return shortestPath;
    }

    private Node getUnvisitedChild(Node node, Set<Node> visited){
        List<Link> chilLinks= this.graph.getLinks(node);
        for(Link link: chilLinks){
            Node child= this.graph.getNode(link.getDst());
            if(child!=null && !visited.contains(child)){
                return child;
            }
        }
        return null;
    }

}
