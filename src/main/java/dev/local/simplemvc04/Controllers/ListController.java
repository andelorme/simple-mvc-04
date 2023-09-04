package dev.local.simplemvc04.Controllers;

import javax.swing.table.DefaultTableModel;

import dev.local.simplemvc04.Models.DAO;

/**
 * @author Andre Delorme
 *
 */
public class ListController {
	// associa classe de modelo
	private DAO model;

    public ListController(DAO model) {
        this.model = model;
    }
	// filtra lista
	public void filterData(String searchTerm) {
		if (searchTerm != null && !"".equals(searchTerm)) {
			Object[][] newData = model.filterData(searchTerm);
			model.setDataVector(newData, model.getHeaders());
		}
	}

	// carrega todos os alunos na lista
	public void fetchAll() {
		Object[][] newData = model.getAll();
		model.setDataVector(newData, model.getHeaders());
	}

	// insere um modelo
	public void insertOne(Object[] newData) {
		model.insert(newData);
		fetchAll();
	}

	// retorna o modelo (para a view, no caso)
	public DefaultTableModel getModel() {
		return model;
	}

	// apaga um modelo
	public void deleteOne(Object id) {
		model.delete(id);
		fetchAll();
	}

	//atualiza um modelo
	public void updateOne(Object id, Object[] data) {
		model.update(id, data);
		fetchAll();
	}

		//atualiza um modelo
		public Object[] getById(Object id) {
			return model.getById(id);
		}
}
