import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eva extends JFrame {

	private JPanel contentPane;
	private JTextField textEBIT;
	private JTextField textIr;
	private JTextField textWacc;
	private JTextField textCustoTerceiros;
	private JTextField textDespesasOperacionais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eva frame = new Eva();
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
	public Eva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 68, 580, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Economic Value Added");
		lblNewLabel.setBounds(252, 43, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEbit = new JLabel("EBIT:");
		lblEbit.setBounds(58, 130, 46, 14);
		contentPane.add(lblEbit);
		
		JLabel lblJrcsl = new JLabel("IR/CSL:");
		lblJrcsl.setBounds(58, 202, 46, 14);
		contentPane.add(lblJrcsl);
		
		JLabel lblCustoPrpriowacc = new JLabel("Custo Pr\u00F3prio (WACC):");
		lblCustoPrpriowacc.setBounds(58, 274, 136, 14);
		contentPane.add(lblCustoPrpriowacc);
		
		JLabel lblCustoTerceiros = new JLabel("Custo Terceiros:");
		lblCustoTerceiros.setBounds(306, 202, 103, 14);
		contentPane.add(lblCustoTerceiros);
		
		JLabel lblDespesasOperacionais = new JLabel("Despesas Operacionais:");
		lblDespesasOperacionais.setBounds(306, 130, 141, 14);
		contentPane.add(lblDespesasOperacionais);
		
		textEBIT = new JTextField();
		textEBIT.setBounds(107, 127, 175, 20);
		contentPane.add(textEBIT);
		textEBIT.setColumns(10);
		
		textIr = new JTextField();
		textIr.setBounds(114, 199, 168, 20);
		contentPane.add(textIr);
		textIr.setColumns(10);
		
		textWacc = new JTextField();
		textWacc.setBounds(204, 271, 78, 20);
		contentPane.add(textWacc);
		textWacc.setColumns(10);
		
		textCustoTerceiros = new JTextField();
		textCustoTerceiros.setBounds(419, 199, 175, 20);
		contentPane.add(textCustoTerceiros);
		textCustoTerceiros.setColumns(10);
		
		textDespesasOperacionais = new JTextField();
		textDespesasOperacionais.setBounds(457, 127, 134, 20);
		contentPane.add(textDespesasOperacionais);
		textDespesasOperacionais.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
				}

			private void calcular() {
				String mensagem = null;
							
				String ebit = textEBIT.getText().trim();
				float e = Float.parseFloat(ebit);
				
				String ir = textIr.getText().trim();
				float i = Float.parseFloat(ir);
				
				
				
				String wacc = textWacc.getText().trim();
				float w = Float.parseFloat(wacc);
				
				String cter = textCustoTerceiros.getText().trim();
				float c = Float.parseFloat(cter);
				
				String desp = textDespesasOperacionais.getText().trim();
				float d = Float.parseFloat(desp);
				
							
				float nopat = e - i;
				float resultado = (nopat - c) - d;
				
		
				JOptionPane.showMessageDialog(null,"O resutado do NOPAT é de: R$ "+nopat+ "\nO resutado final do EVA é de: R$ " +resultado);
				textEBIT.setText(""); // limpa os campos
				textIr.setText(""); 
				textWacc.setText(""); 
				textCustoTerceiros.setText(""); 
				textDespesasOperacionais.setText(""); 
				
				textEBIT.requestFocus(); // Após o cadastro foca no campo nome
			}
		});
		btnCalcular.setBounds(157, 346, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaprincipal = new TelaPrincipal();
				dispose(); // fecha a primeira tela
				telaprincipal.setVisible(true); // chama a segunda tela
			}
		});
		btnVoltar.setBounds(403, 346, 89, 23);
		contentPane.add(btnVoltar);
	}
}
