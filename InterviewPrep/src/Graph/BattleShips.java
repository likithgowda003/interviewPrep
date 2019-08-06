package Graph;

// https://leetcode.com/problems/battleships-in-a-board/
// get number of battleships in a board
public class BattleShips {
	
	// look for the leftmost X and topmost X
	// i.e, We can check for first cells by only counting cells that do not have an 'X' to the left and do not have an 'X' above them.
	public int countBattleships(char[][] board) {
		int m = board.length;
        int n = board[0].length;
        int count =0;
        if (m==0) return 0;
        
        for(int i=0;i<m;i++) {
        		for(int j=0;j<n;j++) {
        			// ignore if '.'
        			if(board[i][j] == '.')
        				continue;
        			// ignore if previous element(left) was 'X'
        			if(i>0 && board[i-1][j] == 'X')
        				continue;
        			// ignore if previous element(top) was 'X'
        			if(j>0 && board[i][j-1] == 'X')
        				continue;
        			
        			count++;
        		}
        }
        return count;
    }
}
