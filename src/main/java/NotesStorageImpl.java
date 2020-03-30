import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.List;

public class NotesStorageImpl implements NotesStorage {


    private Multimap <String, Note> notes = ArrayListMultimap.create();


    @Override
    public void add(Note note) {

        notes.put(note.getName(), note);

    }

    @Override
    public List<Note> getAllNotesOf(String name) {

        return (List<Note>) notes.get(name);

    }

    @Override
    public void clear() {

        notes.clear();

    }
}