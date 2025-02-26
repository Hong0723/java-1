/* Lab2
박재홍
32211792
2024 /04 /10
1분반 */

import java.util.Random;
import java.util.Scanner;

public class Lab2 {

    // 1번 과제
    public static int forecast() {
        Random random = new Random(); 
        int Cort = random.nextInt(101); // 0부터 100까지 사이의 값을 받는다
        return Cort ; //Cort 값을 리턴
    }

    // 2번 과제
    public static double decimalValue(double decimalValue){
        double decimalpart = decimalValue - Math.floor(decimalValue); // Math.floor 함수를 이용한 소수부분 구하기
        double roundedValue = Math.round(decimalpart * 1000.0) / 1000.0 ; // Math.round 함수를 이용한 소수부분을 세번째자리 까지 구하기
        return roundedValue;  // roundedValue 값을 리턴
    }
    
    // 3번 과제
    public static String underlined(String inputString, int lines){
        StringBuilder result = new StringBuilder();
        for ( int i =1 ; i <= lines; i ++){
            result.append(i).append("->").append(inputString.toLowerCase()).append("\n");
        }
        return result.toString();
    }

   // 4번 과제
    public static void bacteria(int minutes, int bacterium){
        int time = 0; // 시간의 값을 0으로 설정
        int totalbacteria = 1 ; // 초기 박테리아 수는 1로 설정
        for ( int i = 0 ; i < bacterium ; i++){ //주어진 세대 수만큼 반복하여 박테리아 수를 출력
            totalbacteria *= 2 ; // 각 기간이 끝날때마다 박테리아 수는 두 배로 증가
            time += minutes ; // 매개변수의 값이 달라질때마다 시간도 동일하게 바뀌도록 설정
            System.out.println("after "+ time + "minutes: " + totalbacteria + "bacteria");
        }
    } 

    // 5번 과제
    public static void convertToCopper(int gp, int sp, int cp) {  
        int totalCopper = ( gp * 50 ) + (sp * 5 ) + cp ;  // 변환된 충 구리의 개수 출력
        System.out.println(gp + "gp, "+ sp + "sp, " + cp + "cp converted to Copper is : "+ totalCopper + " cp");
    }
    public static void convertFromCooper(int totalCopper1){
        int gp = totalCopper1 / 50;     // 변환된 총 구리의 개수를 다시 금화의 최대개수로 변환
        int sp = ( totalCopper1 % 50 )   / 5 ;    // 금화로 변환하고 남은 구리를 은화의 최대개수로 변환
        int cp = (totalCopper1 % 50) % 5 ;  // 총 구리의 개수를 금화와 은화의 최대개수로 변환하고 남은 구리의 개수
        System.out.println(totalCopper1 + " Copper pieces is : " + gp + "gp, " + sp +"sp, " + cp + "cp");
    }

    // 6번 과제
    public static void repeatWord(String Word, int row, int column){
        for( int i = 0 ; i < row ; i++){     // 이중 포문을 이용해 행과 열에 단어가 반복되도록 사용
            for (int j = 0 ; j<column ; j ++) {
                System.out.print(Word);
            }
            System.out.println();
        }
    }

    // 7번 과제
    public static String repeatCharacter(String Word1, int repeatCount){
        StringBuilder repeatedWord = new StringBuilder();
        for (int p = 0; p < Word1.length(); p++ ){   // 각 문자별로 반복 횟수만큼 반복하여 단어를 생성
            char Character = Word1.charAt(p);
            for ( int o = 0; o < repeatCount ; o ++){ // 각 문자를 반복 횟수만큼 반복하여 StringBuilder에 추가
                repeatedWord.append(Character);   
        }
        }
        return repeatedWord.toString();
    }

    // 8번 과제
    public static void textTriangle(int a) {
        for (int i = 1; i <= a ; i++){  // 이중포문을 사용해 a번만큼 반복해서 삼각형을 출력
            for ( int p = 1; p <= i ; p ++ ){ // 현재형의 i 개수만큼 출력
                System.out.print("X"); // print 만 사용해서 줄바꿈이 이루어지지 않고 연속으로 출력 되도록 함
            } 
            System.out.println();  // 한 행 출력 후 줄바꿈 
    }
    }
    
    // 9번 과제 
    enum beefTypeEnum { // 고기의 종류를 나타내는 enum
        HAMBURGER,
        CHUCK,
        ROUND,
        SIRLOIN,
        UNKNOWN
    }
    
