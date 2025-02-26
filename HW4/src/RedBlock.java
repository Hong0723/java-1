import java.awt.geom.Rectangle2D;

public class RedBlock extends Block {  // RedBlock 클래스는 Block 클래스를 상속받아 구체적인 Red Block을 구현
    private static final int BLOCK_WIDTH = 50; // 각 블록의 너비를 정의하는 상수

    public RedBlock(double x, double y) {  // 생성자: 초기 좌표 (x, y)와 블록 타입을 지정하여 RedBlock을 초기화
        super(x, y, BlockType.RED_BLOCK);
    }

    @Override  // 추상 메소드 init을 구현하여 블록을 초기화
    public void init(double x, double y) {  // rectangles 배열의 각 요소를 지정된 좌표와 크기로 초기화
        rectangles[0] = new Rectangle2D.Double(x, y, BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[1] = new Rectangle2D.Double(x + BLOCK_WIDTH, y, BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[2] = new Rectangle2D.Double(x, y + BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[3] = new Rectangle2D.Double(x + BLOCK_WIDTH, y + BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);
    }


    }

