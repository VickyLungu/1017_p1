package p1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void getData() {
        List<Double> l = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            l.add(Math.random()%10);
        }

        Row r = new Row(l);

        assertEquals(r.data, r.getData());
    }
}