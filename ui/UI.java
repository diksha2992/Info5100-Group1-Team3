
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class UI {

    int screenWidth;
    int screenHeight;

    public UI() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Windows is not available, you can set the GUI to another look and feel.
        }
    }

    public void displayCenter(JDialog dialog) {
        int windowWidth = dialog.getWidth();                     //get the width of the window
        int windowHeight = dialog.getHeight();                   //get the height

        dialog.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//display the frame in the center of the screen
    }

    public void displayCenter(JFrame frame) {
        int windowWidth = frame.getWidth();                     //get the width of the window
        int windowHeight = frame.getHeight();                   //get the height

        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//display the frame in the center of the screen
    }

    public JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(Color.GRAY);
        frame.setSize(screenWidth*3/4,screenHeight*3/4);
        displayCenter(frame);
        return frame;
    }

    public JButton createButton(String text) {
        JButton jButton = new JButton(text);
        jButton.setSize(200, 40);
        jButton.setFont(new Font("Arial", Font.PLAIN, 36));
        return jButton;
    }

    public JComboBox createComboBox(String[] items){
        JComboBox jComboBox = new JComboBox(items);
        jComboBox.setSize(100,40);
        jComboBox.setFont(new Font("Arial", Font.PLAIN, 36));
        return jComboBox;
    }

    public JLabel createLabel(String text, int horizontalAlignment){
        JLabel jLabel = new JLabel(text, horizontalAlignment);
        jLabel.setSize(20,30);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        return jLabel;

    }

    public TextField createText(String text){
        TextField textField = new TextField(text);
        textField.setSize(20,50);
        return textField;
    }

    public JLabel createPicture(String path) throws IOException{
        JLabel picLabel = new JLabel(new ImageIcon(path));
        picLabel.setSize(new Dimension(500, 200));
        picLabel.setBounds(100, 200, 2000, 800);
        return picLabel;
    }
}
