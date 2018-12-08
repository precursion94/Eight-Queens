public class Queen {
    private int row;
    private int col;

    public Queen(int row, int col) {
        this.row  = row;
        this.col = col;
    }

   public int getRow() {
        return row;
   }
   public int getCol() {
        return col;
   }

   @Override
   public boolean equals(Object other) {
       Queen otherQueen = (Queen) other;
        if(this.row == otherQueen.row && this.col == otherQueen.col)
            return true;
        return false;
   }
}
