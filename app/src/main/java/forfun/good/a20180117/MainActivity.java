package forfun.good.a20180117;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import forfun.good.a20180117.data.DBtype;
import forfun.good.a20180117.data.Student;
import forfun.good.a20180117.data.StudentDAO;
import forfun.good.a20180117.data.studentDAOFactory;
import forfun.good.a20180117.data.StudentFileDAO;
import forfun.good.a20180117.data.StudentscoreDAO;

public class MainActivity extends AppCompatActivity {
    //final public static StudentscoreDAO dao = new StudentscoreDAO(); //APP每個地方都能用
    public static StudentDAO dao; //從檔案抓資料
    ListView lv;
    DBtype dbtype;
    ArrayList<String> studentNames;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbtype = DBtype.CLOUD;
        dao = studentDAOFactory.getDAOInstance(this, dbtype);
        studentNames = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, studentNames);
        lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id", dao.getList().get(position).id);
                startActivity(it);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        refreshData();


    }

    public  void refreshData()
    {
        studentNames.clear();
        for(Student s: dao.getList())
        {
            studentNames.add(s.name);
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);  //創造出顯示Menu鍵
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_Add)
        {
            Intent it = new Intent(MainActivity.this,AddActivity.class);
            startActivity(it); //跳頁
        }
        return super.onOptionsItemSelected(item);
    }
}
