package com.example.controladorop;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {
    
    @SuppressWarnings("unused")
    private JLabel titulo;

	private JButton iniciar;

	public Login () {
        
		setTitle( "Controlador Ordem De Produção" );
		setBounds( 100, 120, 600, 500 );
		setLayout( null );
		

        titulo = adicionaJLabel(228, 10, 220, 30, "CONTROLADOR DE OP");

		iniciar = adicionaJButton(225, 50, 220, 30, "Entrar");
		iniciar.addActionListener(entrar);
		
		
        

        setLocationRelativeTo(null);
	    setVisible( true );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    }
    
    
    
    private JLabel adicionaJLabel(int x, int y, int w, int h, String texto){
		JLabel novaLabel = new JLabel(texto);
		novaLabel.setBounds(x, y, w, h);
		getContentPane().add(novaLabel);
		return novaLabel;
	}
	
    @SuppressWarnings("unused")
	private JTextField adicionaJTextField(int x, int y, int w, int h){
		JTextField novoTextField = new JTextField();
		novoTextField.setBounds(x, y, w, h);
		getContentPane().add(novoTextField);
		return novoTextField;
	}
	
	private JButton adicionaJButton(int x, int y, int w, int h, String texto){
		JButton novoBotao = new JButton(texto);
		novoBotao.setBounds(x, y, w, h);
		getContentPane().add(novoBotao);
		return novoBotao;
	}

	public static void main(String[] args) {
		new Login();
	}

	ActionListener entrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
            try {
                new InterfaceConsulta();
				dispose();

            } catch (NumberFormatException ex) {
            
            }
        }


	};
	
}

