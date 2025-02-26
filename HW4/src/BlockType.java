import java.awt.Color;

    public enum BlockType implements BLOCK1{ // BlockType 열거형(enum)은 BLOCK1 인터페이스를 상속
        RED_BLOCK(1,Color.RED), // 각 블록 타입 상수와 함께 값과 색상을 정의
        TEAL_BLOCK(2,new Color(54,117,136)),
        DOGERS_BLUE_BLOCK(3,new Color(0,90,156)),
        YELLOW_BLOCK(4,Color.YELLOW),
        ORANGE_BLOCK(5,Color.ORANGE),
        PURPLE_BLOCK(6,Color.MAGENTA),
        GREEN_BLOCK(7,Color.GREEN);
    
        private final int value; // 블록 타입의 값을 나타내는 변수
        private final Color color; // 블록 타입의 색상을 나타내는 변수
    
        // 생성자: 각 블록 타입 상수를 초기화
        private BlockType(int value, Color color) {
            this.value = value;
            this.color = color;
        }
    
        // Getter 메서드: 블록 타입의 값을 반환
        @Override
        public int getValue() {
            return value;
        }
        // Getter 메서드: 블록 타입의 색상을 반환
        @Override
        public Color getColor() {
            return color;
        }
    
    
    } // BLOCK1 인터페이스는 블록 타입의 값을 가져오는 메서드와 색상을 가져오는 메서드를 선언
    interface BLOCK1{
    int getValue(); // 블록 타입의 값을 반환하는 메서드
    Color getColor(); // 블록 타입의 색상을 반환하는 메서드
    }
    