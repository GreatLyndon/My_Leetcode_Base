import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.') {
                    set.add(board[i][j]);
                    count++;
                }
            if(set.size() != count)
                return false;
            set.clear();
            count = 0;
            for (int j = 0; j < 9; j++)
                if (board[j][i] != '.') {
                    set.add(board[j][i]);
                    count++;
                }
            if (set.size() != count)
                return false;
            set.clear();
            count = 0;
            for (int j = 0; j < 9; j++)
                if (board[i / 3 * 3 + j / 3][j % 3 + i % 3 * 3] != '.') {
                    set.add(board[i / 3 * 3 + j / 3][j % 3 + i % 3 * 3]);
                    count++;
                }
            if (set.size() != count)
                return false;
            set.clear();
            count = 0;
        }
        return true;
    }
}
