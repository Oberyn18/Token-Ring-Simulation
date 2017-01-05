package tokenring;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Balon {
    private int pataditas;
    Lock up = new ReentrantLock();

    public Balon() {
        this.pataditas = 0;
    }

    public int getPataditas() {
        return pataditas;
    }

    public void setPataditas(int pataditas) {
        this.pataditas = pataditas;
    }
    
    public void aumentarPataditas(){
        pataditas++;
    }
    
    public boolean tomarBalon(){
        if(up.tryLock()) return true;
        else return false;
    }
    
    public void dejarBalon(){
        up.unlock();
    }
}
