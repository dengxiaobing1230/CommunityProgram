package com.deng.communityprogram.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deng.communityprogram.R;
import com.deng.communityprogram.adapter.ChatAdapter;
import com.deng.communityprogram.widget.Messages;

import java.util.ArrayList;


public class ChatList extends AppCompatActivity {

    //private Toolbar toolbar;
    private RecyclerView message_list;
    private EditText edit_message;
    private Button send;
    private ImageButton back;
    private Button information;
    private Button setting;

    //跳转到设置和主菜单界面的intent
    private Intent back_main_menu;
    private Intent into_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_lsit);
        init();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        message_list.setLayoutManager(layoutManager);
        ArrayList<Messages> messagesList = new ArrayList<>();
        {
            messagesList.add(new Messages("我（舔狗版）", "多喝热水，吨吨吨", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "：，，，，，", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "天冷了，多喝开水", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("女神（舔狗版）", "你和他还不是好友", "2020-05-31", Messages.TYPE_OTHER));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花1", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花2", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花3", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花4", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花5", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花6", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花7", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "BGM:希望之花8", "2020-05-31", Messages.TYPE_MINE));
            messagesList.add(new Messages("我（舔狗版）", "长歌行：汉乐府" + "\n" + "青青园中葵，朝露待日晞。", "2020-05-31", Messages.TYPE_MINE));
        }
        ChatAdapter chatAdapter = new ChatAdapter(messagesList);
        message_list.setAdapter(chatAdapter);

        send.setOnClickListener(v->{});
        information.setOnClickListener(v->{});
        //进入设置界面
        setting.setOnClickListener(v->{
            startActivity(into_setting);
        });
        //退回主界面
        back.setOnClickListener(v->{
            startActivity(back_main_menu);
            finish();
        });
        //两个不同的适配器
        //MessageListAdapter otherMessageListAdapter=new MessageListAdapter(this,R.layout.message_list_item_1,messagesList);
        //MessageListAdapter myMessageListAdapter=new MessageListAdapter(this,R.layout.message_list_item_2,messagesList);
        //两个不同的适配器
        //MessageListAdapter otherMessageListAdapter=new MessageListAdapter(this,R.layout.message_list_item_1,messagesList);
        //MessageListAdapter myMessageListAdapter=new MessageListAdapter(this,R.layout.message_list_item_2,messagesList);
        //2020-06-04
        //列表消息适配器
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myTest);
        //listView.setAdapter(myMessageListAdapter);
        //listView.setAdapter(otherMessageListAdapter);
        //listView.setAdapter(arrayAdapter);

    }

    private void init(){
        //toolbar = findViewById(R.id.chat_toolbar);
        message_list = findViewById(R.id.message_list);
        edit_message = findViewById(R.id.edit_message);
        send = findViewById(R.id.send_message);
        back = findViewById(R.id.chat_back);
        information = findViewById(R.id.information);
        setting = findViewById(R.id.setting);

        back_main_menu.setClass(this,MainMenu.class);
        into_setting.setClass(this,Setting.class);
    }
    //获取输入框的文本
    private String getMessage(){

        return edit_message.getText().toString();
    }
}
