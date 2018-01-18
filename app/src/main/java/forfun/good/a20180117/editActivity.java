package forfun.good.a20180117;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import forfun.good.a20180117.data.Student;

public class editActivity extends AppCompatActivity {
    TextView tv3;
    EditText ed5, ed6 ;
    int id;
    Student s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id = getIntent().getIntExtra("id",0);//抓前一頁傳來的
        s = MainActivity.dao.getStudent(id); //抓DAO的指令
        ed5 =findViewById(R.id.editText4);
        ed6 =findViewById(R.id.editText5);
        tv3 =findViewById(R.id.textView4);

        tv3.setText(String.valueOf(s.id));
        ed5.setText(s.name); //重設名子
        ed6.setText(String.valueOf(s.score)); //分數


    }

    @Override
    protected void onResume() {  //馬上重抓資料
        super.onResume();

    }

    public void clback(View v)
    {
        finish();
    }

    public void cledit(View v)
    {
        Student s = new Student(id,ed5.getText().toString(), Integer.valueOf(ed6.getText().toString()));
        MainActivity.dao.update(s); //全更新
        finish();
    }
}
