import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game2048 extends JFrame {

    private static final int SIZE = 4;
    private int[][] board;
    private JLabel[][] labels;

    public Game2048() {
        setTitle("2048 Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        initializeBoard();
        addKeyListener(new ArrowKeyListener());
        setFocusable(true);

        spawnRandomTile();
        spawnRandomTile();
        updateUI();

        setVisible(true);
    }

    private void initializeBoard() {
        board = new int[SIZE][SIZE];
        labels = new JLabel[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
                labels[i][j] = new JLabel("", SwingConstants.CENTER);
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(labels[i][j]);
            }
        }
    }

    private void spawnRandomTile() {
        Random random = new Random();
        int value = random.nextInt(10) < 9 ? 2 : 4;
        int row, col;

        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (board[row][col] != 0);

        board[row][col] = value;
    }

    private void updateUI() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                labels[i][j].setText(board[i][j] == 0 ? "" : String.valueOf(board[i][j]));
            }
        }
    }

    private boolean moveUp() {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 1; i < SIZE; i++) {
                if (board[i][j] != 0) {
                    int k = i;
                    while (k > 0 && board[k - 1][j] == 0) {
                        board[k - 1][j] = board[k][j];
                        board[k][j] = 0;
                        k--;
                        moved = true;
                    }
                    if (k > 0 && board[k - 1][j] == board[k][j]) {
                        board[k - 1][j] *= 2;
                        board[k][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveDown() {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            for (int i = SIZE - 2; i >= 0; i--) {
                if (board[i][j] != 0) {
                    int k = i;
                    while (k < SIZE - 1 && board[k + 1][j] == 0) {
                        board[k + 1][j] = board[k][j];
                        board[k][j] = 0;
                        k++;
                        moved = true;
                    }
                    if (k < SIZE - 1 && board[k + 1][j] == board[k][j]) {
                        board[k + 1][j] *= 2;
                        board[k][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    int k = j;
                    while (k > 0 && board[i][k - 1] == 0) {
                        board[i][k - 1] = board[i][k];
                        board[i][k] = 0;
                        k--;
                        moved = true;
                    }
                    if (k > 0 && board[i][k - 1] == board[i][k]) {
                        board[i][k - 1] *= 2;
                        board[i][k] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean moveRight() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 2; j >= 0; j--) {
                if (board[i][j] != 0) {
                    int k = j;
                    while (k < SIZE - 1 && board[i][k + 1] == 0) {
                        board[i][k + 1] = board[i][k];
                        board[i][k] = 0;
                        k++;
                        moved = true;
                    }
                    if (k < SIZE - 1 && board[i][k + 1] == board[i][k]) {
                        board[i][k + 1] *= 2;
                        board[i][k] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private class ArrowKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    if (moveTiles(keyCode)) {
                        spawnRandomTile();
                        updateUI();
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}

        private boolean moveTiles(int direction) {
            boolean moved = false;

            switch (direction) {
                case KeyEvent.VK_UP:
                    moved = moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    moved = moveDown();
                    break;
                case KeyEvent.VK_LEFT:
                    moved = moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    moved = moveRight();
                    break;
            }

            return moved;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game2048::new);
    }
}
