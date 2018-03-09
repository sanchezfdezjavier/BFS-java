package es.upm.dit.adsw.ej2;

/*
@author Javier Sánchez Fernández
@version 7-2-2018
Fuente del codigo https://stackoverflow.com
 */

import java.util.*;

public class BFSMeter {
    public static void load(Graph graph, int n){

        Random rnd = new Random(System.currentTimeMillis());
        int intRnd;
        int d;

        for(int i=0; i<=n;i++){

            intRnd = rnd.nextInt(500);
            d = rnd.nextInt(500);
            String name = "" + i;
            graph.addNode(new Node(name, d, intRnd));
        }


        for (int x= 0; x<=n;x++){
            for (int i = 0; i <8 ; i++) {
                intRnd = rnd.nextInt(n+1);
                graph.addLink(new Link(graph.getNodes().get(x).getName(), graph.getNodes().get(intRnd).getName(), 3));
            }
        }
    }
    private static long doit(Graph graph){
        BFS bfs = new BFS(graph);
        long t0 = System.currentTimeMillis();
        bfs.search(graph.getNode("9"), graph.getNode("100"));
        long t2 = System.currentTimeMillis();
        return t2 - t0;
    }
    public static void main(String []args) throws Exception{
        for (int n = 1000; n < 100000; n+= 3000) {
            Graph graph = new Graph();
            load(graph, n);
            long t = doit(graph);
            System.out.printf("%s %d%n", n, t);
        }
    }
}