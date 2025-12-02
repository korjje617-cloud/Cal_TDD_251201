package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    ============== v4 내 풀이 ==============
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

    ============== v5 내 풀이 ==============
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

============== v4 강사님 풀이  ==============
    public static int run(String exp) {
        System.out.println("exp1 : " + exp);

        exp = exp.replace("- ", "+ -");

        System.out.println("exp2 : " + exp);

        String[] bits = exp.split(" \\+ ");

        int sum = 0;
        for (int i = 0; i < bits.length; i++) {
            sum += Integer.parseInt(bits[i]);
        }
        return sum;
    }
}

============== v5 강사님 풀이  ==============
(마이너스 오류)
    public static int run(String exp) {

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+");


        exp = exp.replace("- ", "+ -");

        if (needToPlus) {
            String[] bits = exp.split(" \\+ ");
            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }

            return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }
        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }

============== v6 강사님 풀이  ==============
                재귀함수 이용
    public static int run(String exp) { // 10 + 5 * 2

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+");

        boolean needToCompound = needToPlus && needToMulti;

        exp = exp.replace("- ", "+ -");

        if (needToCompound) {
            String[] bits = exp.split(" \\+ ");

            return Integer.parseInt(bits[0]) + run(bits[1]);
        }

        if (needToPlus) {
            String[] bits = exp.split(" \\+ ");
            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }

            return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }


        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }
============== v7 내 풀이  ==============
    public static int run(String exp) {

        exp = exp.replace("- ", "+ -");

        boolean needToPlus = exp.contains("+");
        boolean needToMulti = exp.contains("*");

        boolean needToCompound = needToPlus && needToMulti;

        if (needToCompound) {
            String[] bits = exp.split(" \\+ ", 2);

            return Integer.parseInt(bits[0]) + run(bits[1]);
        }

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
============== v8 강사님 풀이  ==============
                마이너스 버그
    public static int run(String exp) {

        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+");

        boolean needToCompound = needToPlus && needToMulti;

        exp = exp.replace("- ", "+ -");

        if (needToCompound) {
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj(e -> e + "")
                    .collect(Collectors.joining(" + "));
//1
//            StringBuilder sb = new StringBuilder();
//
//            for (int i = 0; i < bits.length; i++) {
//                int result = Calc.run(bits[i]);
//                sb.append(result);
//
//                // 마지막 요소가 아니면 " + " 추가
//                if (i < bits.length - 1) {
//                    sb.append(" + ");
//                }
//            }
//
//            String newExp = sb.toString();

//2
//            String newExp = "";
//
//            for (int i = 0; i < bits.length; i++) {
//                int result = Calc.run(bits[i]);
//                newExp += result;
//
//                if (i < bits.length - 1) {
//                    newExp += " + ";
//                }
//            }

            return run(newExp);
        }

        if (needToPlus) {
            String[] bits = exp.split(" \\+ ");
            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }

            return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }
        return 0;
    }
}
     */

    public static int run(String exp) {
        exp = exp.replace("- ", "+ -");
        exp = exp.replace("(", "");
        exp = exp.replace(")", "");

        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }



        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+");

        boolean needToCompound = needToPlus && needToMulti;

        if (needToCompound) {
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj(e -> e + "")
                    .collect(Collectors.joining(" + "));

            return run(newExp);
        }

        if (needToPlus) {
            String[] bits = exp.split(" \\+ ");
            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }

            return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }
        return 0;
    }
}