import java.util.*;

public class Hello {

    private static boolean dfs(int i, int j, char[][] grid, int r, int c, String str, int idx, boolean[][] visited) {
        if (idx == str.length()) {
            return true;
        }
        if (i < 0 || i >= r || j < 0 || j >= c) {
            return false;
        }
        if (visited[i][j] || grid[i][j] != str.charAt(idx)) {
            return false;
        }

        visited[i][j] = true;

        boolean found =
                dfs(i, j + 1, grid, r, c, str, idx + 1, visited) ||  // right
                dfs(i, j - 1, grid, r, c, str, idx + 1, visited) ||  // left
                dfs(i + 1, j, grid, r, c, str, idx + 1, visited) ||  // down
                dfs(i - 1, j, grid, r, c, str, idx + 1, visited) ||  // up
                dfs(i + 1, j + 1, grid, r, c, str, idx + 1, visited) ||  // down-right
                dfs(i + 1, j - 1, grid, r, c, str, idx + 1, visited) ||  // down-left
                dfs(i - 1, j + 1, grid, r, c, str, idx + 1, visited) ||  // up-right
                dfs(i - 1, j - 1, grid, r, c, str, idx + 1, visited);    // up-left

        visited[i][j] = false; // backtrack
        return found;
    }

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        int r = z.nextInt();
        int c = z.nextInt();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = z.next().charAt(0);
            }
        }
        z.nextLine(); // consume newline
        String str = z.nextLine();

        boolean flag = false;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r && !flag; i++) {
            for (int j = 0; j < c && !flag; j++) {
                if (grid[i][j] == str.charAt(0)) {
                    if (dfs(i, j, grid, r, c, str, 0, visited)) {
                        flag = true;
                    }
                }
            }
        }

        if (flag) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
