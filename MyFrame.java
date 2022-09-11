import java.awt.event.ActionListener;
import java.util.Random;

import javax.lang.model.util.ElementScanner14;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class MyFrame extends JFrame{
    private JButton rButton;
    private JButton pButton;
    private JButton sButton;
    private JPanel myPanel;
    private OpponentPanel opponentPanel;
    private ResultPanel resultPanel;

    private JPanel[] panels;

    public MyFrame()
    {
        rButton = new JButton("Rock");
        rButton.addActionListener(e -> Choose(0));
        
        pButton = new JButton("Paper");
        pButton.addActionListener(e -> Choose(1));

        sButton = new JButton("Scissors");
        sButton.addActionListener(e -> Choose(2));

        

        myPanel = new JPanel();
        myPanel.add(rButton);
        myPanel.add(pButton);
        myPanel.add(sButton);

        
        opponentPanel = new OpponentPanel(() -> closeOpponentMenu());

        resultPanel = new ResultPanel(() -> closeResultMenu());

        add(myPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panels = new JPanel[]{myPanel, opponentPanel, resultPanel};
    }

    public void Choose(int choice)
    {
        String[] options = new String[] {"Rock", "Paper", "Scissors"};
        int oppInt = (int)(Math.random()*options.length);
        String oppChoice = options[oppInt];
        opponentPanel.setLabel("Opponent chose: " + oppChoice);
        String outcome = "";
        //Calculate if won
        if (choice == oppInt) //Draw
        {
            outcome = "Drew";
        }
        else if ((choice + 1) % options.length == oppInt) //Lose
        {
            outcome = "Lost";
        }
        else{ //Win
            outcome = "Won";
        }

        resultPanel.setLabel("You " + outcome + "!");
        ShowMenu(opponentPanel);
    }

    public void ShowMenu(JPanel menu)
    {
        for (JPanel p : panels)
        {
            if (menu.equals(p))
            {
                p.setVisible(true);
                continue;
            }
            p.setVisible(false);
        }
        add(menu);
        pack();
    }

    public void closeOpponentMenu()
    {
        ShowMenu(resultPanel);
    }

    public void closeResultMenu()
    {
        ShowMenu(myPanel);
    }
}
