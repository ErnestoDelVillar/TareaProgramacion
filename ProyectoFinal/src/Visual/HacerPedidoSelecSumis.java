package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HacerPedidoSelecSumis extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HacerPedidoSelecSumis dialog = new HacerPedidoSelecSumis();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HacerPedidoSelecSumis() {
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
				textField = new JTextField();
				textField.setText((String) null);
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBounds(10, 36, 127, 20);
				panel.add(textField);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(161, 11, 64, 14);
				panel.add(label);
			}
			{
				textField_1 = new JTextField((String) null);
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				textField_1.setBounds(161, 36, 127, 20);
				panel.add(textField_1);
			}
			{
				JLabel label = new JLabel("Pais:");
				label.setBounds(313, 11, 64, 14);
				panel.add(label);
			}
			{
				textField_2 = new JTextField((String) null);
				textField_2.setEditable(false);
				textField_2.setColumns(10);
				textField_2.setBounds(312, 36, 127, 20);
				panel.add(textField_2);
			}
		}
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
	}

}
