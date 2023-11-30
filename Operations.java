import java.util.HashSet;

class Operators {
    private HashSet<OperationInterface> set = new HashSet<>();
    

    public void RegisterOperations(){
        set.add(new Plus());
        set.add(new Minus());
        set.add(new Multiply());
        set.add(new Divide());
        set.add(new Power());
        
    }
    public OperationInterface getOperation(String operation) {
        boolean found = false;
        OperationInterface element = (OperationInterface) new Plus();
        for (OperationInterface check : set) {
            if (check.Key() == operation){
                found = true;
                element = (OperationInterface) check;
                
            }
        }

    if (found == false){
        throw new IllegalArgumentException("Invalid operation");
    }  
    return element;    
    }


    public double operationResult(double a, double b, String operation) {
        double res = 0;
        for (OperationInterface check : set) {
            if ( operation.equals(check.Key() )){
                res = check.calculate(a, b);                 
            }
        }
        System.out.println("R3: " + res);            
        return res;
    }





class Plus implements OperationInterface {
    public String Key() {
        return "+";
    }
    public double calculate(double a, double b) {
        return a + b;
    }
}

class Minus implements OperationInterface {
    public String Key() {
        return "-";
    }
    public double calculate(double a, double b) {
        return a - b;
    }
}

class Multiply implements OperationInterface {
    public String Key() {
        return "*";
    }
    public double calculate(double a, double b) {
        return a * b;
    }
}

class Divide implements OperationInterface {
    public String Key() {
        return "/";
    }
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }
}

class Power implements OperationInterface {
    public String Key() {
        return "**";
    }
    public double calculate(double a, double b) {
        return Math.pow(a, b);
    }
}}