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

============== v9 강사님 풀이  ==============
                뺴기 오류 수정
    public static int run(String exp) {

        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");

        boolean needToCompound = needToPlus && needToMulti;

        exp = exp.replace("- ", "+ -");

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


        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }


}

============== v8 내 풀이  ==============
마이너스 해결 + 괄호 제거
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

============== v9 강사님 풀이  ==============

    public static int run(String exp) {
        // 괄호 제거
        exp = stripOuterBrakets(exp);

        // 숫자만 들어올 경우 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");

        boolean needToCompound = needToPlus && needToMulti;

        exp = exp.replace("- ", "+ -");

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
        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }

    private static String stripOuterBrakets(String exp) {
        if (exp.charAt(0) == '(' && exp.charAt(exp.length() - 1) == ')') {
            exp = exp.substring(1, exp.length() - 1);
        }
        // exp 의 양쪽 끝의 괄호를 제거
        return exp;
    }

}

============== v10 내 풀이  ==============
    이중+삼중 괄호제거
    public static int run(String exp) {
        // 괄호 제거
        exp = stripOuterBrakets(exp);

        // 숫자만 들어올 경우 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");

        boolean needToCompound = needToPlus && needToMulti;

        exp = exp.replace("- ", "+ -");

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
        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }

    private static String stripOuterBrakets(String exp) {
        // 괄호 세개까지 무식하게 정리
        if (exp.contains("(((")) {
                exp = exp.substring(3, exp.length() - 3);
        } else if (exp.contains("((")) {
            exp = exp.substring(2, exp.length() - 2);
        } else if (exp.charAt(0) == '(' && exp.charAt(exp.length() - 1) == ')') {
            exp = exp.substring(1, exp.length() - 1);
        }
        return exp;
    }
}

============== v10 강사님 풀이  ==============
    이중+삼중 괄호제거

    public static int run(String exp) {
        // 괄호 제거
        exp = stripOuterBrakets(exp);

        // 숫자만 들어올 경우 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");

        boolean needToCompound = needToPlus && needToMulti;

        exp = exp.replace("- ", "+ -");

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
        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }

    private static String stripOuterBrakets(String exp) {

        int outerBracketsCount = 0;

        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }

        if (outerBracketsCount == 0) return exp;

        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }
}
     */

    public static int run(String exp) {

        // 괄호 제거
        exp = stripOuterBrackets(exp);

        // 그냥 숫자만 들어올 경우 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");
        boolean needToSplit = exp.contains("(") || exp.contains(")");
        boolean needToCompound = needToPlus && needToMulti;

        exp = exp.replace("- ", "+ -");

        if (needToSplit) {
            int bracketsCount = 0;
            int splitPointIndex = -1;

            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(') {
                    bracketsCount++;
                } else if (exp.charAt(i) == ')') {
                    bracketsCount--;
                }
                if (bracketsCount == 0) {
                    splitPointIndex = i;
                    break;
                }
            }
            String firstExp = exp.substring(0, splitPointIndex + 1);
            String secondExp = exp.substring(splitPointIndex + 4);

            return Calc.run(firstExp) + Calc.run(secondExp);

        } else if (needToCompound) {
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


        throw new RuntimeException("해석 불가 : 올바른 계산식이 아님");
    }

    private static String stripOuterBrackets(String exp) {

        int outerBracketsCount = 0;

        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }

        if (outerBracketsCount == 0) return exp;

        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }

}