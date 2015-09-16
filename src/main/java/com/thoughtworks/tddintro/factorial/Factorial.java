package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i<0){
            throw new IllegalArgumentException ("Number must be positive");
        }
        int factorial=1;
        for(int j=1;j<=i;j++) {
            factorial *= j;
        }
        return factorial;
    }
}
