package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Componente;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;

public class ModSuministro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private Componente componente = null;
	private JTextField tF_Id;
	private JTextField tF_Marca;
	private JSpinner spnr_Precio;
	private JSpinner spnr_CantidadMinima;
	private JSpinner spnr_CantidadMaxima;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModSuministro dialog = new ModSuministro(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModSuministro(Componente selected) {
		componente = selected;
		
		setBounds(100, 100, 432, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 400, 156);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		JLabel label = new JLabel("Id componente:");
		label.setBounds(10, 10, 91, 14);
		panel.add(label);
		
		tF_Id = new JTextField();
		tF_Id.setText("-1");
		tF_Id.setEditable(false);
		tF_Id.setColumns(10);
		tF_Id.setBounds(10, 30, 184, 20);
		panel.add(tF_Id);
		
		JLabel label_1 = new JLabel("Marca:");
		label_1.setBounds(210, 10, 64, 14);
		panel.add(label_1);
		
		tF_Marca = new JTextField();
		tF_Marca.setColumns(10);
		tF_Marca.setBounds(210, 30, 184, 20);
		panel.add(tF_Marca);
		
		JLabel label_2 = new JLabel("Precio:");
		label_2.setBounds(10, 65, 64, 14);
		panel.add(label_2);
		
		spnr_Precio = new JSpinner();
		spnr_Precio.setBounds(10, 85, 184, 20);
		panel.add(spnr_Precio);
		
		JLabel label_3 = new JLabel("Cantidad Minima:");
		label_3.setBounds(210, 65, 105, 14);
		panel.add(label_3);
		
		spnr_CantidadMinima = new JSpinner();
		spnr_CantidadMinima.setBounds(210, 85, 80, 20);
		panel.add(spnr_CantidadMinima);
		
		JLabel label_4 = new JLabel("Cantidad Maxima:");
		label_4.setBounds(305, 65, 105, 14);
		panel.add(label_4);
		
		spnr_CantidadMaxima = new JSpinner();
		spnr_CantidadMaxima.setBounds(305, 85, 64, 20);
		panel.add(spnr_CantidadMaxima);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarInfoSumi();
	}
	
	private void cargarInfoSumi() {
		
		tF_Id.setText(componente.getId().toString());
		tF_Marca.setText(componente.getMarca());
		spnr_CantidadMaxima.setValue(componente.getCantMax());
		spnr_CantidadMinima.setValue(componente.getCantMin());
		spnr_Precio.setValue(componente.getPrecio());
	}
}
