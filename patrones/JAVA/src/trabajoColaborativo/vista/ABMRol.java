package trabajoColaborativo.vista;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import trabajoColaborativo.modelo.DAORol;
import trabajoColaborativo.modelo.Rol;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMRol {

	private JFrame frmAbmrol;
	private JTable table;
	private JTextField txtNom;
	private JTextField txtDesc;
	public static ArrayList<Rol> roles;
	

	public JFrame getFrmAbmrol() {
		return frmAbmrol;
	}

	/**
	 * Create the application.
	 */
	public ABMRol() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbmrol = new JFrame();
		frmAbmrol.setResizable(false);
		frmAbmrol.setTitle("ABM Rol");
		frmAbmrol.setBounds(100, 100, 600, 450);
		frmAbmrol.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmAbmrol.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(16, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Alta / Modificacion Rol");
		lblNewLabel.setBounds(172, 11, 259, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 62, 63, 14);
		panel.add(lblNewLabel_1);

		txtNom = new JTextField();
		txtNom.setBounds(94, 59, 123, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Descripcion:");
		lblNewLabel_1_1.setBounds(282, 62, 84, 14);
		panel.add(lblNewLabel_1_1);

		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(376, 59, 123, 20);
		panel.add(txtDesc);

		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(30, 139, 89, 23);
		panel.add(btnAlta);

		JButton btnModificacion = new JButton("Modificacion");
		btnModificacion.setBounds(271, 139, 116, 23);
		panel.add(btnModificacion);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(410, 139, 89, 23);
		panel.add(btnLimpiar);

		JLabel lblMsj = new JLabel("");
		lblMsj.setBounds(10, 173, 548, 14);
		panel.add(lblMsj);

		JButton btnBaja = new JButton("Eliminar");
		btnBaja.setBounds(157, 139, 89, 23);
		panel.add(btnBaja);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Id", "Nombre", "Descripcion" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		frmAbmrol.getContentPane().setLayout(groupLayout);

		cargarTable(DAORol.findAll());

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				txtNom.setText(model.getValueAt(sr, 1).toString());
				txtDesc.setText(model.getValueAt(sr, 2).toString());
			}
		});

		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNom.getText().equals("")) {
					lblMsj.setText("Debes ingresar un nombre.");
				} else if (txtDesc.getText().equals("")) {
					lblMsj.setText("Debes ingresar una descripcion.");
				} else {
					Rol r = new Rol(txtNom.getText(), txtDesc.getText());
					DAORol.insert(r);
					lblMsj.setText("Registrado con exito.");
					cargarTable(DAORol.findAll());
					limpiarCampos();
				}

			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});

		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNom.getText().equals("")) {
					lblMsj.setText("Debes ingresar un nombre.");
				} else if (txtDesc.getText().equals("")) {
					lblMsj.setText("Debes ingresar una descripcion.");
				} else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int sr = table.getSelectedRow();
					if (sr != -1) {
						Rol r = new Rol(Integer.parseInt(model.getValueAt(sr, 0).toString()), txtNom.getText(),
								txtDesc.getText());
						DAORol.edit(r);
						cargarTable(DAORol.findAll());
						lblMsj.setText("Se modifico con exito.");
					} else {
						lblMsj.setText("Debe seleccionar un rol.");
					}
				}
			}
		});

		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr != -1) {
					DAORol.delete(Integer.parseInt(model.getValueAt(sr, 0).toString()));
					cargarTable(DAORol.findAll());
					lblMsj.setText("Se elimino con exito.");
				} else {
					lblMsj.setText("Debe seleccionar un rol.");
				}

			}
		});

	}

	private void cargarTable(ArrayList<Rol> rol) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Rol r : rol) {
			fila[0] = r.getIdRol();
			fila[1] = r.getNombre();
			fila[2] = r.getDescripcion();

			((DefaultTableModel) table.getModel()).addRow(fila);
		}
	}

	private void limpiarCampos() {
		txtDesc.setText("");
		txtNom.setText("");
	}
}
