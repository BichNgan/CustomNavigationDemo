package android.customnavigationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_nav);
        frameFragment=(FrameLayout)findViewById(R.id.frameFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId())
                {
                    case R.id.nav_shop:actionBar.setTitle("Shop");
                        loadFragment(new FragShop());
                        return true;
                    case R.id.nav_gift:actionBar.setTitle("Gift");
                        loadFragment(new FragGift());
                    return true;
                    case R.id.nav_cart:actionBar.setTitle("Cart");return true;
                    case R.id.nav_profile:actionBar.setTitle("Profile");return true;
                }
                return false;
            }
        });
        actionBar.setTitle("Shop");
    }
public  void loadFragment(androidx.fragment.app.Fragment fragment)
{
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft= fm.beginTransaction();
    ft.replace(R.id.frameFragment,fragment);
    ft.commit();
}
}