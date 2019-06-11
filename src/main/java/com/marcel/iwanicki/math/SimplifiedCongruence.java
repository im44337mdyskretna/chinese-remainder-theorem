package com.marcel.iwanicki.math;

public class SimplifiedCongruence {
    private int alpha;
    private int c;

    public SimplifiedCongruence() { }

    public void setParameters(UnsimplifiedCongruence unsimplifiedCongruence) {
        this.c = unsimplifiedCongruence.getC();

        if(MathUtils.gcd(unsimplifiedCongruence.getA(), c) != 1) {
            System.out.println("NWD(a, c) != 1, KONCZE WYKONYWANIE PROGRAMU!");
            System.exit(-1);
        }

        alpha = (MathUtils.moduloPowerMinusOne(unsimplifiedCongruence.getA(), c) * unsimplifiedCongruence.getB()) % c;
    }

    public int getAlpha() {
        return alpha;
    }

    public int getC() {
        return c;
    }
}
