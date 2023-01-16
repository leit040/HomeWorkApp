package fileNavigator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("HW14");
        FileNavigator root = new FileNavigator("root",null);
        root.addSubCatalog("root/test");
        root.addSubCatalog("root/test/test1");
        root.addSubCatalog("root/test/test1111");
        root.addSubCatalog("root/test/test1222");
        root.addSubCatalog("root/test/test1333");
        root.addSubCatalog("root/test/test1/test2");
        root.addSubCatalog("root/test/test1/test2/test3");
        root.addSubCatalog("root/test/test1/test2/test3/test11");
        root.addSubCatalog("root/test/test1/test2/test3/test112");
        root.addSubCatalog("root/test/test1/test2/test3/test113");
        root.addSubCatalog("root/test/test1/test2/test3/test114");
        root.addSubCatalog("root/test/test1/test2/test3/test115");
        root.addSubCatalog("root/test/test1/test2/test3/test116");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12/test13");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12/test13/test111");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12/test13/test111/test222");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12/test13/test111/test222/test333");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12/test13/test111/test222/test333/test4");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12/test13/test111/test222/test333/test4/test5");
        root.addSubCatalog("root/test/test1/test2/test3/test11/test12/test13/test111/test222/test333/test4/test23");

        String[] path = {"test", "test1", "test2", "test3", "test11", "test12", "test13", "test111", "test222", "test333", "test4", "test5"};
        String[] ext = {".jpg", ".txt", ".pdf", ".exe",".csv",".doc",".xls","json",".sh",".png",".log"};
        String pathName = "root";

        Random random = new Random();
        for (int i = 0; i < 300; i++) {
            //path
            int pathCount = random.nextInt(1, 11);

            for (int j = 0; j < pathCount; j++) {
                pathName = pathName.concat("/" + path[j]);
            }
            //name
            String fileName = path[random.nextInt(0, 11)].concat(String.valueOf(random.nextInt(1,255))).concat(ext[random.nextInt(0, 10)]);
            //filesize
            int fileSize = random.nextInt(10, 500);
            root.add(new FileData(fileName,fileSize,pathName));
            pathName = "root";
           }

        //before remove
        root.sortBySize().forEach((key,value)->System.out.printf("%s -> %s\n",key,value.path+":"+value.name));
        root.remove("root/test/test1");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //after remove
        root.sortBySize().forEach((key,value)->System.out.printf("%s -> %s\n",key,value.path+":"+value.name));


    }
}