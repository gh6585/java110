package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Teacher;
@Component
public class TeacherDao {

    private List<Teacher> list = new ArrayList<>();

    public int insert(Teacher studnet) {
        for (Teacher item : list) {
            if(item.getEmail().equals(studnet.getEmail())) {
                return 0;
            }
        }
        list.add(studnet);
        return 1;
    }
    
    public List<Teacher> findAll() {
        return list;
        
    }
    
    public Teacher findByEmail(String email) {
        for (Teacher item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Teacher item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        } 
        return 0;
    }
}
