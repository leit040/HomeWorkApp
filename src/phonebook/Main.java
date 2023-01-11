package phonebook;



import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add(new Record("Ivanov", "34343434"));
        pb.add(new Record("Ivanov", "234567"));
        pb.add(new Record("Ivanov", "454647"));
        pb.add(new Record("Ivanov", "27272727"));
        pb.add(new Record("Petrov", "2525252"));
        pb.add(new Record("Sidorov", "123123123"));
        printRecords(pb.list);

        printRecords(pb.findAll("Ivanov"));


    }


    static void printRecords(List<Record> list) {
        for (Record rc : list) {
            System.out.println("----------------------------------");
            System.out.printf("\tname: %s\n", rc.name);
            System.out.printf("\tphone: %s\n", rc.phoneNumber);
            System.out.println("----------------------------------");
        }
    }


}