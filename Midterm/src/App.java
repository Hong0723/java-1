public class App {
    public static void main(String[] args) throws Exception {
    // (1)
    int[][] operands = { {123, 45, 4}, {123, 4, 123}, {123, 45, 4}}; // 피연산자 배열
    char[][] operators = { {'+','-'}, {'/', '+'}, {'-', '*'}}; // 연산자 배열
    for( int i =0; i < operands.length; i++) {  // 각 피연산자 배열과 연산자 배열에 대해 반복
    TripleCalculator calculator = new TripleCalculator(operands[i], operators[i]);  // TripleCalculator 객체 생성
    System.out.printf("%d %c %d %c %d = %d\n", operands[i][0], operators[i][0],
    operands[i][1], operators[i][1], operands[i][2], calculator.calculate());
    }

    // (2)  
    System.out.println(123 - 50 / 5); // 주어진 식을 각각 출력
    System.out.println(123 - 50 % 5);
    System.out.println(123 + 50 % 5);
    System.out.println(123 * 50 % 5);
    System.out.println(12350 / 5);

    String[] exprs = { "45 - 123 - 4", "123 + 45 - 4",
    " 123*4-123 ", " 123 / 4 + 123 ",
    " 123 - 45 * 4", " 123 / 4 * 45 ",
    "123 + 50 % 5", "123a - 50 / 5",
    "123 - 50 % 5 %", "123 + + 50 % 5",
    "123 @ 50 % 5 ", "123 50 % 5 ", "" };

    // (3) 
    for (String expr : exprs) { // 주어진 표현식 배열을 순회하며 각 표현식을 계산
    System.out.println("\nCalculating a new expression: " + expr); // 새로운 표현식 계산을 시작하는 메시지 출력 
    ExpressionParser parser = new ExpressionParser(expr); // ExpressionParser 객체 생성하여 표현식 파싱
    if (parser.parse()) {
    TripleCalculator calculator = new TripleCalculator(parser.getOperand(), parser.getOperator()); // TripleCalculator 객체 생성하여 계산
    System.out.printf("%s = %d\n", expr, calculator.calculate());
    }
    else {
    System.out.printf("%s Cannot calculate the value due to expression error!!\n", expr);
    }
    }

    // (5)
    for (char op : new char[] {'+','-','*','/','%','@','#'}) {   // 주어진 연산자 배열을 순회하며 각 연산자의 유효성을 확인
    if (ExpressionParser.isValidOperator(op)) {
    System.out.println(op + " is valid operator.");
    }
    else {
    System.out.println(op + " is invalid operator.");
    }
    } 
    }
    }
