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

public class DemoNavLab8 extends AppCompatActivity {
    ActionBar actionBar;
    FrameLayout frameFragNav;
    BottomNavigationView bottNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_nav_lab8);
        actionBar=getSupportActionBar();

        addControl();
        addEvent();

    }
    public void addControl()
    {
        frameFragNav = (FrameLayout) findViewById(R.id.frameFragNav);
        bottNav = (BottomNavigationView) findViewById(R.id.bottNav);
    }
    public  void addEvent()
    {
        bottNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.item_btt_nav_shop:
                        actionBar.setTitle("Shop");
                        loadFragment(new FragShop1());
                        return true;
                    case R.id.item_btt_nav_gift:
                        actionBar.setTitle("Gift");
                        loadFragment(new FragGift1());
                        return true;

                }
                return false;
            }
        });
    }

    void loadFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameFragNav,fragment);
        ft.commit();
    }
}