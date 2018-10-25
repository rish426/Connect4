package test;

public class Grid {
	private int rowsize;
    private int colsize;
    private int[][] check;
    private int spacesLeft = 0;

    public Grid() {
        rowsize = 7;
        colsize = 6;

        check = new int[rowsize][colsize];
        for (int i = 0; i < rowsize; i++) {
            for (int j = 0; j < colsize; j++) {
                check[i][j] = 0;
                spacesLeft++;
            }
        }
    }

    public int rcells() {
        return spacesLeft;
    }

    public int[][] get_matrix() {
        return check;
    }

    public boolean matrix_equals(int a, int b, int c) {
        return check [a][b] == c;
    }

    public void set_matrix(int a, int b, int playerCh) {
        check[a][b] = playerCh;
    }

    public int get_xsize() {
        return rowsize;
    }

    public int get_ysize() {
        return colsize;
    }

    public int find_y(int x) {
        int y = -1;
        for (int i = 0; i < colsize; i++) {
            if (check[x][i] == 0) {
                y = i;
            }
        }
        return y;
    }

    public int changeplayer(int player, int players) {
        player++;
        if (player > players) {
            return 1;
        }
        return player;
    }
}
