package dev.local.simplemvc04.Models;

/**
 * @author Andre Delorme
 * 
 */
public class DAOProfessores extends DAO {

    // campos do modelo
    static Object[] FIELDS = { "Codigo", "Nome", "Data Nasc.",
            "Título", "Funcional" };

    // lista de alunos (modelos)
    static Object[][] DATA = {
            { 5730735, "José", "10/02/80", "Mestre", "82333279" },
            { 5743313, "Maria", "10/03/82", "Doutor", "3243183749" },
            { 7813423, "Sandra", "12/01/81", "Mestre", "5683749" },
            { 3385166, "Márcio", "15/12/82", "Mestre", "518341749" },
            { 455591, "João", "09/02/84", "Doutor", "128334749" },
            { 5555353, "Rodrigo", "08/10/80", "Doutor", "813574769" },
            { 893125, "José", "12/02/82", "Mestre", "128337449" },
            { 2824896, "Arthur", "30/05/84", "Mestre", "68837549" },
            { 5093026, "Dalva", "01/07/80", "Doutor", "182337449" },
            { 6301789, "Paulo", "21/09/85", "Mestre", "181327549" }
    };

    public DAOProfessores() {
        super(FIELDS, DATA);
    }
}