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
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class AgregarSuminstrador extends JDialog {

	private final JPanel Panel = new JPanel();
	private JTextField textField;
	private JTextField tF_Id;
	private JTextField tF_Nombre;
	private JTextField tF_Pais;
	private JTextField tF_IdComponente;
	private JTextField tF_Marca;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnMicroprocesador;
	private JRadioButton rdbtnMemoriaRam;
	private JRadioButton rdbtnDiscoDuro;
	private JPanel panelTargetaMadre;
	private JPanel panelMicroprocesadores;
	private JPanel panelMemoriRam;
	private JPanel panelDiscoDuro;
	private JPanel panel_ComponentesDelSumi;
	private JList<String> list_Conexiones;
	private JList<String> list_Compatibles;
	private JList<String> list_Suministros;
	private JSpinner spinner_Precio;
	private JSpinner spinner_CantidadMinima;
	private JSpinner spinner_CantidaMaxima;
	private JComboBox cbxTipoSocketMicro;
	private JSpinner spinnerVelocidadMicro;
	private JComboBox cbx_CantidadMemoriaRam;
	private JComboBox cbx_TipoRam;
	private JComboBox cbxTipoSocket;
	private JComboBox cbx_RamComp;
	private JSpinner spinner_CantExactaRam;
	private JComboBox cbx_TipoConexionDD;
	private JSpinner spinner_Capacidad_DD;
	private Suministrador sumi = new Suministrador("", "", "", 0);
	
	private int codigo = 1;
	private int codigoComp = 1;

	private DefaultListModel<String> conexionesDD = new DefaultListModel<String>();
	private DefaultListModel<String> conexionesDD_Compatibles = new DefaultListModel<String>();
	private DefaultListModel<String> suministros = new DefaultListModel<String>();
	
	private JTextField tF_ModeloTM;
	private JTextField tf_ModeloMicro;
	private JTextField tf_ModeloDD;
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
		setBounds(100, 100, 614, 633);
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
			panel_ComponentesDelSumi = new JPanel();
			panel_ComponentesDelSumi.setLayout(null);
			panel_ComponentesDelSumi.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_ComponentesDelSumi.setBounds(10, 169, 559, 140);
			Panel.add(panel_ComponentesDelSumi);
			{
				JLabel lblIdComponente = new JLabel("Id componente:");
				lblIdComponente.setBounds(10, 8, 91, 14);
				panel_ComponentesDelSumi.add(lblIdComponente);
			}
			{
				tF_IdComponente = new JTextField();
				tF_IdComponente.setText("-1");
				tF_IdComponente.setEditable(false);
				tF_IdComponente.setColumns(10);
				tF_IdComponente.setBounds(10, 22, 378, 20);
				panel_ComponentesDelSumi.add(tF_IdComponente);
			}
			{
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(10, 53, 64, 14);
				panel_ComponentesDelSumi.add(lblMarca);
			}
			{
				tF_Marca = new JTextField();
				tF_Marca.setColumns(10);
				tF_Marca.setBounds(10, 78, 184, 20);
				panel_ComponentesDelSumi.add(tF_Marca);
			}
			{
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(207, 53, 64, 14);
				panel_ComponentesDelSumi.add(lblPrecio);
			}

			spinner_Precio = new JSpinner();
			spinner_Precio.setBounds(204, 78, 184, 20);
			panel_ComponentesDelSumi.add(spinner_Precio);

			rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
			rdbtnTarjetaMadre.setSelected(true);
			rdbtnTarjetaMadre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(true);
					
					panelMicroprocesadores.setVisible(false);
					panelMemoriRam.setVisible(false);
					panelDiscoDuro.setVisible(false);
					panelTargetaMadre.setVisible(true);
					updateCodigo();
				}
			});
			rdbtnTarjetaMadre.setBounds(10, 105, 105, 23);
			panel_ComponentesDelSumi.add(rdbtnTarjetaMadre);

			rdbtnMicroprocesador = new JRadioButton("Microprocesador");
			rdbtnMicroprocesador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					rdbtnMicroprocesador.setSelected(true);
					rdbtnTarjetaMadre.setSelected(false);
					
					panelMicroprocesadores.setVisible(true);
					panelMemoriRam.setVisible(false);
					panelDiscoDuro.setVisible(false);
					panelTargetaMadre.setVisible(false);
					updateCodigo();
				}
			});
			rdbtnMicroprocesador.setBounds(113, 105, 105, 23);
			panel_ComponentesDelSumi.add(rdbtnMicroprocesador);

			rdbtnMemoriaRam = new JRadioButton("Memoria RAM");
			rdbtnMemoriaRam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(true);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(false);
					
					panelMicroprocesadores.setVisible(false);
					panelMemoriRam.setVisible(true);
					panelDiscoDuro.setVisible(false);
					panelTargetaMadre.setVisible(false);
					updateCodigo();
				}
			});
			rdbtnMemoriaRam.setBounds(214, 105, 91, 23);
			panel_ComponentesDelSumi.add(rdbtnMemoriaRam);

			rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDiscoDuro.setSelected(true);
					rdbtnMemoriaRam.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(false);
					
					panelMicroprocesadores.setVisible(false);
					panelMemoriRam.setVisible(false);
					panelDiscoDuro.setVisible(true);
					panelTargetaMadre.setVisible(false);
					updateCodigo();
				}
			});
			rdbtnDiscoDuro.setBounds(307, 105, 83, 23);
			panel_ComponentesDelSumi.add(rdbtnDiscoDuro);
			
			JLabel lblCantidadMinima = new JLabel("Cantidad Minima:");
			lblCantidadMinima.setBounds(398, 8, 105, 14);
			panel_ComponentesDelSumi.add(lblCantidadMinima);
			
			spinner_CantidadMinima = new JSpinner();
			spinner_CantidadMinima.setBounds(398, 22, 64, 20);
			panel_ComponentesDelSumi.add(spinner_CantidadMinima);
			
			JLabel lblCantidadMaxima = new JLabel("Cantidad Maxima:");
			lblCantidadMaxima.setBounds(398, 53, 105, 14);
			panel_ComponentesDelSumi.add(lblCantidadMaxima);
			
			spinner_CantidaMaxima = new JSpinner();
			spinner_CantidaMaxima.setBounds(398, 78, 64, 20);
			panel_ComponentesDelSumi.add(spinner_CantidaMaxima);
		}
		{
			JLabel lblComponentesDelSuministrador = new JLabel("Componentes del Suministrador:");
			lblComponentesDelSuministrador.setBounds(10, 155, 185, 14);
			Panel.add(lblComponentesDelSuministrador);
		}
		{
			JLabel lblDatosDelSuministrador = new JLabel("Datos del Suministrador");
			lblDatosDelSuministrador.setBounds(10, 14, 174, 14);
			Panel.add(lblDatosDelSuministrador);
		}

		panelTargetaMadre = new JPanel();
		panelTargetaMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTargetaMadre.setBounds(10, 330, 404, 209);
		Panel.add(panelTargetaMadre);
		panelTargetaMadre.setLayout(null);

		cbxTipoSocket = new JComboBox();
		cbxTipoSocket.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "PGA", "BGA", "LGA"}));
		cbxTipoSocket.setBounds(10, 36, 187, 20);
		panelTargetaMadre.add(cbxTipoSocket);

		JLabel lblTipoDeSocket = new JLabel("Tipo de Socket:");
		lblTipoDeSocket.setBounds(10, 11, 83, 14);
		panelTargetaMadre.add(lblTipoDeSocket);

		JLabel lblRamCompatible = new JLabel("Ram Compatible:");
		lblRamCompatible.setBounds(207, 11, 83, 14);
		panelTargetaMadre.add(lblRamCompatible);

		cbx_RamComp = new JComboBox();
		cbx_RamComp.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "SRAM", "DRAM"}));
		cbx_RamComp.setBounds(207, 36, 187, 20);
		panelTargetaMadre.add(cbx_RamComp);
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

		list_Compatibles = new JList<String>();
		list_Compatibles.setBounds(0, 0, 70, 101);
		panel.add(list_Compatibles);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(246, 67, 64, 14);
		panelTargetaMadre.add(lblModelo);

		tF_ModeloTM = new JTextField();
		tF_ModeloTM.setBounds(244, 88, 150, 20);
		panelTargetaMadre.add(tF_ModeloTM);
		tF_ModeloTM.setColumns(10);
		
		JButton button_Agregar_TM = new JButton("Agregar Suministro");
		button_Agregar_TM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Componente aux = null;
				ArrayList<String> cc = new ArrayList<String>();
				cc.add(list_Compatibles.toString());
				
				float precio = Float.valueOf(spinner_Precio.getValue().toString());
				int cantMin = Integer.valueOf(spinner_CantidadMinima.getValue().toString());
				int cantMax = Integer.valueOf(spinner_CantidaMaxima.getValue().toString());
				
				aux = new MotherBoard(tF_IdComponente.getText(), tF_Marca.getText(), "", precio, cantMin, cantMax , 0, tF_ModeloTM.getText(), cbxTipoSocket.getSelectedItem().toString(), cbx_RamComp.getSelectedItem().toString(), cc);
				
				sumi.getComponentes().add(aux);
				suministros.clear();
				list_Suministros.removeAll();
				
				cargarSuministros();
				list_Suministros.setModel(suministros);
				codigoComp++;
				updateCodigo();
				cleanComponentes();
				
			}
		});
		button_Agregar_TM.setActionCommand("OK");
		button_Agregar_TM.setBounds(244, 136, 150, 23);
		panelTargetaMadre.add(button_Agregar_TM);

		panelMicroprocesadores = new JPanel();
		panelMicroprocesadores.setVisible(false);
		panelMicroprocesadores.setLayout(null);
		panelMicroprocesadores.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMicroprocesadores.setBounds(10, 330, 404, 209);
		Panel.add(panelMicroprocesadores);

		JLabel label = new JLabel("Tipo de Socket:");
		label.setBounds(10, 11, 83, 14);
		panelMicroprocesadores.add(label);

		JLabel label_2 = new JLabel("Modelo:");
		label_2.setBounds(216, 11, 64, 14);
		panelMicroprocesadores.add(label_2);

		tf_ModeloMicro = new JTextField();
		tf_ModeloMicro.setColumns(10);
		tf_ModeloMicro.setBounds(216, 36, 187, 20);
		panelMicroprocesadores.add(tf_ModeloMicro);

		cbxTipoSocketMicro = new JComboBox();
		cbxTipoSocketMicro.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "PGA", "BGA", "LGA"}));
		cbxTipoSocketMicro.setBounds(10, 36, 187, 20);
		panelMicroprocesadores.add(cbxTipoSocketMicro);

		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setBounds(10, 67, 64, 14);
		panelMicroprocesadores.add(lblVelocidad);

		spinnerVelocidadMicro = new JSpinner();
		spinnerVelocidadMicro.setBounds(13, 92, 184, 20);
		panelMicroprocesadores.add(spinnerVelocidadMicro);
		
		JButton button_AgregarSuministroMicro = new JButton("Agregar Suministro");
		button_AgregarSuministroMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float precio = Float.valueOf(spinner_Precio.getValue().toString());
				int cantMin = Integer.valueOf(spinner_CantidadMinima.getValue().toString());
				int cantMax = Integer.valueOf(spinner_CantidaMaxima.getValue().toString());
				int velocidad = Integer.valueOf(spinnerVelocidadMicro.getValue().toString());
				
				Componente aux = new Micro(tF_IdComponente.getText(), tF_Marca.getText(), "", precio, cantMin, cantMax, 0, tf_ModeloMicro.getText(), cbxTipoSocketMicro.getSelectedItem().toString(), velocidad);
				
				sumi.getComponentes().add(aux);
				suministros.clear();
				cargarSuministros();
				list_Suministros.setModel(suministros);
				codigoComp++;
				updateCodigo();
				cleanComponentes();
			}
		});
		button_AgregarSuministroMicro.setActionCommand("OK");
		button_AgregarSuministroMicro.setBounds(216, 91, 150, 23);
		panelMicroprocesadores.add(button_AgregarSuministroMicro);

		panelMemoriRam = new JPanel();
		panelMemoriRam.setVisible(false);
		panelMemoriRam.setLayout(null);
		panelMemoriRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMemoriRam.setBounds(10, 330, 404, 209);
		Panel.add(panelMemoriRam);

		JLabel lblCantidadDeMemoria = new JLabel("Cantidad de Memoria: ");
		lblCantidadDeMemoria.setBounds(10, 11, 124, 14);
		panelMemoriRam.add(lblCantidadDeMemoria);

		JLabel lblTipoDeRam = new JLabel("Tipo de Ram:");
		lblTipoDeRam.setBounds(207, 11, 83, 14);
		panelMemoriRam.add(lblTipoDeRam);

		cbx_TipoRam = new JComboBox();
		cbx_TipoRam.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "DDR SDRAM", "DDR2 SDRAM", "DDR3 SDRAM", "DDR4 SDRAM", "DDR5 SDRAM", "DDR6 SDRAM"}));
		cbx_TipoRam.setBounds(207, 36, 187, 20);
		panelMemoriRam.add(cbx_TipoRam);

		spinner_CantExactaRam = new JSpinner();
		spinner_CantExactaRam.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner_CantExactaRam.setBounds(10, 67, 187, 20);
		panelMemoriRam.add(spinner_CantExactaRam);

		cbx_CantidadMemoriaRam = new JComboBox();
		cbx_CantidadMemoriaRam.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "Giga-Bites", "Tera-Bites"}));
		cbx_CantidadMemoriaRam.setBounds(10, 36, 187, 20);
		panelMemoriRam.add(cbx_CantidadMemoriaRam);
		
		JButton button_Agregar_Suministro_MR = new JButton("Agregar Suministro");
		button_Agregar_Suministro_MR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float precio = Float.valueOf(spinner_Precio.getValue().toString());
				int cantMin = Integer.valueOf(spinner_CantidadMinima.getValue().toString());
				int cantMax = Integer.valueOf(spinner_CantidaMaxima.getValue().toString());
				int cantMemoria = Integer.valueOf(spinner_CantExactaRam.getValue().toString());
				
				Componente aux = new MemoriaRam(tF_IdComponente.getText(), tF_Marca.getText(), "", precio, cantMin, cantMax, 0, cantMemoria, cbx_TipoRam.getSelectedItem().toString());
				//componente sss = new MemoriaRam(id, marca, serial, precio, cantMin, cantMax, cantReal, cantMemoria, tipoMemoria)
				sumi.getComponentes().add(aux);
				suministros.clear();
				cargarSuministros();
				list_Suministros.setModel(suministros);
				codigoComp++;
				updateCodigo();
				cleanComponentes();
			}
		});
		button_Agregar_Suministro_MR.setActionCommand("OK");
		button_Agregar_Suministro_MR.setBounds(126, 125, 150, 23);
		panelMemoriRam.add(button_Agregar_Suministro_MR);
		
		panelDiscoDuro = new JPanel();
		panelDiscoDuro.setVisible(false);
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDiscoDuro.setBounds(10, 330, 404, 209);
		Panel.add(panelDiscoDuro);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(10, 11, 83, 14);
		panelDiscoDuro.add(lblCapacidad);
		
		JLabel label_6 = new JLabel("Modelo:");
		label_6.setBounds(182, 11, 64, 14);
		panelDiscoDuro.add(label_6);
		
		tf_ModeloDD = new JTextField();
		tf_ModeloDD.setColumns(10);
		tf_ModeloDD.setBounds(182, 36, 150, 20);
		panelDiscoDuro.add(tf_ModeloDD);
		
		cbx_TipoConexionDD = new JComboBox();
		cbx_TipoConexionDD.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "IDE", "SATA-1", "SATA-2", "SATA-3"}));
		cbx_TipoConexionDD.setBounds(10, 94, 187, 20);
		panelDiscoDuro.add(cbx_TipoConexionDD);
		
		JLabel lblTipoDeConexion = new JLabel("Tipo de conexion:");
		lblTipoDeConexion.setBounds(10, 69, 103, 14);
		panelDiscoDuro.add(lblTipoDeConexion);
		
		JButton button_Agregar_Suministro_DD = new JButton("Agregar Suministro");
		button_Agregar_Suministro_DD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float precio = Float.valueOf(spinner_Precio.getValue().toString());
				int cantMin = Integer.valueOf(spinner_CantidadMinima.getValue().toString());
				int cantMax = Integer.valueOf(spinner_CantidaMaxima.getValue().toString());
				int capacidadDD = Integer.valueOf(spinner_Capacidad_DD.getValue().toString());
				
				Componente aux = new DiscoDuro(tF_IdComponente.getText(), tF_Marca.getText(), "", precio, cantMin, cantMax, 0, capacidadDD, tf_ModeloDD.getText(), cbx_TipoConexionDD.getSelectedItem().toString());
				
				sumi.getComponentes().add(aux);
				suministros.removeAllElements();
				cargarSuministros();
				list_Suministros.setModel(suministros);
				codigoComp++;
				updateCodigo();
				cleanComponentes();
			}
		});
		button_Agregar_Suministro_DD.setActionCommand("OK");
		button_Agregar_Suministro_DD.setBounds(219, 93, 150, 23);
		panelDiscoDuro.add(button_Agregar_Suministro_DD);
		
		spinner_Capacidad_DD = new JSpinner();
		spinner_Capacidad_DD.setBounds(10, 36, 150, 20);
		panelDiscoDuro.add(spinner_Capacidad_DD);
		
		JLabel lblSuministros = new JLabel("Suministros:");
		lblSuministros.setBounds(420, 318, 83, 14);
		Panel.add(lblSuministros);
		
		JPanel panel_Suministros = new JPanel();
		panel_Suministros.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Suministros.setBounds(420, 330, 149, 208);
		Panel.add(panel_Suministros);
		panel_Suministros.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 149, 208);
		panel_Suministros.add(scrollPane_1);
		
		list_Suministros = new JList<String>();
		list_Suministros.setModel(suministros);
		scrollPane_1.setViewportView(list_Suministros);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton AgregarButton = new JButton("Agregar");
				AgregarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						sumi.setId(tF_Id.getText());
						sumi.setNombre(tF_Nombre.getText());
						sumi.setPais(tF_Pais.getText());
						
						Tienda.getInstance().insertarSuministrador(sumi);
						codigo++;
						codigoComp = 1;
						tF_Id.setText("Sumi- "+Tienda.getInstance().codSumi);
						JOptionPane.showMessageDialog(null, "Suministrador Agregado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
						suministros.removeAllElements();
						sumi = new Suministrador("", "", "", 0);
					}

				});
				AgregarButton.setActionCommand("OK");
				buttonPane.add(AgregarButton);
				getRootPane().setDefaultButton(AgregarButton);
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
		}
		
		updateCodigo();
	}


	void lista_Conexiones() {

		conexionesDD.addElement("IDE");
		conexionesDD.addElement("SATA");
		conexionesDD.addElement("SATA-2");
		conexionesDD.addElement("SATA-3");
		conexionesDD.addElement("DDR");
		conexionesDD.addElement("DDR 2");
		conexionesDD.addElement("DDR 3");
		conexionesDD.addElement("LGA");
		conexionesDD.addElement("TR4");
	}
	
	private void updateCodigo() {
		String pre = "";
		if(rdbtnTarjetaMadre.isSelected()){
			pre = "TM";
		}
		if(rdbtnDiscoDuro.isSelected()){
		   pre = "DD";	
		}
		if(rdbtnMemoriaRam.isSelected()){
			   pre = "MR";	
		}
		
		if(rdbtnMicroprocesador.isSelected()){
			   pre = "MP";	
		}
		tF_IdComponente.setText(pre+"-"+codigoComp+" ");
		
	}
	
	private void cargarSuministros() {
		
		String info;
		
		for (Componente aux : sumi.getComponentes()) {
			
			info = "Id: "+aux.getId()+ "Marca: " + aux.getMarca()+" "+"Precio: "+aux.getPrecio() +"USD";
			
			if(aux instanceof MotherBoard) {
				MotherBoard m = (MotherBoard) aux;
				info = info + " Modelo: " + m.getModelo();
			}
			
			if(aux instanceof Micro) {
				Micro m = (Micro) aux;
				info = info + " Modelo: " + m.getModelo()+" Tipo Socket: "+m.getTipoSocket();
			}
			
			if(aux instanceof MemoriaRam) {
				MemoriaRam m = (MemoriaRam) aux;
				info = info + " Cantidad de Memoria: " + m.getCantMemoria() + cbx_CantidadMemoriaRam.getSelectedItem().toString() +" Tipo Memoria: " + m.getTipoMemoria();
			}
			
			if(aux instanceof DiscoDuro) {
				DiscoDuro m = (DiscoDuro) aux;
				info = info + " Modelo: " + m.getModelo()+" Tipo Conexion: "+m.getTipoConexion();
			}
			
			suministros.addElement(info);
		}
	}
	
	private void clean() {
		cleanComponentes();
		tF_Nombre.setText("");
		tF_Pais.setText("");
		tF_Marca.setText("");
	}
	
	private void cleanComponentes() {
		
		rdbtnDiscoDuro.setSelected(false);
		rdbtnMemoriaRam.setSelected(false);
		rdbtnMicroprocesador.setSelected(false);
		rdbtnTarjetaMadre.setSelected(true);
		panelMicroprocesadores.setVisible(false);
		panelMemoriRam.setVisible(false);
		panelDiscoDuro.setVisible(false);
		panelTargetaMadre.setVisible(true);
		panel_ComponentesDelSumi.setVisible(true);
		
		cbxTipoSocket.setSelectedIndex(0);
		cbx_RamComp.setSelectedIndex(0);
		updateCodigo();
		conexionesDD.removeAllElements();
		conexionesDD_Compatibles.removeAllElements();
		tF_ModeloTM.setText("");
		tf_ModeloMicro.setText("");
		tf_ModeloDD.setText("");
		spinnerVelocidadMicro.setValue(new Integer(0));
		cbxTipoSocketMicro.setSelectedIndex(0);
		cbx_CantidadMemoriaRam.setSelectedIndex(0);
		cbx_TipoRam.setSelectedIndex(0);
		spinner_CantExactaRam.setValue(new Integer(0));
		cbx_TipoConexionDD.setSelectedIndex(0);
		spinner_Capacidad_DD.setValue(new Integer(0));
		spinner_Precio.setValue(new Float(0.0));
		spinner_CantidadMinima.setValue(new Integer(0));
		spinner_CantidaMaxima.setValue(new Integer(0));
		
		
		lista_Conexiones();
		
	}
}
