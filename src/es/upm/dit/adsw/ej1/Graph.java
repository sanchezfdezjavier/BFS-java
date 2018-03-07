package es.upm.dit.adsw.ej2;

import java.util.ArrayList;
import java.util.List;

public class Graph{

    private List<Node> nodes;
    private List<Link> links;

    public Graph(){
        this.nodes= new ArrayList<>();
        this.links= new ArrayList<>();
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public List<Link> getLinks(){
        return this.links;
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }

    public void addLink(Link link){
        this.links.add(link);
    }

    public void addLink2D(String name1, String name2, int w){
        Link link1= new Link(name1, name2, w);
        Link link2= new Link(name2, name1, 2);
        this.links.add(link1);
        this.links.add(link2);
    }

    public Node getNode(String name){
        for(Node node: this.nodes){
            if(node.getName().equals(name)){
                return node;
            }
        }
        return null;
    }

    public Link getLink(Node src, Node dst){
        for(Link link: this.links){
            if(link.getSrc().equals(src.getName())&&
                    link.getDst().equals(dst.getName())){
                return link;
            }
        }
        return null;
    }

    public List<Link> getLinks(Node node){
        List<Link> nodeLinks= new ArrayList<>();
        for(Link link: this.links){
            if(link.getSrc().equals(node.getName())){
                nodeLinks.add(link);
            }
        }
        return nodeLinks;
    }

    public int getWeight(List<Node> path){
        int totalSum=0;
        for (int i = 1; i <path.size() ; i++) {
            Node start=path.get(i-1);
            Node finish=path.get(i);
            Link link= this.getLink(start, finish);

            if(link.equals(null)){
                return -1;
            }else{
                totalSum+= link.getWeight();
            }
        }
        return totalSum;
    }
}