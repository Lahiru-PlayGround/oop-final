package lk.ijse.dep.service;

public class AiPlayer extends Player{

    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
        int raColumn = Coloum.findColoum();
        int reRow;
        do{

            raColumn = (int) (Math.random() *6);

        }while (!board.isLegalMove(raColumn));
        board.updateMove(raColumn,Piece.GREEN);
        board.getBoardUI().update(raColumn,false);
        Winner winner=board.findWinner();
        System.out.println(winner.getWinningPiece());
        if(winner.getWinningPiece().equals(Piece.GREEN)){
            board.getBoardUI().notifyWinner(winner);
        }else{
            if(!board.existLegalMoves()){
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        }
    }
    private static class Coloum{
        //int
        private static int findColoum(){
            return 1;
        }
    }
}
