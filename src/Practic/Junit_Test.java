package Practic;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Junit_Test {
    @Test
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 4;
        int b = -2;
        int result;
        result = calculator.sum(a,b);
        Assert.assertEquals(2,result);
        result = calculator.subtraction(a,b);
        Assert.assertEquals(6,result);
        result = calculator.multiplication(a,b);
        Assert.assertEquals(-8,result);
        result = calculator.division(a,b);
        Assert.assertEquals(-2,result);
    }
}
