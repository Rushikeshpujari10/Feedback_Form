import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackForm extends JFrame {
    private JLabel titleLabel;
    private JTextArea feedbackTextArea;
    private JButton submitButton;

    public FeedbackForm() {
        setTitle("Teacher Feedback Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();
        addEventHandlers();

        setVisible(true);
    }

    private void createUI() {
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Provide your feedback:");
        add(titleLabel, BorderLayout.NORTH);

        feedbackTextArea = new JTextArea();
        feedbackTextArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(feedbackTextArea);
        add(scrollPane, BorderLayout.CENTER);

        submitButton = new JButton("Submit Feedback");
        add(submitButton, BorderLayout.SOUTH);
    }

    private void addEventHandlers() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedback = feedbackTextArea.getText();
                // Process the feedback (e.g., store it in a database)
                // For now, just display it
                JOptionPane.showMessageDialog(FeedbackForm.this, "Feedback submitted:\n" + feedback);
                // You can add further processing here
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FeedbackForm();
            }
        });
    }
}