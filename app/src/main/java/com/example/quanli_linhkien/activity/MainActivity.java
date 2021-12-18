package com.example.quanli_linhkien.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewFlipper;

import com.example.quanli_linhkien.R;
import com.example.quanli_linhkien.fragment.FavoriteFragment;
import com.example.quanli_linhkien.fragment.HistoryFragment;
import com.example.quanli_linhkien.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

   private DrawerLayout mdrawerLayout;
   private NavigationView navigationView;
   private Toolbar toolbar;
   ViewFlipper viewFlipper;
   private ViewPager2 mViewPager2;
   private BottomNavigationView mBottomNavigationView;
   private MyViewPager2Adapter mMyViewPager2Adapter;




   private  static final int FRAMGENT_HOME = 0;
    private  static final int FRAMGENT_FAVORITE = 1;
    private  static final int FRAMGENT_HISTORY = 2;

    private int  mCurrentFramgent = FRAMGENT_HOME;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper)findViewById(R.id.viewflipper);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);


        mBottomNavigationView = findViewById(R.id.bottom_navigation);


         toolbar = findViewById(R.id.toolbarmanhinhchinh);
        mdrawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);
        mViewPager2 = findViewById(R.id.view_pages_2);
        mMyViewPager2Adapter = new MyViewPager2Adapter(this);
        mViewPager2.setAdapter(mMyViewPager2Adapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdrawerLayout.openDrawer(GravityCompat.START);
            }
        });
       // replaceFramgent(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setCheckable(true);
        mBottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.bottom_home){
                        openHomeFragemt();
                       // navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                }else  if(id == R.id.bottom_favorite){
                        openFavoriteFragemt();
                    //navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                }else  if(id == R.id.bottom_history){
                        openHistoryFragemt();
                  //  navigationView.getMenu().findItem(R.id.nav_history).setChecked(true);
                }
                return true;
            }
        });
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mCurrentFramgent =FRAMGENT_HOME;
                        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);
                        break;
                    case 1:
                        mCurrentFramgent =FRAMGENT_FAVORITE;
                        navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_favorite).setChecked(true);
                        break;
                    case 2:
                        mCurrentFramgent =FRAMGENT_HISTORY;
                        navigationView.getMenu().findItem(R.id.nav_history).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_history).setChecked(true);
                        break;

                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
           openHomeFragemt();
          // mBottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);
    }else if(id == R.id.nav_favorite){
           openFavoriteFragemt();
           // mBottomNavigationView.getMenu().findItem(R.id.bottom_favorite).setChecked(true);
    }else if(id == R.id.nav_history){
                openHistoryFragemt();
           // mBottomNavigationView.getMenu().findItem(R.id.bottom_history).setChecked(true);

    }

        mdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
        private void openHomeFragemt(){
            if(mCurrentFramgent != FRAMGENT_HOME){
               // replaceFramgent(new HomeFragment());
                mViewPager2.setCurrentItem(0);
                mCurrentFramgent = FRAMGENT_HOME;
            }
        }
        private void openFavoriteFragemt(){
            if(mCurrentFramgent != FRAMGENT_FAVORITE){
               // replaceFramgent(new FavoriteFragment());
                mViewPager2.setCurrentItem(1);
                mCurrentFramgent = FRAMGENT_FAVORITE;
            }
        }
        private void openHistoryFragemt(){
            if(mCurrentFramgent != FRAMGENT_HISTORY){
               // replaceFramgent(new HistoryFragment());
                mViewPager2.setCurrentItem(2);
                mCurrentFramgent = FRAMGENT_HISTORY;
            }
        }
    @Override
    public void onBackPressed() {
        if(mdrawerLayout.isDrawerOpen((GravityCompat.START))){
            mdrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
//    private void replaceFramgent(Fragment fragment){
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.content_frame,fragment);
//        transaction.commit();
//    }
}











