package trabajoColaborativo.vista;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import trabajoColaborativo.modelo.DAORol;
import trabajoColaborativo.modelo.Rol;

public class SeleccionRol {

	private JFrame frmSeleccionarRol;
	private int idRol;
	public ABMPersona AbmP;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	
	public int getIdRol() {
		return idRol;
	}



	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}



	public JFrame getFrame() {
		return frmSeleccionarRol;
	}

	/**
	 * Create the application.
	 */
	public SeleccionRol() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccionarRol = new JFrame();
		frmSeleccionarRol.setResizable(false);
		frmSeleccionarRol.setTitle("Seleccionar Rol");
		frmSeleccionarRol.setBounds(100, 100, 450, 250);
		frmSeleccionarRol.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSelect = new JButton("Seleccionar");
		GroupLayout groupLayout = new GroupLayout(frmSeleccionarRol.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(btnSelect)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Descripcion"
			}
		));
		scrollPane.setViewportView(table);
		frmSeleccionarRol.getContentPane().setLayout(groupLayout);
		cargarTable(DAORol.findAll());
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				ABMPersona.idRol = Integer.parseInt(model.getValueAt(sr, 0).toString());
				ABMPersona.lblRol.setText(model.getValueAt(sr, 1).toString());
				frmSeleccionarRol.setVisible(false);
			}
		});
	}
	
	private void cargarTable(ArrayList<Rol> roles) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Rol r : roles) {
			fila[0] = r.getIdRol();
			fila[1] = r.getNombre();
			fila[2] = r.getDescripcion();

			((DefaultTableModel) table.getModel()).addRow(fila);
		}
	}
}
