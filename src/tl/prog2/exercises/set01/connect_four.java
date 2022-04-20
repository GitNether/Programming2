package tl.prog2.exercises.set01;

import java.util.Scanner;

public class connect_four {

    char board[][] = new char[7][6];
    boolean player = true;
    boolean stop = false;
    char winner;

    public static void main(String[] args) {
        connect_four cf = new connect_four();
        cf.initBoard();
        cf.printBoard();

        cf.startGame();
    }

    public void startGame(){
        while(!stop) {
            int col = getInput();
            int row = getRow(col);
            if (player) { // Player X
                setX(col, row);
            } else {  // Player O
                setO(col, row);
            }
            printBoard();
            player = !player;
            checkend();
        }
        System.out.println("Game over!");
        if(winner=='O'){
            System.out.println("Player O wins!");
        }else if(winner=='X'){
            System.out.println("Player X wins!");
        }else{
            System.out.println("Tie!");
        }
    }

    public void checkend(){
        for(int i=0;i<7;i++){
            checkWinCol(i);
        }
        for(int j=0;j<6;j++){
            checkWinRow(j);
        }
        checkWinDiagR();
        checkWinDiagL();
        if(!checkCol(0)&&!checkCol(1)&&!checkCol(2)&&!checkCol(3)&&!checkCol(4)&&!checkCol(5)&&!checkCol(6)){
            stop = true;
        }
    }

    public void checkWinDiagL(){
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(isX(6-i,5-j)&&isX(5-i,4-j)&&isX(4-i,3-j)&&isX(3-i,2-j)){
                    stop = true;
                    winner = 'X';
                }
                if(isO(6-i,5-j)&&isO(5-i,4-j)&&isO(4-i,3-j)&&isO(3-i,2-j)){
                    stop = true;
                    winner = 'O';
                }
            }
        }
    }

    public void checkWinDiagR(){
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(isX(0+i,5-j)&&isX(1+i,4-j)&&isX(2+i,3-j)&&isX(3+i,2-j)){
                    stop = true;
                    winner = 'X';
                }
                if(isO(0+i,5-j)&&isO(1+i,4-j)&&isO(2+i,3-j)&&isO(3+i,2-j)){
                    stop = true;
                    winner = 'O';
                }
            }
        }
    }

    public void checkWinRow(int row){
        for(int i=0;i<4;i++){
            if(isX(i,row)&&isX(i+1,row)&&isX(i+2,row)&&(isX(i+3,row))){
                stop = true;
                winner = 'X';
            }
            if(isO(i,row)&&isO(i+1,row)&&isO(i+2,row)&&(isO(i+3,row))){
                stop = true;
                winner = 'O';
            }
        }
    }

    public void checkWinCol(int col){
        for(int i=0; i<3;i++){
            if(isX(col,i)&&isX(col,i+1)&&isX(col,i+2)&&(isX(col,i+3))){
                stop = true;
                winner = 'X';
            }
            if(isO(col,i)&&isO(col,i+1)&&isO(col,i+2)&&(isO(col,i+3))){
                stop = true;
                winner = 'O';
            }
        }
    }

    public boolean isX(int col, int row){
        return board[col][row]=='X';
    }

    public boolean isO(int col, int row){
        return board[col][row]=='O';
    }

    public int getRow(int col){
        int row = 0;
        for(int i=0;i<6;i++){
            if(board[col][i]=='.'){
                row = i;
            }
        }
        return row;
    }

    public int getInput(){
        String p = "Error";
        if(player){p = "X";}else{p = "O";}
        System.out.println("Turn: Player " + p);
        System.out.print("Please enter a column number: ");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        while((input>6 || input<0)||(!checkCol(input))){
                System.out.println("Please enter a valid column number!");
                printBoard();
                System.out.print("Please enter a column number: ");
                input = scan.nextInt();
        }
        System.out.println();
        return input;
    }

    public boolean checkCol(int col){
        return board[col][0] == '.';
    }

    public void initBoard(){
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                board[i][j] = '.';
            }
        }
    }

    public void printBoard(){
        System.out.println("00 01 02 03 04 05 06");
        System.out.println("---------------------");
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                System.out.print(" " + board[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    public void setX(int col, int row){
        board[col][row] = 'X';
    }

    public void setO(int col, int row){
        board[col][row] = 'O';
    }
}
