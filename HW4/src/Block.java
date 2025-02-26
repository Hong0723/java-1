import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public abstract class Block implements IMoveable,IColliding { // Block 클래스는 IMoveable, IColliding 인터페이스를 구현한 추상 클래스
    protected BlockType type; // 블록의 타입을 나타내는 변수
    protected Rectangle2D[] rectangles = new Rectangle2D[4]; // 블록을 구성하는 사각형 배열
    private boolean hasCollided = false;  // 블록이 충돌했는지 여부를 나타내는 변수
    private static final double BOTTOM_LINE = 560.0; //  하단 경계선을 560으로 설정
    
    protected Block(double x, double y, BlockType type) { // 블록의 초기 위치와 타입을 받아서 초기화하는 생성자
        this.type= type;
        init(x,y); 
       
    }
    public BlockType getType(){ // 블록의 타입을 반환하는 메소드
        return type;
    }

    
    public abstract void init(double x, double y); // 블록의 초기화 작업을 위한 추상 메소드

    // 코드 추가 구현
    public void translate(double x, double y){ // 블록을 이동시키는 메소드
        if (hasCollided || isBelowBottomLine()) {
            return; // 충돌이 발생하거나 하단 라인을 지났으면 이동하지 않음
        }
        for (Rectangle2D rectangle : rectangles){
            rectangle.setRect(rectangle.getX() + x, rectangle.getY() + y, rectangle.getWidth(), rectangle.getHeight());
        }
    }
    public boolean collideWith(Block other) { // 다른 블록과의 충돌을 감지하는 메소드
        for (Rectangle2D myRect : rectangles) {
            for ( Rectangle2D otherRect : other.rectangles){
                if(myRect.intersects(otherRect)) { // 충돌이 감지되면 원하는 작업을 수행할 수 있음
                    hasCollided = true; 
                    return true;
                }
            }
        }
        return false;
    }
    // 코드 추가 구현
    private boolean isBelowBottomLine() { // 블록이 하단 경계선을 지났는지 확인하는 메소드
        for (Rectangle2D rect : rectangles) {
            if (rect.getMaxY() > BOTTOM_LINE) {
                return true;
            }
        }
        return false;
    }

    public String toString() {   // 블록의 상태를 문자열로 반환하는 메소드
        StringBuilder sb = new StringBuilder();
        sb.append("Block Type: ").append(type).append("\n");
        for(int i =0; i< rectangles.length; i++) {
            sb.append("Rectangle").append(i+1).append(":").append(rectangles[i]).append("\n");
        }
        return sb.toString();
    }


    public void draw(Graphics2D g2) {  // 블록을 화면에 그리는 메소드
        for (var rect : rectangles) {
        g2.setPaint(type.getColor());   // 블록 타입에 따른 색상으로 채우기
        g2.fill(rect);
        g2.setPaint(Color.BLACK);    // 블록의 테두리를 검은색으로 그리기
        g2.draw(rect);
        }
        } 
}

