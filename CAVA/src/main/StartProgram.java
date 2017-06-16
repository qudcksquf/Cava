package main;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class StartProgram extends JFrame {

	private JPanel contentPane;
	private StartProgram sp;
	private ImageIcon cavaLogo; 
	private JFrame hframe;
	private JTextArea hta;
	private JScrollPane jsp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Music.init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartProgram frame = new StartProgram();
					frame.setVisible(true);
					Music.changeBGM("BGM/" + "start.wav");
				} catch (Exception e) {
					System.out.println("start BGM file has not found!");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartProgram() {
		setTitle("Cava");
		sp=this;
		cavaLogo = new ImageIcon("Image/" + "cavaLogo.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		setResizable(false);
		JButton btnStart = new JButton("Start");
		
		Window window = new Window(sp);
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{   
				Window frame = window;
				if(!((Field)frame.getContentPane()).getMappanel().getTimer().isRunning())
					((Field)frame.getContentPane()).getMappanel().getTimer().start();
				
				Music.offBGM();
				Music.changeBGM("BGM/" + "stage" + ((Field)window.getContentPane()).getMappanel().getCar().getMap().getStage() + ".wav");
				
				frame.setVisible(true);
				setVisible(false);
			}
		});   
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(cavaLogo.getImage(), 100, 30, 100, 60, null);
			}
		};
		
		hframe = new JFrame();
		hframe.setSize(700, 500);
		hframe.setResizable(false);
		hta = new JTextArea();
		hta.setEditable(false);
		jsp = new JScrollPane(hta);
		hframe.add(jsp);
		hframe.addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent e) {   
				setEnabled(true);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		try{
			File tf = new File("Description.txt");
			FileReader fr = new FileReader(tf);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine())!=null){
				hta.setText(hta.getText() + '\n' + line);
			}
			br.close();
		} catch(IOException e2){
			System.out.println("IOExceoption for Description!");
		}
		
		JButton btnHowToPlay = new JButton("How to play");
		btnHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hframe.setVisible(true);
				setEnabled(false);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(101, Short.MAX_VALUE)
					.addComponent(btnHowToPlay)
					.addGap(86))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(120, Short.MAX_VALUE)
					.addComponent(btnStart)
					.addGap(107))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(122, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addGap(109))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHowToPlay)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
