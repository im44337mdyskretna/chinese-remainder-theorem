package com.marcel.iwanicki.io;

import com.marcel.iwanicki.math.MathUtils;
import com.marcel.iwanicki.math.SimplifiedCongruence;
import com.marcel.iwanicki.math.UnsimplifiedCongruence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CongruenceIO {

    private static CongruenceIO instance = null;

    public static CongruenceIO getInstance() {
        if(instance == null)
            instance = new CongruenceIO();

        return instance;
    }

    private int count = 0;
    private List<UnsimplifiedCongruence> unsimplifiedCongruences;
    private List<SimplifiedCongruence> simplifiedCongruences;
    private Scanner scanner;

    private CongruenceIO(){
        scanner = new Scanner(System.in);
        System.out.print("Podaj ilosc kongruencji: ");
        count = scanner.nextInt();

        unsimplifiedCongruences = new ArrayList<UnsimplifiedCongruence>();
        for(int i=0; i<count; i++)
            unsimplifiedCongruences.add(new UnsimplifiedCongruence());

        simplifiedCongruences = new ArrayList<SimplifiedCongruence>();
        for(int i=0; i<count; i++)
            simplifiedCongruences.add(new SimplifiedCongruence());

    }

    public void readEquation(int which) {
        System.out.println("\n[ROWNANIE " + (which + 1) + "] Podaj a, b, c... [rownanie postaci ax = b(mod c)]");
        System.out.print("[A] >> ");
        unsimplifiedCongruences.get(which).setA(scanner.nextInt());
        System.out.print("[B] >> ");
        unsimplifiedCongruences.get(which).setB(scanner.nextInt());
        System.out.print("[C] >> ");
        unsimplifiedCongruences.get(which).setC(scanner.nextInt());

        simplifiedCongruences.get(which).setParameters(unsimplifiedCongruences.get(which));
    }

    public void printUnsimplifiedCongruences() {

        System.out.println("\n=====UKLAD KONGRUENCJI=====");
        for(int i=0; i<unsimplifiedCongruences.size(); i++) {
            UnsimplifiedCongruence tmp = unsimplifiedCongruences.get(i);

            System.out.println(tmp.getA() + "x = " + tmp.getB() + "(mod " + tmp.getC() + ")");
        }
        System.out.println("=========================\n");
    }

    public void printSolution() {
        System.out.println("\nRozwiazanie: x = " + MathUtils.solveCongruences(simplifiedCongruences) + "(mod " + (simplifiedCongruences.get(0).getC() * simplifiedCongruences.get(1).getC()) + ")");
    }
}
