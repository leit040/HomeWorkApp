package Logger;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("HW8");
        FileLoggerConfiguration flc = FileLoggerConfigurationLoader.load("/home/leit/JavaLearn/HomeWorkApp/src/Logger/config");
        FileLogger logger = new FileLogger(flc);

        logger.log("DEBUG","TEst string 1");
        logger.log("INFO","TEst string 2");
        logger.log("INFO","TEst string 3");
        logger.log("DEBUG","TEst string 4");

    }


}