package com.example.garden;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeFragment homeFragment;
    private StoreFragment storeFragment;
    private FeedFragment feedFragment;
    private FragmentUploaded fragmentUploaded;
    private GPSFragment gpsFragment;
    private MyPageFragment myPageFragment;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private Context context = this;
    private View navheader;
    private FrameLayout contentFL;
    Boolean isUploaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        isUploaded = intent.getBooleanExtra("isUploaded", false);
        getHashKey();
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_store:
                        setFrag(1);
                        break;
                    case R.id.action_feed:
                        setFrag(2);
                        break;
                    case R.id.action_gps:
                        setFrag(3);
                        break;
                    case R.id.action_myPage:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        homeFragment = new HomeFragment();
        storeFragment = new StoreFragment();
        feedFragment = new FeedFragment();
        gpsFragment = new GPSFragment();
        myPageFragment = new MyPageFragment();
        fragmentUploaded = new FragmentUploaded();

        if (isUploaded == true) {
            setFrag(2);
            bottomNavigationView.setSelectedItemId(R.id.action_feed);
        }
        else {
            setFrag(0);
        }


        // 로그인 된 상태가 아니라면
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startMyActivity(SimpleLoginActivity.class);
        } else {
            //refreshToken();
        }
    }

    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    private void refreshToken(){
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("Token", "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        // store to db
                        FirebaseAuth mAuth=FirebaseAuth.getInstance();
                        String email=mAuth.getCurrentUser().getEmail();
                        String key = email.split("@")[0];

                        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference tokenRef=rootRef.child("Tokens").child(key);
                        tokenRef.child("token").setValue(token);
                        tokenRef.child("key").setValue(key);
                    }
                });
    }

    private void startMyActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame, homeFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, storeFragment);
                ft.commit();
                break;
            case 2:
                if (isUploaded == true) {
                    ft.replace(R.id.main_frame, fragmentUploaded); // 업로드된 프레그먼
                }
                else {
                    ft.replace(R.id.main_frame, feedFragment);
                }
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, gpsFragment);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, myPageFragment);
                ft.commit();
                break;
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
