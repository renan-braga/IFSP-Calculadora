import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Calculadora {

	private JFrame frame;
	private JTextField txtTela;
	private BigDecimal numAux;
	private Operacao operacao;
	private boolean calculou;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Calculadora DSI - Renan Braga");
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 413, 409);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtTela = new JTextField();
		txtTela.setBounds(24, 22, 351, 43);
		panel.add(txtTela);
		txtTela.setColumns(10);
		
		operacao = new Operacao("+");
		numAux = new BigDecimal(0);
		calculou = false;
		
		ActionListener apertaNumero = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(calculou) {
					txtTela.setText("");
				}

				calculou = false;
				String texto = txtTela.getText() + ((JButton)e.getSource()).getText();
				txtTela.setText(texto);
			}
		};
		
		ActionListener apertaOperacao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BigDecimal numAtual = new BigDecimal(txtTela.getText());
				txtTela.setText(String.valueOf(operacao.realizaOperacao(numAux, numAtual)));
				numAux = numAtual;
				calculou = true;
				
				operacao.setCaracter(((JButton) e.getSource()).getText());
			}
		};
		
		JButton btnUm = new JButton("1");
		btnUm.setBounds(24, 89, 62, 51);
		panel.add(btnUm);
		btnUm.addActionListener(apertaNumero);
		
		JButton btnDois = new JButton("2");
		btnDois.setBounds(113, 89, 62, 51);
		panel.add(btnDois);
		btnDois.addActionListener(apertaNumero);
		
		JButton btnTres = new JButton("3");
		btnTres.setBounds(201, 89, 62, 51);
		panel.add(btnTres);
		btnTres.addActionListener(apertaNumero);
		
		JButton btnQuatro = new JButton("4");
		btnQuatro.setBounds(24, 161, 62, 51);
		panel.add(btnQuatro);
		btnQuatro.addActionListener(apertaNumero);
		
		JButton btnCinco = new JButton("5");
		btnCinco.setBounds(113, 161, 62, 51);
		panel.add(btnCinco);
		btnCinco.addActionListener(apertaNumero);
		
		JButton btnSeis = new JButton("6");
		btnSeis.setBounds(201, 161, 62, 51);
		panel.add(btnSeis);
		btnSeis.addActionListener(apertaNumero);
		
		JButton btnSete = new JButton("7");
		btnSete.setBounds(24, 234, 62, 51);
		panel.add(btnSete);
		btnSete.addActionListener(apertaNumero);
		
		JButton btnOito = new JButton("8");
		btnOito.setBounds(113, 234, 62, 51);
		panel.add(btnOito);
		btnOito.addActionListener(apertaNumero);
		
		JButton btnNove = new JButton("9");
		btnNove.setBounds(201, 234, 62, 51);
		panel.add(btnNove);
		btnNove.addActionListener(apertaNumero);
		
		JButton btnZero = new JButton("0");
		btnZero.setBounds(113, 302, 62, 51);
		panel.add(btnZero);
		btnZero.addActionListener(apertaNumero);
		
		JButton btnZerar = new JButton("CE");
		btnZerar.setBounds(309, 89, 62, 51);
		panel.add(btnZerar);
		btnZerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operacao.setCaracter("+");
				numAux =  new BigDecimal(0);
				txtTela.setText("");
			}
		});
		
		JButton btnMais = new JButton("+");
		btnMais.setMargin(new Insets(0, 0, 0, 0));
		btnMais.setBounds(309, 241, 37, 37);
		panel.add(btnMais);
		btnMais.addActionListener(apertaOperacao);
		
		JButton btnMenos = new JButton("-");
		btnMenos.setMargin(new Insets(0, 0, 0, 0));
		btnMenos.setBounds(356, 241, 37, 37);
		panel.add(btnMenos);
		btnMenos.addActionListener(apertaOperacao);
		
		JButton btnDividir = new JButton("/");
		btnDividir.setMargin(new Insets(0, 0, 0, 0));
		btnDividir.setBounds(309, 289, 37, 37);
		panel.add(btnDividir);
		btnDividir.addActionListener(apertaOperacao);
		
		JButton btnMultiplicar = new JButton("*");
		btnMultiplicar.setMargin(new Insets(0, 0, 2, 0));
		btnMultiplicar.setBounds(356, 289, 37, 37);
		panel.add(btnMultiplicar);
		btnMultiplicar.addActionListener(apertaOperacao);
		
		JButton btnResultado = new JButton("=");
		btnResultado.setBounds(269, 349, 124, 37);
		panel.add(btnResultado);
		
		JButton btnPonto = new JButton(" . ");
		btnPonto.setBounds(201, 302, 62, 51);
		panel.add(btnPonto);
		btnPonto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!txtTela.getText().contains("."))
					txtTela.setText(txtTela.getText()+".");
			}
		});
		
		btnResultado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtTela.setText(""+operacao.realizaOperacao(numAux, new BigDecimal(txtTela.getText())));
				numAux = new BigDecimal(0);
				operacao.setCaracter("+");
			}
		});
	}
}
