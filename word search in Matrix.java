import java.util.*;

public class Hello {

    private static boolean dfs(int i, int j, char[][] grid, int r, int c, String str, int idx) {
        if (idx == str.length()) return true;
        if (i < 0 || j < 0 || i >= r || j >= c) return false;
        if (grid[i][j] != str.charAt(idx)) return false;

        char ch = grid[i][j];
        grid[i][j] = '.'; // mark as visited

        boolean found =
            dfs(i + 1, j, grid, r, c, str, idx + 1) || // down
            dfs(i - 1, j, grid, r, c, str, idx + 1) || // up
            dfs(i, j + 1, grid, r, c, str, idx + 1) || // right
            dfs(i, j - 1, grid, r, c, str, idx + 1);   // left

        grid[i][j] = ch; // backtrack
        return found;
    }

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        int r = z.nextInt();
        int c = z.nextInt();
        char[][] grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = z.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        z.nextLine(); // consume leftover newline
        String str = z.nextLine();

        boolean flag = false;
        for (int i = 0; i < r && !flag; i++) {
            for (int j = 0; j < c && !flag; j++) {
                if (grid[i][j] == str.charAt(0)) {
                    if (dfs(i, j, grid, r, c, str, 0)) {
                        flag = true;
                    }
                }
            }
        }

        System.out.println(flag ? "yes" : "no");
    }
}
