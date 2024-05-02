import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZooGUI extends JFrame {
    private JLabel welcomeLabel;
    private JPanel buttonPanel;
    private JLabel animalImageLabel;

    public ZooGUI() {
        setTitle("Habiba's Zoo");
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeLabel = new JLabel("Welcome to the Zoo!");

        //Setting the image
        ImageIcon zooImage = new ImageIcon("zoo.jpeg");
        JLabel imageLabel = new JLabel(zooImage);

        //add comes from the jframe container to help design your frame placements
        add(imageLabel, BorderLayout.CENTER);

        //.setHoirizontalAlighnment handles the placement of the text of the label
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        //Add handles the placement within the frame
        add(welcomeLabel, BorderLayout.SOUTH);

        //Button panel is for designing and placement of the buttons that is IT no functionality
        buttonPanel = new JPanel(new GridLayout(0, 1));
        add(buttonPanel, BorderLayout.CENTER);

        JButton enterTheZoo = new JButton("Enter The Zoo");
        enterTheZoo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcomeLabel.setVisible(false);
                enterTheZoo.setVisible(false);
                dispose();
                AnimalSelection();
            }
        });

        buttonPanel.add(enterTheZoo);
    }

    /**
     * This Method handles the UI for entering the Zoo and selecting which animal section you want to visit
     */
    public void AnimalSelection() {
        JFrame animalSelectionFrame = new JFrame("Animal Visitor");
        animalSelectionFrame.setSize(1000, 900);
        animalSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcomeLabel = new JLabel("Which animals would you like to visit!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        animalSelectionFrame.add(welcomeLabel, BorderLayout.NORTH);

        buttonPanel = new JPanel(new GridLayout(0, 1));
        animalSelectionFrame.add(buttonPanel, BorderLayout.CENTER);

        animalSelectionFrame.setVisible(true);
        animalImageLabel = new JLabel();
        animalSelectionFrame.add(animalImageLabel, BorderLayout.SOUTH);

        /**
         * For each animal in our list make a button (currently hardcoded but could be dynamic in future release)
         **/

        String[] animalNames = {"Monkey", "Zebra", "Lion", "Snake"};

        for (String animal : animalNames) {
            JButton btn = new JButton(animal);
            btn.addActionListener(new ActionListener() {
                //Passing in the animal from line 73
                public void actionPerformed(ActionEvent e) {

                    displayAnimalInfo(animal);
                }
            });
            buttonPanel.add(btn);
        }

        JButton backButton = new JButton("Leave Zoo");

       //Event listener which will follow through whichever animal button you click, show the information of that animal using the getAll() method
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animalSelectionFrame.dispose();
               // showWelcomeScreen();
            }
        });
        animalSelectionFrame.add(backButton, BorderLayout.SOUTH);
    }

    /**
     * Animal is the list of animals we created on line 71
     * Handles viewing the data we have stored for each animal
     */
    private void displayAnimalInfo(String animalName) {
        Animal animal = null;
        ImageIcon imageIcon = null;
        //Location of images in the project folder
        String imagePath = "./images/";

       //Switch case statement, based on whichever value was passed it creates the object and im able to access the getAll method
        switch (animalName) {
            case "Zebra":
                animal = new Zebra("Zebras", 0, "Unknown");
                imageIcon = new ImageIcon(imagePath + "zebra.png");
                break;
            case "Lion":
                animal = new Lion("Lions", 0, "Unknown");
                imageIcon = new ImageIcon(imagePath + "lion.jpg");
                break;
            case "Monkey":
                animal = new Monkey("Monkeys", 0, "Unknown");
                imageIcon = new ImageIcon(imagePath + "monkey.jpeg");
                break;
            case "Snake":
                animal = new Snake("Snakes", 0, "Unknown");
                imageIcon = new ImageIcon(imagePath + "snake.png");
                break;
        }

        //make sure selection passed actually exists
        if (animal != null) {
            ArrayList<String> animalInfo = animal.getAll();

            //Handles creating the string block section for dispalying info (zebra.getAll() )
            StringBuilder message = new StringBuilder();
            message.append("Info about ").append(animalName).append(":\n");
            for (String info : animalInfo) {
                message.append(info).append("\n");
            }
            //java swing handling showing data on the screen
            JOptionPane.showMessageDialog(this, message.toString());

            // WIP: Display the animal image not working atm :(
            if (imageIcon != null) {
                animalImageLabel.setIcon(imageIcon);
                animalImageLabel.setVisible(true); // Ensure label is visible
                // Refresh container
                revalidate();
                repaint();
            } else {
                System.out.println("Image loading failed.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Info about " + animalName);
        }
    }

    /**
     * Handles launching the Main screen for user interface
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ZooGUI gui = new ZooGUI();
                gui.setVisible(true);
            }
        });
    }
}
