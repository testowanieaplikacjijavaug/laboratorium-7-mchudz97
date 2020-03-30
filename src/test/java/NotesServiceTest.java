import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.print.resources.serviceui;

import static org.assertj.core.api.Assertions.*;


public class NotesServiceTest {

    NotesStorageMock storageMock;
    NotesServiceImpl serviceImpl;


    @BeforeEach
    private void setup(){

        storageMock = new NotesStorageMock();
        serviceImpl = NotesServiceImpl.createWith(storageMock);

    }

    @Test
    public void noteServiceAdd(){

        serviceImpl.add(Note.of("Ja", 5));
        assertThat(storageMock.getSize()).isEqualTo(1);

    }

    @Test
    void noteServiceAddMultipleTimes(){

        for(int i = 0; i<100; i++){

            serviceImpl.add(Note.of("Ja", 5));

        }

        assertThat(storageMock.getSize()).isEqualTo(100);

    }

    @Test
    void noteServiceClearTest(){

        serviceImpl.add( Note.of("ja", 3));
        serviceImpl.add( Note.of("Ja", 3));
        serviceImpl.clear();

        assertThat(storageMock.getSize()).isEqualTo(0);


    }
    @Test
    void noteServiceAverageTest1(){

        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));

        assertThat(serviceImpl.averageOf("K")).isEqualTo(3);

    }

    @Test
    void noteServiceAverageTest2(){

        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("M", 5));

        assertThat(serviceImpl.averageOf("K")).isEqualTo(3);

    }

    @Test
    void noteServiceAverageTest3(){

        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 4));
        serviceImpl.add(Note.of("K", 5));
        serviceImpl.add(Note.of("K", 6));

        assertThat(serviceImpl.averageOf("K")).isEqualTo((float)18/4);

    }



}
