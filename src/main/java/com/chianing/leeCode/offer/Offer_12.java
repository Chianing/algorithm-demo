package com.chianing.leeCode.offer;

/*
矩阵中的路径

给定一个m x n 二维字符网格board 和一个字符串单词word。如果word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false

提示：
1 <= board.length <= 200
1 <= board[i].length <= 200
board 和 word 仅由大小写英文字母组成
*/
public class Offer_12 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.printf("result is %s%n", exist(board, word));
    }

    private static char[] words;
    private static char[][] boardCopy;

    private static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null || "".equals(word)) {
            return false;
        }
        boardCopy = board;
        words = word.toCharArray();

        for (int row = 0; row < boardCopy.length; row++) {
            for (int column = 0; column < boardCopy[0].length; column++) {
                if (dfs(row, column, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int row, int column, int wordIndex) {
        if (row < 0 || column < 0 || row >= boardCopy.length ||
                column >= boardCopy[0].length || boardCopy[row][column] != words[wordIndex]) {
            return false;
        }
        if (wordIndex == words.length - 1) {
            return true;
        }

        // 标记该节点已经访问过
        boardCopy[row][column] = '/';
        // 按右、下、左、上的顺序 判断节点是否在字符串中
        boolean result = dfs(row, column + 1, wordIndex + 1) ||
                dfs(row + 1, column, wordIndex + 1) ||
                dfs(row, column - 1, wordIndex + 1) ||
                dfs(row - 1, column, wordIndex + 1);
        // 还原该节点
        boardCopy[row][column] = words[wordIndex];

        return result;
    }

}
