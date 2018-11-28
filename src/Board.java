public class Board {
    private Queen[][] board;

    public Board(String coordinateString) {

        this.board = new Queen[8][8];
        for(int col = 0; col < 8; col++) {
            int row = Integer.parseInt(coordinateString.charAt(col) + "");
            board[row][col] = new Queen();
        }
    }
    public Queen[][] getBoard() {
        return board;
    }

    public boolean testNewMove(String coordinateString) {
       return false;

    }

    //private boolean testUp(
}
