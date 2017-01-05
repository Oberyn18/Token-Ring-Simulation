package tokenring;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TokenRing {

    private static final int NUM_JUGADORES = 3;    
    
    public static void main(String[] args) throws InterruptedException{        
        
        Escaner principal = new Escaner();
        
        // Tomamos el escáner
        principal.tomarEscaner();
        // -------------------------------
        
        Jugador[] jugadores = null;
        Balon pelota = new Balon();
        
        jugadores = new Jugador[NUM_JUGADORES];
        for(int i = 0; i < NUM_JUGADORES; i++){
            System.out.print("Ingrese nombre del jugador: ");
            String name = principal.getSc().next();
            jugadores[i] = new Jugador(name, i+1, pelota);
            jugadores[i].setSc(principal);
        }
        
        // Dejamos el Escáner
        principal.dejarEscaner();
        // ---------------------------
        
        // Este jugador empezará con el testimonio y con el escáner
           jugadores[0].setTestimonio(true);
           jugadores[0].recibeEscaner();
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
