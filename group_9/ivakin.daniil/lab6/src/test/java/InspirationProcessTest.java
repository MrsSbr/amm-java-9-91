import Poetry.InspirationProcess;
import Poetry.Poet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InspirationProcessTest {

    @Test
    void startProcessWithNoPoets() {
        InspirationProcess insProc = new InspirationProcess(new ArrayList<>());

        List<String> resultPoem = insProc.beginInspitrationProcces();

        Assertions.assertTrue(resultPoem.isEmpty());
    }

    @Test
    void startProcessWithPoetsWithNoPoem() {
        InspirationProcess insProc = new InspirationProcess();

        insProc.addPoet(new Poet("EmptyPoet1"));
        insProc.addPoet(new Poet("EmptyPoet2"));
        insProc.addPoet(new Poet("EmptyPoet3"));

        List<String> resultPoem = insProc.beginInspitrationProcces();

        Assertions.assertTrue(resultPoem.isEmpty());
    }

    @Test
    void startProcessWithNoTissue() {
        InspirationProcess insProc = new InspirationProcess();

        insProc.addPoet(new Poet("EmptyPoet1", List.of("A", "A", "A")));
        insProc.addPoet(new Poet("EmptyPoet2", List.of("B", "B", "B")));
        insProc.addPoet(new Poet("EmptyPoet3", List.of("C", "C", "C")));

        insProc.setTissue(null);

        Assertions.assertThrows(NullPointerException.class, insProc::beginInspitrationProcces);
    }

    @Test
    void startProcessWithEmptyPoetAndOneNotEmpty() {
        InspirationProcess insProc = new InspirationProcess();

        Poet notEmptyPoet = new Poet("NotEmptyPoet1", List.of("A", "A", "A"));

        insProc.addPoet(new Poet("EmptyPoet1"));
        insProc.addPoet(notEmptyPoet);
        insProc.addPoet(new Poet("EmptyPoet2"));

        List<String> resultPoem = insProc.beginInspitrationProcces();
        List<String> notEmptyPoetPoem = notEmptyPoet.getPoem();

        Assertions.assertEquals(notEmptyPoetPoem, resultPoem);
    }

    @Test
    void startProcessWithPoetsWithDifferentLengthPoems() {
        InspirationProcess insProc = new InspirationProcess();

        Poet poet1 = new Poet("EmptyPoet1", List.of("A", "A"));
        Poet poet2 = new Poet("EmptyPoet2", List.of("B", "B", "B"));
        Poet poet3 = new Poet("EmptyPoet3", List.of("C", "C", "C", "C", "C", "C", "C", "C", "C"));


        insProc.addPoet(poet2);
        insProc.addPoet(poet1);
        insProc.addPoet(poet3);

        List<String> resultPoem = insProc.beginInspitrationProcces();

        List<String> poetPoems = poet1.getPoem();
        poetPoems.addAll(poet2.getPoem());
        poetPoems.addAll(poet3.getPoem());

        Assertions.assertEquals(poetPoems.size(), resultPoem.size());
        Assertions.assertTrue(poetPoems.containsAll(resultPoem) && resultPoem.containsAll(poetPoems));
    }

    @Test
    void startProcessWithPoetPassedMoreThanOnce() {
        InspirationProcess insProc = new InspirationProcess();

        Poet poet1 = new Poet("EmptyPoet1", List.of("A", "A"));

        insProc.addPoet(poet1);
        insProc.addPoet(poet1);

        Assertions.assertThrows(IllegalThreadStateException.class, insProc::beginInspitrationProcces);
    }
}
