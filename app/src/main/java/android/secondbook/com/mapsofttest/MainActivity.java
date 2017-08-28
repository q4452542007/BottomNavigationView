package android.secondbook.com.mapsofttest;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private int lastShowFragment = 0;
    private BookFragment mBookFragment;
    private GameFragment mGameFragment;
    private HomeFragment mHomeFragment;
    private MusicFragment mMusicFragment;
    private TvFragment mTvFragment;
    private ImageButton mPhotoButton;
    private ImageView mPhotoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        initFragments();
        mPhotoButton = (ImageButton) findViewById(R.id.take_photo);
        mPhotoView = (ImageView) findViewById(R.id.imageView);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        if (lastShowFragment != 0) {
                            switchFrament(lastShowFragment, 0);
                            lastShowFragment = 0;
                        }
                        return true;
                    case R.id.nav_book:
                        if (lastShowFragment != 1) {
                            switchFrament(lastShowFragment, 1);
                            lastShowFragment = 1;
                        }
                        return true;
                    case R.id.nav_music:
                        if (lastShowFragment != 2) {
                            switchFrament(lastShowFragment, 2);
                            lastShowFragment = 2;
                        }
                        return true;
                    case R.id.nav_tv:
                        if (lastShowFragment != 3) {
                            switchFrament(lastShowFragment, 3);
                            lastShowFragment = 3;
                        }
                        return true;
                    case R.id.nav_game:
                        if (lastShowFragment != 4) {
                            switchFrament(lastShowFragment, 4);
                            lastShowFragment = 4;
                        }
                        return true;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        return false;
    }
    public void switchFrament(int lastIndex, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastIndex]);
        if (!fragments[index].isAdded()) {
            transaction.add(R.id.fragment_layout, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

   /* private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_layout, HomeFragment.newInstance("公交总站"));
        transaction.commit();
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("Home"));
        fragments.add(BookFragment.newInstance("Books"));
        fragments.add(MusicFragment.newInstance("Music"));
        fragments.add(TvFragment.newInstance("Movies & TV"));
        fragments.add(GameFragment.newInstance("Games"));
        return fragments;
    }*/
    private void initFragments() {
        mHomeFragment = HomeFragment.newInstance("公交总站");
        mBookFragment = BookFragment.newInstance("Books");
        mMusicFragment = MusicFragment.newInstance("Music");
        mTvFragment = TvFragment.newInstance("Movies & TV");
        mGameFragment = GameFragment.newInstance("Games");
        fragments = new Fragment[]{mHomeFragment, mBookFragment, mMusicFragment, mTvFragment, mGameFragment};
        lastShowFragment = 0;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_layout, mHomeFragment)
                .show(mHomeFragment)
                .commit();
    }
}
