package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccesoCliente = new JMenu("Cliente");
		menuBar.add(mnAccesoCliente);
		
		JMenu mnAdministrador = new JMenu("Admin");
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmSuministrador = new JMenuItem("Agregar Suministrador");
		mntmSuministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarSuminstrador agregarSuministrador = new AgregarSuminstrador();
				agregarSuministrador.setModal(true);
				agregarSuministrador.setVisible(true);
			}
		});
		mnAdministrador.add(mntmSuministrador);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ver Suministradores");
		mnAdministrador.add(mntmNewMenuItem);
		
		JMenuItem mntmHacerPedido = new JMenuItem("Hacer Pedido");
		mnAdministrador.add(mntmHacerPedido);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
