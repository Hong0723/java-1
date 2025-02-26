import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BlockManager extends JPanel implements ActionListener, KeyListener {

    private final int BOARD_WIDTH = 10; // 게임 보드의 넓이
    private final int BOARD_HEIGHT = 22; // 게임 보드의 높이
    private final int PERIOD_INTERVAL = 300; // 타이머 간격 
    private final int BLOCK_SIZE = 50; // 블록 크기

    private Timer timer; // 게임 루프 타이머
    private boolean isFallingFinished = false; // 블록이 떨어지는것이 끝났는지에 대한 여부
    private boolean isStarted = false; // 게임이 시작됐는지에 대한 여부
    private boolean isPaused = false; // 게임이 멈췄는지에 대한 여부
    private int numLinesRemoved = 0; // 제거된 라인의 수 
    private int curX = 0; // 현재 블록의 X 좌표
    private int curY = 0; // 현재 블록의 Y 좌표
    private Block curPiece; // 현재 블록 객체
    private BlockType[] board; // 게임 보드 배열
    private JLabel statusbar; // 상태 표시줄
    // (your code 추가)
    private JLabel scorebar;
    private int score;
    // (BlockEvent 관련 멤버 추가)
    private ArrayList<BlockEvent>playBlockLogs; // 블록 이벤트 로그 목록   
    private BlockEvent curPieceLog; // 현재 블록 이벤트 로그
    private ArrayList<String> curPieceLogActions; // 현재 블록 이벤트 로그에 대한 액션 목록

    public BlockManager(Lab5MainFrame parent) { // 생성자 
        setFocusable(true);
        curPiece = new Block(); // 새로운 블록 생성
        timer = new Timer(PERIOD_INTERVAL, this); // 타이머 생성
        timer.start();
        statusbar = parent.getStatusBar(); // 부모프레임으로 부터 상태표시줄 가져옴

        // (your code 추가) 점수판을 북쪽에 위치하도록 설정 , 점수 초기값을 0으로 설정
        scorebar = new JLabel("SCORE: 0");
        parent.add(scorebar,BorderLayout.NORTH);


        board = new BlockType[BOARD_WIDTH * BOARD_HEIGHT]; // 보드 배열 초기화
        addKeyListener(this); // 키 리스너 추가 
        clearBoard(); // 보드 초기화
        // (추가)
        playBlockLogs = new ArrayList<>(); // 블록 이벤트 로그 목록 초기화
    }

    private int squareWidth() { // 블록 넓이 반환
        return BLOCK_SIZE;
    }

    private int squareHeight() { // 블록 높이 반환
        return BLOCK_SIZE;  
    }

    private BlockType typeAt(int x, int y) { // 주어진 좌표의 블록 타입을 반환
        return board[(y * BOARD_WIDTH) + x];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isFallingFinished) { // IF문을 사용해 블록이 바닥에 떨어진다면 새로운 블록 생성
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();  // 블록이 아직 바닥에 안떨어졌다면 한칸 아래로 이동
        }
    }

    public void start() { // 게임 시작
        if (isPaused) return;
        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0; 
        score = 0 ;
        updateScore();
        clearBoard(); // 보드 초기화

        newPiece(); // 새로운 블록 생성
        timer.start();
    }

    private void pause() { // 게임 일시정지
        if (!isStarted) return;
        isPaused = !isPaused;
        if (isPaused) {
            timer.stop();
            statusbar.setText("paused");
        } else {
            timer.start();
            statusbar.setText(String.valueOf(numLinesRemoved));
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g); // 그래픽을 그림
    }

    private void doDrawing(Graphics g) {
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();

        for (int i = 0; i < BOARD_HEIGHT; ++i) { // 보드의 각 블록을 그림
            for (int j = 0; j < BOARD_WIDTH; ++j) {
                BlockType shape = typeAt(j, BOARD_HEIGHT - i - 1);
                if (shape != BlockType.NONE)
                    drawSquare(g, 0 + j * squareWidth(), boardTop + i * squareHeight(), shape.getColor());
            }
        }

        if (curPiece.getType() != BlockType.NONE) { // 현재 블록을 그림
            for (int i = 0; i < 4; ++i) {
                int x = curX + curPiece.getX(i);
                int y = curY - curPiece.getY(i);
                drawSquare(g, 0 + x * squareWidth(), boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(), curPiece.getType().getColor());
            }
        }
    }

    private void dropDown() { // 블록을 맨아래로 떨어뜨림
        int newY = curY;
        while (newY > 0) {
            if (!tryMove(curPiece, curX, newY - 1)) break;
            --newY;
        }
        pieceDropped();
        
    }

    private void oneLineDown() { // 블록을 한줄 아래로 이동시킴
        if (!tryMove(curPiece, curX, curY - 1))
            pieceDropped();
    }

    private void clearBoard() { // 보드를 초기화
        for (int i = 0; i < BOARD_HEIGHT * BOARD_WIDTH; ++i)
            board[i] = BlockType.NONE;
    }

    private void pieceDropped() { // 블록이 떨어졌을때 처리
        for (int i = 0; i < 4; ++i) {
            int x = curX + curPiece.getX(i);
            int y = curY - curPiece.getY(i);
            board[(y * BOARD_WIDTH) + x] = curPiece.getType();
        }

        removeFullLines(); // 꽉 찬 라인은 제거

        if (!isFallingFinished)
            newPiece(); // 새로운 블록 생성
    }
    
    private void newPiece() { // 새로운 블록 생성
        curPiece.setType(BlockType.getRandom());
        curPieceLogActions = new ArrayList<>(); // 새로운 액션 로그 초기화
        curX = BOARD_WIDTH / 2 + 1;
        curY = BOARD_HEIGHT - 1 + curPiece.minY();

        if (!tryMove(curPiece, curX, curY)) { // 블록이 보드에 들어갈 수 없을때 게임 오버 처리
            curPiece.setType(BlockType.NONE);
            timer.stop();
            isStarted = false;
            statusbar.setText("game over");
            // (추가)
            System.out.println("Game Over - Print Piece of played blocks");
            for(BlockEvent event : playBlockLogs) { // 전체 로그 출력
                System.out.println(event);
            }
            // (your code 추가) 점수 표시
            System.out.println("Your Tetris score is " + score);
        }
        // (추가)
        curPieceLog = new BlockEvent("NEW_PIECE", curPiece.getType(), curPieceLogActions);
        playBlockLogs.add(curPieceLog); // 이벤트 로그에 추가
    }

    private boolean tryMove(Block newPiece, int newX, int newY) { // 블록을 새로운 위치로 이동 시도
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.getX(i);
            int y = newY - newPiece.getY(i);
            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT)
                return false;
            if (typeAt(x, y) != BlockType.NONE)
                return false;
        }

        curPiece = newPiece;
        curX = newX;
        curY = newY;
        repaint();
        return true;
    }

    private void removeFullLines() { // 꽉 찬 라인 제거
        int numFullLines = 0;

        for (int i = BOARD_HEIGHT - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < BOARD_WIDTH; ++j) {
                if (typeAt(j, i) == BlockType.NONE) { 
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) { // 라인이 꽉 찬 경우 처리
                ++numFullLines;
                for (int k = i; k < BOARD_HEIGHT - 1; ++k) {
                    for (int j = 0; j < BOARD_WIDTH; ++j)
                        board[(k * BOARD_WIDTH) + j] = typeAt(j, k + 1);
                }
            }
        }

        if (numFullLines > 0) { // 제거된 라인이 있을 경우 처리
            numLinesRemoved += numFullLines;
            score += numFullLines * 100; // (your code 추가) (라인이 하나 지워질때마다 스코어 100 증가)
            updateScore(); // 점수 업데이트
            statusbar.setText(String.valueOf(numLinesRemoved));
            isFallingFinished = true;
            curPiece.setType(BlockType.NONE);
            // (추가)
            playBlockLogs.add(new BlockEvent("REMOVE_FULL_LINE", null, null));  
            repaint();
        }
    }   
    // (your code 추가)
    private void updateScore() { // 점수 업데이트 메소드
        scorebar.setText("SCORE: " + score);
    }

    private void drawSquare(Graphics g, int x, int y, Color color) { // 주어진 위치에 그림을 그림
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keycode = e.getKeyCode();

        if (!isStarted && keycode == KeyEvent.VK_ESCAPE) {
            start(); // ESC 키를 누르면 게임 시작
        }

        if (!isStarted || curPiece.getType() == BlockType.NONE) {
            return;               
        }

        if (keycode == 'p' || keycode == 'P') { // P키를 누르면 게임이 일시정지
            pause();
            return;
        }

        if (isPaused)
            return;
        // (추가)
        switch (keycode) { // 키 입력에 따른 블록 이동 및 회전 처리
            case KeyEvent.VK_LEFT:
                tryMove(curPiece, curX - 1, curY);
                curPieceLogActions.add("MOVE_LEFT"); // 게임이 끝나고 왼쪽 이동 로그 추가
                break;
            case KeyEvent.VK_RIGHT:
                tryMove(curPiece, curX + 1, curY);
                curPieceLogActions.add("MOVE_RIGHT"); // 게임이 끝나고 오른쪽 이동 로그 추가
                break;
            case KeyEvent.VK_DOWN:
                tryMove(curPiece.rotateRight(), curX, curY);
                curPieceLogActions.add("ROTATE_RIGHT"); // 게임이 끝나고 오른쪽 회전 로그 추가
                break;
            case KeyEvent.VK_UP:
                tryMove(curPiece.rotateLeft(), curX, curY); // 게임이 끝나고 왼쪽 회전 로그 추가
                curPieceLogActions.add("ROTATE_LEFT");
                break;
            case KeyEvent.VK_SPACE:  // 스페이스바를 누르면 블록을 맨 아래로 떨어뜨림
                curPieceLogActions.add("DROP_DOWN");    
                dropDown();
                break;
            case KeyEvent.VK_D:
                oneLineDown(); // D키를 누를시에 블록을 한칸 아래로 이동시킴
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
    