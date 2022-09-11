import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpponentPanel extends JPanel{
    private JLabel oppChoiceLabel;
    private JButton continueButton;
    public OpponentPanel(Runnable callback)
    {
        oppChoiceLabel = new JLabel("Opponent chose: ");
        add(oppChoiceLabel);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> callback.run());
        add(continueButton);
    }

    public void setLabel(String message)
    {
        this.oppChoiceLabel.setText(message);
    }
}
