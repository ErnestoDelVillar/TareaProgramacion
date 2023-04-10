package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Combo;
import Logico.Componente;
import Logico.DiscoDuro;
import Logico.Micro;
import Logico.MotherBoard;
import Logico.MemoriaRam;
import Logico.Tienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

public class ListarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Combo selected;
	private JTable table;
	private JComboBox cbxTipo;
	private static DefaultTableModel model;
	private static Object rows[];

	/**
	 * Create the dialog.
	 */
	public ListarCombo(Combo combo) {
		selected = combo;
		setTitle("Mostrar Combo: " + selected.getNombre());
		setBounds(100, 100, 483, 365);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel label = new JLabel("Tipo de Componente:");
			label.setBounds(15, 16, 162, 20);
			panel.add(label);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 53, 430, 220);
			panel.add(scrollPane);

			String headers[] = {"Código", "Marca", "Serial", "Precio", "Tipo","Descuento"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table = new JTable();
			table.setModel(model);
			scrollPane.setViewportView(table);

			cbxTipo = new JComboBox();
			cbxTipo.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int selection = cbxTipo.getSelectedIndex();
					loadTable(selection);
				}
			});
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Disco duro", "MicroProcesador", "RAM", "Motherboard"}));
			cbxTipo.setBounds(140, 11, 150, 30);
			panel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cerrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JButton cancelButton = new JButton("Cerrar");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		{

		}
		loadTable(0);
	}

	static void loadTable(int sel) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];

		switch (sel) {
		case 0:
			for (Componente c : selected.getComponentes()) {

				rows[0] = c.getId();
				rows[1] = c.getMarca();
				rows[2] = c.getSerial();
				rows[3] = c.getPrecio() - (selected.getDescuento()/100);
				rows[5] = selected.getDescuento() + "%";

				if (c instanceof DiscoDuro) {
					rows[4] = "Disco Duro";
				}

				if (c instanceof MotherBoard) {
					rows[4] = "MotherBoard";
				}

				if (c instanceof Micro) {
					rows[4] = "Micro";
				}

				if (c instanceof MemoriaRam) {
					rows[4] = "RAM";
				}

				model.addRow(rows);
			}
			break;

		case 1:
			for (Componente c : selected.getComponentes()) {
				if (c instanceof DiscoDuro) {
					rows[0] = c.getId();
					rows[1] = c.getMarca();
					rows[2] = c.getSerial();
					rows[3] = c.getPrecio()-(selected.getDescuento()/100);
					rows[4] = "Disco Duro";
					rows[5]=selected.getDescuento() + "%";

					model.addRow(rows);
				}
			}
			break;

		case 2:
			for (Componente c : selected.getComponentes()) {
				if (c instanceof Micro) {
					rows[0] = c.getId();
					rows[1] = c.getMarca();
					rows[2] = c.getSerial();
					rows[3] = c.getPrecio()-(selected.getDescuento()/100);
					rows[4] = "Micro";
					rows[5]=selected.getDescuento() + "%";
					model.addRow(rows);
				}
			}
			break;

		case 3:
			for (Componente c : selected.getComponentes()) {
				if (c instanceof MemoriaRam) {
					rows[0] = c.getId();
					rows[1] = c.getMarca();
					rows[2] = c.getSerial();
					rows[3] = c.getPrecio();
					rows[4] = "RAM";
					rows[5]=selected.getDescuento() + "%";
					model.addRow(rows);
				}
			}
			break;

		case 4:
			for (Componente c : selected.getComponentes()) {
				if (c instanceof MotherBoard) {
					rows[0] = c.getId();
					rows[1] = c.getMarca();
					rows[2] = c.getSerial();
					rows[3] = c.getPrecio()-(selected.getDescuento()/100);
					rows[4] = "MotherBoard";
					rows[5]=selected.getDescuento() + "%";
					model.addRow(rows);
				}
			}
			break;
		}
	}
}