package gui;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by riccardo on 22/03/2017.
 */

public class HomeScreen extends JFrame implements ActionListener {

    private JPanel panel0;

    //private static container = new JPanel();

//il panel di SINISTRA è stato suddiviso in 3 sotto-panel
    private static JPanel panelLeft = new JPanel();
        private static JPanel panelLeftTop = new JPanel();
        private static JPanel panelLeftMiddle = new JPanel();
        private static JPanel panelLeftDown = new JPanel(new FlowLayout(FlowLayout.LEFT));
//il panel al CENTRO è stato suddiviso in 3 sotto-panel
    private static JPanel panelCenter = new JPanel();
        private static JPanel panelCenterTop = new JPanel(new BorderLayout());
            private static JPanel leftPanel = new JPanel();
            private static JPanel leftPanel1 = new JPanel();
            private static JPanel leftPanel2 = new JPanel();
            private static JPanel leftPanel3 = new JPanel();
            private static JPanel leftPanel4 = new JPanel();
            private static JPanel rightPanel = new JPanel();
        private static JPanel panelCenterMiddle = new JPanel();
            private static JTextPane TextPaneOPPO = new JTextPane();
        private static JPanel panelCenterDown = new JPanel();

//il panel di DESTRA
    private static JPanel panelRight = new JPanel();

    private static JButton chat = new JButton("Chat");
    private static JButton canali = new JButton("Canali");
    private static JButton gruppi = new JButton("Gruppi");
    private static JButton addChat = new JButton("addChat", new ImageIcon(("src/img/plus2.png")));
    private static JButton addCanali = new JButton("addCanali");
    private static JButton addGruppi = new JButton("addGruppi");

    private static JList listaChat = new JList();
    private static JList listaCanali = new JList();
    private static JList listaGruppi = new JList();

    //Menu Move
    private static final JMenuItem upIt = new JMenuItem("Up");
    private static final JMenuItem dwnIt = new JMenuItem("Down");
    private static final JMenu moveMenu = new JMenu("Move");
    //Menu di Editing
    private static final JMenuItem rndmIt = new JMenuItem("Random");
    private static final JMenu editMenu = new JMenu("Edit");
    //Menu File
    private static final JMenuItem newIt = new JMenuItem("New");
    private static final JMenuItem openIt = new JMenuItem("Open");
    private static final JMenuItem saveIt = new JMenuItem("Save as...");
    private static final JMenu fileMenu = new JMenu("File");
    //Menu Bar
    private static final JMenuBar menuBar = new JMenuBar();



