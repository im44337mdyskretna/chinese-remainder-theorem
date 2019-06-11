package com.marcel.iwanicki;

import com.marcel.iwanicki.io.CongruenceIO;

public class Main {

    public static void main(String[] args) {

        CongruenceIO congruenceIO = CongruenceIO.getInstance();
        for(int i=0; i<congruenceIO.getCount(); i++)
            congruenceIO.readEquation(i);

        congruenceIO.printUnsimplifiedCongruences();
        congruenceIO.printSolution();
    }
}
