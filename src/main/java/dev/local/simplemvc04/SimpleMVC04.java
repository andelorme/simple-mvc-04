package dev.local.simplemvc04;

import javax.swing.SwingUtilities;

import dev.local.simplemvc04.Controllers.ListController;
import dev.local.simplemvc04.Models.DAOAlunos;
import dev.local.simplemvc04.Models.DAOProfessores;
import dev.local.simplemvc04.Views.AlunosListView;
import dev.local.simplemvc04.Views.ProfessoresListView;

/**
 *
 * @author andre
 */
public class SimpleMVC04 {

	public static void main(String[] args) {
		// realiza a chamada pela thread de eventos de interface
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					initGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void initGui() throws Exception {

		DAOAlunos daoAlunos = new DAOAlunos();
		DAOProfessores daoProfessores = new DAOProfessores();
		// Cria controller
		ListController alunosController = new ListController(daoAlunos);
		ListController profsController = new ListController(daoProfessores);
		// cria view associada ao controller
		new AlunosListView(alunosController);
		new ProfessoresListView(profsController);
		// solicita ao controller carregar todos os itens
		alunosController.fetchAll();
		profsController.fetchAll();
	}
}
