package p1;

import java.util.List;

public class LinealRegresion {
    private Double alfa;
    private Double beta;

    public void train(Table data) throws Exception { // Los datos se proporcionan en una p1.Table.
        List<Double> x = data.getColumAt(0);
        List<Double> y = data.getColumAt(1);

        alfa = numerador(x, y)/semiVarianza(x);

        beta = mediaArit(y) - (alfa * mediaArit(x));

        //System.out.println("Alfa es: " + alfa + " y beta es: " + beta);
    }

    public Double estimate(Double sample){ // Devuelve una estimación para el «sample»
        double y = (alfa * sample) + beta;
        return y;
    }


    private double numerador(List<Double> vectX, List<Double> vectY) throws Exception {
        if (vectX == null || vectY == null) {
            throw new NullPointerException("Lista nula, no tiene media");
        } else {
            double tam = vectX.size();
            if (tam == 0.0) {
                throw new Exception("Lista vacia, no tiene media");
            } else {
                double total = 0.0;
                double mediaX = mediaArit(vectX);
                double mediaY = mediaArit(vectY);


                for(int i = 0; i < vectX.size(); i++) {
                    double datoX = vectX.get(i);
                    double datoY = vectY.get(i);
                    total += ((datoX - mediaX) * (datoY - mediaY));
                    //System.out.println("EL total ahora mismo es: "+total );
                }
                //System.out.println("el numerador es: "+total);
                return total;
            }
        }
    }


    private double mediaArit(List<Double> vect) throws Exception {
        if (vect == null) {
            throw new NullPointerException("Lista nula, no tiene media");
        } else {
            double tam = vect.size();
            if (tam == 0.0) {
                throw new Exception("Lista vacia, no tiene media");
            } else {
                double total = 0.0;

                for(int i = 0; i < vect.size(); ++i) {
                    double dato = vect.get(i);
                    total += dato;
                }
                return total / tam;
            }
        }
    }

    private double semiVarianza(List<Double> vect) throws Exception {
        double media = this.mediaArit(vect);
        double tam = vect.size();
        double total = 0.0;

        for(int i = 0; i < vect.size(); i++) {
            double dato = vect.get(i);
            total += Math.pow(dato - media, 2);
        }

        return total;
    }
}
