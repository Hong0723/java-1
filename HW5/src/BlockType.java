import java.awt.Color;
import java.util.Random;
public enum BlockType { // 블록 타입과 블록의 색상 및 좌표를 정의
    NONE(Color.BLACK, new int[][] {{0,0}, {0,0}, {0,0}, {0,0}} ),
    TEAL_BLOCK(new Color(54,117,136), new int[][] {{0,-1}, {0,0}, {0,1}, {0,2}}),
    RED_BLOCK(new Color(204, 102, 102), new int[][] { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } }),
    DOGERS_BLUE_BLOCK(new Color(0, 90, 156), new int[][] { { -1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } }),
    YELLOW_BLOCK(new Color(255, 204, 51), new int[][] { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 0, 1 } }),
    PURPLE_BLOCK(new Color(102, 0, 153), new int[][] { { 0, -1 }, { 0, 0 }, { -1, 0 }, { -1, 1 } }),
    ORANGE_BLOCK(new Color(255, 102, 0), new int[][] { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 1, 1 } }),
    GREEN_BLOCK(new Color(55, 153, 34), new int[][] { { 1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } });
    
    private Color color; // 블록의 색상
    private int[][] coords; // 블록의 좌표 배열
    BlockType(Color color, int[][] coords) { // 생성자 
        this.color = color ; // 블록의 색상을 설정
        this.coords = coords; // 블록의 좌표를 설정
    }    

    public Color getColor() { // 블록의 색상을 변환하는 메소드
        return color;
    }

    public int[][] getCoords() { // 블록의 좌표 배열을 반환하는 메소드
        return coords; 
    }

    public static BlockType getRandom(){ // 임의의 블록 타입을 반환하는 정적 메소드
        Random random = new Random(); // 난수를 생성
        BlockType[] values = BlockType.values(); // 모든 블록타입을 배열로 가져옴
            return values()[random.nextInt(1,values.length-1)]; // NONE 블록 타입을 제외한 임의의 블록 타입 반환
        }


    }


