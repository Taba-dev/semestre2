package trabajoColaborativo.vista;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import trabajoColaborativo.modelo.DAOPersona;
import trabajoColaborativo.modelo.Persona;
import trabajoColaborativo.modelo.Rol;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMPersona {

	private JFrame frmAbmpersona;
	private JTable table;
	private JTextField txtDoc;
	private JTextField txtNom1;
	private JTextField txtNom2;
	private JTextField txtApe1;
	private JTextField txtNac;
	private JTextField txtMail;
	private JTextField txtApe2;
	private JPasswordField txtPass1;
	private JPasswordField txtPass2;
	public static JLabel lblRol;
	public static int idRol;

	public JFrame getFrmAbmpersona() {
		return frmAbmpersona;
	}

	public ABMPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbmpersona = new JFrame();
		frmAbmpersona.setResizable(false);
		frmAbmpersona.setTitle("ABMPersona");
		frmAbmpersona.setBounds(100, 100, 600, 500);
		frmAbmpersona.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmAbmpersona.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Alta / Modificacion Persona");
		lblNewLabel.setBounds(187, 11, 229, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Documento:");
		lblNewLabel_1.setBounds(10, 48, 100, 14);
		panel.add(lblNewLabel_1);

		txtDoc = new JTextField();
		txtDoc.setBounds(102, 45, 118, 20);
		panel.add(txtDoc);
		txtDoc.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre1:");
		lblNewLabel_1_1.setBounds(10, 76, 100, 14);
		panel.add(lblNewLabel_1_1);

		txtNom1 = new JTextField();
		txtNom1.setColumns(10);
		txtNom1.setBounds(102, 73, 118, 20);
		panel.add(txtNom1);

		JLabel lblNewLabel_1_2 = new JLabel("Nombre2:");
		lblNewLabel_1_2.setBounds(10, 104, 100, 14);
		panel.add(lblNewLabel_1_2);

		txtNom2 = new JTextField();
		txtNom2.setColumns(10);
		txtNom2.setBounds(102, 101, 118, 20);
		panel.add(txtNom2);

		JLabel lblNewLabel_1_3 = new JLabel("Apellido1:");
		lblNewLabel_1_3.setBounds(10, 132, 100, 14);
		panel.add(lblNewLabel_1_3);

		txtApe1 = new JTextField();
		txtApe1.setColumns(10);
		txtApe1.setBounds(102, 129, 118, 20);
		panel.add(txtApe1);

		JLabel lblNewLabel_1_4 = new JLabel("Nacimiento:");
		lblNewLabel_1_4.setBounds(278, 48, 100, 14);
		panel.add(lblNewLabel_1_4);

		txtNac = new JTextField();
		txtNac.setColumns(10);
		txtNac.setBounds(370, 45, 118, 20);
		panel.add(txtNac);

		JLabel lblNewLabel_1_5 = new JLabel("Mail:");
		lblNewLabel_1_5.setBounds(278, 73, 100, 14);
		panel.add(lblNewLabel_1_5);

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(370, 70, 118, 20);
		panel.add(txtMail);

		JLabel lblNewLabel_1_6 = new JLabel("Clave:");
		lblNewLabel_1_6.setBounds(278, 101, 100, 14);
		panel.add(lblNewLabel_1_6);

		txtApe2 = new JTextField();
		txtApe2.setColumns(10);
		txtApe2.setBounds(102, 157, 118, 20);
		panel.add(txtApe2);

		JLabel lblNewLabel_1_3_1 = new JLabel("Apellido2:");
		lblNewLabel_1_3_1.setBounds(10, 160, 100, 14);
		panel.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Rol:");
		lblNewLabel_1_3_2.setBounds(278, 160, 100, 14);
		panel.add(lblNewLabel_1_3_2);

		lblRol = new JLabel("");
		lblRol.setBounds(370, 158, 118, 14);
		panel.add(lblRol);

		JButton btnRoles = new JButton("...");
		btnRoles.setBounds(499, 154, 27, 23);
		panel.add(btnRoles);

		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(45, 199, 89, 23);
		panel.add(btnAlta);

		JButton btnBaja = new JButton("Eliminar");
		btnBaja.setBounds(172, 199, 89, 23);
		panel.add(btnBaja);

		JButton btnModificacion = new JButton("Modificar");
		btnModificacion.setBounds(295, 199, 105, 23);
		panel.add(btnModificacion);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(425, 199, 89, 23);
		panel.add(btnLimpiar);

		txtPass1 = new JPasswordField();
		txtPass1.setBounds(370, 101, 118, 20);
		panel.add(txtPass1);

		txtPass2 = new JPasswordField();
		txtPass2.setBounds(370, 126, 118, 20);
		panel.add(txtPass2);

		JLabel lblNewLabel_1_6_1 = new JLabel("Repita clave:");
		lblNewLabel_1_6_1.setBounds(278, 126, 100, 14);
		panel.add(lblNewLabel_1_6_1);

		JLabel lblMsj = new JLabel("");
		lblMsj.setBounds(172, 250, 236, 14);
		panel.add(lblMsj);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Documento", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Mail", "Nacimiento"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		frmAbmpersona.getContentPane().setLayout(groupLayout);

		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDoc.getText().equals("")) {
					lblMsj.setText("Debe ingresar un documento.");
				} else if (txtNom1.getText().equals("")) {
					lblMsj.setText("Debe ingresar un Nombre1.");
				} else if (txtApe1.getText().equals("")) {
					lblMsj.setText("Debe ingresar un Apellido1.");
				} else if (txtApe2.getText().equals("")) {
					lblMsj.setText("Debe ingresar un Apellido2.");
				} else if (txtMail.getText().equals("")) {
					lblMsj.setText("Debe ingresar un mail.");
				} else if (txtNac.getText().equals("")) {
					lblMsj.setText("Debe ingresar una fecha de nacimiento.");
				} else if (txtPass1.getText().equals("")) {
					lblMsj.setText("Debe ingresar una contraseña.");
				} else if (txtPass2.getText().equals("")) {
					lblMsj.setText("Debe repetir la contraseña.");
				} else if (!txtPass1.getText().equals(txtPass2.getText())) {
					lblMsj.setText("Las contraseñas deben ser iguales.");
				} else if (lblRol.getText().equals("")) {
					lblMsj.setText("Debe seleccionar un rol.");
				} else {
					Rol r = new Rol();
					r.setIdRol(idRol);
					Persona p = new Persona(txtDoc.getText(), txtApe1.getText(), txtApe2.getText(), txtNom1.getText(),
							txtNom2.getText(), txtNac.getText(), txtPass1.getText(), txtMail.getText(), r);
					DAOPersona.insert(p);
					limpiarCampos();
					cargarTable(DAOPersona.findAll());
					lblMsj.setText("Se registro correctamente.");
				}

			}
		});

		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr != -1) {
					Persona p = new Persona();
					p.setId(Integer.parseInt(model.getValueAt(sr, 0).toString()));
					if (DAOPersona.delete(p)) {
						cargarTable(DAOPersona.findAll());
						lblMsj.setText("Se elimino correctamente.");
					} else {
						lblMsj.setText("No se pudo eliminar.");
					}

				} else {
					lblMsj.setText("Debes seleccionar una persona.");
				}

			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});

		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionRol sr = new SeleccionRol();
				sr.getFrame().setVisible(true);
			}
		});

		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDoc.getText().equals("")) {
					lblMsj.setText("Debe ingresar un documento.");
				} else if (txtNom1.getText().equals("")) {
					lblMsj.setText("Debe ingresar un Nombre1.");
				} else if (txtApe1.getText().equals("")) {
					lblMsj.setText("Debe ingresar un Apellido1.");
				} else if (txtApe2.getText().equals("")) {
					lblMsj.setText("Debe ingresar un Apellido2.");
				} else if (txtMail.getText().equals("")) {
					lblMsj.setText("Debe ingresar un mail.");
				} else if (txtNac.getText().equals("")) {
					lblMsj.setText("Debe ingresar una fecha de nacimiento.");
				} else if (txtPass1.getText().equals("")) {
					lblMsj.setText("Debe ingresar una contraseña.");
				} else if (txtPass2.getText().equals("")) {
					lblMsj.setText("Debe repetir la contraseña.");
				} else if (!txtPass1.getText().equals(txtPass2.getText())) {
					lblMsj.setText("Las contraseñas deben ser iguales.");
				} else if (lblRol.getText().equals("")) {
					lblMsj.setText("Debe seleccionar un rol.");
				} else {
					Rol r = new Rol();
					r.setIdRol(idRol);
					Persona p = new Persona(txtDoc.getText(), txtApe1.getText(), txtApe2.getText(), txtNom1.getText(),
							txtNom2.getText(), txtNac.getText(), txtPass1.getText(), txtMail.getText(), r);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int sr = table.getSelectedRow();
					if (sr != -1) {
						p.setId(Integer.parseInt(model.getValueAt(sr, 0).toString()));
						DAOPersona.update(p);
						limpiarCampos();
						cargarTable(DAOPersona.findAll());
						lblMsj.setText("Se modifico correctamente.");
					} else {
						lblMsj.setText("Debe seleccionar una persona.");
					}

				}
			}
		});

		cargarTable(DAOPersona.findAll());
		table.getColumnModel().removeColumn(table.getColumnModel().getColumn(0));// HAGO INVISIBLE LA COLUMNA ID

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				txtDoc.setText(model.getValueAt(sr, 1).toString());
				txtNom1.setText(model.getValueAt(sr, 2).toString());
				txtNom2.setText(model.getValueAt(sr, 3).toString());
				txtApe1.setText(model.getValueAt(sr, 4).toString());
				txtApe2.setText(model.getValueAt(sr, 5).toString());
				txtNac.setText(model.getValueAt(sr, 6).toString());
				txtMail.setText(model.getValueAt(sr, 7).toString());
			}
		});

	}

	private void cargarTable(ArrayList<Persona> pers) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Persona f : pers) {
			fila[0] = f.getId();
			fila[1] = f.getDocumento();
			fila[2] = f.getNombre1();
			fila[3] = f.getNombre2();
			fila[4] = f.getApellido1();
			fila[5] = f.getApellido2();
			fila[6] = f.getMail();
			fila[7] = f.getFechaNac();

			((DefaultTableModel) table.getModel()).addRow(fila);
		}
	}

	public void limpiarCampos() {
		txtDoc.setText("");
		txtNom1.setText("");
		txtNom2.setText("");
		txtApe1.setText("");
		txtApe2.setText("");
		txtMail.setText("");
		txtNac.setText("");
		txtPass1.setText("");
		txtPass2.setText("");
		lblRol.setText("");
	}
}
