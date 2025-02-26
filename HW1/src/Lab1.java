/* Lab1
박재홍
32211792
2024/03/27
1분반 */

import java.util.*; // 패키지 내의 모든클래스를 포함
public class Lab1{
        public static void main(String[] args) {
    // (1)번 과제
        int length = 5;
        int distance = 3;
        int x = length*length - distance*distance ; // 피타고라스의 정리를 이용해 높이 구하기
        double height = Math.sqrt(x);  // Math.sqrt를 사용해 제곱근 사용
        System.out.println("높이는:" + height); 
 
    // (2)번 과제
        double number= 5.983 ;
        double integerpart= Math.floor(number);  
        double decimalpart = number- integerpart;  // number에서의 정수부분과 소수부분을 분리
        double decimalvalue = Math.round(decimalpart*1000.0)/ 1000.0; //소수부분을 소수점 이하 세 자리로 반올림
        System.out.println("소수 부분은 : " + decimalvalue);

    // (3)번 과제
        double radius = 5.5;
        double cylinderheight = 3.5;
        double surfacearea = 2 * Math.PI * radius * (cylinderheight + radius ) ; // 원통의 표면적 공식
        surfacearea = Math.round(surfacearea*1000.0) / 1000.0 ; //소수부분을 소수점 이하 세 자리로 반올림
        System.out.println("원통의 표면적은:" + surfacearea);

    // (4-1)번 과제
        for(double p=1; p <= 10.0; p += 0.5) {        // for-loop 를 사용한 반지름과 높이의 증가
        double cylinderheightQ = p;
        double radiusQ = p ;      
        double surfaceareaQ =  2 * Math.PI * radiusQ * (cylinderheightQ + radiusQ ) ; // 원통의 표면적 공식
        surfaceareaQ = Math.round(surfaceareaQ*1000.0) / 1000.0 ; //소수부분을 소수점 이하 세 자리로 반올림
        System.out.println("원통의 표면적은:" + surfaceareaQ);
        }
 
    // (4-2)번 과제
        double m=1;
        while(m <=10) {   // while-loop 를 사용한 반지름과 높이의 증가와 반복
        double cylinderheightW = m;
        double radiusW = m ;
        double surfaceareaW =  2 * Math.PI * radiusW * (cylinderheightW + radiusW ) ; // 원통의 표면적 공식
        surfaceareaW = Math.round(surfaceareaW*1000.0) / 1000.0 ; //소수부분을 소수점 이하 세 자리로 반올림
        System.out.println("원통의 표면적은:" +surfaceareaW);
        m += 0.5; 
        }
        
    // (4-3)번 과제
        Scanner b = new Scanner(System.in);  // Scanner user input 을 이용해 사용자에게 반지름과 높이를 입력받기
        System.out.println("반지름을 입력하세요 : " );
        double radiusE = b.nextDouble();
        System.out.println("높이를 입력하세요 : " );
        double cylinderheightE = b.nextDouble();
        double surfaceareaE =  2 * Math.PI * radiusE * (cylinderheightE + radiusE ) ; // 원통의 표면적 공식
        surfaceareaE = Math.round(surfaceareaE*1000.0) / 1000.0 ; //소수부분을 소수점 이하 세 자리로 반올림
        System.out.println("원통의 표면적은 : " + surfaceareaE);
    
    //  (5)번 과제
        Random random = new Random() ; //  난수를 생성 받는 메소드 호출
        int total = 0;
        int count = 0;
        do  // do-while-loop 를 이용한 반복문
        {   
        int roll = random.nextInt(6) + 1 ; //  roll에 1~6 사이의 무작위 정수 할당
        total += roll ;
        count ++;
        System.out.println("주사위의 숫자는 :"+ roll );
        if(roll ==1){ 
        total -= roll;
        count --;
        System.out.println("re-rolling"); // if 문을 이용한 re-rolling 출력 
        } } while (count < 5) ;
        System.out.println("주사위의 총합은:" + total);

    // (6)번 과제 My Code  (구의 반지름을 1~50 사이의 무작위 정수로 반지름을 입력받아 구의 부피 구하기)
        Random radiusRandom = new Random() ; //  난수를 생성 받는 메소드 호출
        int radiusR = radiusRandom.nextInt(50) + 1 ; // 구의 반지름을 1~50 사이의 무작위 정수 할당 
        System.out.println("구의 반지름의 값은 : "+ radiusR);
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radiusR,3); // 구의 부피 공식
        volume = Math.round(volume*1000.0) / 1000.0 ; //소수부분을 소수점 이하 세 자리로 반올림
        System.out.println("구의 부피는 : " + volume);
        }
    }