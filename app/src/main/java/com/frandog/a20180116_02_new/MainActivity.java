package com.frandog.a20180116_02_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
//    流程:
//    登入firebase > d9 開新專案 > 點擊上方tool/firebase
//    > 點realtime database > Connect your app to firebase
//    > add the realtime database to your app > 到firebase網點右上的"轉到控制台"
//    > 網站上點擊專案 > 點左方database > 點"開始使用" > 規則都改true(讓任何人都能讀寫資料庫)

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message20180116");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView tv = (TextView) findViewById(R.id.textView);
                String value = dataSnapshot.getValue(String.class);
                tv.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void click1(View v)
    {
//        將firebase視窗的第4步內容貼上，移到最外層
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message20180116");     //寫入key

        myRef.setValue("Hello, FRANK!!!!");       //寫入value
    }
}
