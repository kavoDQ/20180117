package forfun.good.a20180117;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import forfun.good.a20180117.data.Student;

public class DetailActivity extends AppCompatActivity {
    Student s;
    TextView tv1,tv2,tv3;
    int id;
    boolean fastBack = false; //快速返回首頁
    @Override
    protected void onCreate(Bundle savedInstanceState) { //第一次開起就建立
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        id = getIntent().getIntExtra("id",0);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);


    }

    @Override
    protected void onResume() { //頁面馬上重抓資料
        super.onResume();
        if (fastBack)
        {
            finish();
        }
        s = MainActivity.dao.getStudent(id);
        tv1.setText(String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.score));

    }

    public void CL2 (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);//創一個刪除提醒
        builder.setTitle("刪除確認!!!");
        builder.setMessage("確定真的要刪除此筆資料???");
        builder.setPositiveButton("真的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.dao.delete(id); //執行前面設的delete student id 動作
                finish();
            }
        });
        builder.setNegativeButton("假的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void CL3 (View v)
    {
        finish();//直接回上一頁
    }

    public void CL4 (View v) //編輯
    {
        Intent it = new Intent(DetailActivity.this,editActivity.class);
        it.putExtra("id",id); //把ID帶入到下一頁
        fastBack = true;
        startActivity(it);

    }
}
