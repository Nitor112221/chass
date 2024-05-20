import java.util.Scanner;

public class Main {
    public static final int WHITE = 1;
    public static final int BLACK = 2;

    public static int opponent(int color) {return color == WHITE ? BLACK : WHITE;}

    public static boolean correctCoords(int row, int col) {
        return (0 <= row && row < 8 && 0 <= col && col < 8);
    }

    public static void print_board(Board board) {
        System.out.println("     +----+----+----+----+----+----+----+----+");
        for (int row = 7; row > -1; row--) {
            System.out.print(" " + row + "  ");
            for (int col = 0; col < 8; col++) System.out.print(" | " + board.cell(row, col) + "");
            System.out.println(" |");
            System.out.println("     +----+----+----+----+----+----+----+----+");
        }
        System.out.print("        ");
        for (int col = 0; col < 8; col++) System.out.print(col + "    ");
        System.out.println();
    }

    public static void game() {
        Scanner in = new Scanner(System.in);
        Board board = new Board();
        while (true) {
            print_board(board);
            System.out.println("Команды:");
            System.out.println("    exit                               -- выход");
            System.out.println("    move <row> <col> <row1> <col1>     -- ход из клетки (row, col)");
            System.out.println("                                          в клетку (row1, col1)");
            System.out.println(board.current_player_color() == WHITE ? "Ход белых:" : "Ход чёрных:");
            String command = in.nextLine().trim();
            if (command.equals("exit")) break;
            String move_type = command.split(" ")[0];
            int row;
            int col;
            int row1;
            int col1;
            try {
                row = Integer.parseInt(command.split(" ")[1]);
                col = Integer.parseInt(command.split(" ")[2]);
                row1 = Integer.parseInt(command.split(" ")[3]);
                col1 = Integer.parseInt(command.split(" ")[4]);
            }
            catch (Exception e) {
                System.out.println(e.toString());
                continue;
            }
            if (board.movAndPromotePawn(row, col, row1, col1) || board.move_piece(row, col, row1, col1)) {
                System.out.println("Ход успешен");
            }
            else System.out.println("Ход говно, координаты не корректны! Попробуйте другой ход!");

        }
    }

    public static void main(String[] args) {
        game();
    }

}