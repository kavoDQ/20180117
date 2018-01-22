package forfun.good.a20180117.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/22.
 */

public class StudentDAODBImpl implements StudentDAO {
    Context context;
    SQLiteDatabase db;
    public StudentDAODBImpl(Context context)
    {
        this.context = context;
        MyDBHelper helper = new MyDBHelper(context);
        db = helper.getWritableDatabase();
    }
    @Override
    public boolean add(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("_id",s.id);
        cv.put("name",s.name);
        cv.put("score",s.score);
        db.insert("students",null,cv); //把上面資料寫入
        return true;
    }

    @Override
    public ArrayList<Student> getList() {
        ArrayList<Student> mlist = new ArrayList<>();
        Cursor c = db.query("students",new String[]{"_id","name","score"},null,null,null,null,null);
        if (c.moveToFirst())
        {
            Student s1 = new Student(c.getInt(0),c.getString(1),c.getInt(2)); //()指的是欄位
            mlist.add(s1);
            while (c.moveToFirst())
            {
                Student s = new Student(c.getInt(0),c.getString(1),c.getInt(2));
                mlist.add(s);
            }
        }

        return mlist;
    }

    @Override
    public Student getStudent(int id) {
        Cursor c = db.query("students",new String[]{"_id","name","score"},"_id=?", new String[]{String.valueOf(id)},null, null, null);
        if (c.moveToFirst())
        {
            Student s1 = new Student(c.getInt(0), c.getString(1), c.getInt(2));
            return s1;
        }
        return null;
    }


    @Override
    public boolean update(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("name", s.name);
        cv.put("score", s.score);
        db.update("students", cv, "_id=?", new String[] {String.valueOf(s.id)});
        return true;
    }

    @Override
    public boolean delete(int id) {
        db.delete("students", "_id=?", new String[] {String.valueOf(id)});
        return true;
    }
}
