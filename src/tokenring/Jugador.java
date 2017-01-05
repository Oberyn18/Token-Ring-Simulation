package tokenring;

import java.util.Scanner;

public class Jugador implements Runnable{
    private String nombre;
    private int turno;
    volatile private Boolean testimonio;
    private Jugador siguiente;
    private Jugador anterior;
    private Balon balon;
    private Interfaz interfaz;
    
    public Jugador(String nombre, int turno, Balon balon, Interfaz interfaz) {
        this.nombre = nombre;
        this.turno = turno;
        this.balon = balon;
        this.interfaz = interfaz;
        testimonio = false;
    }
    
    
    public Interfaz getInterfaz(){
        return interfaz;
    }
    
    public void setInterfaz(Interfaz interfaz){
        this.interfaz = interfaz;
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
        System.out.println(this.getNombre() + ", deseas recibir el testimonio (1/0)");
        int rpta = sc.nextInt();
        if(rpta == 1)   this.testimonio = true;
        else
            this.pasarTestimonio();
    }
    
    public void  pasarTestimonio(){
        this.testimonio = false;
        System.out.println("Yo, "+this.getNombre()+ ", estoy pasando el testimonio a "+ this.getSiguiente().getNombre());
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
                    System.out.print(this.getNombre() + ", ¿seguiras jugando?(1/0)");
                    if(sc.nextInt() == 0){
                        this.anterior.setSiguiente(this.siguiente);
                        this.siguiente.setAnterior(this.anterior);
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
