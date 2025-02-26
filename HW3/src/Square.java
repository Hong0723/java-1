  // 3번 과제
public class Square {
    // 멤버변수 width, upperLeft, lowerRight
    private int width; // 정사각형의 너비
    private Point upperLeft; // 좌상단의 점
    private Point lowerRight; // 우하단의 점

    // 좌상단의 점과 정사각형의 너비를 받아 초기화시키는 Square 에 대한 객체 생성
    public Square(Point upperLeft, int width){
        this.upperLeft = upperLeft; // 좌상단의 점 설정
        this.width = width; // 너비 설정 
        this.lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + width); // 우하단의 점 계산

    }

    // 너비를 반환하는 Getter 메소드
    public int getWidth() {
        return this.width;
    }
    // 너비를 설정하는 Setter 메소드
    public void setWidth(int width) {
        this.width = width;
    }
    // 좌상단의 점을 반환하는 Getter 메소드
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    // 좌상단의 점을 설정하는 Setter 메소드
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }
    // 우하단의 점을 반환하는 Getter 메소드
    public Point getLowerRight() {
        return this.lowerRight;
    }
    // 우하단의 점을 설정하는 Setter 메소드
    public void setLowerRight(Point lowerRight) {
        this.lowerRight = lowerRight;
    }

    // Square 객체를 문자열로 표현하는 toString 메소드 생성
    @Override
    public String toString() {
        return "{" +
            "width='" + getWidth() + "'" + 
            ", upperLeft=" + getUpperLeft() + "" +
            ", lowerRight=" + getLowerRight() + "" +
            "}" + System.lineSeparator() ; 
    }
    // upperLeft 와 lowerRight에 주어진 양만큼 이동시키는 메소드
    public void translate(int dx, int dy) {
        upperLeft.translate(dx,dy);
        lowerRight.translate(dx,dy);
    }
}
