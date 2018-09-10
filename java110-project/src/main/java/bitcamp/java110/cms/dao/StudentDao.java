package bitcamp.java110.cms.dao;



import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Student;

public class StudentDao {
    
    private List<Student> list = new ArrayList<>();

    public int insert(Student studnet) {
        for (Student item : list) {
            if(item.getEmail().equals(studnet.getEmail())) {
                return 0;
            }
        }
        list.add(studnet);
        return 1;
    }
    
    public List<Student> findAll() {
        return list;
        
    }
    
    public Student findByEmail(String email) {
        for (Student item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Student item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        } 
        return 0;
    }
}
