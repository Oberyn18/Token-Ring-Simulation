package tokenring;

import java.util.Scanner;


public class TokenRing {

    private static final int NUM_JUGADORES = 5;
    public static void main(String[] args) throws InterruptedException{        
        Scanner sc = new Scanner(System.in);
        
        Jugador[] jugadores = null;
        Balon pelota = new Balon();
        
        jugadores = new Jugador[NUM_JUGADORES];
        for(int i = 0; i < NUM_JUGADORES; i++){
            System.out.print("Ingrese nombre del jugador: ");
            String name = sc.next();
            jugadores[i] = new Jugador(name, i+1, pelota);
        }
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
    }
}
