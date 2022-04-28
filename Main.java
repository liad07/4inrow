import java.util.Scanner;

public class Main {


    public static int isCOL(char player, char[][] board) {
        int counter =0;
        int  res=0;

        for (int col = 0; col < board[0].length; col++) {

            for (int row = 0; row < board.length; row++) {

                if (board[row][col]==player){
                    counter++;
                }
                else{
                    counter=0;
                }

            }
            if(counter==4){
                res=1;
            }

        }
        return res;
    }
    public static int isROW(char player, char[][] board) {
        int counter =0;
        int  res=0;
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col]==player){
                    counter++;
                }
                else{
                    counter=0;
                }

            }
            if(counter==4){
                res=1;
            }

        }
        return res;
    }

    public static boolean isWinner(char player, char[][] board) {
    return (isROW(player,board)==1||isCOL(player,board)==1);
    }

    public static boolean validate(int column, char[][] board) {
        if (column < 0 || column > board[0].length) {
            return false;
        }

        if (board[0][column] != ' ') {
            return false;
        }

        return true;
    }

    public static void prind_arr(char[][] board) {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("|");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }


    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int game = 0;
        int turn = 1;
        char player ;

        char[][] board = new char[6][7];
        char ch = '1';

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';

            }
        }
        boolean winner = false;
        while (!winner  && turn <= 42) {
            boolean validPlay;
            int play;
            do {
                prind_arr(board);
                if (turn%2==0){
                    player='y';
                }
                else {
                    player='r';
                }
                turn++;
                System.out.print("Player " + player + ", choose a column: ");
                play = reader.nextInt();

                validPlay = validate(play, board);

            } while (validPlay == false);

            for (int row = board.length - 1; row >= 0; row--) {
                if (board[row][play] == ' ') {
                    board[row][play] = player;
                    break;
                }
            }

             winner = isWinner(player,board);


        }
        prind_arr(board);
        if (turn%2==0){
            player='y';
        }
        else {
            player='r';
        }
        turn++;
        if (winner){
            if (player=='r'){
                System.out.println("Yellow won");
            }else{
                System.out.println("Red won");
            }
        }else{
            System.out.println("Tie game");
        }


    }


}