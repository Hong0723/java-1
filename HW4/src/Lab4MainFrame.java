import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab4MainFrame extends JFrame implements KeyListener { // Lab4MainFrame 클래스는 JFrame을 상속받고 KeyListener를 구현
	private JPanel displayPanel = null; // 블록을 표시할 패널
	private BlockManager blockManager = null; // 블록 관리 객체
	private int selectedIndex = 0; //선택된 블록의 인덱스

	public Lab4MainFrame(String title) { //Lab4MainFrame 생성자
		super(title); // JFrame 생성자를 호출하여 제목 설정
		blockManager = new BlockManager();	//BlockManager 객체 생성
		blockManager.start(); // BlockManager의 타이머 시작
		displayPanel = new JPanel(new BorderLayout()); // BorderLayout를 사용하는 JPanel 생성
		displayPanel.add(blockManager, BorderLayout.CENTER); // BlockManager를 중앙에 추가
		displayPanel.addKeyListener(this); // KeyListener 추가
		displayPanel.setFocusable(true);  // displayPanel을 포커스 받을 수 있도록 설정 
		displayPanel.requestFocusInWindow(); // displayPanel에 포커스 요청
		this.getContentPane().add(displayPanel); // diplayPanel을 JFrame의 컨텐트페인에 추가
 
		this.setSize(600, 600); // JFrame의 크기를 600x600으로 설정
		this.setVisible(true); // JFrame을 화면에 표시
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭시 프로그램 종료
	}

	@Override
	public void keyTyped(KeyEvent e) { 
	}

	@Override
	public void keyPressed(KeyEvent e) { // 키가 눌렸을때 호출됨
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {  // 오른쪽 화살표 키 처리
            blockManager.translate(selectedIndex, 5.0, 0.0);  // 선택된 블록을 오른쪽으로 5만큼 이동
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {  // 왼쪽 화살표 키 처리
            blockManager.translate(selectedIndex, -5.0, 0.0);  // 선택된 블록을 왼쪽으로 5만큼 이동
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {  // 위쪽 화살표 키 처리
            blockManager.translate(selectedIndex, 0.0, -5.0);  // 선택된 블록을 위로 5만큼 이동
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {  // 아래쪽 화살표 키 처리
            blockManager.translate(selectedIndex, 0.0, 5.0);  // 선택된 블록을 아래로 5만큼 이동
        } else if (e.getKeyCode() == KeyEvent.VK_1) { // 숫자 1키 처리
			selectedIndex = 0; // 첫번째 블록 선택
		} else if (e.getKeyCode() == KeyEvent.VK_2) { // 숫자 2키 처리
			selectedIndex = 1; // 두번째 블록 선택
		} else if (e.getKeyCode() == KeyEvent.VK_3) { // 숫자 3키 처리
			selectedIndex = 2; // 세번째 블록 선택
		} else if (e.getKeyCode() == KeyEvent.VK_4) { // 숫자 4키 처리
			selectedIndex = 3; // 네번째 블록 선택
		}
		
		blockManager.collide(); // 블록끼리의 충돌 체크
		displayPanel.revalidate(); // 화면 갱신 요청
		displayPanel.repaint(); // 화면 갱신
	}

	@Override
	public void keyReleased(KeyEvent e) { // 키가 릴리즈 될때 호출
	}

    public static void main(String[] args) { // Lab4MainFrame 객체 생성 및 실행
        new Lab4MainFrame("Block");
    }
}
 