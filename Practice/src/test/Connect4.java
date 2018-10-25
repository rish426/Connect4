package test;

public class Connect4 {
	public static void main(String[] args) {
        int rule = 0;
        boolean program = true;

        if (program) {
            gui game = new gui();
            while (rule != -1) {
                switch (rule) {
                    case 0:
                        game.updateBoard();
                        if (game.getHasWon()) {
                            rule = 1;
                        } else if (game.getHasDraw()) {
                            rule = 2;
                        } else if (game.getNewGame()) {
                            game = new gui();
                            rule = 0;
                        }
                        break;
                    case 1:
                        game.showWon();
                        if (game.getQuit()) {
                            rule = -1;
                        } else  if (game.getNewGame()) {
                            game = new gui();
                            rule = 0;
                        }
                        break;
                    case 2:
                        game.showDraw();
                        if (game.getQuit()) {
                            rule = -1;
                        } else if (game.getNewGame()) {
                            game = new gui();
                            rule = 0;
                        }
                        break;
                }
            }
        } 
            
        
    }
}
