package cn.djzhao.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.djzhao.annotation.BindView;
import cn.djzhao.annotation.MyAnno;
import cn.djzhao.annotation.R;
import cn.djzhao.utils.InjectUtils;

@MyAnno(value = "dj", id = 9)
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main)
    private TextView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.bindView(this);
        main.setText("djzhao");
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", "djzhao in extra");
                startActivity(intent);
            }
        });
    }
}
