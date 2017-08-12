package administrator.example.com.lazyfrgament_test;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        ArrayList<TestFragment> fragments = new ArrayList<>();
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < 5; i++) {
            fragments.add(TestFragment.getNewInstance("页面"+String.valueOf(i)));
        }
        adapter.notifyDataSetChanged();
    }


    class MyPagerAdapter extends FragmentPagerAdapter{
        private List<TestFragment> mFragments;
        public MyPagerAdapter(FragmentManager fm,List<TestFragment> fragments) {
            super(fm);
            mFragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments==null?0:mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getFragmengTitle();
        }
    }




}
