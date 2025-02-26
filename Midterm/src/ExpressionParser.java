public class ExpressionParser {

    private String expression;
    private int[] operand;
    private char[] operator;
    public ExpressionParser(String expression) {
    this.expression = expression;
    }
    public String getExpression() {
    return this.expression;
    }
    public int[] getOperand() {
    return this.operand;
    }
    public char[] getOperator() {
    return this.operator;
    }
    // (10)
    public boolean parse() { // expression 이 null 인지 "" 인지 확인하는 코드
    if (expression == null || expression.equals("")) {
    return false;
    }
    // 공백 제거
    expression = removeWhiteSpace(expression);
    if (!containsOnlyDigitsAndOperators(expression)) {  // 숫자와 연산자 이외의 문자가 포함되어 있는지 확인
    System.out.println("Invalid characters in expression: " + expression); // 잘못된 연산자 문자가 포함되어 있는지 확인
    return false;
    }
    // 연속된 연산자가 있는지 확인
    if (containsConsecutiveOperators(expression)) {
    System.out.println("Consecutive operators! Invalid expression format: " + expression);
    return false;
    }
    // 유효한 피연산자와 연산자를 설정하고 확인
    operand = setOperand(expression);
    if (operand == null) {
    System.out.println("Invalid operand : " + expression);
    return false;
    }
    operator = setOperator(expression);
    if (operator == null) {
    System.out.println("Invalid operator : " + expression);
    return false;
    }
    return true;
    }
    // 공백을 제거하는 메서드
    // ex) "45 - 123 - 4" => "45-123-4"
    public static String removeWhiteSpace(String expr) {
    return expr.replaceAll("\\s+", ""); // 모든 공백을 제거하여 반환한다
    }
    public static boolean isValidOperator(char c) { // 주어진 문자가 유효한 연산자인지 확인하는 메서드
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    // (8)
    public static boolean containsOnlyDigitsAndOperators(String expr) { // 주어진 문자열이 숫자와 연산자만 포함하고 있는지 확인하는 코드
    for (char c : expr.toCharArray()) { 
    if (!Character.isDigit(c) && !isValidOperator(c)) {
    return false; 
    }
    }
    return true;    
    }
    public static boolean containsConsecutiveOperators(String expr) { // 주어진 문자열에 연속된 연산자가 포함되어 있는지 확인하는 코드
    for (int i = 0; i < expr.length() - 1; i++) { // 문자열의 각 문자를 순회하면서 현재문자와 다음문자를 가져온다
    char current = expr.charAt(i);
    char next = expr.charAt(i + 1);
    if (isValidOperator(current) && isValidOperator(next)) {
    return true;
    }
    }
    return false;
    }
    public static int[] setOperand(String expr) { // 주어진 문자열에서 피연산자를 설정하는 메서드
    String[] nums = expr.split("[\\+\\-\\*\\/\\%]"); // 연산자를 기준으로 문자열을 분할하여 숫자를 얻음
    if (nums.length != 3) {
    return null;
    }
    int[] operand = new int[3];  // 3개의 피연산자를 저장할 배열 생성   
    for (int i = 0; i < 3; i++) {
    operand[i] = Integer.parseInt(nums[i]);
    }
    return operand;
    }

    // (9)
    public static char[] setOperator(String expr) { // 주어진 문자열에서 연산자를 설정하는 코드
    String[] ops = expr.split("[0-9]+");   // 숫자를 기준으로 문자열을 분할하여 연산자를 얻음
    if (ops.length != 3) {
    return null;
    }
    char[] operator = new char[2]; // 2개의 연산자를 저장할 배열 생성
    for (int i = 1; i < 3; i++) {
    operator[i-1] = ops[i].charAt(0); //문자열의 첫 번째 문자를 연산자로 설정하여 저장
    }
    return operator;
    }
    } 
