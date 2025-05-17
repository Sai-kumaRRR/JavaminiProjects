package CalculatorProject;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MiniProject01 extends JFrame {
    private final ArrayList<String> tasks;
    private final DefaultListModel<String> listModel;
    private final JList<String> taskList;
    private final JTextField taskInput;
    private final JButton addButton;
    private final JButton removeButton;
    private final JButton markDoneButton;

    public MiniProject01() {
        // Initialize data structures
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();

        // Set up the main window
        setTitle("To-Do List Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create input panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 0));
        taskInput = new JTextField();
        addButton = new JButton("Add Task");
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Create task list
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        removeButton = new JButton("Remove Task");
        markDoneButton = new JButton("Mark as Done");
        buttonPanel.add(removeButton);
        buttonPanel.add(markDoneButton);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(e -> addTask());

        removeButton.addActionListener(e -> removeTask());

        markDoneButton.addActionListener(e -> markTaskAsDone());

        taskInput.addActionListener(e -> addTask()); // Allow adding task with Enter key

        // Set window properties
        setSize(400, 500);
        setLocationRelativeTo(null);
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(task);
            taskInput.setText("");
            tasks.add(task);
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
            tasks.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a task to remove",
                    "No Task Selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void markTaskAsDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            String task = listModel.getElementAt(selectedIndex);
            if (!task.startsWith("✓ ")) {
                listModel.setElementAt("✓ " + task, selectedIndex);
                tasks.set(selectedIndex, "✓ " + task);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a task to mark as done",
                    "No Task Selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create and show GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                // Set system look and feel
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            MiniProject01 todoList = new MiniProject01();
            todoList.setVisible(true);
        });
    }
}



