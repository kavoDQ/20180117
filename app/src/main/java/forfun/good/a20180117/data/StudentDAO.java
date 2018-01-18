package forfun.good.a20180117.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */
// 存在的目的是為了要規範下面所有DAO輸入資料都要符合這個格式

public interface StudentDAO {
    public boolean add(Student s);
    public ArrayList<Student> getList();
    public Student getStudent(int id);
    public boolean update(Student s);
    public boolean delete(int id);
}
