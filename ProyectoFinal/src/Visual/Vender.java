package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.rmi.CORBA.Tie;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cliente;
import Logico.Combo;
import Logico.Componente;
import Logico.Factura;
import Logico.Credito;
import Logico.Tienda;
import Logico.Vendedor;
import Logico.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;
import javax.swing.event.ChangeEvent;

public class Vender extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private static JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JButton btnRegistrar;
	private JList<String> listComponente;
	private JList<String> listVenta;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private DefaultListModel<String> listModelComp;
	private DefaultListModel<String> listModelVenta;
	private Cliente cliente;
	private JButton btnFinalizar;
	private JRadioButton rdbtnSinCredito;
	private JSpinner spnDescuento;
	private JRadioButton rdbtnCredito; 
	private JSpinner spnMonto;
	private JSpinner spnDiasPagar;
	private JButton btnInfo;
	private JButton btnDerechaCombo;
	private JButton btnIzquierdaCombo;
	private JList<String> listCombo;
	private JList<String> listVentaCombo;
	private DefaultListModel<String> listModelCombo;
	private DefaultListModel<String> listModelVentaCombo;
	private JButton btnInfoVenta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vender dialog = new Vender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vender() {
		setTitle("Hacer venta");
		setBounds(100, 100, 450, 935);
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
			
			JLabel lblNewLabel = new JLabel("Cedula:");
			lblNewLabel.setBounds(15, 16, 79, 14);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(64, 8, 241, 30);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cliente = Tienda.getInstance().buscarClienteByCedula(txtCedula.getText());
					loadCliente(cliente);
				}
			});
			btnBuscar.setBounds(314, 8, 95, 30);
			panel.add(btnBuscar);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(15, 46, 394, 161);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(15, 21, 113, 14);
			panel_1.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(75, 13, 250, 30);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(15, 56, 113, 14);
			panel_1.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setBounds(75, 48, 250, 30);
			panel_1.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Telefono:");
			lblNewLabel_2.setBounds(15, 91, 113, 14);
			panel_1.add(lblNewLabel_2);
			
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setBounds(75, 83, 250, 30);
			panel_1.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Tienda.getInstance().checkCedula(txtCedula.getText()) ) {
						
						Cliente aux = new Cliente(txtCedula.getText(),txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
						Tienda.getInstance().insertarCliente(aux);
						cliente = aux;
						JOptionPane.showMessageDialog(null, "Se ha registrado el cliente con exito", "Registro de cliente", JOptionPane.INFORMATION_MESSAGE);
						loadCliente(aux);
					} else {
						JOptionPane.showMessageDialog(null, "Esta cedula ya esta registrada", "Registro de cliente", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			btnRegistrar.setEnabled(false);
			btnRegistrar.setBounds(149, 122, 95, 30);
			panel_1.add(btnRegistrar);
			
			JLabel lblNewLabel_3 = new JLabel("Componentes:");
			lblNewLabel_3.setBounds(15, 235, 122, 14);
			panel.add(lblNewLabel_3);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 260, 140, 135);
			panel.add(scrollPane);
			
			listModelComp = new DefaultListModel<String>();
			listComponente = new JList<String>();
			listComponente.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index =- 1;
					index = listComponente.getSelectedIndex();
					if (index != -1){
						btnDerecha.setEnabled(true);
					}
				}
			});
			listComponente.setModel(listModelComp);
			scrollPane.setViewportView(listComponente);
			
			btnDerecha = new JButton(">>");
			btnDerecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = listComponente.getSelectedValue().toString();
					listModelVenta.addElement(aux);
					listModelComp.remove(listComponente.getSelectedIndex());
					btnDerecha.setEnabled(false);
					updateMonto();
				}
			});
			btnDerecha.setEnabled(false);
			btnDerecha.setBounds(178, 278, 70, 30);
			panel.add(btnDerecha);
			
			btnIzquierda = new JButton("<<");
			btnIzquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = listVenta.getSelectedValue().toString();
					listModelComp.addElement(aux);
					listModelVenta.remove(listVenta.getSelectedIndex());
					btnIzquierda.setEnabled(false);
					updateMonto();
				}
			});
			btnIzquierda.setEnabled(false);
			btnIzquierda.setBounds(178, 341, 70, 30);
			panel.add(btnIzquierda);
			
			JLabel lblNewLabel_4 = new JLabel("Venta:");
			lblNewLabel_4.setBounds(269, 235, 122, 14);
			panel.add(lblNewLabel_4);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(269, 260, 140, 135);
			panel.add(scrollPane_1);
			
			listModelVenta = new DefaultListModel<String>();
			listVenta = new JList<String>();
			listVenta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = -1;
					index = listVenta.getSelectedIndex();
					if (index != -1){
						btnIzquierda.setEnabled(true);
					}
				}
			});
			listVenta.setModel(listModelVenta);
			scrollPane_1.setViewportView(listVenta);
			
			rdbtnCredito = new JRadioButton("A credito");
			rdbtnCredito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnCredito.setSelected(true);
					rdbtnSinCredito.setSelected(false);
					spnDiasPagar.setEnabled(true);
				}
			});
			rdbtnCredito.setBounds(30, 651, 109, 23);
			panel.add(rdbtnCredito);
			
			rdbtnSinCredito = new JRadioButton("Sin Credito");
			rdbtnSinCredito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnSinCredito.setSelected(true);
					rdbtnCredito.setSelected(false);
					spnDiasPagar.setEnabled(false);
				}
			});
			rdbtnSinCredito.setSelected(true);
			rdbtnSinCredito.setBounds(146, 651, 122, 23);
			panel.add(rdbtnSinCredito);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(15, 216, 394, 2);
			panel.add(separator);
			
			JPanel panelInfo = new JPanel();
			panelInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfo.setBounds(15, 686, 394, 150);
			panel.add(panelInfo);
			panelInfo.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("% Descuento:");
			lblNewLabel_5.setBounds(15, 27, 140, 14);
			panelInfo.add(lblNewLabel_5);
			
			spnDescuento = new JSpinner();
			JFormattedTextField field = getTextField(spnDescuento);
		    DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
		    formatter.setCommitsOnValidEdit(true);
			spnDescuento.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					updateMonto();
				}
			});
			spnDescuento.setBounds(110, 19, 145, 30);
			panelInfo.add(spnDescuento);
			spnDescuento.setModel(new SpinnerNumberModel(0, 0, 100, 1));
			
			JLabel lblNewLabel_5_1 = new JLabel("Monto a pagar:");
			lblNewLabel_5_1.setBounds(15, 109, 140, 14);
			panelInfo.add(lblNewLabel_5_1);
			
			spnMonto = new JSpinner();
			spnMonto.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnMonto.setBounds(110, 101, 145, 30);
			panelInfo.add(spnMonto);
			spnMonto.setEnabled(false);
			
			JLabel lblNewLabel_5_2 = new JLabel("Dias para pagar:");
			lblNewLabel_5_2.setBounds(15, 68, 140, 14);
			panelInfo.add(lblNewLabel_5_2);
			
			spnDiasPagar = new JSpinner();
			spnDiasPagar.setBounds(110, 60, 145, 30);
			panelInfo.add(spnDiasPagar);
			spnDiasPagar.setEnabled(false);
			
			JLabel lblNewLabel_3_1 = new JLabel("Combos:");
			lblNewLabel_3_1.setBounds(15, 411, 122, 14);
			panel.add(lblNewLabel_3_1);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(15, 436, 140, 135);
			panel.add(scrollPane_2);
			
			listModelCombo = new DefaultListModel<String>();
			listCombo = new JList<String>();
			listCombo.setModel(listModelCombo);
			listCombo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index =- 1;
					index = listCombo.getSelectedIndex();
					if (index != -1){
						btnDerechaCombo.setEnabled(true);
						btnInfo.setEnabled(true);
					}
				}
			});
			scrollPane_2.setViewportView(listCombo);
			
			JLabel lblNewLabel_4_1 = new JLabel("Venta de combos:");
			lblNewLabel_4_1.setBounds(269, 411, 140, 14);
			panel.add(lblNewLabel_4_1);
			
			JScrollPane scrollPane_1_1 = new JScrollPane();
			scrollPane_1_1.setBounds(269, 436, 140, 135);
			panel.add(scrollPane_1_1);
			
			listModelVentaCombo = new DefaultListModel<String>();
			listVentaCombo = new JList<String>();
			listVentaCombo.setModel(listModelVentaCombo);
			listVentaCombo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index =- 1;
					index = listVentaCombo.getSelectedIndex();
					if (index != -1){
						btnIzquierdaCombo.setEnabled(true);
						btnInfoVenta.setEnabled(true);
					}
				}
			});
			scrollPane_1_1.setViewportView(listVentaCombo);
			
			btnDerechaCombo = new JButton(">>");
			btnDerechaCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String aux = listCombo.getSelectedValue().toString();
					listModelVentaCombo.addElement(aux);
					listModelCombo.remove(listCombo.getSelectedIndex());
					btnDerechaCombo.setEnabled(false);
					btnInfo.setEnabled(false);
					updateMonto();
				}
			});
			btnDerechaCombo.setEnabled(false);
			btnDerechaCombo.setBounds(178, 454, 70, 30);
			panel.add(btnDerechaCombo);
			
			btnIzquierdaCombo = new JButton("<<");
			btnIzquierdaCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = listVentaCombo.getSelectedValue().toString();
					listModelCombo.addElement(aux);
					listModelVentaCombo.remove(listVentaCombo.getSelectedIndex());
					btnIzquierdaCombo.setEnabled(false);
					btnInfoVenta.setEnabled(false);
					updateMonto();
				}
			});
			btnIzquierdaCombo.setEnabled(false);
			btnIzquierdaCombo.setBounds(178, 517, 70, 30);
			panel.add(btnIzquierdaCombo);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(15, 633, 404, 2);
			panel.add(separator_1);
			
			btnInfo = new JButton("Mas info.");
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = listCombo.getSelectedValue().toString();
					Combo combo = Tienda.getInstance().buscarComboById(id);
					if (combo != null) {
						ListarCombo info = new ListarCombo(combo);
						info.setModal(true);
						info.setVisible(true);
					}
					btnInfo.setEnabled(false);
					btnDerechaCombo.setEnabled(false);
				}
			});
			btnInfo.setEnabled(false);
			btnInfo.setBounds(15, 587, 95, 30);
			panel.add(btnInfo);
			
			btnInfoVenta = new JButton("Mas info.");
			btnInfoVenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = listVentaCombo.getSelectedValue().toString();
					Combo combo = Tienda.getInstance().buscarComboById(id);
					if (combo != null) {
						ListarCombo info = new ListarCombo(combo);
						info.setModal(true);
						info.setVisible(true);
					}
					btnInfoVenta.setEnabled(false);
					btnIzquierdaCombo.setEnabled(false);
				}
			});
			btnInfoVenta.setEnabled(false);
			btnInfoVenta.setBounds(269, 587, 95, 30);
			panel.add(btnInfoVenta);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFinalizar = new JButton("Finalizar");
				btnFinalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (listModelVenta.size() > 0 || listModelVentaCombo.size() > 0) {
							if (cliente != null) {
								
								Componente verify = checkDisponibilidad();
								if (verify == null) {
									
									if (rdbtnCredito.isSelected()) {
										
										float monto = new Float(spnMonto.getValue().toString());
										if (Tienda.getInstance().checkCredito(cliente, monto)) {
											
											cliente.setCreditoEnUso(cliente.getCreditoEnUso() + monto);
											
											Credito f = null;
											String id = new String("F-" + Factura.cod);
											Cliente c = cliente;
											int descuento = Integer.valueOf(spnDescuento.getValue().toString());
											Usuario usr = Tienda.getLoginUser();	
											int dias = Integer.valueOf(spnDiasPagar.getValue().toString());
											
											f = new Credito(id, c, descuento, usr, dias);
											
											for (int i = 0; i < listModelVenta.size(); i++) {
												Componente comp = Tienda.getInstance().buscarComponenteById(listModelVenta.get(i).toString());
												comp.setCantReal(comp.getCantReal() - 1);
												
												if (!Tienda.getInstance().checkDisponibilidadComponente(comp)) {
													JOptionPane.showMessageDialog(null,"No se encontro un suministrador que supla el componente: " + comp.getId() 
													+ ", por lo que no se genero una orden de compra","Error",JOptionPane.ERROR_MESSAGE);
												}
												f.agregarComponente(comp);
											}
											
											for (int i = 0; i < listModelVentaCombo.size(); i++) {
												Combo combo = Tienda.getInstance().buscarComboById(listModelVentaCombo.get(i).toString());
												
												for (Componente comp : combo.getComponentes()) {
													comp.setCantReal(comp.getCantReal() - 1);
													if (!Tienda.getInstance().checkDisponibilidadComponente(comp)) {
														JOptionPane.showMessageDialog(null,"No se encontro un suministrador que supla el componente: " + comp.getId() 
														+ ", por lo que no se genero una orden de compra","Error",JOptionPane.ERROR_MESSAGE);
													}
												}
												f.agregarCombo(combo);
											}
											
											if (Tienda.getLoginUser() instanceof Vendedor) {
												((Vendedor) Tienda.getLoginUser()).setCantVentas(((Vendedor) Tienda.getLoginUser()).getCantVentas() + 1);
												((Vendedor) Tienda.getLoginUser()).setVentas(((Vendedor) Tienda.getLoginUser()).getVentas() + f.precioTotal());
											}
											
											Tienda.getInstance().insertarFactura(f);
											JOptionPane.showMessageDialog(null,"Venta a credito realizada con exito","Finalizar Venta",JOptionPane.INFORMATION_MESSAGE);
											clean();
											
										} else {
											JOptionPane.showMessageDialog(null,"El cliente no tiene suficiente credito para esta orden","Error de Credito",JOptionPane.WARNING_MESSAGE);
										}
										
									} else if (rdbtnSinCredito.isSelected()) {
										
										Factura f = new Factura(new String("F-" + Factura.cod), cliente, Integer.valueOf(spnDescuento.getValue().toString()), Tienda.getLoginUser());
										
										for (int i = 0; i < listModelVenta.size(); i++) {
											Componente comp = Tienda.getInstance().buscarComponenteById(listModelVenta.get(i).toString());
											comp.setCantReal(comp.getCantReal() - 1);
											if (!Tienda.getInstance().checkDisponibilidadComponente(comp)) {
												JOptionPane.showMessageDialog(null,"No se encontro un suministrador que supla el componente: " + comp.getId() 
												+ ", por lo que no se genero una orden de compra","Error",JOptionPane.ERROR_MESSAGE);
											}
											f.agregarComponente(comp);
										}
										
										for (int i = 0; i < listModelVentaCombo.size(); i++) {
											Combo combo = Tienda.getInstance().buscarComboById(listModelVentaCombo.get(i).toString());
											
											for (Componente comp : combo.getComponentes()) {
												comp.setCantReal(comp.getCantReal() - 1);
												if (!Tienda.getInstance().checkDisponibilidadComponente(comp)) {
													JOptionPane.showMessageDialog(null,"No se encontro un suministrador que supla el componente: " + comp.getId() 
													+ ", por lo que no se genero una orden de compra","Error",JOptionPane.ERROR_MESSAGE);
												}
											}
											f.agregarCombo(combo);
										}
										
										if (Tienda.getLoginUser() instanceof Vendedor) {
											((Vendedor) Tienda.getLoginUser()).setCantVentas(((Vendedor) Tienda.getLoginUser()).getCantVentas() + 1);
											((Vendedor) Tienda.getLoginUser()).setVentas(((Vendedor) Tienda.getLoginUser()).getVentas() + f.precioTotal());
										}
										
										Tienda.getInstance().insertarFactura(f);
										JOptionPane.showMessageDialog(null,"Venta realizada con exito","Finalizar Venta",JOptionPane.INFORMATION_MESSAGE);
										clean();
									}
									
								} else {
									JOptionPane.showMessageDialog(null,"No hay suficientes unidades de: " + verify.getId() + ", en inventario para esta venta","Aviso",JOptionPane.WARNING_MESSAGE);
								}
								
							} else {
								JOptionPane.showMessageDialog(null,"Necesita seleccionar un cliente","Aviso",JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,"Necesita al menos 1 componente o combo para finalizar la venta","Aviso",JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				btnFinalizar.setEnabled(false);
				btnFinalizar.setActionCommand("OK");
				buttonPane.add(btnFinalizar);
				getRootPane().setDefaultButton(btnFinalizar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadComponentesDisponible();
		loadCombosDisponibles();
	}
	
	private Componente checkDisponibilidad() {
		int count;
		
		for (int i = 0; i < listModelVenta.size(); i++) {
			count = 1;
			Componente comp = Tienda.getInstance().buscarComponenteById(listModelVenta.get(i).toString());
			
			for (int j = 0; j < listModelVentaCombo.size(); j++) {
				Combo combo = Tienda.getInstance().buscarComboById(listModelVentaCombo.get(j).toString());
				
				for (Componente c : combo.getComponentes()) {
					if (comp.equals(c)) {
						count++;
					}
				}
			}
			
			if (comp.getCantReal() < count) {
				return comp;
			}
		}
		return null;
	}

	private void updateMonto() {
		float total = 0;
		
		for (int i = 0; i < listModelVenta.size(); i++) {
			Componente comp = Tienda.getInstance().buscarComponenteById(listModelVenta.get(i).toString());
			total += comp.getPrecio();
		}
		
		for (int i = 0; i < listModelVentaCombo.size(); i++) {
			Combo combo = Tienda.getInstance().buscarComboById(listModelVentaCombo.get(i).toString());
			total += combo.precio();
		}
		
		float descuento = new Float(spnDescuento.getValue().toString()) / 100;
		spnMonto.setValue(total - (total*descuento));
	}

	private void loadCliente(Cliente c) {
		if (c != null) {
			
			txtNombre.setText(c.getNombre());
			txtDireccion.setText(c.getDireccion());
			txtTelefono.setText(c.getTelefono());
			btnFinalizar.setEnabled(true);
			
			txtNombre.setEditable(false);
			txtDireccion.setEditable(false);
			txtTelefono.setEditable(false);
			btnRegistrar.setEnabled(false);
			
		} else {
			
			txtNombre.setText("");
			txtDireccion.setText("");
			txtTelefono.setText("");
			btnFinalizar.setEnabled(false);
			
			txtNombre.setEditable(true);
			txtDireccion.setEditable(true);
			txtTelefono.setEditable(true);
			btnRegistrar.setEnabled(true);
		}
	}
	
	private void loadCombosDisponibles() {
		listModelCombo.removeAllElements();
		for (Combo c : Tienda.getInstance().getCombos()) {
			if (Tienda.getInstance().checkCombo(c)) {
				listModelCombo.addElement(c.getId());
			}
		}
	}

	private void loadComponentesDisponible() {
		listModelComp.removeAllElements();
		for (Componente comp : Tienda.getInstance().getInventario()) {
			if (comp.getCantReal() > 0) {
				listModelComp.addElement(comp.getId());
			}
		}
	}
	
	private void clean() {
		txtCedula.setText("");
		spnDescuento.setValue(0);
		cleanReg();
		
		listModelVenta.removeAllElements();
		listModelVentaCombo.removeAllElements();
		loadCombosDisponibles();
		loadComponentesDisponible();
		
		btnFinalizar.setEnabled(false);
		btnDerecha.setEnabled(false);
		btnDerechaCombo.setEnabled(false);
		btnIzquierda.setEnabled(false);
		btnIzquierdaCombo.setEnabled(false);
		btnInfo.setEnabled(false);
		btnInfoVenta.setEnabled(false);
		
		rdbtnSinCredito.setSelected(true);
		rdbtnCredito.setSelected(false);
		
		spnMonto.setValue(0);
		spnDiasPagar.setValue(0);
	}
	
	private void cleanReg() {
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		btnRegistrar.setEnabled(false);
	}
	
	//Esto es para cambiar el precio si cambia el combo
	private JFormattedTextField getTextField(JSpinner spinner) {
		return ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField(); 
	}
}