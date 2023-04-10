package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Administrador;
import Logico.Tienda;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					if (Tienda.getLoginUser() == null) {
						Login.main(args);
					} else {
						Principal frame = new Principal();
						frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				Tienda.getInstance().updateCodigos();
				FileOutputStream tiendaOutput;
				ObjectOutputStream writer;
				
				try {
					tiendaOutput = new  FileOutputStream("tienda2.dat");
					writer = new ObjectOutputStream(tiendaOutput);
					writer.writeObject(Tienda.getInstance());
					
					tiendaOutput.close();
					writer.close();
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
		
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 635);
		
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-35);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmHacerVentas = new JMenuItem("Hacer Venta");
		mntmHacerVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vender venta = new Vender();
				venta.setModal(true);
				venta.setVisible(true);
			}
		});
		mnVentas.add(mntmHacerVentas);
		
		JMenuItem mntmListFacturas = new JMenuItem("Listado de Facturas");
		mntmListFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarFactura listFactura = new ListarFactura(null);
				listFactura.setModal(true);
				listFactura.setVisible(true);
			}
		});
		mnVentas.add(mntmListFacturas);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmNewMenuItem21 = new JMenuItem("Registrar");
		mntmNewMenuItem21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarCliente regClien = new AgregarCliente(null);
				regClien.setModal(true);
				regClien.setVisible(true);
			}
		});
		mnClientes.add(mntmNewMenuItem21);
		
		JMenuItem mntmListClientes = new JMenuItem("Listar Clientes");
		mntmListClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente listCliente=new ListarCliente();
				listCliente.setModal(true);
				listCliente.setVisible(true);
			}
		});
		mnClientes.add(mntmListClientes);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		if (Tienda.getLoginUser() instanceof Administrador) {
			mnUsuarios.setEnabled(true);
		} else {
			mnUsuarios.setEnabled(false);
		}
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarUsuario regUser = new AgregarUsuario();
				regUser.setModal(true);
				regUser.setVisible(true);
			}
		});
		mnUsuarios.add(mntmNewMenuItem);
		
		JMenuItem mntmListarUsuarios = new JMenuItem("Listar");
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuario listUser = new ListarUsuario();
				listUser.setModal(true);
				listUser.setVisible(true);
			}
		});
		mnUsuarios.add(mntmListarUsuarios);
		
		
		JMenu mnAdmin = new JMenu("Administracion");
		menuBar.add(mnAdmin);
		if (Tienda.getLoginUser() instanceof Administrador) {
			mnAdmin.setEnabled(true);
		} else {
			mnAdmin.setEnabled(false);
		}
		
		JMenu mnNewMenu = new JMenu("Inventario");
		mnAdmin.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Componente");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarComponente regComp = new AgregarComponente(null);
				regComp.setModal(true);
				regComp.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ver inventario");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarComponente listComp = new ListarComponente();
				listComp.setModal(true);
				listComp.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Combos");
		mnAdmin.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Nuevo");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarCombo regcombo = new AgregarCombo(null);
				regcombo.setModal(true);
				regcombo.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCombo listCombo= new ListarCombo(null);
				listCombo.setModal(true);
				listCombo.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Suministradores");
		mnAdmin.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Registrar");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarSuminstrador regSumi=new AgregarSuminstrador();
				regSumi.setModal(true);
				regSumi.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listar");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerSuministradores listSumi=new VerSuministradores();
				listSumi.setModal(true);
				listSumi.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Editar");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarSuminstrador ModiSumi=new ModificarSuminstrador(null);
				ModiSumi.setModal(true);
				ModiSumi.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_20);
		
		JMenu mnNewMenu_3 = new JMenu("Ordenes de Compra");
		mnAdmin.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Hacer Pedido");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AgregarCompra regOrden=new AgregarCompra(null);
			regOrden.setModal(true);
			regOrden.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Listar");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCompra listOrdenCompra=new ListarCompra();
				listOrdenCompra.setModal(true);
				listOrdenCompra.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Otorgar Cr\u00E9dito");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcesoCredito credito=new ProcesoCredito();
				credito.setModal(true);
				credito.setVisible(true);
			}
		});
		mnAdmin.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(12);
		panel.add(panel_1, BorderLayout.SOUTH);
	}

}

