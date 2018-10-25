package test;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class gui {
	 private JFrame frame;
	    private JLabel[][] slots;
	    private JButton[] buttons;
	    private int rowsize = 7;
	    private int colsize = 6;
	    private int currentPlayer = 1;
	    private boolean hasDraw = false;
	    private boolean newGame = false;
	    private boolean quit = false;
	    private boolean hasWon = false;
	   
	    Grid theGrid = new Grid();
	    logic my_logic = new logic(theGrid);
	    ImageIcon empty = new ImageIcon("Images/empty.png");
	    ImageIcon player1 = new ImageIcon("Images/red.png");
	    ImageIcon player2 = new ImageIcon("Images/blue.png");
	    
	    public gui() {

	        frame = new JFrame("connect four");

	        JPanel panel = (JPanel) frame.getContentPane();
	        panel.setLayout(new GridLayout(rowsize, colsize + 1));

	        slots = new JLabel[rowsize][colsize];
	        buttons = new JButton[rowsize];

	        for (int i = 0; i < rowsize; i++) {
	            buttons[i] = new JButton("" + (i + 1));
	            buttons[i].setActionCommand("" + i);
	            buttons[i].setBackground(Color.LIGHT_GRAY);
	            buttons[i].setForeground(Color.cyan);
	            buttons[i].addActionListener(
	            
	                    new ActionListener() {

	                        public void actionPerformed(ActionEvent e) {
	                            int a = Integer.parseInt(e.getActionCommand());
	                            int y = theGrid.find_y(a);
	                            if (y != -1) {
	                            	
	                                if (my_logic.set_and_check(a, y, currentPlayer)) {
	                                	buttons[a].setIcon(player1);
	                                	hasWon = true;
	                                } else if (my_logic.draw_game()) {
	                                    hasDraw = true;
	                                } else {
	                                    currentPlayer = theGrid.changeplayer(currentPlayer, 2);
	                                    frame.setTitle("Rishi Deendyal Connect 4 ~ Player " + currentPlayer + "'s Turn");

	                                }

	                            } else {
	                                JOptionPane.showMessageDialog(null, "Please Pick Another", "Columnn is Filled", JOptionPane.INFORMATION_MESSAGE);
	                            }
	                        }
	                    });
	            panel.add(buttons[i]);
	        }
	        for (int column = 0; column < colsize; column++) {
	            for (int row = 0; row < rowsize; row++) {
	                slots[row][column] = new JLabel();
	                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
	                slots[row][column].setBorder(new LineBorder(Color.black));
	                slots[row][column].setIcon(empty);
	                panel.add(slots[row][column]);
	            }
	        }

	        
	        frame.setContentPane(panel);
	        frame.setSize(700, 600);
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	 	    
	    public void updateBoard() {
	        for (int row = 0; row < rowsize; row++) {
	            for (int column = 0; column < colsize; column++) {
	                if (theGrid.matrix_equals(row, column, 1)) {
	                	slots[row][column].setIcon(player1);
	                }
	                if (theGrid.matrix_equals(row, column, 2)) {
	                    slots[row][column].setIcon(player2);
	                }
	            }
	        }
	    }

	    public void showWon() {
	        String winner = "Player " + currentPlayer + " Wins!";
	        int n = JOptionPane.showConfirmDialog(
	                frame,
	                "new game?",
	                winner,
	                JOptionPane.YES_NO_OPTION);
	        if (n < 1) {
	            frame.dispose();
	            newGame = true;
	        } else {
	            frame.dispose();
	            quit = true;
	        }
	    }

	    public void showDraw() {
	        String winner = "draw game";
	        int n = JOptionPane.showConfirmDialog(
	                frame,
	                "new game?",
	                winner,
	                JOptionPane.YES_NO_OPTION);
	        if (n < 1) {
	            frame.dispose();
	            newGame = true;
	        } else {
	            frame.dispose();
	            quit = true;
	        }
	    }

	    public boolean getHasWon() {
	        return hasWon;
	    }

	    public boolean getHasDraw() {
	        return hasDraw;
	    }

	    public boolean getQuit() {
	        return quit;
	    }

	    public boolean getNewGame() {
	        return newGame;
	    }

	    public static void main(String[] args) {
	        gui Gui = new gui();
	    }
}
