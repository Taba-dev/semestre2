package JTableGrupal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Ventana {

	private JFrame frmGestinDeUsuarios;
	private JTextField textCedula;
	private JTextField textApellido;
	private JTextField textNombre;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnMostrarTodo;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmGestinDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestinDeUsuarios = new JFrame();
		frmGestinDeUsuarios.setTitle("Gesti\u00F3n de Usuarios");
		frmGestinDeUsuarios.setResizable(false);
		frmGestinDeUsuarios.setBounds(100, 100, 450, 300);
		frmGestinDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestinDeUsuarios.getContentPane().setLayout(null);

		textCedula = new JTextField();
		textCedula.setBounds(132, 36, 128, 20);
		frmGestinDeUsuarios.getContentPane().add(textCedula);
		textCedula.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(132, 129, 128, 22);
		frmGestinDeUsuarios.getContentPane().add(textApellido);
		textApellido.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(132, 81, 128, 22);
		frmGestinDeUsuarios.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// VALIDACION DE CAMPOS VACIOS
				if (validarCampos(textCedula.getText(), textNombre.getText(), textApellido.getText())) {
					String ci = textCedula.getText();
					String nombre = textNombre.getText();
					String apellido = textApellido.getText();
					Empleado e = new Empleado(ci, nombre, apellido);
					// VALIDACION RETORNO DEL METODO INSERT
					if (DAOEmpleados.insert(e)) {
						JOptionPane.showMessageDialog(null, "Registrado con exito.", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
				}
			}
		});
		btnAlta.setBounds(300, 35, 89, 23);
		frmGestinDeUsuarios.getContentPane().add(btnAlta);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VALIDACION DE CAMPOS VACIOS
				if (validarCampos(textCedula.getText(), textNombre.getText(), textApellido.getText())) {
					String ci = textCedula.getText();
					String nombre = textNombre.getText();
					String apellido = textApellido.getText();
					Empleado e1 = new Empleado(ci, nombre, apellido);
					if (DAOEmpleados.delete(e1)) {
						JOptionPane.showMessageDialog(null, "Se elimino con exito.", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					} else {
						JOptionPane.showMessageDialog(null, "Error al eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnEliminar.setBounds(300, 80, 89, 23);
		frmGestinDeUsuarios.getContentPane().add(btnEliminar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VALIDACION DE CAMPO VACIO
				if (textCedula.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese una cedula.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String ci = textCedula.getText();
					Empleado re = DAOEmpleados.find(ci);
					// SE VALIDA QUE EXISTA EL EMPLEADO
					if (re != null) {
						textNombre.setText(re.getNombre());
						textApellido.setText(re.getApellido());
					} else {
						JOptionPane.showMessageDialog(null, "El empleado no existe.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});
		btnBuscar.setBounds(300, 128, 89, 23);
		frmGestinDeUsuarios.getContentPane().add(btnBuscar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VALIDACION DE CAMPOS VACIOS
				if (validarCampos(textCedula.getText(), textNombre.getText(), textApellido.getText())) {
					String ci = textCedula.getText();
					String nombre = textNombre.getText();
					String apellido = textApellido.getText();
					Empleado e1 = new Empleado(ci, nombre, apellido);
					// SE VALIDA SI ES EXITOSO O NO
					if (DAOEmpleados.update(e1)) {
						JOptionPane.showMessageDialog(null, "Se modifico con exito.", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo modificar", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnModificar.setBounds(300, 176, 89, 23);
		frmGestinDeUsuarios.getContentPane().add(btnModificar);

		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarTodo mt = new MostrarTodo();
				mt.mostrar();
			}
		});
		btnMostrarTodo.setBounds(12, 176, 157, 23);
		frmGestinDeUsuarios.getContentPane().add(btnMostrarTodo);

		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(48, 39, 46, 14);
		frmGestinDeUsuarios.getContentPane().add(lblCedula);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(48, 84, 46, 14);
		frmGestinDeUsuarios.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(48, 132, 46, 14);
		frmGestinDeUsuarios.getContentPane().add(lblApellido);
		//BOTÓN LIMPIAR
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(191, 175, 97, 25);
		frmGestinDeUsuarios.getContentPane().add(btnLimpiar);
	}

	// VALIDACION DE CAMPOS VACIOS
	public boolean validarCampos(String ci, String nom, String ape) {
		boolean ret = true;
		if (textCedula.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese una cedula.", "Error", JOptionPane.ERROR_MESSAGE);
			ret = false;
		} else if (textNombre.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
			ret = false;
		} else if (textApellido.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un apellido.", "Error", JOptionPane.ERROR_MESSAGE);
			ret = false;
		}
		return ret;
	}

	// LIMPIA LOS CAMPOS
	public void limpiarCampos() {
		textCedula.setText("");
		textNombre.setText("");
		textApellido.setText("");
	}

}
