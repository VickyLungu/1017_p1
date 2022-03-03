package p1;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RowWithLabelTest {

    @Test
    void getLabel() {
        List<Double> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(Math.random() % 10);
        }
        String label = "I am a testing label";
        RowWithLabel r = new RowWithLabel(l, label);
        assertEquals(r.label, r.getLabel());
    }
}