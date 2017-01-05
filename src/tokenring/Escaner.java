package tokenring;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Escaner {
    private Scanner sc = new Scanner(System.in);
    Lock up = new ReentrantLock();

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
    public boolean tomarEscaner(){
        if(up.tryLock()) return true;
        else return false;
    }
    
    public void dejarEscaner(){
        up.unlock();
    }
}
