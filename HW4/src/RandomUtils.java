import java.util.Random;
public class RandomUtils { // RandomUtils 클래스는 랜덤 값을 생성하기 위한 유틸리티 메소드
    private static final Random random = new Random();  // 랜덤 객체를 하나만 생성하여 사용
 
    public static BlockType randomBlockType() {  // 랜덤으로 BlockType을 반환하는 메소드
        BlockType[] values = BlockType.values();  // BlockType 열거형의 모든 값을 배열로 가져옴
        return values[random.nextInt(values.length)]; // 배열의 길이 내에서 랜덤 인덱스를 선택하여 BlockType을 반환
    }
    public static int randomInt(int min, int max) {  // 지정된 범위 내에서 랜덤 정수를 반환하는 메소드
        return random.nextInt(max - min + 1) + min ; // min과 max 사이의 랜덤 정수를 반환
    }
    public static double randomDouble(double min, double max){   // 지정된 범위 내에서 랜덤 실수를 반환하는 메소드
        return min + (max - min) * random.nextDouble(); // min과 max 사이의 랜덤 실수를 반환
    }
}
