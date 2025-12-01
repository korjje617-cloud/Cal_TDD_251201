package org.example;

public class Calc {

    /*
    ============== v1 ==============
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
    }
    ============== v2 ==============
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
    }
    ============== v3 ==============
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
    ============== v4 ==============
        public static int run(String exp) {

            exp = exp.replace("- ", "+ -");

            String[] bits = exp.split(" \\+ ");

            int answer = 0;

            for (int i = 0; i < bits.length; i++) {
                int a = Integer.parseInt(bits[i]);
                answer += a;

            }
            return answer;
        }
    }
    */

    public static int run(String exp) {

        exp = exp.replace("- ", "+ -");

        boolean needToPlus = exp.contains("+");
        boolean needToMulti = exp.contains("*");

        String[] bits = null;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
        } else if (needToMulti) {
            bits = exp.split(" \\* ");
        }

        int answer = 0;

        if (needToPlus){
            for (int i = 0; i < bits.length; i++) {
                int a = Integer.parseInt(bits[i]);
                answer += a;
            }
        } else if (needToMulti){

            answer = 1;
            for (int i = 0; i < bits.length; i++) {
                int a = Integer.parseInt(bits[i]);
                answer *= a;
            }
        }
        return answer;
    }
}

