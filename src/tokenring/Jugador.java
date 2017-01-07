package tokenring;

import java.util.Scanner;

public class Jugador implements Runnable {

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

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(Interfaz interfaz) {
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

    public void darPataditas(int num) {
        this.balon.aumentarPataditas(num);
    }

    public void pasarTestimonio() {
        this.testimonio = false;
        this.siguiente.setTestimonio(true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (this.testimonio && this.balon.tomarBalon()) {
                    switch (this.getTurno()) {
                        case 1:
                                this.interfaz.getjTextField6().setEnabled(true);
                                this.interfaz.getjButton1().setEnabled(true);
                                while (true) {
                                    if (this.interfaz.flagBtn1) {
                                        if (!" ".equals(this.interfaz.getjTextField6().getText())) {
                                            this.interfaz.flagBtn1 = false;
                                            this.interfaz.getjTextField6().setEnabled(false);
                                            this.interfaz.getjButton1().setEnabled(false);
                                            if (!"0".equals(this.interfaz.getjTextField6().getText())) {
                                                this.darPataditas(Integer.parseInt(this.interfaz.getjTextField6().getText()));
                                                this.interfaz.getjTextField6().setText("");
                                                System.out.println("El balon ha dado hasta ahora " + this.balon.getPataditas() + " pataditas.");
                                            }
                                            this.balon.dejarBalon();
                                            this.pasarTestimonio();
                                            break;
                                        }else{
                                            System.out.println("");
                                        }
                                    }else{
                                        System.out.print("");
                                    }
                                }
                                break;
                            
                        case 2:
                                this.interfaz.getjTextField7().setEnabled(true);
                                this.interfaz.getjButton2().setEnabled(true);
                                while (true) {
                                    if (this.interfaz.flagBtn2) {
                                        if (!" ".equals(this.interfaz.getjTextField7().getText())) {
                                            this.interfaz.flagBtn2 = false;
                                            this.interfaz.getjTextField7().setEnabled(false);
                                            this.interfaz.getjButton2().setEnabled(false);
                                            if (!"0".equals(this.interfaz.getjTextField7().getText())) {
                                                this.darPataditas(Integer.parseInt(this.interfaz.getjTextField7().getText()));
                                                this.interfaz.getjTextField7().setText("");
                                                System.out.println("El balon ha dado hasta ahora " + this.balon.getPataditas() + " pataditas.");
                                            }
                                            this.balon.dejarBalon();
                                            this.pasarTestimonio();
                                            break;
                                        }else{
                                            System.out.print("");
                                        }
                                    }else{
                                        System.out.print("");
                                    }
                                }
                                break;
                                
                        case 3:
                                this.interfaz.getjTextField8().setEnabled(true);
                                this.interfaz.getjButton3().setEnabled(true);
                                while (true) {
                                    if (this.interfaz.flagBtn3) {
                                        if (!" ".equals(this.interfaz.getjTextField8().getText())) {
                                            this.interfaz.flagBtn3 = false;
                                            this.interfaz.getjTextField8().setEnabled(false);
                                            this.interfaz.getjButton3().setEnabled(false);
                                            if (!"0".equals(this.interfaz.getjTextField8().getText())) {
                                                this.darPataditas(Integer.parseInt(this.interfaz.getjTextField8().getText()));
                                                this.interfaz.getjTextField8().setText("");
                                                System.out.println("El balon ha dado hasta ahora " + this.balon.getPataditas() + " pataditas.");
                                            }
                                            this.balon.dejarBalon();
                                            this.pasarTestimonio();
                                            break;
                                        }else{
                                            System.out.print("");
                                        }
                                    }else{
                                        System.out.print("");
                                    }
                                }
                                break;

                        case 4:
                                this.interfaz.getjTextField9().setEnabled(true);
                                this.interfaz.getjButton4().setEnabled(true);
                                while (true) {
                                    if (this.interfaz.flagBtn4) {
                                        if (!" ".equals(this.interfaz.getjTextField9().getText())) {
                                            this.interfaz.flagBtn4 = false;
                                            this.interfaz.getjTextField9().setEnabled(false);
                                            this.interfaz.getjButton4().setEnabled(false);
                                            if (!"0".equals(this.interfaz.getjTextField9().getText())) {
                                                this.darPataditas(Integer.parseInt(this.interfaz.getjTextField9().getText()));
                                                this.interfaz.getjTextField9().setText("");
                                                System.out.println("El balon ha dado hasta ahora " + this.balon.getPataditas() + " pataditas.");
                                            }
                                            this.balon.dejarBalon();
                                            this.pasarTestimonio();
                                            break;
                                        }else{
                                            System.out.print("");
                                        }
                                    }else{
                                        System.out.print("");
                                    }
                                }
                                break;

                        case 5:
                                this.interfaz.getjTextField10().setEnabled(true);
                                this.interfaz.getjButton5().setEnabled(true);
                                while (true) {
                                    if (this.interfaz.flagBtn5) {
                                        if (!" ".equals(this.interfaz.getjTextField10().getText())) {
                                            this.interfaz.flagBtn5 = false;
                                            this.interfaz.getjTextField10().setEnabled(false);
                                            this.interfaz.getjButton5().setEnabled(false);
                                            if (!"0".equals(this.interfaz.getjTextField10().getText())) {
                                                this.darPataditas(Integer.parseInt(this.interfaz.getjTextField10().getText()));
                                                this.interfaz.getjTextField10().setText("");
                                                System.out.println("El balon ha dado hasta ahora " + this.balon.getPataditas() + " pataditas.");
                                            }
                                            this.balon.dejarBalon();
                                            this.pasarTestimonio();
                                            break;
                                        }else{
                                            System.out.print("");
                                        }
                                    }else{
                                        System.out.print("");
                                    }
                                }
                                break;
                    }
                    /*
                    System.out.print(this.getNombre() + ", ¿seguiras jugando?(1/0)");
                    if(true){
                        this.anterior.setSiguiente(this.siguiente);
                        this.siguiente.setAnterior(this.anterior);
                        break;
                    }
                     */
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
