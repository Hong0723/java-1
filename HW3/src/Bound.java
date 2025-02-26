public class Bound {
    private int xmin; // x좌표의 최솟값
    private int xmax; // x좌표의 최댓값
    private int ymin; // y좌표의 최솟값
    private int ymax; // y좌표의 최댓값

    // Bound 객체 생성자
    public Bound(int xmin, int xmax, int ymin, int ymax) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }

    // x좌표 최솟값 반환
    public int getXmin() {
        return xmin;
    }

    // x좌표 최댓값 반환
    public int getXmax() {
        return xmax;
    }

    // y좌표 최솟값 반환
    public int getYmin() {
        return ymin;
    }

    // y좌표 최댓값 반환
    public int getYmax() {
        return ymax;
    }
}
