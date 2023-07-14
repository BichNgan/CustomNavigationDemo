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

public class DemoBottNavigation_02 extends AppCompatActivity {
    ActionBar actionBar;
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_bott_navigation02);
        actionBar = getSupportActionBar();




        frameLayout=(FrameLayout) findViewById(R.id.frame_layout_fragment);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottNav_02);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
//                switch (id)
//                {
//                    case R.id.shop2:
//                        return true;
//                    case R.id.gift2:
//                        return true;
//                    case R.id.cart2:
//                        return true;
//                    case R.id.profile2:
//                        return true;
//                }
                if(id==R.id.shop2)
                {
                    loadFragment(new ShopFrag_02());
                    actionBar.setTitle("Shop");
                    return true;
                } else if (id==R.id.gift2) {
                    loadFragment(new GiftFrag_02());
                    actionBar.setTitle("Gift");
                    return true;
                }
                return false;
            }
        });
    }
    public void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_fragment,fragment);
        fragmentTransaction.commit();
    }
}