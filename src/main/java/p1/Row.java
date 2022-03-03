package p1;

import java.util.List;

public class Row {
    List<Double> data;

    public Row(List<Double> datos){
        this.data = datos;
    }

    public List<Double> getData(){
        return this.data;
    }
}
