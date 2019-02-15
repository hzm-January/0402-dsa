package houzm.accumulation.dsa.inaction;

import houzm.accumulation.dsa.LinkedStackSentinel;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/2/14 19:49
 * Modified By:
 * Description：表达式计算
 * 两个栈：1个保存数字，1个保存操作符
 */
public class ExpressionCalculation {

    LinkedStackSentinel<Integer> stackOperands = new LinkedStackSentinel<>();
    LinkedStackSentinel<Operator> stackOperator = new LinkedStackSentinel<>();

    public int calculation(String expression) {
        if (expression == null || expression.trim().length() < 1) {
            return 0;
        }
        if (expression.trim().length() == 1) {
            if (Character.isDigit(expression.charAt(0))) {
                return expression.charAt(0);
            } else {
                return 0;
            }
        }
        for (int i = 0; i < expression.length(); i++) {
            char value = expression.charAt(i);
            if (Character.isDigit(value)) {
                stackOperands.push(Integer.valueOf(String.valueOf(value)));
            } else if (Operator.isOperator(String.valueOf(value))) {
                Operator nextPushOperator = Operator.getOperator(String.valueOf(value));
                if (stackOperator.deep() < 1) {
                    // 第一次放入操作符栈
                    stackOperator.push(nextPushOperator);
                } else {
                    Operator lastOperatorInStack = stackOperator.pop();
                    if (nextPushOperator.level <= lastOperatorInStack.level) {
                        // 即将插入的运算符优先级比栈中最上面的运算符低或者相同，弹出两个数字进行计算
                        Integer operansRight = stackOperands.pop();
                        Integer operansLeft = stackOperands.pop();
                        // 计算并压栈
                        stackOperands.push(Operator.operator(lastOperatorInStack, operansRight, operansLeft));
                        i--;
                    } else {
                        stackOperator.push(lastOperatorInStack); //取出的运算符重新压栈
                        stackOperator.push(nextPushOperator);
                    }
                }
            } else {
                System.err.println("expressions contain illegal characters");
                return 0;
            }
        }
        while (stackOperator.deep() > 0) {
            int calcResult = Operator.operator(stackOperator.pop(), stackOperands.pop(), stackOperands.pop());
            stackOperands.push(calcResult);
        }
        return stackOperands.pop();
    }


    public enum Operator {
        PLUS("+", 1),
        MINUS("-", 1),
        MULTIPLY("*", 2),
        DIVIDE("/", 2);
        private String operator;
        private int level;

        Operator(String operator, int level) {
            this.operator = operator;
            this.level = level;
        }

        public static boolean isOperator(String symbol) {
            for (Operator operator : Operator.values()) {
                if (operator.operator.equalsIgnoreCase(symbol)) {
                    return true;
                }
            }
            return false;
        }

        public static Operator getOperator(String symbol) {
            for (Operator operator : Operator.values()) {
                if (operator.operator.equalsIgnoreCase(symbol)) {
                    return operator;
                }
            }
            return null;
        }

        public static int operator(Operator operator, Integer right, Integer left) {
            switch (operator) {
                case PLUS:
                    return left + right;
                case MINUS:
                    return left - right;
                case MULTIPLY:
                    return left * right;
                case DIVIDE:
                    return left / right;
                default:
                    System.err.println("expressions contain illegal operators");
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
//        String expression = "1+2+3-0+2*6/3";
        String expression = "2*3+1+2+3-0+2*6/3";
//        String expression = "1+2+3-0+2*6/3+2";
        ExpressionCalculation ec = new ExpressionCalculation();
        int result = ec.calculation(expression);
        System.out.println(result);

//        System.out.println(Integer.valueOf(String.valueOf(expression.charAt(0))));
//        System.out.println(String.valueOf(expression.charAt(1)));
    }

}
