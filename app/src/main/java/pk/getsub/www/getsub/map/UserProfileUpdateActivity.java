package pk.getsub.www.getsub.map;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import pk.getsub.www.getsub.R;
import pk.getsub.www.getsub.UserSharPrefer;

public class UserProfileUpdateActivity extends AppCompatActivity {


    private static final String TAG = "HTAG";
    private ImageView imgProfile;
    private EditText editName;
    private EditText editPhone;
    private EditText editAddress;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_update);

        imgProfile = findViewById(R.id.img_user_profile_update_detail);
        editName = findViewById(R.id.edit_name_user_profile_update_activity);
        editPhone = findViewById(R.id.edit_phone_user_profile_update_activity);
        editAddress = findViewById(R.id.edit_address_user_profile_update_activity);

        UserSharPrefer storeUser = new UserSharPrefer(this);
        editName.setText(storeUser.getName());
        editPhone.setText(storeUser.getUserPhone());
        editAddress.setText(storeUser.getUserAddress());




        // cz "myImgPath" is not store in UserProfileAcitivity
        SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        String ss = sp.getString("myImgPath", "mNull");
        loadImageFromStorage(ss);

    }

    // method for show image from internal storage
    private void loadImageFromStorage(String path) {

        try {
            File f = new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            imgProfile.setImageBitmap(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "loadImageFromStorage: " + e.toString());
        }

    }
}

