package forfun.good.a20180117.data;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import forfun.good.a20180117.MainActivity;

/**
 * Created by Student on 2018/1/17.
 */

public class StudentsCloudDAO implements StudentDAO{

    public ArrayList<Student> mlist;
    Context context;
    FirebaseDatabase database;
    DatabaseReference myRef;
    public StudentsCloudDAO(final Context context)
    {
        this.context = context;
        mlist = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("scores");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                mlist = gson.fromJson(value,new TypeToken<ArrayList<Student>>(){}.getType());
                if (mlist == null)
                {
                    mlist = new ArrayList<>(); //當陣列為空的時候新建一個陣列
                }
                ((MainActivity) context).refreshData();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public boolean add(Student s){ //新增傳值是不是正確
        if (mlist == null)
        {
            mlist = new ArrayList<>();
        }
        mlist.add(s);
        saveFile();
        return true;
    }

    private void saveFile() {
        Gson gson = new Gson();
        String data = gson.toJson(mlist);
        myRef.setValue(data);

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
        return false;
    }
//    public Student getsum (int score)
//    {
//
//        mlist.get()
//    }
}
