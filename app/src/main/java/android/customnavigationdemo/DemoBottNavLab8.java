package android.customnavigationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DemoBottNavLab8 extends AppCompatActivity {
    ActionBar actionBar;
    FrameLayout frameFragment3;
    BottomNavigationView bttnav3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_bott_nav_lab8);
        actionBar=getSupportActionBar();


        frameFragment3=(FrameLayout) findViewById(R.id.frameFragment3);
        bttnav3 = (BottomNavigationView) findViewById(R.id.bttnav3);

        bttnav3.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.item_btt_nav_shop3) {
                    actionBar.setTitle("Shop");
                    loadFragment(new FragShop3());
                    return true;
                }
                else if (id==R.id.item_btt_nav_gift3) {
                    actionBar.setTitle("Gift");
                    loadFragment(new FragGift3());
                    return true;
                }

                return false;
            }
        });

    }

    public void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameFragment3,fragment);
        ft.commit();
    }
}