package pk.getsub.www.getsub.map;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pk.getsub.www.getsub.R;
import pk.getsub.www.getsub.history.AppDatabase;
import pk.getsub.www.getsub.history.MyAdapter;
import pk.getsub.www.getsub.history.UserHistory;

public class History extends AppCompatActivity {


    private static final String TAG = "HTAG";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private ArrayList<UserHistory> arrayList;

    String []myData = {"Hamza" , "Ali","Hamza" , "Ali","Hamza" , "Ali","Hamza" , "Ali","Hamza" , "Ali",
            "Hamza" , "Ali","Hamza" , "Ali","Hamza" , "Ali","Hamza" , "Ali","Hamza" , "Ali","Hamza" , "Ali"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        arrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(History.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(History.this , arrayList);
        recyclerView.setAdapter(adapter);



        Log.d(TAG, "onCreate: ");
        Log.d(TAG, "onCreate: ");
        Toast.makeText(this, "Tis is My Time", Toast.LENGTH_SHORT).show();


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name").build();


                UserHistory user1 = new UserHistory( 2, "Hamza2" , "Ayub2");
                db.userDao().insertAll(user1);




                List<UserHistory> myUser = db.userDao().getAll();

                for (int i = 0; i < db.userDao().getAll().size(); i++) {

                    UserHistory user = new UserHistory(myUser.get(i).getUid() ,myUser.get(i).getOrder(), myUser.get(i).getAddress() );
                    arrayList.add(user);
                    //   Log.d(TAG, "run: " + myUser.get(i).getFirstName()+" // " + myUser.get(i).getLastName());
                }

                Log.d(TAG, "run: " + arrayList.size());


                //  Log.d(TAG, "run: " + myUser.get(1).getFirstName()+" // " + myUser.get(1).getLastName());
/*
                Log.d(TAG, "onCreate: " + db.userDao().getAll());
                Log.d(TAG, "onCreate: " + db.userDao().getAll());

                int []a = {1};

                Log.d(TAG, "onCreate: " + db.userDao().loadAllByIds(a));*/

            }
        });

        t.start();

    }
}
