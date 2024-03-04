package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces;
    private final BoardUI boardUi;

    public BoardImpl(BoardUI boardUi){

        this.boardUi=boardUi;
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        for(int i=0;i<NUM_OF_COLS;i++){
            for(int j=0;j<NUM_OF_ROWS;j++){
                pieces[i][j]=Piece.EMPTY;
            }
        }


    }

    @Override
    public BoardUI getBoardUI() {
        return boardUi;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for(int i = 0;i<NUM_OF_ROWS;i++){
            if(pieces[col][i]==Piece.EMPTY) return i;
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        if(findNextAvailableSpot( col)==-1){
            return false;
        }
        return true;
    }

    @Override
    public boolean existLegalMoves() {
       for(int i=0;i<NUM_OF_COLS;i++){
            for(int j=0;j<NUM_OF_ROWS;j++){
                if(pieces[i][j]==Piece.EMPTY) return true;
            }
        }
       return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        for(int i=0;i<NUM_OF_ROWS;i++){
            if(pieces[col][i]==Piece.EMPTY){
                pieces[col][i]=move;
                break;
            }

        }
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row]= move;
    }

    @Override
    public Winner findWinner() {

//        for (int i = 0; i < NUM_OF_COLS; i++) {
//            for (int j = 0; j <= 1; j++) {
//                if ( ( (pieces[i][j] == Piece.GREEN) && (pieces[i][j + 1] == Piece.GREEN) ) && ( (pieces[i][j + 2] == Piece.GREEN) && (pieces[i][j + 3] == Piece.GREEN))) {
//                    return new Winner(Piece.GREEN, i , j , i , (j+3));
//                } if (((pieces[i][j] == Piece.BLUE) && (pieces[i][j + 1] == Piece.BLUE)) && ( (pieces[i][j + 2] == Piece.BLUE) && (pieces[i][j + 3] == Piece.BLUE)) ){
//                    System.out.println("2");
//                    return new Winner(Piece.BLUE, i , j , i , (j+3));
//                }
//            }
//        }
//        for (int i = 0; i <= 2; i++) {
//            for (int j = 0; j < NUM_OF_ROWS; j++) {
//                if (((pieces[i][j] == Piece.GREEN) && (pieces[i + 1][j] == Piece.GREEN)) && ((pieces[i + 2][j] == Piece.GREEN) && (pieces[i + 3][j] == Piece.GREEN))) {
//                    System.out.println("3");
//                    return new Winner(Piece.GREEN, i , j , (i+3) , j);
//                } if (((pieces[i][j] == Piece.BLUE) && (pieces[i + 1][j] == Piece.BLUE)) && ((pieces[i + 2][j] == Piece.BLUE) && (pieces[i + 3][j] == Piece.BLUE)) ){
//                    System.out.println("4");
//                    return new Winner(Piece.BLUE, i , j , (i+3) , j);
//                }
//            }
//        }
//        return new Winner(Piece.EMPTY);
//    }
//        int count =0;
//        for (int i=0;i<NUM_OF_COLS;i++){
//            count=0;
//            for (int j=0;j<NUM_OF_ROWS-1;j++){
//                if(pieces[i][j]==pieces[i][j+1]){
//                    count++;
//                } else  {
//                    count=0;
//
//                }
//                if(count==3 && pieces[i][j]!=Piece.EMPTY){
//                    System.out.println("111111111111");
//                    System.out.println((new Winner(pieces[i][j],i,(j-3),i,j)).getWinningPiece());
//                    return new Winner(pieces[i][j],i,(j-3),i,j);
//                }
//
//            }
//
//        }
//        for(int i=0;i<NUM_OF_ROWS;i++){
//            count=0;
//            for (int j=0;j<NUM_OF_COLS-1;j++){
//                if(pieces[j][i]==pieces[j+1][i]){
//                    count++;
//                }else {
//                    count=0;
//                }
//                if(count==3 && pieces[j][i]!=Piece.EMPTY){
//                    System.out.println("22222222222222222");
//                    return new Winner(pieces[j][i],(j-3),i,j,i);
//                }
//            }
//        }

//        return new Winner(Piece.EMPTY);
        for(int i =0;i<NUM_OF_COLS;i++){
            int count =0;

           for(int j = 1;j<NUM_OF_ROWS;j++){
               if(pieces[i][j]==Piece.EMPTY) break;
               if(pieces[i][j]==pieces[i][j-1]){
                   count++;
                   if (count==3) return new Winner(pieces[i][j],i,j-3,i,j);
               }else {
                   count=0;
               }

           }
        }
        for(int i =0;i<NUM_OF_ROWS;i++){
            int count =0;

            for(int j = 1;j<NUM_OF_COLS;j++){
                //if(pieces[j][i]==Piece.EMPTY) break;
                if(pieces[j][i]==pieces[j-1][i]){
                    count++;
                    if (count==3 && pieces[j][i]!=Piece.EMPTY) return new Winner(pieces[j][i],j-3,i,j,i);
                }else {
                    count=0;
                }

            }
        }
        return new Winner(Piece.EMPTY);
    }

}
