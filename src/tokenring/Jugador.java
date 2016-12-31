package tokenring;

import java.util.Scanner;

public class Jugador implements Runnable{
    private String nombre;
    private int turno;
    private Boolean testimonio;
    private Jugador siguiente;
    private Jugador anterior;
    private Balon balon;
    Scanner sc = new Scanner(System.in);
    public Jugador(String nombre, int turno, Balon balon) {
        this.nombre = nombre;
        this.turno = turno;
        this.balon = balon;
        testimonio = false;
    }
    public Jugador getAnterior() {
        return anterior;
    }

    public void setAnterior(Jugador anterior) {
        this.anterior = anterior;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Boolean getTestimonio() {
        return testimonio;
    }

    public void setTestimonio(Boolean testimonio) {
        this.testimonio = testimonio;
    }

    public Jugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Jugador siguiente) {
        this.siguiente = siguiente;
    }
     
    public void darPataditas(){
        this.balon.aumentarPataditas();        
    }
    
    public void recibirTestimonio(){
        System.out.println("Deseas recibir el testimonio (1/0)");
        int rpta = sc.nextInt();
        if(rpta == 1)   this.testimonio = true;
        else
            this.pasarTestimonio();
    }
    
    public void  pasarTestimonio(){
        this.testimonio = false;
        this.siguiente.recibirTestimonio();
    }
    
    @Override
    public void run(){
        try{
            while(true){
                if(this.testimonio && this.balon.tomarBalon()){
                    this.darPataditas();
                    this.balon.dejarBalon();
                    this.pasarTestimonio();
                    System.out.print("¿Seguiras jugando?(1/0)");
                    if(sc.nextInt() == 0){
                        this.anterior.setSiguiente(this.siguiente);
                        break;
                    }
                }
            }   
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
