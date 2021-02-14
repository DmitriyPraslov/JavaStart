package Practic;

public class CalculatorOperation {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int a = 4;
        int b = -2;
        System.out.println(calc.sum(a,b));
        System.out.println(calc.subtraction(a,b));
        System.out.println(calc.multiplication(a,b));
        try {
            System.out.println(calc.division(a,b));
        } catch (ArithmeticException e) {
            System.out.println("Нельзя делить на ноль!");
        }

    }
}

class Calculator {
    int sum(int a, int b) {
        int result;
        result = a + b;
        return result;
    }

    int subtraction(int a, int b) {
        int result;
        result = a + (-b);
        return result;
    }

    int multiplication(int a, int b) {
        int result = 0;
        for (int i = 1; i <= Math.abs(b); i++) {
            result += Math.abs(a);
        }
        return (a > 0 && b > 0) || (a < 0 && b < 0) ? result : -result;
    }

    int division(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        int result = 0;
        for (int i = Math.abs(b); i <= Math.abs(a); i += Math.abs(b)) {
            result++;
        }
        return (a > 0 && b > 0) || (a < 0 && b < 0) ? result : -result;
    }
}