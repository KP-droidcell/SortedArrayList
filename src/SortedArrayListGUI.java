import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class SortedArrayListGUI extends JFrame {

    private JTextField searchField;
    private JTextArea resultArea;
    private ArrayList<String> dataList;

    public SortedArrayListGUI() {
        setTitle("Sorted ArrayList Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Add components to the frame
        JPanel topPanel = new JPanel();
        topPanel.add(searchField);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Initialize data and sort it
        dataList = new ArrayList<>();
        dataList.add("Apple");
        dataList.add("Banana");
        dataList.add("Cherry");
        dataList.add("Date");
        Collections.sort(dataList);

        // Add action listener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void search() {
        String searchTerm = searchField.getText();
        int index = Collections.binarySearch(dataList, searchTerm);

        if (index >= 0) {
            resultArea.setText("Found at index: " + index);
        } else {
            resultArea.setText("Not found");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SortedArrayListGUI();
            }
        });
    }
}