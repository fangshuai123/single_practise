package leetcode;

/**
 * Created by Fangshuai on 2016/3/4.
 */
public class RoateImage_48 {

    public void rotate(int[][] matrix) {
        int[][] temp = matrix;
        int n = matrix.length;
        int[][] tempRotate = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                tempRotate[i][j] = temp[n - j - 1][i];
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tempRotate[i][j];
            }
    }
}
