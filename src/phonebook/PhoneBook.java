package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    List<Record> list;
    PhoneBook(){
        this.list = new ArrayList<Record>();
    }
    void add(Record record){
        list.add(record);
    }

    Record find (String name){
        for (Record record:list) {
            if(record.name.equals(name)){
                return record;
            }
        }
        return null;
    }
    List<Record> findAll(String name){
        List<Record> result = new ArrayList<Record>();
        for (Record record:list) {
            if(record.name.equals(name)){
                result.add(record);
            }
        }
        return result.size()>0?result:null;
    }

}
