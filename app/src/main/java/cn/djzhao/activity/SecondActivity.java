package cn.djzhao.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import cn.djzhao.annotation.Autowired;
import cn.djzhao.annotation.BindView;
import cn.djzhao.annotation.R;
import cn.djzhao.utils.InjectUtils;

public class SecondActivity extends AppCompatActivity {

    @Autowired()
    private String title;

    @BindView(R.id.main)
    private TextView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        InjectUtils.bindView(this);
        InjectUtils.autowired(this);
        main.setText(title);
    }
}