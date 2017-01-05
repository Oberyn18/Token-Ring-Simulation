package tokenring;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TokenRing {

    private static final int NUM_JUGADORES = 5;
    public static void main(String[] args) throws InterruptedException{        
                
        Jugador[] jugadores = null;
        Balon pelota = new Balon();
        
        Interfaz grafico = new Interfaz();
        
        
        jugadores = new Jugador[NUM_JUGADORES];
        
        // A la espera de que el botón sea pulsado
        while(true){
            // Botón pulsado, ahora salimos
            if(grafico.getjButton6().isSelected()){
                jugadores[0] = new Jugador(grafico.getjTextField1().getText(), 1, pelota, grafico);
                jugadores[1] = new Jugador(grafico.getjTextField2().getText(), 2, pelota, grafico);
                jugadores[2] = new Jugador(grafico.getjTextField3().getText(), 3, pelota, grafico);
                jugadores[3] = new Jugador(grafico.getjTextField4().getText(), 4, pelota, grafico);
                jugadores[4] = new Jugador(grafico.getjTextField5().getText(), 5, pelota, grafico);
                // Desactiva el botón
                grafico.getjButton6().setEnabled(false);
                break;
            }
        }
        // ------------------------------------------------------
        
        // Este jugador empezará con el testimonio
           jugadores[0].setTestimonio(true);
        // --------------------------------------------
         
        // Formamos el anillo
        for(int i = 0; i < NUM_JUGADORES-1; i++){
            jugadores[i].setSiguiente(jugadores[i+1]);
            jugadores[i+1].setAnterior(jugadores[i]);
        }
        jugadores[NUM_JUGADORES-1].setSiguiente(jugadores[0]);
        jugadores[0].setAnterior(jugadores[NUM_JUGADORES-1]);
        
        //---------------------------------------------
        
        // PROBARÉ SI ESTAMOS CREANDO UN TOKEN RING
        for(int i = 0; i < NUM_JUGADORES; i++){
            System.out.println(jugadores[i].getNombre()+":");
            System.out.println("\tSiguiente: " + jugadores[i].getSiguiente().getNombre());
            System.out.println("\tAnterior: " + jugadores[i].getAnterior().getNombre());
            System.out.println("\tTestimonio: "+ jugadores[i].getTestimonio());
            System.out.println("");
            System.out.println("");
        }
        // ----------------------------------------------
        
        ExecutorService threadPool = Executors.newFixedThreadPool(NUM_JUGADORES);
        try{
            for(int i = 0; i < NUM_JUGADORES; i++){
                threadPool.execute(jugadores[i]);
            }
            Thread.sleep(10000);
        }finally{
            // Acabamos todos los hilos.
            threadPool.shutdown();

            // Esperamos a que todos los hilos hayan acabado
            while (!threadPool.isTerminated()) {
                Thread.sleep(1000);
            }
            System.out.println("El balon dio " + pelota.getPataditas() + " pataditas.");
        }
    }
}
