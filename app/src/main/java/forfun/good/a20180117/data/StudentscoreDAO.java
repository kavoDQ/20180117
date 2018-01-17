package forfun.good.a20180117.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class StudentscoreDAO {
    public ArrayList<Student> mlist;
    public StudentscoreDAO() {mlist = new ArrayList<>();}
    public boolean add(Student s){ //新增傳值是不是正確
        mlist.add(s);
        return true;
    }
    public ArrayList<Student> getList(){return mlist;}
    public Student getStudent(int id)
    {
        for (Student s : mlist)
        {
            if(s.id == id) //id是否對到
            {
                return s;
            }
        }return null; //沒有就回傳NULL
    }
    public boolean update(Student student)
    {
       for (Student t : mlist)
       {
           if (t.id == student.id)
           {
               t.name = student.name;
               t.score = student.score;
               return true;

           }
       }
       return  false;

    }
    public boolean delete(int id)
    {
        for (int i=0;i<mlist.size();i++)
        {
            if(mlist.get(i).id == id)
            {
                mlist.remove(i);
                return true;
            }
        }
        // mlist.remove(id); 如果直接寫是刪除該位置
        return true;
    }
}
