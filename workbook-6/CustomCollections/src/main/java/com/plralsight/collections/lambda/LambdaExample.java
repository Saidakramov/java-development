package com.plralsight.collections.lambda;

public class LambdaExample implements NumericOperator{
    private int one;
    private int two;

    public LambdaExample(int one, int two) {
        this.one = one;
        this.two = two;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public static void main(String[] args) {

        //lambda addition
        NumericOperator addition = (one, two) -> one + two;
        int result = addition.operate(7,8);
        System.out.println(result);

        //lambda finMax
        NumericOperator findMax = (one, two) -> Math.max(one, two);
        System.out.println(findMax.operate(5,10));

        //StringFormatter
        StringFormatter toUpper = (s) -> s.toUpperCase();
        System.out.println(toUpper.format("hello world!"));
    }

    @Override
    public int operate(int one, int two) {
        return one + two;
    }
}
