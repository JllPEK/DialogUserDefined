package com.example.jlljia.dialoguserdefined;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jlljia.dialoguserdefined.Layout.ClickableLinearLayout;
import com.example.jlljia.dialoguserdefined.dialog.MyDialog;
import com.example.jlljia.dialoguserdefined.dialog.MyDialog2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnShowDialog;
    private Button mBtnShowDialog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        mBtnShowDialog.setOnClickListener(this);
        mBtnShowDialog2 = (Button) findViewById(R.id.btn_show_dialog2);
        mBtnShowDialog2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mBtnShowDialog) {
            new MyDialog(this).show();
        } else if (v == mBtnShowDialog2) {
            new MyDialog2(this).show();
        }
    }
}
