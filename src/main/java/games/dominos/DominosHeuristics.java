package games.dominos;

import iialib.games.algs.IHeuristic;

public class DominosHeuristics {

	public static IHeuristic<DominosBoard,DominosRole>  hVertical = (board,role) -> {

		if(role == DominosRole.VERTICAL) {
			return board.nbHorizontalMoves() - board.nbVerticalMoves();
		}
		else {
			return board.nbVerticalMoves() - board.nbHorizontalMoves();
		}
	};


	public static IHeuristic<DominosBoard,DominosRole> hHorizontal = (board,role) -> {
		if(role == DominosRole.HORIZONTAL) {
			return board.nbHorizontalMoves() - board.nbVerticalMoves();
		}
		else {
			return board.nbVerticalMoves() - board.nbHorizontalMoves();
		}
	};

}
	