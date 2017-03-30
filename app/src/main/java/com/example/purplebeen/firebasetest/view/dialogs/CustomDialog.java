package com.example.purplebeen.firebasetest.view.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.purplebeen.firebasetest.R;
import com.example.purplebeen.firebasetest.models.Auth;
import com.example.purplebeen.firebasetest.models.FriendsData;
import com.example.purplebeen.firebasetest.models.TimeLineData;
import com.example.purplebeen.firebasetest.view.TabLayoutActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by verak on 2017-02-22.
 */

public class CustomDialog extends Dialog {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
    //    getWindow().setAttributes(lpWindow);

        setContentView(R.layout.customdialog);

        setLayout();

        timeline_send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(timeline_edit.getText().toString().equals("")))
                {
                    long now = System.currentTimeMillis();
                    Date date = new Date(now);
                    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String formatDate = sdfNow.format(date);
                 //   String timeLine_uuid=UUIDBuilder.getUUID();
                    FriendsData.getInstance().getmDatabase().child("timeline").push()
                            .setValue(new TimeLineData(Auth.getSingleAuth().userName, timeline_edit.getText().toString(),formatDate, 0, 0, 0));
                    CustomDialog.this.dismiss();
                }

            }
        });

        timeline_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.this.dismiss();
            }
        });

        timeline_back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.this.dismiss();
            }
        });
    }
    public CustomDialog(Context context) {
        // Dialog 배경을 투명 처리 해준다.
        super(context , android.R.style.Theme_Translucent_NoTitleBar);
    }


    private EditText timeline_edit;
    private Button timeline_send_btn;
    private Button timeline_back_btn;
    private ImageButton timeline_upload_btn;
    private ImageButton timeline_back_btn2;


    private void setLayout(){
        timeline_edit = (EditText)findViewById(R.id.timeline_edit);
        timeline_send_btn = (Button)findViewById(R.id.timeline_send_btn);
        timeline_back_btn = (Button)findViewById(R.id.timeline_back_btn);
        timeline_upload_btn = (ImageButton)findViewById(R.id.timeline_upload_btn);
        timeline_back_btn2= (ImageButton)findViewById(R.id.timeline_back_btn2);
    }

}