package Data;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Utils {

    protected final String PATH_TO_IMAGE = "src/main/resources/1980x1320ru.jpg";
    protected final String URL = "http://s2.fotokto.ru/photo/full/226/2262378.jpg";
    protected byte[] getFileContent() {
        byte[] byteArray = new byte[0];
        try {
            byteArray = FileUtils.readFileToByteArray(new File(PATH_TO_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }

}
