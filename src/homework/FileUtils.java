package homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;


public class FileUtils {
	
	public static String readFileAsString(String name) throws IOException {
           //ترد محتويات الملف  
		return new String (Files.readAllBytes(Paths.get(name)));
	}
	public static void appendStringToFile(String name, String line) throws IOException {
	//كتابة نص ضمن ملف
        //الأول اسم الملف
        // الثاني النص
            File file = new File(name);
		FileWriter fw = new FileWriter(file, true);
		fw.write(line + "\n");
		fw.close();
	}

}
