package trabajoColaborativo.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	private JFrame frmInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setResizable(false);
		frmInicio.setTitle("Inicio");
		frmInicio.setBounds(100, 100, 260, 280);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ABM Persona");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMPersona per = new ABMPersona();
				per.getFrmAbmpersona().setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 224, 59);
		frmInicio.getContentPane().add(btnNewButton);
		
		JButton btnAbmRol = new JButton("ABM Rol");
		btnAbmRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMRol rol = new ABMRol();
				rol.getFrmAbmrol().setVisible(true);
			}
		});
		btnAbmRol.setBounds(10, 81, 224, 59);
		frmInicio.getContentPane().add(btnAbmRol);
		
		JButton btnAbmFuncionalidades = new JButton("ABM Funcionalidades");
		btnAbmFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMFuncionalidad fun = new ABMFuncionalidad();
				fun.getFrmAbmfuncionalidad().setVisible(true);
			}
		});
		btnAbmFuncionalidades.setBounds(10, 151, 224, 59);
		frmInicio.getContentPane().add(btnAbmFuncionalidades);
	}

}
