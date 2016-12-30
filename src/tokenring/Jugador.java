package tokenring;

public class Jugador {
    private String nombre;
    private int turno;
    private Boolean testimonio;
    private Jugador siguiente;
    private Jugador anterior;
    private Balon balon;  

    public Jugador(String nombre, int turno, Balon balon) {
        this.nombre = nombre;
        this.turno = turno;
        this.balon = balon;
        testimonio = false;
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

    public Jugador getAnterior() {
        return anterior;
    }

    public void setAnterior(Jugador anterior) {
        this.anterior = anterior;
    }

    public Balon getBalon() {
        return balon;
    }

    public void setBalon(Balon balon) {
        this.balon = balon;
    }
       
    public void darPataditas(){
        if(this.testimonio == true && this.balon.tomarBalon()){
            
        }
    }
    
    public void recibirTestimonio(){
       
    }
    
    public void  pasarTestimonio(){
        
    }
}
