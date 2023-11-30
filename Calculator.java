import java.util.Scanner;
import java.util.logging.*;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fh;

        


        try {
            fh = new FileHandler("CalculatorLog.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            System.out.println("Enter first number:");
            double a = scanner.nextDouble();

            System.out.println("Enter second number:");
            double b = scanner.nextDouble();

            System.out.println("Enter operation (+, -, *, /, **):");
            String operation = scanner.next();

            Operators ops = new Operators();
            ops.RegisterOperations();


            double result = ops.operationResult(a, b, operation);

            System.out.println("Result: " + result);
            logger.info("Operation: " + a + " " + operation + " " + b + " = " + result);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error", e);
        }
    }
}