    public HomeScreen() {
        super("Quirk IM");
        this.setSize(1100, 635);
        setContentPane(panel0);
        listaChat.setVisible(false);
        listaCanali.setVisible(false);
        listaGruppi.setVisible(false);
// Move Menu
        moveMenu.add(upIt);
        moveMenu.add(dwnIt);
// Edit Menu
        editMenu.add(moveMenu);
        editMenu.add(rndmIt);
// File Menu
        fileMenu.add(newIt);
        fileMenu.add(openIt);
        fileMenu.add(saveIt);
// Barra menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
// Imposta la Barra Menu nel frame
        this.setJMenuBar(menuBar);

        panel0.setLayout(new BoxLayout(panel0, BoxLayout.X_AXIS));
        panel0.add(panelLeft);
        panel0.add(panelCenter);
        panel0.add(panelRight);

//Panel LEFT
        //set layout verticale del panel Left
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeftMiddle.setLayout(new BoxLayout(panelLeftMiddle, BoxLayout.Y_AXIS));

        panelLeft.add(panelLeftTop);
        panelLeft.add(panelLeftMiddle);
        panelLeft.add(panelLeftDown);

        JLabel label1 = new JLabel(new ImageIcon("src/img/icon2.png"));
        //JLabel label2 = new JLabel(new ImageIcon("src/img/plus.png"));
        panelLeftTop.add(label1);

//Panel LEFT//Colori
        panelLeft.setBackground(new Color(167,213,241));
        panelLeftTop.setBackground(new Color(167,213,241));
        panelLeftMiddle.setBackground(new Color(167,213,241));
        panelLeftDown.setBackground(Color.blue);

//Panel LEFT//Dimensioni personalizzate
        panelLeft.setPreferredSize(new Dimension(200,635));
        panelLeftTop.setPreferredSize(new Dimension(0,170));
        panelLeftMiddle.setPreferredSize(new Dimension(0,130));
        //chat.setPreferredSize(new Dimension(200,20));
        //canali.setPreferredSize(new Dimension(200,20));
        //gruppi.setPreferredSize(new Dimension(200,20));


//Panel LEFT////Panel MIDDLE
        panelLeftMiddle.add(chat);
        panelLeftMiddle.add(canali);
        panelLeftMiddle.add(gruppi);

        JLabel label4 = new JLabel("");
        //label4
        panelLeftMiddle.add(label4);
        panelLeftMiddle.setLayout(new GridLayout(5, 1));

//Panel LEFT////Panel DOWN
        panelLeftDown.add(listaChat);
        panelLeftDown.add(listaCanali);
        panelLeftDown.add(listaGruppi);
        panelLeftDown.setPreferredSize(new Dimension(0,335));
        listaChat.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaCanali.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaGruppi.setLayoutOrientation(JList.HORIZONTAL_WRAP);

//panelLEFT (END)

//panelCENTER//TOP

        JLabel label2 = new JLabel(new ImageIcon("src/img/avatar.jpg"));//80x80
        JLabel label3 = new JLabel("Cambia Avatar");
        //JLabel nomecognome= new JLabel("Cambia Avatar");;

        label2.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        label3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));

        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.add(panelCenterTop);
        panelCenter.add(panelCenterMiddle);
        panelCenter.add(panelCenterDown);
        //panelCenterTop.setLayout(new GridLayout(1, 2, 0, 0));
        panelCenterTop.setLayout(new BoxLayout(panelCenterTop, BoxLayout.X_AXIS));
        //panelCenterTop.add( leftPanel, BorderLayout.WEST );
        panelCenterTop.add( leftPanel);
        //panelCenterTop.add( rightPanel, BorderLayout.EAST );
        panelCenterTop.add( rightPanel);
        leftPanel.setLayout(new GridLayout(1, 2, 0, 0));
        leftPanel.add( leftPanel1, BorderLayout.WEST );
        //leftPanel.add( leftPanel2, BorderLayout.EAST );
        //leftPanel.add( leftPanel3, BorderLayout.WEST );
        //leftPanel.add( leftPanel4, BorderLayout.EAST );
        leftPanel1.setLayout(new BoxLayout(leftPanel1, BoxLayout.Y_AXIS));
        leftPanel1.add(label2);
        leftPanel1.add(label3);
//panelCENTER//MIDDLE
        TextPaneOPPO.setEditable(false);
        TextPaneOPPO.setPreferredSize(new Dimension(599,200));
        panelCenterMiddle.add(TextPaneOPPO);
        panelCenterMiddle.setPreferredSize(new Dimension(600,200));
        panelCenterDown.setPreferredSize(new Dimension(600,200));

//panelCENTER//Colori
        //panelCenter.setBackground(Color.black);
        panelCenterTop.setBackground(Color.pink);
        panelCenterMiddle.setBackground(Color.red);
        panelCenterDown.setBackground(Color.orange);
        leftPanel.setBackground(Color.red);
        leftPanel1.setBackground(Color.yellow);
        //leftPanel2.setBackground(Color.cyan);
        //leftPanel3.setBackground(Color.cyan);
        //leftPanel4.setBackground(Color.yellow);
        rightPanel.setBackground(Color.green);


