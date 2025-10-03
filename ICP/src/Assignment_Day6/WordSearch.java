public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (wordSearch(board, m, n, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean wordSearch(char[][] board, int m, int n, String word, int row, int col, int idx) {
        if (idx == word.length() - 1 && board[row][col] == word.charAt(idx)) {
            return true;
        }
        if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] != word.charAt(idx)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean flag = wordSearch(board, m, n, word, row + 1, col, idx + 1) ||
                       wordSearch(board, m, n, word, row - 1, col, idx + 1) ||
                       wordSearch(board, m, n, word, row, col - 1, idx + 1) ||
                       wordSearch(board, m, n, word, row, col + 1, idx + 1);

        board[row][col] = temp;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board1 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        System.out.println("ABCCED -> " + exist(board1, "ABCCED")); // true
        System.out.println("SEE -> " + exist(board1, "SEE"));       // true
        System.out.println("ABCB -> " + exist(board1, "ABCB"));     // false

        char[][] board2 = {
            {'A','B'},
            {'C','D'}
        };

        System.out.println("ACDB -> " + exist(board2, "ACDB"));     // true
    }
}
