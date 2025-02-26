import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Lab5MainFrame extends JFrame {

    private JLabel statusbar; // 상태 표시줄

    public Lab5MainFrame() { // 생성자 : GUI 초기화 및 설정
        statusbar = new JLabel(" 0"); // 상태 표시줄 초기화 
        add(statusbar, BorderLayout.SOUTH); // 상태 표시줄을 프레임의 남쪽에 추가
        var board = new BlockManager(this); // BlockManager 인스턴스 생성
        add(board); // BlockManager를 프레임에 추가
        board.start(); // 게임 시작

        setTitle("Tetris"); // 프레임 제목 설정
        setSize(510, 1000); // 프레임 크기 설정 
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
        setLocationRelativeTo(null); // 프레임을 화면 중앙에 위치
    }

    public JLabel getStatusBar() { // 상태 표시줄을 반환하는 메소드
        return statusbar;
    }

    public static void main(String[] args) { // 메인 메소드 
        EventQueue.invokeLater(() -> {
            var game = new Lab5MainFrame();
            game.setVisible(true);
        });
    }
}
