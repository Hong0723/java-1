/* Lab3
박재홍
32211792
2024 /05 /01
1분반 */

// 9번 과제
    import java.util.Random;
    import java.util.Scanner;

    public class Lab3 {
    public static void main(String[] args)  {
    BlockBuilder blockBuilder = new BlockBuilder(); //BlockBuilder 객체 생성
    BlockType blockTypes[] = BlockType.values();  // 블록 타입 배열 생성
    Random random = new Random(); // 난수 생성기 생성
    Scanner scanner = new Scanner(System.in); // 스캐너 객체 생성
    String choice;
  
  // 사용자 입력 반복
    do {
    System.out.println("블럭 타입을 선택하시오:"); // 사용자로부터 BlockType 선택
    for (BlockType blockType : BlockType.values()) {
    System.out.println(blockType.name()); 
    }
    String typeStr = scanner.nextLine();
    BlockType selectedType = BlockType.valueOf(typeStr);

    System.out.println("블록의 시작위치를 입력하시오:"); // 사용자로부터 시작 위치 입력
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    scanner.nextLine(); 

    Point point = new Point(x, y);
    Block block = blockBuilder.buildBlock(selectedType, point);

    System.out.println("이동량을 입력하시오:"); // 사용자로부터 이동량 입력
    int dx = scanner.nextInt();
    int dy = scanner.nextInt();
    scanner.nextLine();

    block.translate(dx, dy);  // Block 이동
    System.out.println("블록 이동후의 위치 " + block);
    System.out.println("계속 하려면 Enter, 종료하려면 q를 누르시오:");
    choice = scanner.nextLine();
    }
    while(!choice.equals("q"));

// 10번 과제

// Block 생성
    Point p1 = new Point(10, 10);
    Point p2 = new Point(20, 20);
    Point p3 = new Point(30, 30);
    Square[] squares1 = {new Square(p1, 5), new Square(p2, 5), new Square(p3, 5)};
    Block block1 = new Block(BlockType.RED_BLOCK, squares1);

    Point p4 = new Point(50, 50);
    Point p5 = new Point(60, 60);
    Point p6 = new Point(70, 70);
    Square[] squares2 = {new Square(p4, 8), new Square(p5, 8), new Square(p6, 8)};
    Block block2 = new Block(BlockType.TEAL_BLOCK, squares2);
      
// Block의 Bound 생성
    Bound bound1 = calculateBound(block1);
    Bound bound2 = calculateBound(block2);

// Bound 확인
    System.out.println("Block 1의 경계:");
    System.out.println("xmin: " + bound1.getXmin() + ", xmax: " + bound1.getXmax() +
                ", ymin: " + bound1.getYmin() + ", ymax: " + bound1.getYmax());
    System.out.println("Block 2의 경계:");
    System.out.println("xmin: " + bound2.getXmin() + ", xmax: " + bound2.getXmax() +
                ", ymin: " + bound2.getYmin() + ", ymax: " + bound2.getYmax());
    }

// Block의 경계를 계산하는 메서드
    private static Bound calculateBound(Block block) {
    int xmin = Integer.MAX_VALUE;
    int xmax = Integer.MIN_VALUE;
    int ymin = Integer.MAX_VALUE;
    int ymax = Integer.MIN_VALUE;

    for (Square square : block.getSquares()) {
        Point upperLeft = square.getUpperLeft();
        Point lowerRight = square.getLowerRight();
        xmin = Math.min(xmin, upperLeft.getX());
        xmax = Math.max(xmax, lowerRight.getX());
        ymin = Math.min(ymin, upperLeft.getY());
        ymax = Math.max(ymax, lowerRight.getY());
        }

        return new Bound(xmin, xmax, ymin, ymax);
    }