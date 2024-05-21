package games.escampe;

import iialib.games.algs.IHeuristic;

public class EscampeHeuristics {
	public static IHeuristic<EscampeBoard, EscampeRole> heuristic = (board, role) -> {
		// Difference in number of possible moves
		return board.possibleMoves(role).size() - board.possibleMoves(role == EscampeRole.WHITE ? EscampeRole.BLACK : EscampeRole.WHITE).size();
	};
}