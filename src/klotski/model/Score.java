package klotski.model;

import klotski.model.Board;

public class Score {
    int score;
    long time;
    int config;
    int moves;

    final int MIN_MOVES_CONF_1 = 78;
    final int MIN_MOVES_CONF_2 = 24;
    final int MIN_MOVES_CONF_3 = 30;
    final int MIN_MOVES_CONF_4 = 118;
    final int MAX_SCORE = 100;

    final Board board;

    public Score(Board b) {
        this.board = b;
    }
    
    //riceve in ingresso il numero di mosse per la vittoria e il tempo in millisec impegato per vincere
    public int calculateScore() {
        switch(board.getConfig()) {
            case 1:
                if(board.getMoves() < MIN_MOVES_CONF_1) score = MAX_SCORE;
                else score = (MAX_SCORE - (board.getMoves() - MIN_MOVES_CONF_1));
            break;
            case 2:
                if(board.getMoves() < MIN_MOVES_CONF_2) score = MAX_SCORE;
                else score = (MAX_SCORE - (board.getMoves() - MIN_MOVES_CONF_2));
            break;
            case 3:
                if(board.getMoves() < MIN_MOVES_CONF_3) score = MAX_SCORE;
                else score = (MAX_SCORE - (board.getMoves() - MIN_MOVES_CONF_3));
            break;
            case 4:
                if(board.getMoves() < MIN_MOVES_CONF_4) score = MAX_SCORE;
                else score = (MAX_SCORE - (board.getMoves() - MIN_MOVES_CONF_4));
            break;
        }
        return score;
    };

    public String toString() {
		String out = "";
		out = out.concat(Integer.toString(config) + " ")
				.concat(Integer.toString(moves) + " ")
				.concat(Integer.toString(score) + " ")
				.concat(board.getTime());
		return out;
	}
}
