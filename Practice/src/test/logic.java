package test;

public class logic {
	private int spacesLeft = 0;
    private int max;
    private int rowsize;
    private int colsize;
    Grid grid;

    public logic(Grid tempGrid) {
        max = 4;//this is where i can choose for connect x
        grid = tempGrid;
        spacesLeft = grid.rcells();
        rowsize = grid.get_xsize();
        colsize = grid.get_ysize();
    }

    public boolean set_and_check(int x, int y, int player) {
        grid.set_matrix(x, y, player);
        spacesLeft--;
        return check_one(x, y, 0, 1, player)
                || check_one(x, y, -1, 1, player)
                	|| check_one(x, y, -1, 0, player)
                		|| check_one(x, y, 1, 1, player);
    }

    public boolean draw_game() {
        return spacesLeft == 0;
    }

    private boolean check_one(int x, int y, int thex, int they, int player) {
       
        int anX = x;
        int anY = y;
        int matches = 0;
        
        while (matches < max && valid(anX, anY)) {
            if (!grid.matrix_equals(anX, anY, player)) {
                break;

            }
            anX += thex;
            anY += they;
            matches++;
        }
        anX = x - thex;
        anY = y - they;
        while (matches < max && valid(anX, anY)) {
            if (!grid.matrix_equals(anX, anY, player)) {
                break;
            }
            anX -= thex;
            anY -= they;
            matches++;
        }
        return matches == max;
    }

    private boolean valid(int x, int y) {
       return x >= 0 && x < rowsize && y >= 0 && y < colsize;
    }
}
