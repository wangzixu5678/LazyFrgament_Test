package administrator.example.com.lazyfrgament_test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/12.
 */

public abstract class BaseFragment extends Fragment{

   protected boolean isPrepared;
   protected boolean isVisible;
   private View rootView;

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
      isPrepared = true;
      lazyLoad();
      rootView =  inflater.inflate(getLayout(), container, false);
      initView();
      return rootView;

   }
   protected View getRootView(){
      return rootView;
   }
   protected abstract void initView();

   /**
    * 在这里实现Fragment数据的缓加载.
    * @param isVisibleToUser
    */
   @Override
   public void setUserVisibleHint(boolean isVisibleToUser) {
      super.setUserVisibleHint(isVisibleToUser);
      if(getUserVisibleHint()) {
         isVisible = true;
         onVisible();
      } else {
         isVisible = false;
         onInvisible();
      }
   }

   protected void onVisible(){
      lazyLoad();
   }

   protected abstract void lazyLoad();
   protected abstract int getLayout();
   protected void onInvisible(){}


   protected abstract String getFragmengTitle();
}
