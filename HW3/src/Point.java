    // 2번 과제
public class Point {
    // 멤버 변수 x,y 
    private int x;
    private int y; 

    // x와 y좌표를 받아 초기화하는 객체 생성
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // x 좌표를 반환하는 Getter 메소드 
    public int getX() {
        return this.x;
    }
    // x 좌표를 설정하는 Setter 메소드
    public void setX(int x) {
        this.x = x;
    }
    // y 좌표를 반환하는 Getter 메소드
    public int getY() {
        return this.y;
    }
    // y 좌표를 설정하는 Setter 메소드
    public void setY(int y) {
        this.y = y;
    }

    // Point 객체를 문자열로 표현하는 toString 메소드 생성
    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            "}";
    }   
    // x,y 좌표를 주어진 양만큼 이동시키는 메소드
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
