public class Board {
    private Queen[][] board;
    private String coords;

    public Board(String coordinateString) {
        setBoardState(coordinateString);
    }
    
    public Board() {
    	
    }
    
    public Queen[][] getBoard() {
        return board;
    }

    public int getFitness() {
        //setBoardState(coordinateString);

        int totalCollisions =0;
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board.length; c++) {
               Queen queen = board[r][c];
               if(queen != null) {
                   totalCollisions += countQueenCollisions(queen);

//                       System.out.println("Collisions: "  + collisions);
              }
            }
        }
        return totalCollisions;
    }

    public int countQueenCollisions (Queen queen) {
        int counter = 0;

        if(!testUp(queen))
            counter++;
        if (!testDown(queen))
            counter++;
        if (!testRight(queen))
            counter++;
        if (!testLeft(queen))
            counter++;
        if(!testUpRight(queen))
            counter++;
        if (!testUpLeft(queen))
            counter++;
        if (!testDownRight(queen))
            counter++;
        if (!testDownLeft(queen))
            counter++;

        return counter;
    }
//  true = no collisions; false = collision
    public boolean testUp(Queen queen) {
        if(queen.getRow() == 7) {
            return true;
        }
        for(int r = queen.getRow()+1; r < 8; r++) {
            if(board[r][queen.getCol()] != null)
                return false;
        }
        return true;
    }
    public boolean testDown(Queen queen) {
        if(queen.getRow() == 0) {
            return true;
        }
        for(int r = queen.getRow()-1; r >= 0; r--) {
            if(board[r][queen.getCol()] != null)
                return false;
        }
        return true;
    }

    public boolean testRight(Queen queen) {
        if(queen.getCol() == 7) {
            return true;
        }
       for(int c = queen.getCol()+1; c < 8; c++) {
            if(board[queen.getRow()][c] != null)
                return false;
        }
        return true;
    }

    public boolean testLeft(Queen queen) {
        if(queen.getCol() == 0) {
            return true;
        }
        for(int c = queen.getCol()-1; c >= 0; c--) {
            if(board[queen.getRow()][c] != null)
                return false;
        }
        return true;
    }
    public boolean testUpRight(Queen queen) {
        if(queen.getRow() == 7 || queen.getCol() == 7) {
            return true;
        }
        for(int r = queen.getRow()+1; r < 8; r++) {
            for(int c = queen.getCol()+1; c < 8; c++) {
                if(board[r][c] != null)
                    return false;
            }
        }
        return true;
    }


    public boolean testUpLeft(Queen queen) {

        if(queen.getRow() == 7 || queen.getCol() == 0) {
            return false;
        }
        for(int r = queen.getRow()+1; r < 8; r++) {
            for(int c = queen.getCol()-1; c >= 0; c--) {
                if(board[r][c] !=null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean testDownRight(Queen queen) {
        if(queen.getRow() == 0 || queen.getCol() == 7) {
            return true;
        }
        for(int r = queen.getRow()-1; r >= 0; r--) {
            for(int c = queen.getCol()+1; c < 8; c++) {
                if(board[r][c] != null)
                    return false;
            }
        }
        return true;
    }

    public boolean testDownLeft (Queen queen) {

        if(queen.getRow() == 0 || queen.getCol() == 0) {
            return false;
        }
        for(int r = queen.getRow()-1; r >= 0; r--) {
            for(int c = queen.getCol()-1; c >= 0; c--) {
                if(board[r][c] !=null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setBoardState(String coordinateString) {
        this.board = new Queen[8][8];
        for(int col = 0; col < 8; col++) {
            String sRow = coordinateString.charAt(col) + "";
            int row = Integer.parseInt(sRow)-1;
            board[row][col] = new Queen(row,col);
        }
    }
}