//panelCENTER//Dimensioni personalizzate
        //Dimension dp2 = panelCenter.getPreferredSize();
        panelCenter.setPreferredSize(new Dimension(600,635));

        //Dimension dp2Top = panelCenterTop.getPreferredSize();
        panelCenterTop.setPreferredSize(new Dimension(600,100));

        Dimension dpleftPanel1 = leftPanel.getPreferredSize();
        leftPanel.setPreferredSize(new Dimension(dpleftPanel1.width-120,dpleftPanel1.height-100));
        Dimension dpleftPanel11 = leftPanel1.getPreferredSize();
        //leftPanel1.setPreferredSize(new Dimension(180,25));
        //leftPanel2.setPreferredSize(new Dimension(0,25));
        //leftPanel3.setPreferredSize(new Dimension(25,10));
        //leftPanel4.setPreferredSize(new Dimension(25,10));
        rightPanel.setPreferredSize(new Dimension(400,100));


//panelCENTER (END)


//panelRIGHT

//panelRIGHT//Colori
        panelRight.setBackground(Color.black);

//panelRIGHT//Dimensioni personalizzate
        Dimension dp3 = panelRight.getPreferredSize();
        panelRight.setPreferredSize(new Dimension(200,635));
//panelRIGHT (END)

// Frame "New Chat"
        JFrame frameNewChat = new JFrame("Nuovo Amico");

        // Ottieni il riferimento al Content Pane
        Container frmContentPane = frameNewChat.getContentPane();

        // disporre i componenti nel content pane di un JFrame secondo
        // la politica di posizionamento dei componenti definita dal "FlowLayout"
        frmContentPane.setLayout(new FlowLayout());

        // Creo gli oggetti da inserire nel frame
        JLabel nameChat = new JLabel(" Nome");
        JButton nameButtonChat = new JButton("Crea");
        // oggetto "textBox"
        JTextField nameTextChat = new JTextField("");
        // do le dimensioni all'oggetto "textBox"
        Dimension d = nameTextChat.getPreferredSize();
        nameTextChat.setPreferredSize(new Dimension(d.width+160,d.height+8));

        // inserisco gli oggetti nel frame tramite il Container
        frmContentPane.add(nameChat);
        frmContentPane.add(nameTextChat);
        frmContentPane.add(nameButtonChat);

        // Imposta la dimensione minima per visualizzare tutti i componenti
        frameNewChat.pack();
        // Posizioniamo la finestra al centro dello schermo
        frameNewChat.setLocationRelativeTo(null);
// Frame "New Chat" (END)

        chat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeftMiddle.add(addChat);
                panelLeftMiddle.remove(addCanali);
                panelLeftMiddle.remove(addGruppi);

                DefaultListModel model = new DefaultListModel();
                model.addElement("Davide Parlapiano");

                listaChat.setModel(model);
                listaChat.setVisible(true);
                listaCanali.setVisible(false);
                listaGruppi.setVisible(false);
                //add new chat button
                addChat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //mostra il frame
                        frameNewChat.setVisible(true);

                    }
                });

//Bottone "Crea" del frame aggiungi Chat
                nameButtonChat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //aggiungi il nome inserito alla lista (ci dovrebbe essere un controllo prima o no?)
                        model.addElement(nameTextChat.getText());
                        listaChat.setModel(model);

                        //nascondi il frame
                        frameNewChat.setVisible(false);
                        //Messaggio di controllo
                        //JOptionPane.showMessageDialog(null, "Hai inserito "+ nameText.getText());
                        nameTextChat.setText("");
                    }
                });
            }
        });

// Frame "New Canali"
        JFrame frameNewCanali = new JFrame("Nuovo Canale");

        // Ottieni il riferimento al Content Pane
        Container frmContentPane2 = frameNewCanali.getContentPane();

        // disporre i componenti nel content pane di un JFrame secondo
        // la politica di posizionamento dei componenti definita dal "FlowLayout"
        frmContentPane2.setLayout(new FlowLayout());

        // Creo gli oggetti da inserire nel frame
        JLabel nameCanali = new JLabel(" Nome");
        JButton nameButtonCanali = new JButton("Crea");
        // oggetto "textBox"
        JTextField nameTextCanali = new JTextField("");
        // do le dimensioni all'oggetto "textBox"
        Dimension dCanali = nameTextCanali.getPreferredSize();
        nameTextCanali.setPreferredSize(new Dimension(dCanali.width+160,dCanali.height+8));

        // inserisco gli oggetti nel frame tramite il Container
        frmContentPane2.add(nameCanali);
        frmContentPane2.add(nameTextCanali);
        frmContentPane2.add(nameButtonCanali);

        // Imposta la dimensione minima per visualizzare tutti i componenti
        frameNewCanali.pack();
        // Posizioniamo la finestra al centro dello schermo
        frameNewCanali.setLocationRelativeTo(null);
