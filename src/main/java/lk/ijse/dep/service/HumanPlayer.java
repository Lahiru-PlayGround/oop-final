package lk.ijse.dep.service;

public class HumanPlayer extends Player{

    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
        if(board.isLegalMove(col)){
            board.updateMove(col,Piece.BLUE);
            board.getBoardUI().update (col, true);
            Winner winner1 =board.findWinner();
            System.out.println(winner1.getWinningPiece());
            if(winner1.getWinningPiece().equals(Piece.BLUE)){
                board.getBoardUI().notifyWinner(winner1);
                }
            }else{
                if(!board.existLegalMoves()){
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        }

    }
}
