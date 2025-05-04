package lambda.calculator;

// WIP
public class Calculator {


    public static void main(String[] args) {





    }

    public static Integer addition(int a, int b) {
        return a + b;
    }

    public static Integer subtraction(int a, int b) {
        if (a>b){
            return a - b;
        }
        return b - a;
    }

    public static Integer multiplication (int a, int b) {
        return a * b;
    }

    public static Integer division (int a, int b) {
        return a / b;
    }

}
