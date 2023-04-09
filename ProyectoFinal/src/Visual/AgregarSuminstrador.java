package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Logico.Tienda;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarSuminstrador extends JDialog {

	private final JPanel Panel = new JPanel();
	private JTextField textField;
	private JTextField tF_Id;
	private JTextField tF_Nombre;
	private JTextField tF_Pais;
	private JTextField tF_IdComponente;
	private JTextField tF_Marca;
	private JTextField tF_Serial;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnMicroprocesador;
	private JRadioButton rdbtnMemoriaRam;
	private JRadioButton rdbtnDiscoDuro;
	private JPanel panelTargetaMadre;
	private JPanel panelMicroprocesadores;
	private JPanel panelMemoriRam;
	private JList<String> list_Conexiones;
	private JList<String> list_Compatibles;


	private DefaultListModel<String> conexionesDD = new DefaultListModel<String>();
	private DefaultListModel<String> conexionesDD_Compatibles = new DefaultListModel<String>();

	private JTextField tF_Modelo;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarSuminstrador dialog = new AgregarSuminstrador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarSuminstrador() {
		setBounds(100, 100, 1014, 707);
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
			panel.setBounds(10, 39, 404, 112);
			Panel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblId = new JLabel("Id:");
				lblId.setBounds(10, 0, 37, 14);
				panel.add(lblId);
			}

			tF_Id = new JTextField();
			tF_Id.setText("Sumi- "+Tienda.getInstance().codSumi);
			tF_Id.setEditable(false);
			tF_Id.setColumns(10);
			tF_Id.setBounds(10, 22, 378, 20);
			panel.add(tF_Id);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 53, 64, 14);
			panel.add(lblNombre);

			tF_Nombre = new JTextField();
			tF_Nombre.setColumns(10);
			tF_Nombre.setBounds(10, 78, 184, 20);
			panel.add(tF_Nombre);

			JLabel lblPais = new JLabel("Pais:");
			lblPais.setBounds(204, 53, 64, 14);
			panel.add(lblPais);

			tF_Pais = new JTextField();
			tF_Pais.setColumns(10);
			tF_Pais.setBounds(204, 78, 184, 20);
			panel.add(tF_Pais);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 169, 404, 209);
			Panel.add(panel);
			{
				JLabel lblIdComponente = new JLabel("Id componente:");
				lblIdComponente.setBounds(10, 8, 91, 14);
				panel.add(lblIdComponente);
			}
			{
				tF_IdComponente = new JTextField();
				tF_IdComponente.setText("-1");
				tF_IdComponente.setEditable(false);
				tF_IdComponente.setColumns(10);
				tF_IdComponente.setBounds(10, 22, 378, 20);
				panel.add(tF_IdComponente);
			}
			{
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(10, 53, 64, 14);
				panel.add(lblMarca);
			}
			{
				tF_Marca = new JTextField();
				tF_Marca.setColumns(10);
				tF_Marca.setBounds(10, 78, 184, 20);
				panel.add(tF_Marca);
			}
			{
				JLabel lblSerial = new JLabel("Serial:");
				lblSerial.setBounds(204, 53, 64, 14);
				panel.add(lblSerial);
			}
			{
				tF_Serial = new JTextField();
				tF_Serial.setText("-1");
				tF_Serial.setColumns(10);
				tF_Serial.setBounds(204, 78, 184, 20);
				panel.add(tF_Serial);
			}
			{
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(10, 109, 64, 14);
				panel.add(lblPrecio);
			}

			JSpinner spinner = new JSpinner();
			spinner.setBounds(10, 134, 184, 20);
			panel.add(spinner);

			rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
			rdbtnTarjetaMadre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(true);

					panelMicroprocesadores.setVisible(false);
					panelMemoriRam.setVisible(false);
					panelTargetaMadre.setVisible(true);
				}
			});
			rdbtnTarjetaMadre.setSelected(true);
			rdbtnTarjetaMadre.setBounds(6, 179, 105, 23);
			panel.add(rdbtnTarjetaMadre);

			rdbtnMicroprocesador = new JRadioButton("Microprocesador");
			rdbtnMicroprocesador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					rdbtnMicroprocesador.setSelected(true);
					rdbtnTarjetaMadre.setSelected(false);

					panelMicroprocesadores.setVisible(true);
					lista_Conexiones();

					panelTargetaMadre.setVisible(false);
					panelMemoriRam.setVisible(false);
				}
			});
			rdbtnMicroprocesador.setBounds(113, 179, 105, 23);
			panel.add(rdbtnMicroprocesador);

			rdbtnMemoriaRam = new JRadioButton("Memoria RAM");
			rdbtnMemoriaRam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(true);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(false);

					panelMicroprocesadores.setVisible(false);
					panelMemoriRam.setVisible(true);
					panelTargetaMadre.setVisible(false);
				}
			});
			rdbtnMemoriaRam.setBounds(220, 179, 91, 23);
			panel.add(rdbtnMemoriaRam);

			rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.setBounds(315, 179, 83, 23);
			panel.add(rdbtnDiscoDuro);
		}
		{
			JLabel lblComponentesDelSuministrador = new JLabel("Componentes del Suministrador:");
			lblComponentesDelSuministrador.setBounds(10, 155, 174, 14);
			Panel.add(lblComponentesDelSuministrador);
		}
		{
			JLabel lblDatosDelSuministrador = new JLabel("Datos del Suministrador");
			lblDatosDelSuministrador.setBounds(10, 14, 174, 14);
			Panel.add(lblDatosDelSuministrador);
		}

		panelTargetaMadre = new JPanel();
		panelTargetaMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTargetaMadre.setBounds(10, 385, 404, 209);
		Panel.add(panelTargetaMadre);
		panelTargetaMadre.setLayout(null);

		JComboBox cbxTipoSocket = new JComboBox();
		cbxTipoSocket.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "PGA", "BGA", "LGA"}));
		cbxTipoSocket.setBounds(10, 36, 187, 20);
		panelTargetaMadre.add(cbxTipoSocket);

		JLabel lblTipoDeSocket = new JLabel("Tipo de Socket:");
		lblTipoDeSocket.setBounds(10, 11, 83, 14);
		panelTargetaMadre.add(lblTipoDeSocket);

		JLabel lblRamCompatible = new JLabel("Ram Compatible:");
		lblRamCompatible.setBounds(207, 11, 83, 14);
		panelTargetaMadre.add(lblRamCompatible);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "SRAM", "DRAM"}));
		comboBox.setBounds(207, 36, 187, 20);
		panelTargetaMadre.add(comboBox);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 88, 72, 104);
			panelTargetaMadre.add(panel_1);
			panel_1.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 72, 103);
			panel_1.add(scrollPane);

			list_Conexiones = new JList<String>();
			lista_Conexiones();
			list_Conexiones.setModel(conexionesDD);
			scrollPane.setViewportView(list_Conexiones);
		}

		JLabel lblConexiones = new JLabel("Conexiones:");
		lblConexiones.setBounds(10, 67, 72, 14);
		panelTargetaMadre.add(lblConexiones);

		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = list_Conexiones.getSelectedIndex();
				conexionesDD_Compatibles.addElement(conexionesDD.elementAt(index));
				conexionesDD.remove(index);
				list_Compatibles.setModel(conexionesDD_Compatibles);
			}
		});
		button.setBounds(92, 100, 60, 25);
		panelTargetaMadre.add(button);

		JButton button_1 = new JButton("<<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index;
				if( (index = list_Compatibles.getSelectedIndex()) != -1) {
					button.setEnabled(true);
				}
				conexionesDD.addElement(conexionesDD_Compatibles.elementAt(index));
				conexionesDD_Compatibles.remove(index);
				list_Conexiones.setModel(conexionesDD);

			}
		});
		button_1.setBounds(92, 136, 60, 23);
		panelTargetaMadre.add(button_1);

		JLabel lblConexionCompatibles = new JLabel("Compatibles:");
		lblConexionCompatibles.setBounds(159, 67, 77, 14);
		panelTargetaMadre.add(lblConexionCompatibles);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 89, 72, 103);
		panelTargetaMadre.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		list_Compatibles = new JList();
		list_Compatibles.setBounds(0, 0, 70, 101);
		panel.add(list_Compatibles);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(246, 67, 64, 14);
		panelTargetaMadre.add(lblModelo);

		tF_Modelo = new JTextField();
		tF_Modelo.setBounds(244, 88, 150, 20);
		panelTargetaMadre.add(tF_Modelo);
		tF_Modelo.setColumns(10);

		panelMicroprocesadores = new JPanel();
		panelMicroprocesadores.setVisible(false);
		panelMicroprocesadores.setLayout(null);
		panelMicroprocesadores.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMicroprocesadores.setBounds(10, 385, 404, 209);
		Panel.add(panelMicroprocesadores);

		JLabel label = new JLabel("Tipo de Socket:");
		label.setBounds(10, 11, 83, 14);
		panelMicroprocesadores.add(label);

		JLabel label_2 = new JLabel("Modelo:");
		label_2.setBounds(216, 11, 64, 14);
		panelMicroprocesadores.add(label_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(216, 36, 187, 20);
		panelMicroprocesadores.add(textField_1);

		JComboBox cbxTipoSocketMicro = new JComboBox();
		cbxTipoSocketMicro.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "PGA", "BGA", "LGA"}));
		cbxTipoSocketMicro.setBounds(10, 36, 187, 20);
		panelMicroprocesadores.add(cbxTipoSocketMicro);

		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setBounds(10, 67, 64, 14);
		panelMicroprocesadores.add(lblVelocidad);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(13, 92, 184, 20);
		panelMicroprocesadores.add(spinner);

		panelMemoriRam = new JPanel();
		panelMemoriRam.setLayout(null);
		panelMemoriRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMemoriRam.setBounds(10, 385, 404, 209);
		Panel.add(panelMemoriRam);

		JLabel lblCantidadDeMemoria = new JLabel("Cantidad de Memoria: ");
		lblCantidadDeMemoria.setBounds(10, 11, 124, 14);
		panelMemoriRam.add(lblCantidadDeMemoria);

		JLabel lblTipoDeRam = new JLabel("Tipo de Ram:");
		lblTipoDeRam.setBounds(207, 11, 83, 14);
		panelMemoriRam.add(lblTipoDeRam);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "DDR SDRAM", "DDR2 SDRAM", "DDR3 SDRAM", "DDR4 SDRAM", "DDR5 SDRAM", "DDR6 SDRAM"}));
		comboBox_2.setBounds(207, 36, 187, 20);
		panelMemoriRam.add(comboBox_2);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(10, 67, 187, 20);
		panelMemoriRam.add(spinner_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "Giga-Bites", "Tera-Bites"}));
		comboBox_1.setBounds(10, 36, 187, 20);
		panelMemoriRam.add(comboBox_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton AgregarButton = new JButton("Agregar");
				AgregarButton.setActionCommand("OK");
				buttonPane.add(AgregarButton);
				getRootPane().setDefaultButton(AgregarButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
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

	void lista_Conexiones() {

		conexionesDD.addElement("IDE");
		conexionesDD.addElement("SATA");
		conexionesDD.addElement("SATA-2");
		conexionesDD.addElement("SATA-3");

	}

}
