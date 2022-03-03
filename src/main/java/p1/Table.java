package p1;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> filas;

    public Table(List<String> cabecera){
        this.headers = cabecera;
        this.filas = new ArrayList<>();
    }

    public Row getRowAt(int fila){
        return this.filas.get(fila);
    }

    public List<Double> getColumAt(int col){

        List column = new ArrayList();
        for (Row s : this.filas){
            List fil = s.getData();
            column.add(fil.get(col));
        }
        return column;
    }

    public void addRow(Row r){
        filas.add(r);
    }

    public List<String> getHeaders(){
        return headers;
    }

    public List<Row> getRows(){
        return filas;
    }

    public int getRowsSize(){
        return filas.size();
    }
}