            public static String beefType(double percentLean) {  // 비율에 따라 고기의 종류를 반환
            if (percentLean < 78) {
                return "Hamburger";
            } else if (percentLean >= 78 && percentLean < 85) {
                return "Chuck";
            } else if (percentLean >= 85 && percentLean < 90) {
                return "Round";
            } else if (percentLean >= 90 && percentLean <= 95) {
                return "Sirloin";
            } else {
                return "Unknown";
            }
        }
    
        public static String beefTypeEnum(double percentLean) { // 열거형을 사용하여 고기의 종류를 출력
            if (percentLean < 78) {
                return beefTypeEnum.HAMBURGER.name();
            } else if (percentLean >= 78 && percentLean < 85) {
                return beefTypeEnum.CHUCK.name();
            } else if (percentLean >= 85 && percentLean < 90) {
                return beefTypeEnum.ROUND.name();
            } else if (percentLean >= 90 && percentLean <= 95) {
                return beefTypeEnum.SIRLOIN.name();
            } else {
                return beefTypeEnum.UNKNOWN.name();
            }
        }

    // 10번 과제
    public static boolean isNormalBloodPressure(int top, int bottom) { // 혈압이 정상인지 여부를 반환하는 함수
    return (top < 120 && bottom < 80);
    }
     public static void doctor() {  // 사용자에게 수축기 & 확장기 혈압 수치를 입력받고 혈압을 판단하여 출력하는 함수
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter your systolic reading: \033[32m ");  // 사용자가 수축기 혈압을 초록색으로 입력
        int systolic = scanner.nextInt();
        System.out.print("\033[0m"); // 다시 색을 흰색으로 변환
        System.out.print("Enter your diastolic reading:\033[32m ");  // 사용자가 확장기 혈압을 초록색으로 입력 
        int diastolic = scanner.nextInt();
        System.out.print("\033[0m"); // 다시 색을 흰색으로 변환
        if (isNormalBloodPressure(systolic, diastolic)) {  // 입력받은 혈압에 따라 혈압이 정상인지 판단하여 결과 출력
            System.out.println("Your blood pressure is normal.");
        } else {
            System.out.println("Your blood pressure is high.");
        }
    }

    
    public static void main(String[] args) {  
        // 1번 과제
        int Cort = forecast(); // forecast 함수 호출
        System.out.println("비가 올 확률은 : " + Cort + "%");
        
        // 2번 과제
        System.out.println("5.9832 Decimal part is : "+ decimalValue(5.9832) );
        
        // 3번 과제
        String underlinedString = underlined("a_string_that_looks_like_this", 5 );
        System.out.println(underlinedString);
    
        // 4번 과제
        bacteria(21,3); // bacteria 함수 호출
        
        // 5번 과제
        convertToCopper(5,10,7);  
        convertFromCooper((1107));     // convertToCopper 함수와 convertFromCopper 함수를 호출
        
        // 6번 과제
        repeatWord("Carrot",3,5);  // reapeatWord 함수를 호출
        
        // 7번 과제 
        String repeatedString = repeatCharacter("carrot",3);
        System.out.println("Repeat each character three times: "+  repeatedString);

        // 8번 과제
        textTriangle(3) ; // textTriangle 함수를 호출

        // 9번 과제
        System.out.println("beefType(95.1) --> " + beefType(95.1)); // beefType 함수 호출    
        System.out.println("beefType(87) --> " + beefTypeEnum(87));  // beefTypeEnum 함수 호출 
        
        // 10번 과제
        doctor();  // 함수 호출                  

        // Your Code  2~9 번을 다르게 호출
        
        System.out.println("3.141592 Decimal part is : " + decimalValue(3.141592)) ; // 2번 함수 호출
        String underlinedString1 = underlined("a_new_function_call",8);
        System.out.println(underlinedString1); // 3번 함수 호출
        bacteria(28, 5); // 4번 함수 호출
        convertToCopper(19,17,7); // 5번 함수 호출
        convertFromCooper(10394);
        repeatWord("a_new_function_call", 5, 7); // 6번 함수 호출
        String repeatedString1 = repeatCharacter("newfunctioncall", 4);
        System.out.println("Repeat each character four times: "+  repeatedString1); // 7번 함수 호출
        textTriangle(8); // 8번 함수 호출
        System.out.println("beefType(98) --> " + beefType(98)); 
        System.out.println("beefType(79) --> " + beefTypeEnum(79));  // 9번 함수 호출
        

        


        
        

    }


    

    
}
