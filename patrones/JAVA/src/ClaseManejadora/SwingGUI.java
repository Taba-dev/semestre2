package ClaseManejadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class SwingGUI {

	private JFrame frmTareaDao;
	private JTextField textFieldDocumento;
	private JTextField textFieldNombre1;
	private JTextField textFieldNombre2;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldBuscarNombre;
	private JTextField textFieldBuscarApellido;
	private JTextField textFieldEditDocumento;
	private JTextField textFieldEditNombre1;
	private JTextField textFieldEditNombre2;
	private JTextField textFieldEditApellido1;
	private JTextField textFieldEditApellido2;
	private JTextField textFieldEditarID;
	private JTextField textFieldDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingGUI window = new SwingGUI();
					window.frmTareaDao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingGUI() {
		initializeSwingGUI();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeSwingGUI() {
		frmTareaDao = new JFrame();
		frmTareaDao.setResizable(false);
		frmTareaDao.setTitle("Tarea DAO");
		frmTareaDao.setVisible(true);
		frmTareaDao.setBounds(100, 100, 394, 361);
		frmTareaDao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTareaDao.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 378, 322);
		frmTareaDao.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Contar", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextPane textPaneCuenta = new JTextPane();
		textPaneCuenta.setBounds(10, 59, 310, 23);
		panel_1.add(textPaneCuenta);
		textPaneCuenta.setVisible(false);
		textPaneCuenta.setBackground(SystemColor.control);
		
		JButton btnNewButton_1 = new JButton("Contar");
		btnNewButton_1.setBounds(10, 11, 87, 34);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cuenta = DAOPersona.cuentaPersonas();
				String cuentaString = "Hay "+Integer.toString(cuenta)+" registros en la base de datos.";
				textPaneCuenta.setText(cuentaString);
				textPaneCuenta.setVisible(true);
			}
		});
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Listar", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.setBounds(10, 11, 84, 33);
		panel_3.add(btnNewButton);
		
		JTextPane listaPersonas = new JTextPane();
		listaPersonas.setBackground(SystemColor.menu);
		listaPersonas.setBounds(10, 45, 353, 238);
		panel_3.add(listaPersonas);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedList<Persona> personas = null;
				personas = DAOPersona.findAll();
				String personasString = "";
				for (Persona p1 : personas) {
					personasString = personasString+p1.nombre1+" "+p1.apellido1+"\n";					
				}
				listaPersonas.setText(personasString);

			}
		});
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Insertar", null, panel, null);
		panel.setLayout(null);
		
		JTextPane textPaneAgregar = new JTextPane();
		textPaneAgregar.setBounds(20, 204, 310, 20);
		panel.add(textPaneAgregar);
		textPaneAgregar.setBackground(SystemColor.menu);
		
		JButton btnNewButton_2 = new JButton("Agregar");
		btnNewButton_2.setBounds(20, 156, 86, 37);
		panel.add(btnNewButton_2);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setBounds(126, 11, 104, 20);
		panel.add(textFieldDocumento);
		textFieldDocumento.setColumns(10);
		
		textFieldNombre1 = new JTextField();
		textFieldNombre1.setBounds(126, 39, 104, 20);
		panel.add(textFieldNombre1);
		textFieldNombre1.setColumns(10);
		
		textFieldNombre2 = new JTextField();
		textFieldNombre2.setBounds(126, 65, 104, 20);
		panel.add(textFieldNombre2);
		textFieldNombre2.setColumns(10);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(126, 94, 104, 20);
		panel.add(textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(126, 124, 104, 20);
		panel.add(textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		JTextPane txtpnDocumento = new JTextPane();
		txtpnDocumento.setBounds(20, 11, 104, 20);
		panel.add(txtpnDocumento);
		txtpnDocumento.setText("Documento");
		txtpnDocumento.setBackground(SystemColor.menu);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setBounds(20, 39, 104, 20);
		panel.add(txtpnNombre);
		txtpnNombre.setText("Primer nombre");
		txtpnNombre.setBackground(SystemColor.menu);
		
		JTextPane txtpnSegundoNombre = new JTextPane();
		txtpnSegundoNombre.setBounds(20, 65, 104, 20);
		panel.add(txtpnSegundoNombre);
		txtpnSegundoNombre.setText("Segundo nombre");
		txtpnSegundoNombre.setBackground(SystemColor.menu);
		
		JTextPane txtpnPrimerApellido = new JTextPane();
		txtpnPrimerApellido.setBounds(20, 94, 104, 20);
		panel.add(txtpnPrimerApellido);
		txtpnPrimerApellido.setText("Primer apellido");
		txtpnPrimerApellido.setBackground(SystemColor.menu);
		
		JTextPane txtpnSegundoApellido = new JTextPane();
		txtpnSegundoApellido.setBounds(20, 124, 104, 20);
		panel.add(txtpnSegundoApellido);
		txtpnSegundoApellido.setText("Segundo apellido");
		txtpnSegundoApellido.setBackground(SystemColor.menu);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Buscar", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2_1 = new JButton("Buscar");
		btnNewButton_2_1.setBounds(31, 89, 87, 37);
		panel_2.add(btnNewButton_2_1);
		
		textFieldBuscarNombre = new JTextField();
		textFieldBuscarNombre.setBounds(137, 21, 104, 20);
		panel_2.add(textFieldBuscarNombre);
		textFieldBuscarNombre.setColumns(10);
		
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setBounds(31, 23, 104, 20);
		panel_2.add(txtpnNombre_1);
		txtpnNombre_1.setText("Primer nombre");
		txtpnNombre_1.setBackground(SystemColor.menu);
		
		JTextPane txtpnPrimerApellido_1 = new JTextPane();
		txtpnPrimerApellido_1.setBounds(31, 54, 104, 20);
		panel_2.add(txtpnPrimerApellido_1);
		txtpnPrimerApellido_1.setText("Primer apellido");
		txtpnPrimerApellido_1.setBackground(SystemColor.menu);
		
		textFieldBuscarApellido = new JTextField();
		textFieldBuscarApellido.setBounds(137, 52, 104, 20);
		panel_2.add(textFieldBuscarApellido);
		textFieldBuscarApellido.setColumns(10);
		
		JTextPane textPaneBuscar = new JTextPane();
		textPaneBuscar.setBackground(SystemColor.menu);
		textPaneBuscar.setBounds(31, 141, 304, 46);
		panel_2.add(textPaneBuscar);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Editar", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(30, 196, 94, 36);
		panel_4.add(btnEditar);
		
		textFieldEditDocumento = new JTextField();
		textFieldEditDocumento.setColumns(10);
		textFieldEditDocumento.setBounds(136, 52, 104, 20);
		panel_4.add(textFieldEditDocumento);
		
		textFieldEditNombre1 = new JTextField();
		textFieldEditNombre1.setColumns(10);
		textFieldEditNombre1.setBounds(136, 80, 104, 20);
		panel_4.add(textFieldEditNombre1);
		
		textFieldEditNombre2 = new JTextField();
		textFieldEditNombre2.setColumns(10);
		textFieldEditNombre2.setBounds(136, 106, 104, 20);
		panel_4.add(textFieldEditNombre2);
		
		textFieldEditApellido1 = new JTextField();
		textFieldEditApellido1.setColumns(10);
		textFieldEditApellido1.setBounds(136, 135, 104, 20);
		panel_4.add(textFieldEditApellido1);
		
		textFieldEditApellido2 = new JTextField();
		textFieldEditApellido2.setColumns(10);
		textFieldEditApellido2.setBounds(136, 165, 104, 20);
		panel_4.add(textFieldEditApellido2);
		
		JTextPane txtpnDocumento_1 = new JTextPane();
		txtpnDocumento_1.setText("Documento");
		txtpnDocumento_1.setBackground(SystemColor.menu);
		txtpnDocumento_1.setBounds(30, 52, 104, 20);
		panel_4.add(txtpnDocumento_1);
		
		JTextPane txtpnNombre_2 = new JTextPane();
		txtpnNombre_2.setText("Primer nombre");
		txtpnNombre_2.setBackground(SystemColor.menu);
		txtpnNombre_2.setBounds(30, 80, 104, 20);
		panel_4.add(txtpnNombre_2);
		
		JTextPane txtpnSegundoNombre_1 = new JTextPane();
		txtpnSegundoNombre_1.setText("Segundo nombre");
		txtpnSegundoNombre_1.setBackground(SystemColor.menu);
		txtpnSegundoNombre_1.setBounds(30, 106, 104, 20);
		panel_4.add(txtpnSegundoNombre_1);
		
		JTextPane txtpnPrimerApellido_2 = new JTextPane();
		txtpnPrimerApellido_2.setText("Primer apellido");
		txtpnPrimerApellido_2.setBackground(SystemColor.menu);
		txtpnPrimerApellido_2.setBounds(30, 135, 104, 20);
		panel_4.add(txtpnPrimerApellido_2);
		
		JTextPane txtpnSegundoApellido_1 = new JTextPane();
		txtpnSegundoApellido_1.setText("Segundo apellido");
		txtpnSegundoApellido_1.setBackground(SystemColor.menu);
		txtpnSegundoApellido_1.setBounds(30, 165, 104, 20);
		panel_4.add(txtpnSegundoApellido_1);
		
		textFieldEditarID = new JTextField();
		textFieldEditarID.setColumns(10);
		textFieldEditarID.setBounds(136, 21, 104, 20);
		panel_4.add(textFieldEditarID);
		
		JTextPane txtpnDocumento_1_1 = new JTextPane();
		txtpnDocumento_1_1.setText("ID");
		txtpnDocumento_1_1.setBackground(SystemColor.menu);
		txtpnDocumento_1_1.setBounds(30, 21, 104, 20);
		panel_4.add(txtpnDocumento_1_1);
		
		JTextPane textPaneEdit = new JTextPane();
		textPaneEdit.setBackground(SystemColor.menu);
		textPaneEdit.setBounds(10, 238, 351, 20);
		panel_4.add(textPaneEdit);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				int ID = Integer.valueOf(textFieldEditarID.getText());
				
				String editDocumento = textFieldEditDocumento.getText();
				String editApellido1 = textFieldEditApellido1.getText();
				String editApellido2 = textFieldEditApellido2.getText();
				String editNombre1 = textFieldEditNombre1.getText();
				String editNombre2 = textFieldEditNombre2.getText();
					
				Persona personaEditada = new Persona(editDocumento, editApellido1, editApellido2, editNombre1, editNombre2);

				DAOPersona.edit(ID,personaEditada);
				
				textPaneEdit.setText("Persona editada correctamente");
							
			}
		});
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Eliminar", null, panel_5, null);
		panel_5.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.setBounds(162, 5, 81, 33);
		panel_5.add(btnNewButton_3);
		
		textFieldDelete = new JTextField();
		textFieldDelete.setColumns(10);
		textFieldDelete.setBounds(48, 11, 104, 20);
		panel_5.add(textFieldDelete);
		
		JTextPane txtpnDocumento_1_1_1 = new JTextPane();
		txtpnDocumento_1_1_1.setText("ID");
		txtpnDocumento_1_1_1.setBackground(SystemColor.menu);
		txtpnDocumento_1_1_1.setBounds(10, 11, 28, 20);
		panel_5.add(txtpnDocumento_1_1_1);
		
		JTextPane textPaneDelete = new JTextPane();
		textPaneDelete.setBackground(SystemColor.menu);
		textPaneDelete.setBounds(20, 42, 309, 23);
		panel_5.add(textPaneDelete);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ID = Integer.valueOf(textFieldDelete.getText());
				
				boolean asd = DAOPersona.delete(ID);
				
				textPaneDelete.setText("Persona eliminada de la base de datos");
		
			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreBuscar = textFieldBuscarNombre.getText();
				String apellidoBuscar = textFieldBuscarApellido.getText();
	
				Persona personaEncontrada = DAOPersona.findPersona(apellidoBuscar, nombreBuscar);
				textPaneBuscar.setText("Se encontro a: "+personaEncontrada.nombre1+ " "+ personaEncontrada.apellido1+" que posee el documento "+ personaEncontrada.documento);
								
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String documento = textFieldDocumento.getText();
				String apellido1 = textFieldApellido1.getText();
				String apellido2 = textFieldApellido2.getText();
				String nombre1 = textFieldNombre1.getText();
				String nombre2 = textFieldNombre2.getText();
				Persona p = new Persona(documento, apellido1, apellido2, nombre1, nombre2);
				if(DAOPersona.insert(p))
				{
					textPaneAgregar.setText("Se ha insertado una persona en la base de datos.");
				}else
				{
					textPaneAgregar.setText("No se ha podido insertar una persona en la base de datos.");
				}
				
				
			}
		});
		

	}
}
