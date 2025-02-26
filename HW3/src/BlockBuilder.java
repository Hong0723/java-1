// 5번 과제

public class BlockBuilder {
// 블록의 너비 상수
final static int BLOCK_WIDTH = 50;

// Red 블럭 
public static Block buildRedBlock(Point p){ 
    Square[] squares = new Square[4];  // 4개의 정사각형으로 이루어진 블록 생성 
    squares[0] = new Square(p, BLOCK_WIDTH);
    squares[1] = new Square(new Point(p.getX() + BLOCK_WIDTH,p.getY()), BLOCK_WIDTH); // 시작 위치에서 X좌표를 50만큼 이동함
    squares[2] = new Square(new Point(p.getX() ,p.getY()+ BLOCK_WIDTH), BLOCK_WIDTH); // 시작 위치에서 Y좌표를 50만큼 이동함
    squares[3] = new Square(new Point(p.getX() + BLOCK_WIDTH ,p.getY() + BLOCK_WIDTH), BLOCK_WIDTH); //시작 위치에서  X와Y좌표를 50씩 이동함
    Block red = new Block(BlockType.RED_BLOCK, squares); // 생성된 정사각형들로 Red 블록 객체 생성
    return red ; 
}

// Teal 블럭
public static Block buildTealBlock(Point p){ 
    Square[] squares = new Square[4]; // 4개의 정사각형으로 이루어진 블록 생성
    squares[0] = new Square(p, BLOCK_WIDTH);
    squares[1] = new Square(new Point(p.getX(), p.getY() +BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 Y좌표를 50만큼 이동
    squares[2] = new Square(new Point(p.getX(), p.getY() +BLOCK_WIDTH * 2), BLOCK_WIDTH) ; // 시작 위치에서 Y좌표를 100만큼 이동
    squares[3] = new Square(new Point(p.getX(), p.getY() +BLOCK_WIDTH * 3), BLOCK_WIDTH) ; // 시작 위치에서 Y좌표를 150만큼 이동
    Block teal = new Block(BlockType.TEAL_BLOCK, squares); // 생성된 정사각형들로 Teal 블록 객체 생성
    return teal;
}

// DOGERSBLUE 블럭
public static Block buildDogersBlueBlock(Point p){  
    Square[] squares = new Square[4]; // 4개의 정사각형으로 이루어진 블록 생성
    squares[0] = new Square(p, BLOCK_WIDTH);
    squares[1] = new Square(new Point(p.getX(), p.getY() +BLOCK_WIDTH), BLOCK_WIDTH) ; //시작 위치에서  Y좌표를 50만큼 이동
    squares[2] = new Square(new Point(p.getX()+ BLOCK_WIDTH, p.getY() +BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X좌표와 Y좌표를 50만큼 이동
    squares[3] = new Square(new Point(p.getX()+ BLOCK_WIDTH * 2, p.getY() +BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 100만큼, Y좌표를 50만큼 이동  
    Block dogersblue = new Block(BlockType.DOGERS_BLUE_BLOCK,squares); // 생성된 정사각형들로 DOGERSBLUE 블록 객체 생성
    return dogersblue;
}
 // 블록 타입에 따라 적절한 블록 생성하는 메서드
public static Block buildBlock(BlockType type ,Point upperLeft){
    switch (type) {
        case BlockType.RED_BLOCK:
            return buildRedBlock(upperLeft);
        case BlockType.TEAL_BLOCK :
            return buildTealBlock(upperLeft);
        case BlockType.DOGERS_BLUE_BLOCK :
            return buildDogersBlueBlock(upperLeft);
        case BlockType.YELLOW_BLOCK :
            return buildDogersBlueBlock(upperLeft);
        case BlockType.ORANGE_BLOCK :
            return buildDogersBlueBlock(upperLeft);
        case BlockType.PURPLE_BLOCK :
            return buildDogersBlueBlock(upperLeft); 
        case BlockType.GREEN_BLOCK :
            return buildDogersBlueBlock(upperLeft);   
        default :
            return null;
    }

}   

// 6번 과제 
// Yellow 블럭
public static Block buildYellowBlock(Point p){ 
Square[] squares = new Square[4]; // 4개의 정사각형으로 이루어진 블록 생성
    squares[0] = new Square(p, BLOCK_WIDTH);
    squares[1] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY() + BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X,Y좌표를 50만큼 이동
    squares[2] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY()), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 50만큼 이동
    squares[3] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY() - BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 50만큼, Y좌표를 -50만큼 이동
    Block yellow = new Block(BlockType.YELLOW_BLOCK,squares); // 생성된 정사각형들로 Yellow 블록 객체 생성
    return yellow;

}

// 7번 과제
// Orange 블럭
public static Block buildOrangeBlock(Point p){ 
    Square[] squares = new Square[4]; // 4개의 정사각형으로 이루어진 블록 생성
        squares[0] = new Square(p, BLOCK_WIDTH);
        squares[1] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY() + BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X,Y좌표를 50만큼 이동
        squares[2] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY()), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 50만큼 이동
        squares[3] = new Square(new Point(p.getX(), p.getY() - BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 Y좌표를 -50만큼 이동
        Block orange = new Block(BlockType.ORANGE_BLOCK,squares); // 생성된 정사각형들로 Orange 블록 객체 생성
        return orange; 
    }


// 8번 과제
// Purple 블럭
public static Block buildPurpleBlock(Point p){ 
    Square[] squares = new Square[4]; // 4개의 정사각형으로 이루어진 블록 생성
        squares[0] = new Square(p, BLOCK_WIDTH);
        squares[1] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY()), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 50만큼 이동
        squares[2] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY()+ BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X,Y좌표를 50만큼 이동
        squares[3] = new Square(new Point(p.getX() + BLOCK_WIDTH * 2, p.getY() + BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 100,Y좌표를 50만큼 이동
        Block purple = new Block(BlockType.PURPLE_BLOCK,squares); // 생성된 정사각형들로 Purple 블록 객체 생성
        return purple; 
    }

    // Green 블럭
    public static Block buildGreenBlock(Point p){ 
        Square[] squares = new Square[4]; // 4개의 정사각형으로 이루어진 블록 생성
            squares[0] = new Square(p, BLOCK_WIDTH);
            squares[1] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY()), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 50만큼 이동
            squares[2] = new Square(new Point(p.getX() + BLOCK_WIDTH * 2, p.getY()), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 100만큼 이동
            squares[3] = new Square(new Point(p.getX() + BLOCK_WIDTH * 2, p.getY() + BLOCK_WIDTH), BLOCK_WIDTH) ; // 시작 위치에서 X좌표를 100,Y좌표를 50만큼 이동
            Block green = new Block(BlockType.GREEN_BLOCK,squares); // 생성된 정사각형들로 Green 블록 객체 생성
            return green; 
        }

}
