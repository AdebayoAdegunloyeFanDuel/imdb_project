import config_mgr.ConfigMgr;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ImdbRecordScanner {
    public static final Logger logger = LogManager.getLogger(ImdbRecordScanner.class);
    private final ImdbFileReader imdbFileReader = new ImdbFileReader();

    public List<String[]> generateIMDBRawData(){
        List<String[]> imdbRawData = new ArrayList<>();
        Scanner scanner = new Scanner(imdbFileReader.imdbFileReader(ConfigMgr.imdbFileLocation()));
        scanner.nextLine();
        while(scanner.hasNext()){
            String[] movieItem = scanner.nextLine().split(",");
            for (String item: movieItem){
                if(item.isEmpty()){
                    logger.debug(Arrays.toString(movieItem));
                    break;
                } else {
                    imdbRawData.add(movieItem);
                }
            }
        }
        return imdbRawData;
    }

    public static void main(String[] args) {
        ImdbRecordScanner imdbRecordScanner = new ImdbRecordScanner();
        imdbRecordScanner.generateIMDBRawData();
    }
}
