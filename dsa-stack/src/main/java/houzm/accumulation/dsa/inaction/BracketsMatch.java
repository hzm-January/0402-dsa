package houzm.accumulation.dsa.inaction;

import houzm.accumulation.dsa.LinkedStackSentinel;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/2/15 9:51
 * Modified By:
 * Description：括弧匹配
 */
public class BracketsMatch {
    LinkedStackSentinel<Symbol> stack = new LinkedStackSentinel<>();

    public boolean check(String expression) {
        if (expression == null || expression.trim().length() < 1) {
            return true;
        }
        String[] expressionArray = expression.split("");
        for (int i = 0; i < expressionArray.length; i++) {
            String element = expressionArray[i];
            if (Symbol.isRight(element)) {
                if (stack.deep() == 0) {
                    return false;
                } else if (!stack.pop().right.equalsIgnoreCase(element)) {
                    return false;
                }
            } else if (Symbol.isLeft(element)) {
                stack.push(Symbol.getSymbolByLeft(element));
            }
        }
        if (stack.deep() != 0) {
            return false;
        }
        return true;
    }

    public enum Symbol {
        BRACKET("[", "]"),
        BRACE("{", "}"),
        PARENTHESIS("(", ")");
        private String left;
        private String right;

        Symbol(String left, String right) {
            this.left = left;
            this.right = right;
        }
        public static boolean isRight(String symbolRight) {
            for (Symbol symbol : Symbol.values()) {
                if (symbol.right.equalsIgnoreCase(symbolRight)) {
                    return true;
                }
            }
            return false;
        }
        public static boolean isLeft(String symbolLeft) {
            for (Symbol symbol : Symbol.values()) {
                if (symbol.left.equalsIgnoreCase(symbolLeft)) {
                    return true;
                }
            }
            return false;
        }
        public static Symbol getSymbolByRight(String symbolRight) {
            for (Symbol symbol : Symbol.values()) {
                if (symbol.right.equalsIgnoreCase(symbolRight)) {
                    return symbol;
                }
            }
            return null;
        }
        public static Symbol getSymbolByLeft(String symbolLeft) {
            for (Symbol symbol : Symbol.values()) {
                if (symbol.left.equalsIgnoreCase(symbolLeft)) {
                    return symbol;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
//        String expression = "(houzhiming){}[]";
//        String expression = "(houzhim{ing){}[]";
        String expression = "(houzhiming{}[]";
        BracketsMatch bm = new BracketsMatch();
        boolean check = bm.check(expression);
        System.out.println(check);
    }
}
