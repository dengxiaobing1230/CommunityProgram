package com.deng.communityprogram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.deng.communityprogram.R;

public class MainActivity extends AppCompatActivity {

    private Button skip;
    private Button login;
    private Button register;
    private EditText edit_user;
    private EditText edit_password;
    private CheckBox remember_me;

    //是否记住账号和密码
    private boolean isRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        init();
        //跳过按钮
        skip.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ChatList.class);
            startActivity(intent);
            finish();
        });
        //登陆活动
        login.setOnClickListener(v->{

        });
        //注册活动
        register.setOnClickListener(v->{

        });

        remember_me.setOnCheckedChangeListener((buttonView, isChecked) -> isRemember=!isRemember);

    }
    //初始化组件
    private void init(){
        isRemember = false;
        skip = findViewById(R.id.skip);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        edit_user = findViewById(R.id.edit_user);
        edit_password = findViewById(R.id.edit_password);
        remember_me = findViewById(R.id.remember_me);
    }
    //获取当前输入框的用户名
    private String getUser(){
        return edit_user.getText().toString();
    }
    //获取当前输入框的密码
    private String getPassword(){
        return edit_password.getText().toString();
    }

    private boolean isRemember(){
        return isRemember;
    }
}
