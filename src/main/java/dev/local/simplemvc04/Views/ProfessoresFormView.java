package dev.local.simplemvc04.Views;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dev.local.simplemvc04.Controllers.ListController;

/**
 * @author Andre Delorme
 *
 */
public class ProfessoresFormView {

	JFrame frame;
	boolean isEdit;

	public ProfessoresFormView(ListController controller, boolean isEdit, Object id) {
		this.isEdit = isEdit;
		// cria componentes de interface





		JTextField codeTextField = new JTextField(20);
		JTextField nameTextField = new JTextField(20);
		JTextField birthdateTextField = new JTextField(20);
		JTextField titleTextField = new JTextField(20);
		JTextField functionalTextField = new JTextField(20);

		JButton saveButton = new JButton("Salvar");
		JButton cancelButton = new JButton("Cancelar");

		// botão de todos: realiza chamada ao controller
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] newData = {
						codeTextField.getText(),
						nameTextField.getText(),
						birthdateTextField.getText(),
						titleTextField.getText(),
						functionalTextField.getText()
				};
				if (isEdit)
					controller.updateOne(newData[0], newData);
				else
					controller.insertOne(newData);

				frame.setVisible(false);
				frame.dispose();
			}
		});
		// botão de inserção: realiza chamada ao controller
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		// cria JPanel para organizar os componentes (layout)
		GridLayout formLayout = new GridLayout(0, 2);
		JPanel ctrlPane = new JPanel();
		ctrlPane.setLayout(formLayout);
		// adiciona os componentes ao JPanel

		ctrlPane.add(new Label("Codigo"));
		ctrlPane.add(codeTextField);
		ctrlPane.add(new Label("Nome"));
		ctrlPane.add(nameTextField);
		ctrlPane.add(new Label("Data Nasc."));
		ctrlPane.add(birthdateTextField);
		ctrlPane.add(new Label("Título"));
		ctrlPane.add(titleTextField);
		ctrlPane.add(new Label("Funcional"));
		ctrlPane.add(functionalTextField);
		ctrlPane.add(saveButton);
		ctrlPane.add(cancelButton);

	
		if (isEdit) {
	
			Object[] edit = controller.getById(id);
	
			codeTextField.setText(edit[0].toString());
			nameTextField.setText(edit[1].toString());
			birthdateTextField.setText(edit[2].toString());
			titleTextField.setText(edit[3].toString());
			functionalTextField.setText(edit[4].toString());
		}

		// cria um frame para receber o split pane
		frame = new JFrame(
				"Swing MVC Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ctrlPane);
		frame.pack();
		frame.setVisible(true);
	}

}
