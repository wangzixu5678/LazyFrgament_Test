package administrator.example.com.lazyfrgament_test;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment{


    private String mKey;
    public TestFragment(String key){
        mKey = key;
    }

    public static TestFragment getNewInstance(String key){
        TestFragment testFragment = new TestFragment(key);
        return testFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initView() {
        TextView textView = (TextView) getRootView().findViewById(R.id.fragment_text);
        textView.setText(mKey);
    }

    @Override
    protected void lazyLoad() {
        if(isPrepared&&isVisible) {
            Toast.makeText(getActivity(), ""+mKey, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_test;
    }

    @Override
    protected String getFragmengTitle() {
        return mKey;
    }


}
