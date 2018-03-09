package es.upm.dit.adsw.ej2;

import java.util.*;

public class Graph {

    private Map<String, Node> nodeMap;
    private Map<Node, List<Link>> linkMap;



    public Graph(){
        this.linkMap= new HashMap<>();
        this.nodeMap= new HashMap<>();
    }

    public void addNode(Node node){
        this.nodeMap.put(node.getName(), node);
    }

    public void addLink(Link link){
        Node src= this.nodeMap.get(link.getSrc());
        if(src!= null ){
            List<Link> linkList= this.linkMap.get(src);
            if(linkList==null){
                linkList= new ArrayList<>();
                this.linkMap.put(src, linkList);
            }
            linkList.add(link);
        }
    }

    public void addLink2D(String name1, String name2, int num){
        Link link1= new Link(name1, name2, num);
        Link link2= new Link(name2, name1, num);

        this.addLink(link1);
        this.addLink(link2);
    }

    public Node getNode(String nodeName){
        return this.nodeMap.get(nodeName);
    }

    public List<Node> getNodes(){
        return new ArrayList<>(this.nodeMap.values());
    }

    public List<Link> getLinks(){
        List<Link> resultado= new ArrayList<>();
        for (List<Link> linkList: this.linkMap.values()){
            resultado.addAll(linkList);
        }
        return resultado;
    }

    public Link getLink(Node src, Node dst) {
        for(Link l: this.linkMap.get(src)){
            if(l.getSrc().equals(src.getName())&&
                    l.getDst().equals(dst.getName())){
                return l;
            }
        }
        return null;
    }

    //revisar este metodo seguramente mal
    public List<Link> getLinks(Node node){
        List<Link> resultado= this.linkMap.get(node);
        return resultado!= null ? resultado : new ArrayList<>();
    }
//no es necesario para esta practica y creo que tampoco lo es para el BFS
//    public int getWeight(LinkedList<Node> path) {
//
//        int resultado = 0;
//        for (int i = 0; i < path.size()-1; i++) {
//            if(this.getLink(path.get(i), path.get(i+1)).equals(null)){
//                return -1;
//            }
//            Node src= path.get(i);
//            Node dst= path.get(i+1);
//            Link edge= this.getLink(src, dst);
//            int weight= edge.getWeight();
//
//            resultado+= weight;
//        }
//        return resultado;
//    }
}