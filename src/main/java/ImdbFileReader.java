import java.io.FileNotFoundException;
import java.io.FileReader;

public class ImdbFileReader {

    public FileReader imdbFileReader(String imdbFileLocation){
        try {
            return new FileReader(imdbFileLocation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
