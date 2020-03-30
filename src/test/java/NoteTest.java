
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NoteTest {

    public Note note;



    @Test
    @DisplayName("when name is null")
    public void ofNoteTestNullString(){

        assertThatThrownBy(() -> { Note.of(null, 3); }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("Imię ucznia nie może być null");

    }
    @Test
    @DisplayName("when name is blank")
    public void ofNoteTestExceptionBlankString(){

        assertThatThrownBy(() -> { Note.of("", 3); }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("Imię ucznia nie może być puste");

    }

    @Test
    @DisplayName("when note value is out of range")
    public void ofNoteTestExceptionInvalidNote(){

        assertThatThrownBy(() -> { Note.of("a", 0); }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("Niewłaściwa ocena");

    }

    @Test
    @DisplayName("Simple name value getter test")
    public void getNameTest(){

        assertThat(Note.of("Hi", 3).getName()).isEqualTo("Hi");

    }

    @Test
    @DisplayName("Simple note value getter test")
    public void getNoteTest(){

        assertThat(Note.of("Hi", 3).getNote()).isEqualTo(3);

    }


}
