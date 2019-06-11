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
        for(int i=0; i<c; i++)
            Z.add(i);

        for(int i=0; i<Z.size(); i++)
            if(Z.get(i) * a % c == 1)
                return Z.get(i);

        return 0;
    }

    public static int solveCongruences(SimplifiedCongruence[] simplifiedCongruences) {

        int alpha1 = simplifiedCongruences[0].getAlpha();
        int alpha2 = simplifiedCongruences[1].getAlpha();

        int c1 = simplifiedCongruences[0].getC();
        int c2 = simplifiedCongruences[1].getC();

        //Sprawdz zalozenie
        if(gcd(c1, c2) != 1) {
            System.out.println("NWD(C1, C2) != 1, Nie mozna rozwiazac ukladu, zalozenie CToR nie spelnione!");
            System.exit(-1);
        }

        int n = c1 * c2;
        int N1 = n/c1;
        int N2 = n/c2;

        int M1 = moduloPowerMinusOne(N1, c1);
        int M2 = moduloPowerMinusOne(N2, c2);

        return (alpha1 * c2 * M1 + alpha2 * c1 * M2) % n;
    }

}
