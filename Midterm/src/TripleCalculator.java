import java.util.Arrays;
public class TripleCalculator {
    private int[] operand; 
    private char[] operator;

    public TripleCalculator(int[] operand, char[] operator) {
        set(operand,operator); 
    }
    public void set(int[] operand, char[] operator){ // 피연산자와 연산자 설정하는 코드
    if (operand.length != 3) { 
    System.out.println("Error operand" + Arrays.toString(operand));
    }
    this.operand = operand;
    if (operator.length != 2){
    System.out.println("Error operator" + Arrays.toString(operator));
    }
    this.operator = operator;
    }
    // (6)
    public int calculator() { // 연산 수행하는 메서드
    int result = Integer.MIN_VALUE; // 결과 초기값 설정
    if (comparePriority(operator[0], operator[1]) >= 0 ){ // 우선순위 비교하여 첫 번째 연산자, 두 번째 연산자 계산
    result = calc(operator[0], operand[0], operand[1]);
    result = calc(operator[1], result, operand[2]); 
    }
    else {
    result = calc(operator[1], operand[1], operand[2]);
    result = calc(operator[0], operand[0], result);
    }
    return result;
    }
    public static int comparePriority(char operator1, char operator2){ // 연산자 우선순위를 비교하는 코드
    if (operator1 == '*' || operator1 == '/' || operator1 == '%'){
    if (operator2 == '*' || operator2 == '/' || operator2 == '%'){
    return 0; // 두 연산자가 모두 *, /, %이면 우선순위가 같음
    }
    else { 
    return 1; // operator1이 *, /, %이고 operator2가 +, -이면 operator1의 우선순위가 높음
    }
    }
    else { 
    if (operator2 == '*' || operator2 == '/' || operator2 == '%'){
    return -1; // operator1이 +, -이고 operator2가 *, /, %이면 operator2의 우선순위가 높음
    }
    else { 
    return 0; // 두 연산자가 모두 +, -이면 우선순위가 같음
    }      
    }
    }

    // (7) 코드 수정
    public static int calc(char operator, int operand1, int operand2){ // 연산을 수행하는 메서드
    int result ;
    if (operator == '+') {
    result = operand1 + operand2 ; }
    else if (operator == '-') {
    result = operand1 - operand2; }
    else if (operator == '*') {
    result = operand1 * operand2; }
    else if (operator == '/') {
    result = operand1 / operand2;}
    else if (operator == '%'){
    result = operand1 % operand2;}
    else { throw new IllegalArgumentException("Invaild operator" + operator);} // 유효하지 않은 연산자면 예외 발생
    return result;
    }
    public Object calculate() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calculate'");
    }
    }   