// Frame "New Canali" (END)

        canali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeftMiddle.remove(addChat);
                panelLeftMiddle.add(addCanali);
                panelLeftMiddle.remove(addGruppi);
                DefaultListModel model2 = new DefaultListModel();
                model2.addElement("HD Blog");

                listaCanali.setModel(model2);
                listaChat.setVisible(false);
                listaCanali.setVisible(true);
                listaGruppi.setVisible(false);
                //add new canali button
                addCanali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //mostra il frame
                        frameNewCanali.setVisible(true);

                    }
                });

//Bottone "Crea" del frame aggiungi Canale
                nameButtonCanali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //aggiungi il nome inserito alla lista (ci dovrebbe essere un controllo prima o no?)
                        model2.addElement(nameTextCanali.getText());
                        listaCanali.setModel(model2);

                        //nascondi il frame
                        frameNewCanali.setVisible(false);
                        //Messaggio di controllo
                        //JOptionPane.showMessageDialog(null, "Hai inserito "+ nameText.getText());
                        nameTextCanali.setText("");
                    }
                });

            }
        });

// Frame "New Gruppi"
        JFrame frameNewGruppi = new JFrame("Nuovo Gruppo");

        // Ottieni il riferimento al Content Pane
        Container frmContentPane3 = frameNewGruppi.getContentPane();

        // disporre i componenti nel content pane di un JFrame secondo
        // la politica di posizionamento dei componenti definita dal "FlowLayout"
        frmContentPane3.setLayout(new FlowLayout());

        // Creo gli oggetti da inserire nel frame
        JLabel nameGruppi = new JLabel(" Nome");
        JButton nameButtonGruppi = new JButton("Crea");
        // oggetto "textBox"
        JTextField nameTextGruppi = new JTextField("");
        // do le dimensioni all'oggetto "textBox"
        Dimension dGruppi = nameTextGruppi.getPreferredSize();
        nameTextGruppi.setPreferredSize(new Dimension(dGruppi.width+160,dGruppi.height+8));

        // inserisco gli oggetti nel frame tramite il Container
        frmContentPane3.add(nameGruppi);
        frmContentPane3.add(nameTextGruppi);
        frmContentPane3.add(nameButtonGruppi);

        // Imposta la dimensione minima per visualizzare tutti i componenti
        frameNewGruppi.pack();
        // Posizioniamo la finestra al centro dello schermo
        frameNewGruppi.setLocationRelativeTo(null);
// Frame "New Gruppi" (END)

        gruppi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLeftMiddle.remove(addChat);
                panelLeftMiddle.remove(addCanali);
                panelLeftMiddle.add(addGruppi);
                DefaultListModel model3 = new DefaultListModel();
                model3.addElement("Supinfo");

                listaGruppi.setModel(model3);
                listaChat.setVisible(false);
                listaCanali.setVisible(false);
                listaGruppi.setVisible(true);

                //add new gruppi button
                addGruppi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //mostra il frame
                        frameNewGruppi.setVisible(true);

                    }
                });

//Bottone "Crea" del frame aggiungi Gruppi
                nameButtonGruppi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //aggiungi il nome inserito alla lista (ci dovrebbe essere un controllo prima o no?)
                        model3.addElement(nameTextGruppi.getText());
                        listaGruppi.setModel(model3);

                        //nascondi il frame
                        frameNewGruppi.setVisible(false);
                        //Messaggio di controllo
                        //JOptionPane.showMessageDialog(null, "Hai inserito "+ nameText.getText());
                        nameTextGruppi.setText("");
                    }
                });

            }
        });




        panel0.add(panelLeft);
        panel0.add(panelCenter);
        panel0.add(panelRight);



        setContentPane(panel0);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //Name.setVisible(false);
        setResizable(false);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}



