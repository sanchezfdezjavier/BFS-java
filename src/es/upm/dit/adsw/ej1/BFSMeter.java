package es.upm.dit.adsw.ej1;

import java.lang.*;


public class BFSMeter {

    public BFSMeter(){
        //espcio para el constructor
    }

    private static long doit(Graph graph){
        BFS bfs= new BFS(graph);
        long t0= System.currentTimeMillis(); //aqui el tiempo empieza a contar
        bfs.serach(//falta por completar);
        //aqui es donde hay que hacer
        long t2= System.currentTimeMillis()
        return t2-t0;
    }
}
