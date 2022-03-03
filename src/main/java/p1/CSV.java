package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CSV {
    public Table readTable(String fichero) throws IOException {

        final String div = ",";
        BufferedReader br = null;
        Table t = null;

        try {
            br = new BufferedReader(new FileReader(fichero));
            String line = br.readLine();

            if (line != null) {
                List<String> l = createHeader(line, div);
                t = new Table(l);

                addRows(t, br, div);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return t;
    }


    //----------------------------------------------------------------------------------
    public TableWithLabels readTableWithLabels(String fichero) throws IOException {

        final String div = ",";
        BufferedReader br = null;
        TableWithLabels t = null;

        try {
            br = new BufferedReader(new FileReader(fichero));
            String line = br.readLine();

            if (line != null) {
                List<String> l = createHeader(line, div);

                t = new TableWithLabels(l);
                addRowsWL(t, br, div);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return t;
    }

    //------------------------------------------------------------------------------------------------
    private List<String> createHeader(String line, String div) throws IOException {

        String[] campos = line.split(div);
        List<String> l = new LinkedList<>();
        l.addAll(Arrays.asList(campos));

        return l;
    }

    //------------------------------------------------------------------------------------------------
    private void addRows(Table t, BufferedReader br, String div) throws IOException {

        String line = br.readLine();

        while (line != null) {
            String[] campos = line.split(div);

            Row r = auxAR(campos, false);

            t.addRow(r);

            line = br.readLine();
        }
    }

    private void addRowsWL(TableWithLabels t, BufferedReader br, String div) throws IOException {

        String line = br.readLine();

        while (line != null) {

            String[] campos = line.split(div);

            Row r = auxAR(campos, true);

            String etiqueta = campos[campos.length - 1];

            RowWithLabel r2 = new RowWithLabel(r, etiqueta);

            t.addRow(r2);

            line = br.readLine();
        }
    }

    private Row auxAR(String[] campos, boolean withLabel) throws IOException {

        List<Double> datos = new LinkedList<>();

        int fin;

        if (withLabel){
            fin = campos.length -1;
        }else{
            fin = campos.length;
        }

        for (int i = 0; i < fin; i++) {
            datos.add(parseDouble(campos[i]));
        }

        Row r = new Row(datos);

        return r;
    }
}