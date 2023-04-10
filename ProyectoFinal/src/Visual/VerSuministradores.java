package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Componente;
import Logico.Suministrador;
import Logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class VerSuministradores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	private Suministrador selected;
	private JButton btnDelete;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerSuministradores dialog = new VerSuministradores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerSuministradores() {
		setBounds(100, 100, 633, 345);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] headers = {"ID","Nombre","Pais","Cantidad de Suministros"};

					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index >=0 ) {
								btnDelete.setEnabled(true);
								btnUpdate.setEnabled(true);
								String id = table.getValueAt(index, 0).toString();
								selected = Tienda.getInstance().buscarSumiById(id);
							}
						}
					});
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);

					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDelete = new JButton("Eliminar");
				btnDelete.setEnabled(false);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if(selected!=null){
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el cliente con cedula: "+selected.getId(), "Eliminar Suministrador", JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION){
							  Tienda.getInstance().eliminarSuministrador(selected);
							  loadSuministradores(0);
							  btnDelete.setEnabled(false);
							}
							
						}
					}
				});
				buttonPane.add(btnDelete);
			}
			{
				btnUpdate = new JButton("Modificar");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ModificarSuminstrador modSumi = new ModificarSuminstrador(selected);
						modSumi.setModal(true);
						modSumi.setVisible(true);
					}
				});
				btnUpdate.setEnabled(false);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadSuministradores(0);
	}

	private void loadSuministradores(int index) {

		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0){
			for (Suministrador aux : Tienda.getInstance().getSuministradores()) {

				rows[0] = aux.getId();
				rows[1] = aux.getNombre();
				rows[2] = aux.getPais();
				rows[3] = cantSuministros(aux);
				model.addRow(rows);
			}
		}
	}
	
	private int cantSuministros(Suministrador suministrador) {
		
		int cant = 0;
		for (Componente aux : suministrador.getComponentes()) {
			
			if(aux != null) {
				cant++;
			}
		}
		
		return cant;
	}
}
