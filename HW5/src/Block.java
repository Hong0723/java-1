public class Block {
    private BlockType type; // 블록의 타입 
    private int[][] coords = new int[4][2]; // 블록의 좌표를 저장하는 2차원 배열

    public Block() { // 생성자
        setType(BlockType.NONE); // 블록의 기본 타입을 NONE으로 지정
    }

    public void setType(BlockType type) { // 블록의 타입을 설정
        for (int i = 0; i < 4; i++) {   // 주어진 타입의 좌표를 복사하여 coords 배열에 저장
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = type.getCoords()[i][j]; 
            }
        }
        this.type = type;        // 블록 타입 설정
    }
    
    public BlockType getType() {  // 블록의 타입을 반환
        return type; 
    }

    public void setX(int index, int x) {  // 블록 좌표의 X값을 설정
        coords[index][0] = x; 
    }

    public int getX(int index) {  // 블록 좌표의 X값을 반환
        return coords[index][0]; 
    }

    public void setY(int index, int y) { // 블록 좌표의 Y값을 설정
        coords[index][1] = y; 
    }

    public int getY(int index) { // 블록 좌표의 Y값을 반환
        return coords[index][1]; 
    }

    public int minX() { // 블록의 X좌표중 최소값을 반환
        int m = coords[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][0]);
        }
        return m;
    }

    public int minY() { // 블록의 Y좌표중 최소값을 반환
        int m = coords[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][1]);
        }
        return m;
    }

    public Block rotateLeft() { // 블록을 왼쪽으로 회전
        if (type == BlockType.RED_BLOCK) // 블록 타입이 레드블록일시에 회전하지 않음
            return this;

        Block result = new Block(); // 새로운 블록 생성
        result.type = type; // 타입 설정

        for (int i = 0; i < 4; ++i) { // 좌표를 왼쪽으로 회전
            result.setX(i, getY(i)); // X좌표를 현재 Y좌표로 설정
            result.setY(i, -getX(i)); // Y좌표를 현재 X좌표의 음수로 설정
        }

        return result;
    }

    public Block rotateRight() { // 블록을 오른쪽으로 회전
        if (type == BlockType.RED_BLOCK) //블록 타입이 레드블록일시에 회전하지 않음
            return this;

        Block result = new Block(); // 새로운 블록 생성
        result.type = type; // 타입 설정

        for (int i = 0; i < 4; ++i) { // 좌표를 오른쪽으로 회전
            result.setX(i, -getY(i)); // X좌표를 현재 Y좌표의 음수로 설정
            result.setY(i, getX(i)); // Y좌표를 현재 X좌표로 설정   
        }

        return result;
    }
}
