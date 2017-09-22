import javax.swing.*;
import java.awt.*;

public class Main {

    private static ChessBoard chessBoard = new ChessBoard();
    public static void main(String[] args) {
        chessBoard.initWindow();
        chessBoard.initChessBoard();
    }
}
