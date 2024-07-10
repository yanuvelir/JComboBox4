import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JComboBox4 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JComboBox4 window = new JComboBox4();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public JComboBox4() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(37, 39, 49, 14);
        frame.getContentPane().add(lblCountry);

        JLabel lblFlag = new JLabel("");
        lblFlag.setBounds(137, 68, 120, 81);
        frame.getContentPane().add(lblFlag);

        JComboBox cbxCountry = new JComboBox();
        cbxCountry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String val = cbxCountry.getSelectedItem().toString();
                countryComboBoxChanged(val, lblFlag);

            }
        });
        String[] countries = new String[] {"-Select-", "Belgium", "Great Britain",
                "Spain", "Ukraine"};
        for(int i = 0; i<countries.length; i++) {
            cbxCountry.addItem(countries[i]);
        }
        cbxCountry.setBounds(137, 35, 120, 22);
        frame.getContentPane().add(cbxCountry);

    }

    private void countryComboBoxChanged(String val, JLabel lblFlag) {
        switch (val) {
            case "-Select-":
                setImgToLabel(lblFlag, "Blank.png");
                break;
            case "Belgium":
                setImgToLabel(lblFlag, "Belgium.png");
                break;
            case "Great Britain":
                setImgToLabel(lblFlag, "Great Britain.png");
                break;
            case "Spain":
                setImgToLabel(lblFlag, "Spain.png");
                break;
            case "Ukraine":
                setImgToLabel(lblFlag, "Ukraine.png");
                break;

        }
    }
    private void setImgToLabel(JLabel lbl, String imgName) {
        java.net.URL imgUrl = this.getClass().getResource("img/" + imgName);

        Icon image = new ImageIcon(imgUrl);
        lbl.setIcon(image);
    }
}
