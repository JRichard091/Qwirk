package gui;

import javax.swing.*;
import java.awt.*;
import static java.awt.GridBagConstraints.*;

import javax.swing.JTabbedPane;

/**
 * Created by Jack on 28/03/2017.
 */


public class HomeScreen2 extends JFrame{

    private static JPanel northPnl = new JPanel();
    private static JPanel southPnl = new JPanel();
    private static Panel eastPnl = new Panel();
    private static Panel westPnl = new Panel();
    private static JPanel centerPnl = new JPanel();

    //Panel westPnlNorth = new Panel();//cambiare sfondo
    private static JPanel westPnlNorth = new JPanel();
    private static JPanel westPnlCenter = new JPanel();
    private static JPanel westPnlSouth = new JPanel();

    //JLabel userName = new JLabel();
    //JLabel userStatus = new JLabel();
    private static JList listaChat = new JList();
    private static JTabbedPane tabbedPane = new JTabbedPane();
    private static JPanel firstPanel = new JPanel();
    private static JPanel secondPanel = new JPanel();
    private static JLabel firstLabel = new JLabel("All!");
    private static JLabel secondLabel = new JLabel("Recent!");

    public HomeScreen2() {
        super("Qwirk IM");
        this.setSize(1100, 635);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        ImageIcon logoWindow = new ImageIcon("src/img/QwirkLogoIcon.png");
        super.setIconImage(logoWindow.getImage());
//WEST PANEL
        c.add(westPnl, BorderLayout.WEST);

        westPnl.setLayout(new BorderLayout());
        //westPnl.setBackground(Color.red);
        westPnl.add(westPnlNorth, BorderLayout.NORTH);
        westPnl.add(westPnlCenter, BorderLayout.CENTER);
        westPnl.add(westPnlSouth, BorderLayout.SOUTH);

        westPnlNorth.setOpaque(false);
        westPnlCenter.setOpaque(false);
        westPnlSouth.setOpaque(false);
        //westPnlCenter.setBackground(Color.blue);
        //westPnlSouth.setBackground(Color.green);

        GridBagLayout layout;
        layout = new GridBagLayout();
        GridBagConstraints lim = new GridBagConstraints();

        lim.insets.left = 20;

        lim.insets.bottom = 5;

        westPnlNorth.setLayout(layout);
        westPnlNorth.setPreferredSize(new Dimension(240, 80));
        westPnlNorth.setMinimumSize(new Dimension(240, 80));

        Component labelOut = new JLabel("<html><font color='white'>Logout</font></html>");
        set(lim, 0, 0, 4, 1, NONE, EAST);
        westPnlNorth.add(labelOut, lim);

        ImageIcon iconOptions = dwindle("src/img/settings.png", 8);
        Component imgOptions = new JLabel(iconOptions);
        set(lim, 4, 0, 1, 1, NONE, EAST);
        westPnlNorth.add(imgOptions, lim);

        ImageIcon iconAvatar = dwindle("src/img/avatar.jpg", 2);
        Component imgAvatar = new JLabel(iconAvatar);
        set(lim, 0, 2, 2, 2, BOTH, WEST);
        westPnlNorth.add(imgAvatar, lim);

        Component labelName = new JLabel("<html><font color='white'>Nome Cognome</font></html>");
        set(lim, 2, 2, 1, 1, NONE, WEST);
        westPnlNorth.add(labelName, lim);

        Component labelStatus = new JLabel("<html><font color='white'>Stato</font></html>");
        set(lim, 2, 3, 1, 1, NONE, WEST);
        westPnlNorth.add(labelStatus, lim);

        westPnlCenter.setPreferredSize(new Dimension(240, 40));
        westPnlCenter.setMinimumSize(new Dimension(240, 40));

        ImageIcon iconFriend = dwindle("src/img/plusFriend2.png", 2);
        Component buttoFriend = new JButton(iconFriend);
        buttoFriend.setPreferredSize(new Dimension(70, 35));
        buttoFriend.setMinimumSize(new Dimension(70, 35));
        set(lim, 0, 0, 1, 1, BOTH, CENTER);
        westPnlCenter.add(buttoFriend, lim);

        ImageIcon iconGroup = dwindle("src/img/plusGroup.png", 2);
        Component buttonGroup = new JButton(iconGroup);
        buttonGroup.setPreferredSize(new Dimension(70, 35));
        buttonGroup.setMinimumSize(new Dimension(70, 35));
        set(lim, 1, 0, 1, 1, BOTH, CENTER);
        westPnlCenter.add(buttonGroup, lim);

        ImageIcon iconChannel = dwindle("src/img/plusChannel2.png", 2);
        Component buttonChannel = new JButton(iconChannel);
        buttonChannel.setPreferredSize(new Dimension(70, 35));
        buttonChannel.setMinimumSize(new Dimension(70, 35));
        set(lim, 2, 0, 1, 1, BOTH, CENTER);
        westPnlCenter.add(buttonChannel, lim);

        westPnlSouth.setLayout(new BorderLayout());
        westPnlSouth.setPreferredSize(new Dimension(240, 485));
        westPnlSouth.setMinimumSize(new Dimension(240, 485));

        //tabbedPane.setTabPlacement(JTabbedPane.TOP);
        //firstPanel.add(firstLabel);
        //secondPanel.add(secondLabel);
        tabbedPane.add("All", listaChat);
        tabbedPane.add("Recent", secondPanel);
        westPnlSouth.add(tabbedPane);
        //westPnlSouth.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//WEST PANEL (END)

//CENTER PANEL
        c.add(centerPnl, BorderLayout.CENTER);
        centerPnl.setLayout(new BorderLayout());
        centerPnl.setPreferredSize(new Dimension(680, 80));
        centerPnl.setMinimumSize(new Dimension(680, 80));

        TextArea textAreaOppo = new TextArea();

        textAreaOppo.setWrapStyleWord(true);//Quando la riga è piena vai a capo
        textAreaOppo.setLineWrap(true);

        JScrollPane scrollPaneOppo = new JScrollPane(textAreaOppo);
        //scrollPaneOppo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPaneOppo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //JScrollPane textScrollOppo = new JScrollPane();

        //textScrollOppo.add(TextPaneOPPO);
        //TextPaneOPPO.setEditable(false);
        //TextPaneOPPO.setPreferredSize(new Dimension(100,100));
        //TextPaneOPPO.setMinimumSize(new Dimension(100, 80));
        centerPnl.add(scrollPaneOppo);
//CENTER PANEL (END)

//NORTH PANEL
        centerPnl.add(northPnl, BorderLayout.NORTH);
        northPnl.setLayout(new BorderLayout());

        lim.insets.left = 20;

        lim.insets.bottom = 5;

        northPnl.setLayout(layout);
        northPnl.setPreferredSize(new Dimension(680, 80));
        northPnl.setMinimumSize(new Dimension(680, 80));

        ImageIcon iconAvatar2 = dwindle("src/img/avatar.jpg", 2);
        Component imgAvatar2 = new JLabel(iconAvatar2);
        set(lim, 0, 2, 2, 2, BOTH, WEST);
        northPnl.add(imgAvatar2, lim);

        Component labelName2 = new JLabel("Nome Cognome");
        set(lim, 2, 2, 1, 1, NONE, WEST);
        northPnl.add(labelName2, lim);

        Component labelStatus2 = new JLabel("Stato");
        set(lim, 2, 3, 1, 1, NONE, WEST);
        northPnl.add(labelStatus2, lim);

        ImageIcon iconCall = dwindle("src/img/call.png", 10);
        Component imgCall = new JLabel(iconCall);
        set(lim, 6, 2, 1, 1, NONE, WEST);
        northPnl.add(imgCall, lim);

        ImageIcon iconVideoCall = dwindle("src/img/videoCall.png", 10);
        Component imgVideoCall = new JLabel(iconVideoCall);
        set(lim, 6,3, 1, 1, NONE, WEST);
        northPnl.add(imgVideoCall, lim);

//NORTH PANEL (END)

//SOUTH PANEL
        centerPnl.add(southPnl, BorderLayout.SOUTH);
        southPnl.setPreferredSize(new Dimension(680, 110));
        southPnl.setMinimumSize(new Dimension(680, 110));

        lim.insets.left = 5;
        lim.insets.right = 5;
        lim.insets.bottom = 0;
        southPnl.setLayout(layout);

        JTextArea textAreaUser = new JTextArea();
        textAreaUser.setWrapStyleWord(true);//Quando la riga è piena vai a capo
        textAreaUser.setLineWrap(true);
        JScrollPane scrollPaneMessage = new JScrollPane(textAreaUser);
        set(lim, 0,0, 6, 3, NONE, WEST);
        scrollPaneMessage.setPreferredSize(new Dimension(570,100));
        southPnl.add(scrollPaneMessage, lim);

        Component buttonSend = new JButton("Send");
        set(lim, 6,0, 1, 1, NONE, CENTER);
        southPnl.add(buttonSend, lim);

        ImageIcon iconEmoticon = dwindle("src/img/smile2.png", 12);
        //Component buttoFriend = new JButton(iconFriend);

        Component ButtonEmoticon = new JButton(iconEmoticon);
        set(lim, 6,2, 1, 1, NONE, CENTER);
        southPnl.add(ButtonEmoticon, lim);
//SOUTH PANEL (END)

        //northPnl.setBackground(Color.cyan);
        centerPnl.setBackground(Color.blue);
        //southPnl.setBackground(Color.red);
//EAST PANEL
        c.add(eastPnl, BorderLayout.EAST);
        eastPnl.setLayout(new BorderLayout());
        eastPnl.setPreferredSize(new Dimension(180, 80));
        eastPnl.setMinimumSize(new Dimension(180, 80));

        JLabel logo = new JLabel(new ImageIcon("src/img/QwirkLogoIcon.png"));
        logo.setBorder(BorderFactory.createEmptyBorder(50,10,10,10));
        eastPnl.add(logo, BorderLayout.NORTH);
//EAST PANEL (END)

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setLocation(10,10);

    }


    private void set(GridBagConstraints lim, int gridx, int gridy, int gridwidth, int gridheight, int fill, int anchor)
    {
        lim.gridx = gridx;
        lim.gridy = gridy;
        lim.gridwidth = gridwidth;
        lim.gridheight = gridheight;
        lim.anchor = anchor;
        lim.fill = fill;
    }

    //Funzione che mi rimpicciolisce l'immagine
    private ImageIcon dwindle(String path, int reduce)
    {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        image = image.getScaledInstance(image.getWidth(null)/reduce, image.getHeight(null)/reduce,Image.SCALE_SMOOTH);
        icon.setImage(image);
        return icon;
    }
}
