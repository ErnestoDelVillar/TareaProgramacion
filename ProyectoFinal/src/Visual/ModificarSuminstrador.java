package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Componente;
import Logico.DiscoDuro;
import Logico.MemoriaRam;
import Logico.Micro;
import Logico.MotherBoard;
import Logico.Suministrador;
import Logico.Tienda;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;

public class ModificarSuminstrador extends JDialog {

	private final JPanel Panel = new JPanel();
	private JTextField textField;
	private JTextField tF_Id;
	private JTextField tF_Nombre;
	private JTextField tF_Pais;
	private JPanel panelComponentesSumi;

	private DefaultTableModel model;
	private Object rows[];
	private Suministrador suministrador = null;
	private Componente componente = null;

	private JTable table;

	private JButton btnModificarSuministro;
	private JButton btnEliminarSuministro;
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarSuminstrador dialog = new ModificarSuminstrador(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarSuminstrador(Suministrador pSuministrador) {

		suministrador = pSuministrador;
		setBounds(100, 100, 464, 508);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		Panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(Panel, BorderLayout.CENTER);
		Panel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(216, 10, 1, 1);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			Panel.add(panel);
			{
				JLabel label = new JLabel("C\u00F3digo:");
				label.setBounds(10, 24, 53, 14);
				panel.add(label);
			}
			{
				textField = new JTextField();
				textField.setText("-1 ");
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBounds(10, 49, 364, 20);
				panel.add(textField);
			}
			{
				JLabel label = new JLabel("Precio Base:");
				label.setBounds(10, 82, 72, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Costo Unitario:");
				label.setBounds(213, 82, 93, 14);
				panel.add(label);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setBounds(10, 107, 161, 20);
				panel.add(spinner);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setBounds(213, 107, 161, 20);
				panel.add(spinner);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 39, 422, 112);
			Panel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblId = new JLabel("Id:");
				lblId.setBounds(10, 0, 37, 14);
				panel.add(lblId);
			}

			tF_Id = new JTextField();
			tF_Id.setText(suministrador.getId());
			tF_Id.setEditable(false);
			tF_Id.setColumns(10);
			tF_Id.setBounds(10, 22, 378, 20);
			panel.add(tF_Id);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 53, 64, 14);
			panel.add(lblNombre);

			tF_Nombre = new JTextField(suministrador.getNombre());
			tF_Nombre.setColumns(10);
			tF_Nombre.setBounds(10, 78, 184, 20);
			panel.add(tF_Nombre);

			JLabel lblPais = new JLabel("Pais:");
			lblPais.setBounds(228, 53, 64, 14);
			panel.add(lblPais);

			tF_Pais = new JTextField(suministrador.getPais());
			tF_Pais.setColumns(10);
			tF_Pais.setBounds(228, 78, 184, 20);
			panel.add(tF_Pais);
		}
		{
			JLabel lblComponentesDelSuministrador = new JLabel("Componentes del Suministrador:");
			lblComponentesDelSuministrador.setBounds(10, 155, 207, 14);
			Panel.add(lblComponentesDelSuministrador);
		}
		{
			JLabel lblDatosDelSuministrador = new JLabel("Datos del Suministrador");
			lblDatosDelSuministrador.setBounds(10, 14, 174, 14);
			Panel.add(lblDatosDelSuministrador);
		}

		panelComponentesSumi = new JPanel();
		panelComponentesSumi.setVisible(true);
		panelComponentesSumi.setLayout(null);
		panelComponentesSumi.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelComponentesSumi.setBounds(10, 180, 422, 209);
		Panel.add(panelComponentesSumi);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 422, 209);
			panelComponentesSumi.add(scrollPane, BorderLayout.CENTER);
			{
				String[] headers = {"ID","Marca","Precio"};

				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						index = table.getSelectedRow();
						if(index >=0 ) {
							btnModificarSuministro.setEnabled(true);
							btnEliminarSuministro.setEnabled(true);

							String id = table.getValueAt(index, 0).toString();
							componente = buscarComponenteEnSumiByID(id);
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

		btnModificarSuministro = new JButton("Modificar Suministro");
		btnModificarSuministro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModSuministro modSuministro = new ModSuministro(componente);
				modSuministro.setModal(true);
				modSuministro.setVisible(true);
			}
		});
		btnModificarSuministro.setActionCommand("OK");
		btnModificarSuministro.setBounds(10, 400, 134, 23);
		Panel.add(btnModificarSuministro);

		btnEliminarSuministro = new JButton("Eliminar Suministro");
		btnEliminarSuministro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el suministro: ", "Eliminar Suministro", JOptionPane.OK_CANCEL_OPTION);
				if(option == JOptionPane.OK_OPTION){
					
					suministrador.getComponentes().remove(index);
					loadComp(0);
					//btnEliminar.setEnabled(false);
				}
			}
		});
		btnEliminarSuministro.setActionCommand("OK");
		btnEliminarSuministro.setBounds(154, 400, 134, 23);
		Panel.add(btnEliminarSuministro);

		JButton btnAgregarSuministro = new JButton("Agregar Suministro");
		btnAgregarSuministro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Componente comp = null;
				AgregarComponente agrComp = new AgregarComponente(comp);
				agrComp.setModal(true);
				agrComp.setVisible(true);
				suministrador.getComponentes().add(comp);
				loadComp(0);
				
			}
		});
		btnAgregarSuministro.setActionCommand("OK");
		btnAgregarSuministro.setBounds(298, 400, 134, 23);
		Panel.add(btnAgregarSuministro);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ModificarButton = new JButton("Modificar");
				ModificarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						suministrador.setId(tF_Id.getText());
						suministrador.setNombre(tF_Nombre.getText());
						suministrador.setPais(tF_Pais.getText());

						Tienda.getInstance().modificarSuministrador(suministrador);
						VerSuministradores.loadSuministradores(0);
						JOptionPane.showMessageDialog(null, "Suministrador Modificado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}

				});
				ModificarButton.setActionCommand("OK");
				buttonPane.add(ModificarButton);
				getRootPane().setDefaultButton(ModificarButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			loadComp(0);
		}

	}

	private void loadComp(int index) {

		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
			for (Componente aux : suministrador.getComponentes()) {

				rows[0] = aux.getId();
				rows[1] = aux.getMarca();
				rows[2] = aux.getPrecio();
				model.addRow(rows);
		}
	}

	private Componente buscarComponenteEnSumiByID(String id) {

		Componente comABus = null;

		for (Componente aux : suministrador.getComponentes()) {

			if(aux.getId().equals(id)) {
				comABus = aux;
				return comABus;
			}
		}
		return null;
	}
}
