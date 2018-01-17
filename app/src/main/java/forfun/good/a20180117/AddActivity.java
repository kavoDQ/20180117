package forfun.good.a20180117;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import forfun.good.a20180117.data.Student;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void CL1(View view)
    {
        EditText ed1 = findViewById(R.id.editText);
        EditText ed2 = findViewById(R.id.editText2);
        EditText ed3 = findViewById(R.id.editText3);

        int id = Integer.valueOf(ed1.getText().toString());
        String name = ed2.getText().toString();
        int score = Integer.valueOf(ed3.getText().toString());
        MainActivity.dao.add(new Student(id, name, score));
        finish();

    }
    public void CL2(View view)
    {

    }
    public void CL3(View View)
    {
        Intent intent = new Intent();
        intent.setClass(AddActivity.this, MainActivity.class);
        startActivity(intent);
        AddActivity.this.finish();
    }
}
