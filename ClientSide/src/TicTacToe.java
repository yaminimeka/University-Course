




import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Font;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.UIManager;





public class TicTacToe extends JFrame{

    private static final int FRAME_WIDTH = 300;

    private static final int FRAME_HEIGHT = 300;

    

    private JButton[] button = new JButton[9];

    

    

    

    private ActionListener actionlistener;

    private JTextField view;

    private boolean firstPlayer = true;

    

    public static void main(String[] args){

        JFrame frame = new TicTacToe();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Tic Tac Toe");

        frame.setVisible(true);

    }

    

    public TicTacToe(){

        

        class GameListener implements ActionListener{



            
            public void actionPerformed(ActionEvent e) {

              JButton press = (JButton)e.getSource();

              

                  if(firstPlayer){

                	  press.setFont(new Font(Font.SERIF,Font.BOLD,24));

                	  press.setText("X");

                	  press.setBackground(Color.lightGray);

                      UIManager.getDefaults().put("Button.disabledText", Color.BLACK);

                      press.setEnabled(false);

                      firstPlayer = false;

                      if(checkPlayerWins(press)){

                        view.setText("First Player Won"); 

                        disable();

                      }else{

                            if(isDisabled()){

                            	view.setText("Game Over !!! None Won");

                            }else{

                            	view.setText("Second Player's turn");

                            }

                      }

                  }else{

                	  press.setFont(new Font(Font.SERIF,Font.BOLD,24));

                	  press.setText("O");

                	  press.setBackground(Color.GREEN);

                      UIManager.getDefaults().put("Button.disabledText", Color.ORANGE);

                      press.setEnabled(false);

                      firstPlayer = true;

                      if(checkPlayerWins(press)){

                    	  view.setText("Second Player Won");

                        disable();

                      }else{

                            if(isDisabled()){

                            	view.setText("Game Over !!! None Won");

                            }else{

                            	view.setText("First Player's turn");

                            }                            

                      }

                  }

            }

            

        }

        actionlistener =  new GameListener();

        board();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }

    

    public void board(){

        

        JPanel panel = new JPanel();

        JPanel buttonPanel = new JPanel();

        JPanel resetPanel = new JPanel();

        panel.setLayout(new BorderLayout());

        resetPanel.setLayout(new BorderLayout());

        buttonPanel.setLayout(new GridLayout(3, 3));

        

        for(int i=0; i<9; i++){

            button[i] = new JButton();

        }

        

        for(int i=0; i < 9; i++){

            button[i].addActionListener(actionlistener);

            buttonPanel.add(button[i]);

        }

        panel.add(buttonPanel, BorderLayout.CENTER);

        view = new JTextField(); 

        view.setEditable(false);

        view.setText("Firsr Players turn");

        panel.add(view, BorderLayout.SOUTH);

        add(panel);        

    }

    

    public boolean checkPlayerWins(JButton b){

        boolean output = false;

        

        if(b.equals(button[0])){

            if(button[0].getText().equalsIgnoreCase(button[1].getText()) && button[1].getText().equalsIgnoreCase(button[2].getText())){

                output = true;

            }

             

            if(button[0].getText().equalsIgnoreCase(button[3].getText()) && button[3].getText().equalsIgnoreCase(button[6].getText())){

                output = true;

            }

            

            if(button[0].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[1])){

            if(button[0].getText().equalsIgnoreCase(button[1].getText()) && button[1].getText().equalsIgnoreCase(button[2].getText())){

                output = true;

            }

            

            if(button[1].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[7].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[2])){

            if(button[0].getText().equalsIgnoreCase(button[1].getText()) && button[1].getText().equalsIgnoreCase(button[2].getText())){

                output = true;

            }

            

            if(button[2].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[6].getText())){

                output = true;

            }

            

            if(button[2].getText().equalsIgnoreCase(button[5].getText()) && button[5].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[3])){

            if(button[0].getText().equalsIgnoreCase(button[3].getText()) && button[3].getText().equalsIgnoreCase(button[6].getText())){

                output = true;

            }

            

            if(button[3].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[5].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[4])){

            if(button[0].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

            

            if(button[1].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[7].getText())){

                output = true;

            }

            

            if(button[2].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[6].getText())){

                output = true;

            }

            

            if(button[3].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[5].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[5])){

            if(button[2].getText().equalsIgnoreCase(button[5].getText()) && button[5].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

            

            if(button[3].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[5].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[6])){

            if(button[0].getText().equalsIgnoreCase(button[3].getText()) && button[3].getText().equalsIgnoreCase(button[6].getText())){

                output = true;

            }

            

            if(button[2].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[6].getText())){

                output = true;

            }

            

            if(button[6].getText().equalsIgnoreCase(button[7].getText()) && button[7].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[7])){

            if(button[1].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[7].getText())){

                output = true;

            }

            

            if(button[6].getText().equalsIgnoreCase(button[7].getText()) && button[7].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

        }

        

        if(b.equals(button[8])){

            if(button[0].getText().equalsIgnoreCase(button[4].getText()) && button[4].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

            

            if(button[2].getText().equalsIgnoreCase(button[5].getText()) && button[5].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

            

            if(button[6].getText().equalsIgnoreCase(button[7].getText()) && button[7].getText().equalsIgnoreCase(button[8].getText())){

                output = true;

            }

        }

        

        return output;

    }

    

    public void disable(){

        

        for(int i=0; i<9; i++){

            button[i].setEnabled(false);

        }

    }

    

    public boolean isDisabled(){

        boolean result = false;

        

        if(!button[0].isEnabled() && !button[1].isEnabled() && !button[2].isEnabled() && !button[3].isEnabled() 

                && !button[4].isEnabled() && !button[5].isEnabled() && !button[6].isEnabled() && !button[7].isEnabled()

                && !button[8].isEnabled()){

            result = true;

        }

        

        return result;

    }

}
