import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BlockManager extends JPanel implements ActionListener { // BlockManager 클래스는 JPanel을 상속받고 ActionListener를 구현
    private Timer timer = null; // 타이머 객체 선언
    private final static int DELAY = 500; // 타이머 지연 시간 설정    
    private Block[] blocks = new Block[4]; // 블록 배열 선언 및 초기화

    public BlockManager() { // BlockManager 생성자
        timer = new Timer(DELAY, this); // 타이머 생성 
        this.setDoubleBuffered(true); // 더블 버퍼링 활성화 (화면 깜빡임 방지)
        
        // 블록 배열 초기화
        blocks[0] = BlockFactory.getInstance(BlockType.RED_BLOCK, 50.0, 0.0); // RED_BLOCK 타입 블록 생성
        blocks[1] = BlockFactory.getInstance(BlockType.TEAL_BLOCK, 180.0, 10); // TEAL_BLOCK 타입 블록 생성
        blocks[2] = BlockFactory.getInstance(BlockType.DOGERS_BLUE_BLOCK, 70.0, 170.0); // DOGERS_BLUE_BLOCK 타입 블록 생성
        blocks[3] = BlockFactory.getInstance(RandomUtils.randomBlockType(), 
        RandomUtils.randomDouble(200.0,400.0), RandomUtils.randomDouble(20.0,40.0)); // 랜덤 타입 블록 생성
    }
   
    public void translate(int index, double dx, double dy) { // 블록을 이동시키는 메소드
        blocks[index].translate(dx, dy);
    }

    public void collide() { // 블록 충돌 체크 메소드
        for (Block block : blocks) {
            for (Block otherBlock : blocks) {
                if (block != otherBlock && block.collideWith(otherBlock)) { // 블록이 다른 블록과 충돌하는지 확인
                    System.out.println(block.getType() + " collide with " + otherBlock.getType()); // 블록이 서로 충돌시 충돌 블록 정보 출력
                    System.out.println();
                } 
            }
        }
    }
    
    @Override  
    public void paintComponent(Graphics g) { // 블록을 그리는 메소드 
        super.paintComponent(g); // JPanel의 paintComponent 호출
        Graphics2D g2 = (Graphics2D) g; // Graphics 객체를 Graphics2D로 캐스팅 
        for (var block : blocks) {    
            if (block != null) block.draw(g2); // 블록이 null이 아니면 블록을 그림
        }
    }    

    
    @Override // 타이머 이벤트가 발생할 때 호출되는 메서드
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i< blocks.length; i++) {            
            translate(i, RandomUtils.randomInt(-1, 2), RandomUtils.randomInt(1, 5));
        }
        // 하단 경계선 체크
        collide(); // 충돌 체크
        repaint(); // 화면 갱신
   }

    // 타이머 시작 메소드 
    public void start() {
		if (timer.isRunning())  // 타이머가 실행 중이면
			timer.restart();    //  타이머를 재시작
		else 
		    timer.start();  // 타이머를 시작
	}

    // 타이머 정지 메소드 
	public void stop() {
        timer.stop();   // 타이머를 정지
	}
}