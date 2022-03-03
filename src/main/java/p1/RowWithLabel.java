package p1;

import java.util.List;
public class RowWithLabel extends Row{

    String label;

    public RowWithLabel(Row r, String label) {
        super(r.getData());
        this.label = label;
    }

    public RowWithLabel(List<Double> datos, String label) {
        super(datos);
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
