// 4번 과제

import java.util.Arrays;

public class Block {
private BlockType type; // 블록의 유형을 나타내는 열거형 변수
private Square[] squares;   // 블록을 구성하는 사각형들을 담는 배열

    // Block에 대한 객체 생성, 블록의 유형과 사각형 배열을 받아 초기화
    public Block(BlockType type, Square[] squares) { 
        this.type = type;
        this.squares = squares;
    }

    // 블록의 유형을 반환하는 Getter 메소드
    public BlockType getType() {
        return this.type;
    }
    // 블록의 유형을 설정하는 Setter 메소드
    public void setType(BlockType type) {
        this.type = type;
    }
    // 블록을 구성하는 사각형들의 배열을 반환하는 Getter 메소드
    public Square[] getSquares() {
        return this.squares;
    }
    // 블록을 구성하는 사각형들의 배열을 설정하는 Setter 메소드
    public void setSquares(Square[] squares) {
        this.squares = squares;
    }

    // Block 객체를 문자열로 표현하는 toString 메소드 생성
    @Override
    public String toString() {
        return "{" +    
            "type='" + getType() + "'" +  
            "}" + System.lineSeparator() +  "squares=" + Arrays.toString(getSquares()) +   "}";
    }

    // 모든 사각형을 주어진 양만큼 이동시키는 메소드
    public void translate(int dx,int dy){
        for (Square square : squares){
            square.translate(dx, dy);
        }
    }

}
