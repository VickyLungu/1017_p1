package p1;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        CSV c = new CSV();
        Table t1 = c.readTable("miles_dollars.csv");
        System.out.println(t1.getHeaders());
        for(int i = 0; i < t1.getRowsSize();i++){
            Row fila = t1.getRowAt(i);
            System.out.println("getData() de t1");
            System.out.println(fila.getData());
        }

        System.out.println("getColumAt(1) de t1");
        System.out.println(t1.getColumAt(1));

        TableWithLabels t2 = c.readTableWithLabels("iris.csv");
        System.out.println("headers de t2");
        System.out.println(t2.getHeaders());

        System.out.println("filas de t2");
        System.out.println(t2.getRows());

        System.out.println("getRows() de t2");
        System.out.println(t2.getRows());

        System.out.println("El tam de filas de t2 es: " + t2.getRowsSize());
        for(int i = 0; i<t2.getRowsSize();i++){
            RowWithLabel fila = (RowWithLabel) t2.getRowAt(i);
            System.out.println("getData() de t2");
            System.out.println(fila.getData());
            System.out.println("getLabel() de t2");
            System.out.println(fila.getLabel());
        }


        System.out.println("getColumAt(1) de t2");
        System.out.println(t2.getColumAt(0));


        LinealRegresion l = new LinealRegresion();

        l.train(t1);

        K_Neighbour kn = new K_Neighbour();

        kn.train(t2);

        List<Double> l2 = Arrays.asList(5.1, 3.5, 1.35, 0.2);

        String label = kn.estimate(l2);

        System.out.println(label);
    }
}
