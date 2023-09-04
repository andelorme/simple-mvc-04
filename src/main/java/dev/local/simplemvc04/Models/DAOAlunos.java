package dev.local.simplemvc04.Models;

/**
 * @author Andre Delorme
 * 
 */
public class DAOAlunos extends DAO {

	// campos do modelo
	static Object[] FIELDS = { "NF", "Nome", "Sobrenome",
			"Curso", "Semestre" };

	// lista de alunos (modelos)
	static Object[][] DATA = {
			{ 5730735, "José", "Silva", "ADS", 4 },
			{ 5743313, "Maria", "Pereira", "PSICO", 2 },
			{ 7813423, "Sandra", "Rodrigues", "ADS", 4 },
			{ 3385166, "Márcio", "Fonseca", "VET", 4 },
			{ 455591, "João", "Santos", "ADS", 2 },
			{ 5555353, "Rodrigo", "Oliveira", "PSICO", 1 },
			{ 893125, "José", "Souza", "ADS", 1 },
			{ 2824896, "Arthur", "Pereira", "PSICO", 4 },
			{ 5093026, "Dalva", "Alvas", "ADS", 2 },
			{ 6301789, "Paulo", "Santos", "VET", 3 }
	};

	public DAOAlunos() {
		super(FIELDS, DATA);
	}

}
