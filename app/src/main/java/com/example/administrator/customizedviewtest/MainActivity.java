package com.example.administrator.customizedviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.administrator.customizedviewtest.Utils.AnimationUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;
    private ImageButton home;
    private ImageButton menu;
    boolean isLevel3Display=true;
    boolean isLevel2Display=true;
    boolean isLevel1Display=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level1=(RelativeLayout)findViewById(R.id.level1);
        level2=(RelativeLayout)findViewById(R.id.level2);
        level3=(RelativeLayout)findViewById(R.id.level3);
        home=(ImageButton)findViewById(R.id.home);
        menu=(ImageButton)findViewById(R.id.menu);

        menu.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_MENU){
            if(isLevel1Display){
                if(isLevel2Display){
                    if(isLevel3Display){
                        AnimationUtil.rotateOutAnim(level3,0);
                        isLevel3Display=false;
                    }
                    AnimationUtil.rotateOutAnim(level2,0);
                    isLevel2Display=false;
                }
                AnimationUtil.rotateOutAnim(level1,0);
                isLevel3Display=false;
            }else{
                AnimationUtil.rotateInAnim(level1);
                AnimationUtil.rotateInAnim(level2);
                AnimationUtil.rotateInAnim(level3);
            }
        }

        return  true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.menu):
                if(isLevel3Display){
                    AnimationUtil.rotateOutAnim(level3,0);
                    isLevel3Display=false;
                }else {
                    AnimationUtil.rotateInAnim(level3);
                    isLevel3Display=true;
                }
                break;
            case(R.id.home):
                long delay=0;
                if(isLevel2Display){
                    if(isLevel3Display){
                        AnimationUtil.rotateOutAnim(level3,0);
                        delay=200;
                        isLevel3Display=false;
                    }
                    AnimationUtil.rotateOutAnim(level2,delay);
                    isLevel2Display=false;
                }else {
                    AnimationUtil.rotateInAnim(level2);
                    isLevel2Display=true;
                }
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
