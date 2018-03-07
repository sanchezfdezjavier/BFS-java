package es.upm.dit.adsw.ej2;

import sun.jvm.hotspot.debugger.RandomAccessFileDataSource;

import java.util.*;

public class BFSMeter {

    public static void main(String []args){
        for (int n = 1_000; n < 100_000; n+= 5_000) {
            Graph graph = new Graph();
            load(graph, n);
            long t = doit(graph);
            System.out.printf("%s %d%n", n, t);
        }
    }

    private static long doit(Graph graph) {
        BFS bfs = new BFS(graph);
        long t0 = System.currentTimeMillis();
        bfs.search(graph.getNode(""), graph.getNode(("")));
        long t2 = System.currentTimeMillis();
        return t2 - t0;
    }

    private static void load(Graph g, int n){
        int beginNum= g.getNodes().size();

        for (int i = 0; i <n ; i++) {
            String nodeName=""+i + beginNum;
            new Node(nodeName,0,0);
            Random rnd= new Random();

            for (int j = 0; j <5 ; j++) {
               g.addLink(new Link(nodeName, ""+ rnd.nextInt(beginNum+i+1), Math.abs(rnd.nextInt())));
            }
        }
    }
}



