package com.marcel.iwanicki;

import com.marcel.iwanicki.io.CongruenceIO;

public class Main {

    public static void main(String[] args) {

        CongruenceIO congruenceIO = CongruenceIO.getInstance();
        congruenceIO.readEquation(0);
        congruenceIO.readEquation(1);

        congruenceIO.printUnsimplifiedCongruences();
        congruenceIO.printSolution();
    }
}
