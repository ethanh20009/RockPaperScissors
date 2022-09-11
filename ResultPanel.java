import javax.swing.*;

public class ResultPanel extends JPanel {
    private JLabel result;
    private JButton continueButton;

    
    public ResultPanel(Runnable callback)
    {
        result = new JLabel();
        add(result);

        continueButton = new JButton("Play again?");
        continueButton.addActionListener(e -> callback.run());
        add(this.continueButton);
    }

    public void setLabel(String message)
    {
        result.setText(message);
    }
}
