package java2048;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    int size;
    Piece[][] board;
    long score;
    Random random = new Random();
    boolean isOver = false;
    
    public Game(int size)
    {
    	this.size = size;
    	board = new Piece[size][size];
    }
    // create piece
    public static Piece createAPiece()
    {
    	return new NumPiece();
    }

    /***
     * merge the piece(row) 2 2 0 0 -> 4 0 0 0
     * 
     * @param pieces 棋子数组
     */
    public void mergeRow(Piece[] pieces)
    {
    	compressRow(pieces);
    	for(int i = 0; i < pieces.length; i++)
    	{
    		if(i < 3)
    		{
    			Piece piece = pieces[i];
    			Piece rightPiece = pieces[i + 1];
    			
    			if(!piece.isBlank() && piece.equals(rightPiece)){
    				score = score + piece.expand();
    				rightPiece.setBlank();
    				compressRow(pieces);

	
}
    		}
    	}
    }
    /**
     * 
     * compress the pieces, for example: 2 0 0 2 -> 2 2 0 0
     * @param pieces
     */
	private void compressRow(Piece[] pieces) {
	    ArrayList<Piece> temp = new ArrayList<>();
	    for(int i = 0; i < pieces.length; i++)
	    {
	    	if(!pieces[i].isBlank())
	    	{
	    		temp.add(pieces[i]);
	    	}
	    }
		for(int i = 0; i < pieces.length; i++)
		{
			if(temp.size() > 1)
			{
				pieces[i] = temp.get(i);
			}else
			{
				pieces[i] = createAPiece();
			}
		}
	}
}
