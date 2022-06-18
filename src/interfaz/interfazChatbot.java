package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import chatbot.FiltradoReglas;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class interfazChatbot extends JFrame {

	private JPanel contentPane;
	public FiltradoReglas filtradoReglas;
	
	//Componentes
	private JTextArea areaTextoChat;
	private JButton btnEnviarMensaje;
	private JTextField textField;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazChatbot frame = new interfazChatbot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public interfazChatbot(FiltradoReglas fr) {
		this.filtradoReglas = fr;
		renderComponents();
		String mensajeInicio = generarFraseInicio(); //genero un mensaje de inicio entre las opciones 
		this.setMensaje(mensajeInicio, true); //al mensaje le seteo como inicio la frase random de ayuda y le paso true porque es el bot quien lo manda 
	}
	
	public interfazChatbot() {
		renderComponents();
	}
	
	public static String generarFraseInicio() {
		
		ArrayList<String> aux = new ArrayList<>();
		
		aux.add("¡Hola! Soy tu asistente virtual. ¿Con qué necesitas ayuda? \n "
				+ "Puedo ayudarte con: PASAJES - HOTELES - PAQUETES TURISTICOS");
		aux.add("¡Hola! Soy tu asistente virtual. ¿En qué te puedo ayudar? \n "
				+ "Puedo ayudarte con: PASAJES - HOTELES - PAQUETES TURISTICOS");
		aux.add("¡Hola! Soy tu asistente virtual. ¿Con qué te puedo ayudar? \n "
				+ "Puedo ayudarte con: PASAJES - HOTELES - PAQUETES TURISTICOS");

		return aux.get(new Random(System.currentTimeMillis()).nextInt(aux.size()));
	}

	private void renderComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(interfazChatbot.class.getResource("/imagenes/botOrange.png")));
		
		btnEnviarMensaje = new JButton("");
		textField =  new RoundJTextField(40); //lo declaro como RoundJTextField para que se haga redondeado
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 475);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(0, 0, 457, 43);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(interfazChatbot.class.getResource("/imagenes/botWhite.png")));
		lblNewLabel.setBounds(0, 0, 457, 43);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(244, 164, 96));
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(244, 164, 96)));
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(0, 380, 457, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField.setForeground(SystemColor.desktop);
		textField.setBounds(35, 10, 333, 40);
		panel_1.add(textField);
		textField.setToolTipText("");
		textField.setBorder(new LineBorder(new Color(244, 164, 96), 1, true));
		textField.setColumns(10);
		TextPrompt tp = new TextPrompt("Escribí tu consulta", textField);
		textField.setBorder(BorderFactory.createCompoundBorder(
				textField.getBorder(), 
		        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				textField.requestFocus();
			}
		});
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setMensaje(textField.getText(), false);
					textField.setText("");
					textField.requestFocus();
					String nuevoMensajeBot = filtradoReglas.nuevoCicloDeRespuesta(textField.getText());
					setMensaje(nuevoMensajeBot, true);
				}
			}
		});
		
		btnEnviarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMensaje(textField.getText(), false);
				textField.setText("");
				textField.requestFocus();
				String nuevoMensajeBot = filtradoReglas.nuevoCicloDeRespuesta(textField.getText());
				setMensaje(nuevoMensajeBot, true);
			}
		});
		btnEnviarMensaje.setBackground(SystemColor.text);
		btnEnviarMensaje.setForeground(new Color(244, 164, 96));
		btnEnviarMensaje.setBounds(378, 11, 40, 37);
		btnEnviarMensaje.setBorder(new RoundedBorder(40));
		btnEnviarMensaje.setIcon(new ImageIcon(getClass().getResource("/imagenes/enviar-mensaje.png")));
		panel_1.add(btnEnviarMensaje);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 43, 457, 336);
		scrollPane.setBorder(null);
		contentPane.add(scrollPane);
		
		//Componentes declarados
		areaTextoChat = new JTextArea();
		scrollPane.setViewportView(areaTextoChat);
		
		areaTextoChat.setEditable(false);
		areaTextoChat.setBackground(SystemColor.text);
	}
	
	public void setMensaje(String mensaje, boolean bot) {
		if (bot) {
			this.areaTextoChat.append("\n" + " - Bot: " + mensaje + "\n");
		} else {
			this.areaTextoChat.append("\n" + " + Tu: " + mensaje + "\n");
		}
		this.areaTextoChat.setCaretPosition(areaTextoChat.getDocument().getLength());
	}
}
