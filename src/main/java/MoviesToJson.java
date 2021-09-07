import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


public class MoviesToJson {
    private ImdbRecordScanner imdbRecordScanner = new ImdbRecordScanner();

    public Map<Integer, Movie> generateMovieJson(){
        Map<Integer, Movie> movieMap = new HashMap<>();

        for (String[] movie: imdbRecordScanner.generateIMDBRawData()){
            Movie rawMovie = new Movie(movie);

            movieMap.put(rawMovie.getId(), rawMovie);
        }
        return movieMap;
    }
    public static void main(String[] args) throws IOException {
        File input = new File("imdbRecordScanner.imdbRawData");
        File output = new File("movies.json");

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        // Read Data from imdb csv file
        List<String> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValue(input);
        ObjectMapper mapper = new ObjectMapper();

        // Write Json formatted data
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
    }
}
