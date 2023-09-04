package dev.local.simplemvc04.Models;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;

public abstract class DAO extends DefaultTableModel {
    private Object[] fields;
    private ArrayList<Object> data;

    public DAO(Object[] fields, Object[][] data) {
        this.fields = fields;
        this.data = new ArrayList<Object>(Arrays.asList(data));
    }

    // retorna os campos (pra montagem da tabela, no caso)
    public Object[] getHeaders() {
        return fields;
    }

    // retorna todos os alunos
    public Object[][] getAll() {
        int idx = 0;
        Object[][] newData = new Object[this.data.size()][];
        for (Object o : this.data)
            newData[idx++] = (Object[]) o;
        return newData;
    }

    // retorna o aluno por id
    public Object[] getById(Object id) {
        Object found = null;
        for (Object o : this.data) {
            if (((Object[]) o)[0] == id) {
                found = o;
            }
        }
        return (Object[]) found;
    }

    // insere um elemento na lista
    public void insert(Object[] data) {
        this.data.add(data);
    }

    // deleta um elemento buscando pelo primeiro campo (id)
    public void update(Object id, Object data) {
        for (Object o : this.data) {
            if (((Object[]) o)[0].toString().equals(id)) {
                this.data.set(this.data.indexOf(o), data);
            }
        }

    }

    // deleta um elemento buscando pelo primeiro campo (id)
    public void delete(Object id) {
        Object found = null;
        for (Object o : this.data) {
            if (((Object[]) o)[0] == id) {
                found = o;
            }
        }
        data.remove(found);
    }

    // executa filtro no modelo
    public Object[][] filterData(String searchTerm) {
        int idx = 0;
        Object[][] newData = new Object[this.data.size()][];
        for (Object o : this.data) {
            if ("*".equals(searchTerm.trim())) {
                newData[idx++] = (Object[]) o;
            } else {
                if (String.valueOf(((Object[]) o)[0]).startsWith(searchTerm.toUpperCase().trim())) {
                    newData[idx++] = (Object[]) o;
                }
            }
        }
        return newData;
    }
}
