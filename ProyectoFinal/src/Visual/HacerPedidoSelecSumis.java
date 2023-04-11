package Visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Componente;
import Logico.MotherBoard;
import Logico.Suministrador;
import Logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HacerPedidoSelecSumis extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tF_Id;
	private JTextField tF_Nombre;
	private JTextField tF_Pais;
	private JTable table;
	private Suministrador suministrador = null;

	private static DefaultTableModel model;
	private static Object rows[];
	
	int index;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HacerPedidoSelecSumis dialog = new HacerPedidoSelecSumis(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HacerPedidoSelecSumis(Suministrador selected) {
		suministrador = selected;
		setBounds(100, 100, 514, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 478, 281);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("Id:");
				label.setBounds(10, 11, 37, 14);
				panel.add(label);
			}
			{
				tF_Id = new JTextField();
				tF_Id.setText((String) null);
				tF_Id.setEditable(false);
				tF_Id.setColumns(10);
				tF_Id.setBounds(10, 36, 127, 20);
				panel.add(tF_Id);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(161, 11, 64, 14);
				panel.add(label);
			}
			{
				tF_Nombre = new JTextField((String) null);
				tF_Nombre.setEditable(false);
				tF_Nombre.setColumns(10);
				tF_Nombre.setBounds(161, 36, 127, 20);
				panel.add(tF_Nombre);
			}
			{
				JLabel label = new JLabel("Pais:");
				label.setBounds(313, 11, 64, 14);
				panel.add(label);
			}
			{
				tF_Pais = new JTextField((String) null);
				tF_Pais.setEditable(false);
				tF_Pais.setColumns(10);
				tF_Pais.setBounds(312, 36, 127, 20);
				panel.add(tF_Pais);
			}
			{
				JLabel lblSeleccioneElSuministro = new JLabel("Seleccione El Suministro:");
				lblSeleccioneElSuministro.setBounds(10, 67, 144, 14);
				panel.add(lblSeleccioneElSuministro);
			}

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 92, 278, 178);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 278, 178);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			{
				String[] headers = {"ID","Marca","Precio","Cantidad Maxima"};

				table = new JTable();
				table.setCellSelectionEnabled(true);
				table.setColumnSelectionAllowed(true);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						index = table.getSelectedRow();
						if(index >=0 ) {
							
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton HacerPedidoButton = new JButton("Hacer Pedido");
				HacerPedidoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						agregarComponentesPedidoAtienda(suministrador.getComponentes().get(index), suministrador.getComponentes().get(index).getCantMax());
						dispose();
					}

				});
				HacerPedidoButton.setActionCommand("OK");
				buttonPane.add(HacerPedidoButton);
				getRootPane().setDefaultButton(HacerPedidoButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadSuministrador();
		loadSuministrosSumi();

	}
	
	private void loadSuministrador() {
		
		tF_Id.setText(suministrador.getId());
		tF_Pais.setText(suministrador.getPais());
		tF_Nombre.setText(suministrador.getNombre());
		
	}
	
	private void loadSuministrosSumi() {

		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Componente aux : suministrador.getComponentes()) {

			rows[0] = aux.getId();
			rows[1] = aux.getMarca();
			rows[2] = aux.getPrecio();
			rows[3] = aux.getCantMax();
			model.addRow(rows);
		}
	}
	
	private String genSerial(){

		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		Random r = new Random();
		char c;
		String codigo = "";

		for(int i = 0; i < 10; i++){
			c = alphabet.charAt(r.nextInt(alphabet.length()));
			codigo += c;
		}

		return codigo;
	}
	
	private void agregarComponentesPedidoAtienda(Componente componente, int CantPedido) {
		
		String serial;
		Componente aux = componente;
		for(int i = 0;i<CantPedido;i++) {
			
			serial = genSerial();
			aux.setCantMax(CantPedido);
			aux.setCantMin(CantPedido);
			aux.setSerial(serial);
			aux.setCantReal(CantPedido);
			Tienda.getInstance().getInventario().add(i, aux);
		}
	}
	
}
