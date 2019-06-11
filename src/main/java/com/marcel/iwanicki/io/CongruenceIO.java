package com.marcel.iwanicki.io;

import com.marcel.iwanicki.math.MathUtils;
import com.marcel.iwanicki.math.SimplifiedCongruence;
import com.marcel.iwanicki.math.UnsimplifiedCongruence;

import java.util.Scanner;

public class CongruenceIO {

    private static CongruenceIO instance = null;

    public static CongruenceIO getInstance() {
        if(instance == null)
            instance = new CongruenceIO();

        return instance;
    }

    private UnsimplifiedCongruence[] unsimplifiedCongruences;
    private SimplifiedCongruence[] simplifiedCongruences;
    private Scanner scanner;

    private CongruenceIO(){
        unsimplifiedCongruences = new UnsimplifiedCongruence[2];
        for(int i=0; i<unsimplifiedCongruences.length; i++)
            unsimplifiedCongruences[i] = new UnsimplifiedCongruence();

        simplifiedCongruences = new SimplifiedCongruence[2];
        for(int i=0; i<simplifiedCongruences.length; i++)
            simplifiedCongruences[i] = new SimplifiedCongruence();

        scanner = new Scanner(System.in);

    }

    public void readEquation(int which) {
        System.out.println("\n[ROWNANIE " + (which + 1) + "] Podaj a, b, c... [rownanie postaci ax = b(mod c)]");
        System.out.print("[A] >> ");
        unsimplifiedCongruences[which].setA(scanner.nextInt());
        System.out.print("[B] >> ");
        unsimplifiedCongruences[which].setB(scanner.nextInt());
        System.out.print("[C] >> ");
        unsimplifiedCongruences[which].setC(scanner.nextInt());

        simplifiedCongruences[which].setParameters(unsimplifiedCongruences[which]);
    }

    public void printUnsimplifiedCongruences() {

        System.out.println("\n=====UKLAD KONGRUENCJI=====");
        for(int i=0; i<unsimplifiedCongruences.length; i++) {
            UnsimplifiedCongruence tmp = unsimplifiedCongruences[i];

            System.out.println(tmp.getA() + "x = " + tmp.getB() + "(mod " + tmp.getC() + ")");
        }
        System.out.println("=========================\n");
    }

    public void printSolution() {
        System.out.println("\nRozwiazanie: " + MathUtils.solveCongruences(simplifiedCongruences) + "(mod " + (simplifiedCongruences[0].getC() * simplifiedCongruences[1].getC()) + ")");
    }
}
