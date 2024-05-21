package games.escampe;

import games.otherGame.otherGameMove;
import games.otherGame.otherGameRole;
import iialib.games.model.IBoard;
import iialib.games.model.Score;

import java.io.*;
import java.util.ArrayList;

public class EscampeBoard implements IBoard<EscampeMove, EscampeRole, EscampeBoard> {
	// ---------------------- Attributes ---------------------
	private static final int BOARD_SIZE = 6;
	private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];

	public EscampeBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = "empty";
			}
		}
	}

	public EscampeBoard(EscampeBoard other) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.arraycopy(other.board[i], 0, this.board[i], 0, BOARD_SIZE);
		}
	}

	public void setFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			int row = 0;
			while ((line = br.readLine()) != null && row < 6) {
				board[row] = line.split(" ");
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveToFile(String fileName) {
		try (PrintWriter out = new PrintWriter(fileName)) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					out.print(board[i][j] + (j == 5 ? "" : " "));
				}
				out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// --------------------- IBoard Methods ---------------------

	@Override
	public ArrayList<EscampeMove> possibleMoves(EscampeRole playerRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EscampeBoard play(EscampeMove move, EscampeRole playerRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidMove(EscampeMove move, EscampeRole playerRole) {
		if (move.equals("E")) {
			// Vérifier si le joueur est réellement bloqué et doit passer son tour
			return true;
		}

		String[] parts = move.toString().split("-");
		if (parts.length == 2) { // Format B1-D1
			String start = parts[0];
			String end = parts[1];
			int startRow = start.charAt(1) - '1';
			int startCol = start.charAt(0) - 'A';
			int endRow = end.charAt(1) - '1';
			int endCol = end.charAt(0) - 'A';

			// Vérifier la validité de la position initiale et finale
			if (board[startRow][startCol] == null || board[endRow][endCol] != null) {
				return false;
			}

			// Vérifier le joueur, la pièce et la possession
			if (!board[startRow][startCol].startsWith(player.substring(0, 1))) {
				return false;
			}

			// Vérifier le liseré et la distance
			int distance = Math.abs(endRow - startRow) + Math.abs(endCol - startCol);
			String liseré = board[startRow][startCol].substring(1); // Supposons que le liseré est codé dans la pièce
			int maxDistance = Integer.parseInt(liseré); // Supposons que liseré "simple" = "1", etc.

			if (distance > maxDistance) {
				return false;
			}

			// Plus de logique pour le mouvement linéaire sans sauter les pièces, etc.
			// ...

			return true;
		} else if (move.toString().contains("/")) { // Format initial C6/A6/B5/D5/E6/F5
			// Implémenter la logique pour le placement initial des pièces
			return true; // Simplement pour l'exemple, doit être implémenté correctement
		}

		return false;
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Score<EscampeRole>> getScores() {
		// TODO Auto-generated method stub
		return null;
	}

	// --------------------- Other Methods ---------------------

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	
}
