package org.example;

public class Calc {

/*
    public static int run(String exp) {

        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");

        String[] bits = null;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
        } else if (needToMinus) {
            bits = exp.split(" - ");
        }

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);

        if (needToPlus) {
            return a + b;
        } else if (needToMinus) {
            return a - b;
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }

    public static int run(String exp) {

        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");

        String[] bits = null;

        for (int i = 0; i < exp.length(); i++) {

            if (needToPlus) {
                bits = exp.split(" \\+ ");
            } else if (needToMinus) {
                bits = exp.split(" - ");
            }

            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            int c = 0;

            if (bits.length > 2) {
                c = Integer.parseInt(bits[2]);
            }


            for (int j = 0; j < exp.length(); j++) {
                if (needToPlus) {
                    return a + b + c;
                } else if (needToMinus) {
                    return a - b;
                }

                a = Integer.parseInt(bits[i + 1]);
                b = Integer.parseInt(bits[i + 2]);

            }
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }
*/

    public static int run(String exp) {
        System.out.println("exp1 : " + exp);

        exp = exp.replace("- ", "+ -");

        System.out.println("exp2 : " + exp);

        String[] bits = exp.split(" \\+ ");

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);
        int c = 0;

        if (bits.length > 2) {
            c = Integer.parseInt(bits[2]);
        }

        return a + b + c;


//        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }


}