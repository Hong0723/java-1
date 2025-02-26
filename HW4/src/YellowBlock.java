import java.awt.geom.Rectangle2D;

public class YellowBlock extends Block {  // YellowBlock 추상 클래스는 Block 클래스를 상속
    private static final int BLOCK_WIDTH = 50; // 블록의 너비를 나타내는 상수

    public YellowBlock(double x, double y) {   // YellowBlock 생성자
        super(x, y,BlockType.YELLOW_BLOCK );
    }

    @Override
    public void init(double x, double y) { // init 메서드를 재정의하여 사각형들을 초기화
        // 각 사각형을 (x, y) 좌표를 기준으로 특정 위치에 초기화
        rectangles[0] = new Rectangle2D.Double(x + BLOCK_WIDTH, y, BLOCK_WIDTH, BLOCK_WIDTH); 
        rectangles[1] = new Rectangle2D.Double(x, y + BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[2] = new Rectangle2D.Double(x + BLOCK_WIDTH, y + BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[3] = new Rectangle2D.Double(x + BLOCK_WIDTH, y + BLOCK_WIDTH * 2, BLOCK_WIDTH, BLOCK_WIDTH);
    }


    }

