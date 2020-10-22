package trabajoColaborativo.vista;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import trabajoColaborativo.modelo.DAOFuncionalidad;
import trabajoColaborativo.modelo.Funcionalidad;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMFuncionalidad {

	private JFrame frmAbmfuncionalidad;
	private JTable table;
	private JTextField txtNom;
	private JTextField txtDesc;

	public JFrame getFrmAbmfuncionalidad() {
		return frmAbmfuncionalidad;
	}

	/**
	 * Create the application.
	 */
	public ABMFuncionalidad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbmfuncionalidad = new JFrame();
		frmAbmfuncionalidad.setResizable(false);
		frmAbmfuncionalidad.setTitle("ABMFuncionalidad");
		frmAbmfuncionalidad.setBounds(100, 100, 600, 450);
		frmAbmfuncionalidad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmAbmfuncionalidad.getContentPane());
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

		JLabel lblNewLabel = new JLabel("Alta / Modificacion Funcionalidad");
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
		btnAlta.setBounds(30, 106, 89, 23);
		panel.add(btnAlta);

		JButton btnModificacion = new JButton("Modificar");
		btnModificacion.setBounds(280, 106, 105, 23);
		panel.add(btnModificacion);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(410, 106, 89, 23);
		panel.add(btnLimpiar);

		JLabel lblMsj = new JLabel("");
		lblMsj.setBounds(10, 143, 548, 14);
		panel.add(lblMsj);

		JButton btnBaja = new JButton("Eliminar");
		btnBaja.setBounds(157, 106, 89, 23);
		panel.add(btnBaja);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nombre", "Descripcion" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		frmAbmfuncionalidad.getContentPane().setLayout(groupLayout);

		cargarTable(DAOFuncionalidad.findAll());
		table.getColumnModel().removeColumn(table.getColumnModel().getColumn(0));// HAGO INVISIBLE LA COLUMNA ID

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
					lblMsj.setText("Debe ingresar un nombre.");
				} else if (txtDesc.getText().equals("")) {
					lblMsj.setText("Debe ingresar una descripcion.");
				} else {
					try {
						Funcionalidad f = new Funcionalidad(txtNom.getText(), txtDesc.getText());
						DAOFuncionalidad.insert(f);
						lblMsj.setText("Registrado con exito.");
						cargarTable(DAOFuncionalidad.findAll());
						limpiarCampos();
					} catch (Exception e) {
						lblMsj.setText(e.getMessage());
					}
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
					lblMsj.setText("Debe ingresar un nombre.");
				} else if (txtDesc.getText().equals("")) {
					lblMsj.setText("Debe ingresar una descripcion.");
				} else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int sr = table.getSelectedRow();
					if (sr != -1) {
						Funcionalidad f = new Funcionalidad(Integer.parseInt(model.getValueAt(sr, 0).toString()),
								txtNom.getText(), txtDesc.getText());
						DAOFuncionalidad.edit(f);
						cargarTable(DAOFuncionalidad.findAll());
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
					DAOFuncionalidad.delete(Integer.parseInt(model.getValueAt(sr, 0).toString()));
					cargarTable(DAOFuncionalidad.findAll());
					lblMsj.setText("Se elimino con exito.");
				} else {
					lblMsj.setText("Debe seleccionar una funcionalidad.");
				}
			}
		});

	}

	private void cargarTable(ArrayList<Funcionalidad> fun) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Funcionalidad f : fun) {
			fila[0] = f.getId();
			fila[1] = f.getNombre();
			fila[2] = f.getDescripcion();

			((DefaultTableModel) table.getModel()).addRow(fila);
		}
	}

	private void limpiarCampos() {
		txtDesc.setText("");
		txtNom.setText("");
	}
}
