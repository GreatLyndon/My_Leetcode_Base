class Solution {
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] cells = new int[9];
    private char[][] board;
    private int bitmask = (1 << 9) - 1;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                int num = (int) (c - '1');
                int bitPos = 1 << num;
                rows[i] |= bitPos;
                cols[j] |= bitPos;
                cells[(i / 3) * 3 + j / 3] |= bitPos;
            }
        dfs(0, 0);
    }

    private boolean dfs(int r, int c) {
        while (r < 9 && board[r][c] != '.')
            if (c == 8) {
                r++;
                c = 0;
            } else
                c++;
        if (r == 9)
            return true;
        int bitCombo = rows[r] | cols[c] | cells[(r / 3) * 3 + c / 3];
        if (bitCombo == 511)
            return false;
        int cands = bitmask & ~bitCombo;
        for (int i = 0; i < 9; i++) {
            int bitPos = 1 << i;
            if ((cands & bitPos) > 0) {
                board[r][c] = (char) ('1' + i);
                rows[r] |= bitPos;
                cols[c] |= bitPos;
                cells[(r / 3) * 3 + c / 3] |= bitPos;
                int nextR = c == 8 ? r + 1 : r;
                int nextC = c == 8 ? 0 : c + 1;
                if (dfs(nextR, nextC))
                    return true;
                rows[r] &= ~bitPos;
                cols[c] &= ~bitPos;
                cells[(r / 3) * 3 + c / 3] &= ~bitPos;
                board[r][c] = '.';
            }
        }
        return false;
    }
}
