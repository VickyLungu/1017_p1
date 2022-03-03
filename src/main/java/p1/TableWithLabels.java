package p1;

import java.util.ArrayList;
import java.util.List;

public class TableWithLabels extends Table{
    private List<RowWithLabel> filas;

    public TableWithLabels(List<String> cabecera) {
          super(cabecera);

        this.filas = new ArrayList<>();
    }


}
