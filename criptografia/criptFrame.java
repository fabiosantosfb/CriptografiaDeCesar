package criptografia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import controller.criptografia;
import custom.dialogClass;
import custom.dialogClass.painelVerde;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class criptFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldKey;
	private JTextArea textAreaMenssage;
	private JTextArea textAreaCript, textAreaHex, textAreaBinario;
	private criptografia cript;
	private int key_i;
	private ButtonGroup grup;
	private JRadioButton rdbtnHide, rdbtnReveal;
	private boolean hide ;
	private JTextField textFieldLinha;
	private JTextField textFieldColuna;
	private JTable table;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					criptFrame frame = new criptFrame();
					frame.setLocationRelativeTo( null ); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public criptFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\fabiano\\Documents\\criptografiaJava\\criptografia\\src\\imag\\iconeCadeado.png"));
		super.setTitle("Criptografia Estacio ADS_1 2015.2-Version(1.2)");
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 464, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 428, 740);
		contentPane.add(tabbedPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Arial", Font.PLAIN, 12));
		tabbedPane.addTab("Criptografia Cesar", null, menuBar, null);
		tabbedPane.setBackgroundAt(0, new Color(248, 248, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		menuBar.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Key:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 11, 58, 15);
		panel.add(lblNewLabel);
		
		textFieldKey = new JTextField();
		textFieldKey.setBounds(82, 7, 44, 20);
		panel.add(textFieldKey);
		textFieldKey.setColumns(10);
		
		rdbtnHide = new JRadioButton("hide");
		rdbtnHide.setBackground(new Color(248, 248, 255));
		rdbtnHide.setSelected(true);
		rdbtnHide.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnHide.setBounds(146, 43, 77, 23);
		panel.add(rdbtnHide);
		
		rdbtnReveal = new JRadioButton("reveal");
		rdbtnReveal.setBackground(new Color(248, 248, 255));
		rdbtnReveal.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnReveal.setBounds(227, 43, 109, 23);
		panel.add(rdbtnReveal);
		
		grup = new ButtonGroup();
		grup.add(rdbtnHide);
		grup.add(rdbtnReveal);
		
		
		JLabel lblMessange = new JLabel("Menssagem:");
		lblMessange.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMessange.setBounds(44, 40, 132, 26);
		panel.add(lblMessange);
		
		textAreaMenssage = new JTextArea();
		textAreaMenssage.setTabSize(0);
		textAreaMenssage.setLineWrap(true);
		textAreaMenssage.setBounds(44, 74, 355, 56);
		panel.add(textAreaMenssage);
		
		JScrollPane scrollPaneMessange = new JScrollPane(textAreaMenssage);
		scrollPaneMessange.setBounds(44, 74, 355, 56);
		panel.add(scrollPaneMessange);
		scrollPaneMessange.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);			
		
		JLabel lblCripti = new JLabel("Criptografia ASC:");
		lblCripti.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCripti.setBounds(44, 136, 161, 20);
		panel.add(lblCripti);
		
		textAreaCript = new JTextArea();
		textAreaCript.setTabSize(0);
		textAreaCript.setLineWrap(true);
		textAreaCript.setBounds(44, 161, 355, 93);
		panel.add(textAreaCript);
		
		JScrollPane scrollPaneCript = new JScrollPane(textAreaCript);
		scrollPaneCript.setBounds(44, 161, 355, 93);
		panel.add(scrollPaneCript);
		scrollPaneCript.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		textAreaHex = new JTextArea();
		textAreaHex.setTabSize(0);
		textAreaHex.setLineWrap(true);
		textAreaHex.setBounds(40, 297, 359, 100);
		panel.add(textAreaHex);
		
		JScrollPane scrollPaneHex = new JScrollPane(textAreaHex);
		scrollPaneHex.setBounds(40, 297, 359, 100);
		panel.add(scrollPaneHex);
		scrollPaneHex.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
		
		JLabel lblHex = new JLabel("Criptografia HexDecimal:");
		lblHex.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHex.setBounds(44, 263, 233, 23);
		panel.add(lblHex);
		
		JLabel lblBinario = new JLabel("Criptografia Binario:");
		lblBinario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBinario.setBounds(44, 408, 161, 24);
		panel.add(lblBinario);
		
		textAreaBinario = new JTextArea();
		textAreaBinario.setTabSize(0);
		textAreaBinario.setLineWrap(true);
		textAreaBinario.setBounds(40, 443, 359, 100);
		panel.add(textAreaBinario);
		
		JScrollPane scrollPaneBinario = new JScrollPane(textAreaBinario);
		scrollPaneBinario.setBounds(40, 443, 359, 100);
		panel.add(scrollPaneBinario);
		scrollPaneBinario.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton btnCripter = new JButton("Criptografar");
		btnCripter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String msg = textAreaMenssage.getText().toString();
				
				if(!textFieldKey.getText().equals("")){
				if((Integer.parseInt(textFieldKey.getText())<=26) && (Integer.parseInt(textFieldKey.getText())>0)){
					
					if(rdbtnHide.isSelected()){
						hide=true;
					}else if(rdbtnReveal.isSelected()){
						hide=false;
					}
					
					try {
						key_i = Integer.parseInt(textFieldKey.getText().toString());
						try{
							cript = new criptografia(msg,key_i,hide);
							String msgC = cript.getCript();
							textAreaCript.setText(msgC);
						try{
							

							String hexD=cript.getCriptHex();
							textAreaHex.setText(hexD);
			
						} catch(NumberFormatException e){
							System.out.println("Ocorreu um erro na converção Hexdecimal!");
						}
						try{
							
							String hexB=cript.getCriptBin();
							textAreaBinario.setText(hexB);
							
						} catch (NumberFormatException e){
							System.out.println("Ocorreu um erro na converção Binaria!");
						}
						}catch(NumberFormatException e){
							JOptionPane.showMessageDialog(null,"Problema na classe criptografia !","Alerta",JOptionPane.WARNING_MESSAGE);
						}
				
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,"Digite apenas numeros!","Alerta",JOptionPane.WARNING_MESSAGE);
				    }
				
				}else{
					JOptionPane.showMessageDialog(null,"Digite a key de 1 a 26 !","Alerta",JOptionPane.WARNING_MESSAGE);
				}
				}else{
					JOptionPane.showMessageDialog(null,"Digite a key !","Alerta",JOptionPane.WARNING_MESSAGE);
				}

				
			}
		});
		btnCripter.setBounds(44, 638, 115, 38);
		panel.add(btnCripter);
		
		JMenuBar menuBar_1 = new JMenuBar();
		tabbedPane.addTab("Criptografia Espartana", null, menuBar_1, null);
		tabbedPane.setBackgroundAt(1, new Color(248, 248, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(248, 248, 255));
		menuBar_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLinha = new JLabel("Linha:");
		lblLinha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLinha.setBounds(22, 11, 58, 24);
		panel_1.add(lblLinha);
		
		textFieldLinha = new JTextField();
		textFieldLinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldLinha.setBounds(63, 14, 27, 20);
		panel_1.add(textFieldLinha);
		textFieldLinha.setColumns(10);
		
		JLabel lblColuna = new JLabel("Coluna:");
		lblColuna.setFont(new Font("Arial", Font.PLAIN, 15));
		lblColuna.setBounds(100, 11, 86, 24);
		panel_1.add(lblColuna);
		
		textFieldColuna = new JTextField();
		textFieldColuna.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldColuna.setBounds(152, 14, 27, 20);
		panel_1.add(textFieldColuna);
		textFieldColuna.setColumns(10);
		
		JLabel lblMenssagem = new JLabel("Menssagem:");
		lblMenssagem.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMenssagem.setBounds(22, 50, 91, 20);
		panel_1.add(lblMenssagem);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(22, 180, 390, 213);
		panel_1.add(table);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 74, 390, 55);
		panel_1.add(textArea);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(22, 74, 390, 55);
		panel_1.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton buttonCriptEspart = new JButton("Criptografar");
		buttonCriptEspart.setBounds(44, 638, 115, 38);
		panel_1.add(buttonCriptEspart);
	}
}
