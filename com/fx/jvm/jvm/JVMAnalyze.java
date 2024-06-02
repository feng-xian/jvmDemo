package com.fx.jvm.jvm;



public class JVMAnalyze {


    public int add() {
        int num1 = 10;
        int num2 = 20;
        int num3 = (num1 + num2) * 5;
        return num3;
    }


    public static void main(String[] args) {
        JVMAnalyze jvmAnalyze = new JVMAnalyze();
        jvmAnalyze = null;
        int result = jvmAnalyze.add();
        System.out.println(result);

    }


}
