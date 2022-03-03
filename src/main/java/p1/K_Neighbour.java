package p1;

import java.util.List;

public class K_Neighbour {
    private TableWithLabels datos;

    public void train(TableWithLabels data){ // Lee los datos de un fichero y construye el modelo.
        datos = data;
    }

    public String estimate(List<Double> sample){
        int tam = datos.getColumAt(0).size();

        double distMin = -1;
        int min = -1;

        for(int i = 0; i < tam; i++){
            double dist = distancia(sample, i);
            if (distMin == -1 || dist < distMin){
                distMin = dist;
                min = i;
            }
        }

        RowWithLabel r = (RowWithLabel) datos.getRowAt(min);

        return r.getLabel();
    }

    private double distancia(List<Double> r1, int x){
        List<Double> r2 = datos.getRowAt(x).getData();

        double total = 0.0;

        for(int i = 0; i < r1.size(); i++){
            total += Math.pow(r1.get(i) - r2.get(i), 2);
        }

        return Math.sqrt(total);
    }
}
