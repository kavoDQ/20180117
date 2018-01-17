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

import forfun.good.a20180117.data.Student;
import forfun.good.a20180117.data.StudentscoreDAO;

public class MainActivity extends AppCompatActivity {
    final public static StudentscoreDAO dao = new StudentscoreDAO(); //APP每個地方都能用
    ListView lv;
    Intent it;

    public MainActivity() {
        it = new Intent(String.valueOf(( R.id.listView)));
        dao.getStudent(1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    @Override
    protected void onResume() {
        super.onResume();
        lv = findViewById(R.id.listView);
        ArrayList<String> studentNames = new ArrayList<>();
        for (Student s: dao.getList())
        {
            studentNames.add(s.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,studentNames);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this,DetailActivity.class);
                it.putExtra("id",dao.getList().get(position).id);
                startActivity(it);
            }
        });
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
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
