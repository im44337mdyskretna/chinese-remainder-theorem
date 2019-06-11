package com.marcel.iwanicki.math;

import java.util.ArrayList;
import java.util.List;

public class MathUtils {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    public static int moduloPowerMinusOne(int a, int c) {

        List<Integer> Z = new ArrayList<Integer>();
        for (int i = 0; i < c; i++)
            Z.add(i);

        for (int i = 0; i < Z.size(); i++)
            if (Z.get(i) * a % c == 1)
                return Z.get(i);

        return 0;
    }

    public static int solveCongruences(List<SimplifiedCongruence> simplifiedCongruences) {
        int[] N = new int[simplifiedCongruences.size()];
        int[] M = new int[simplifiedCongruences.size()];


        //sprawdz warunek
        for (int i = 0; i < simplifiedCongruences.size(); i++) {
            for (int j = 0; j < simplifiedCongruences.size(); j++) {
                if(i == j) continue;

                if (gcd(simplifiedCongruences.get(i).getC(), simplifiedCongruences.get(j).getC()) != 1) {
                    System.out.println("NWD(C1, C2, ...) != 1, Nie mozna rozwiazac ukladu, zalozenie CToR nie spelnione!");
                    System.exit(-1);
                }
            }
        }

        //oblicz n
        int n = 1;
        for(int i=0; i<simplifiedCongruences.size(); i++)
            n *= simplifiedCongruences.get(i).getC();

        //oblicz N i M
        for(int i=0; i<simplifiedCongruences.size(); i++) {
            N[i] = n / simplifiedCongruences.get(i).getC();
            M[i] = moduloPowerMinusOne(N[i], simplifiedCongruences.get(i).getC());
        }

        //oblicz x
        int result = 0;
        for(int i=0; i<simplifiedCongruences.size(); i++) {
            result += (simplifiedCongruences.get(i).getAlpha() * simplifiedCongruences.get(simplifiedCongruences.size() - 1 - i).getC() * M[i]);
        }

        System.out.println("\nRozwiazano uklad kongruencji: ");
        for(int i=0; i<simplifiedCongruences.size(); i++) {
            System.out.println("N_" + i + " = " + N[i]);
            System.out.println("M_" + i + " = " + M[i]);
        }

        return result % n;

    }
}
