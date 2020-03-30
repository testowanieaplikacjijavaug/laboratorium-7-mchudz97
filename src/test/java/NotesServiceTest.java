
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("When added 1 time")
    public void noteServiceAdd(){

        serviceImpl.add(Note.of("Ja", 5));
        assertThat(storageMock.getSize()).isEqualTo(1);

    }

    @Test
    @DisplayName("When added multiple times")
    void noteServiceAddMultipleTimes(){

        for(int i = 0; i<100; i++){

            serviceImpl.add(Note.of("Ja", 5));

        }

        assertThat(storageMock.getSize()).isEqualTo(100);

    }

    @Test
    @DisplayName("Checking clear method")
    void noteServiceClearTest(){

        serviceImpl.add( Note.of("ja", 3));
        serviceImpl.add( Note.of("Ja", 3));
        serviceImpl.clear();

        assertThat(storageMock.getSize()).isEqualTo(0);


    }
    @Test
    @DisplayName("Average test for same values")
    void noteServiceAverageTest1(){

        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));

        assertThat(serviceImpl.averageOf("K")).isEqualTo(3);

    }

    @Test
    @DisplayName("Average test for 2 different names")
    void noteServiceAverageTest2(){

        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("M", 5));

        assertThat(serviceImpl.averageOf("K")).isEqualTo(3);

    }

    @Test
    @DisplayName("Average test for different values")
    void noteServiceAverageTest3(){

        serviceImpl.add(Note.of("K", 3));
        serviceImpl.add(Note.of("K", 4));
        serviceImpl.add(Note.of("K", 5));
        serviceImpl.add(Note.of("K", 6));

        assertThat(serviceImpl.averageOf("K")).isEqualTo((float)18/4);

    }




}
