package com.gachon.app.course1_2.course1_2_1;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.gachon.app.R;
import com.gachon.app.helper.MyViewPager;
import com.gachon.app.helper.PageHelper;
import com.gachon.app.main.OnGoNextPageInterface;

public class Course1_2_1Activity extends AppCompatActivity implements OnGoNextPageInterface {
    MyViewPager viewPager;
    ImageView[] progressImageViewList;
    Button buttonGoNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_g_page_container);

        //progress 상태 표시
        progressImageViewList = new ImageView[5];
        progressImageViewList[0] = (ImageView)findViewById(R.id.course_progress0);
        progressImageViewList[1] = (ImageView)findViewById(R.id.course_progress1);
        progressImageViewList[2] = (ImageView)findViewById(R.id.course_progress2);
        progressImageViewList[3] = (ImageView)findViewById(R.id.course_progress3);
        progressImageViewList[4] = (ImageView)findViewById(R.id.course_progress4);

        //초기 시작은 첫번째 progress 이미지 초기화
        progressImageViewList[0].setImageDrawable(getResources().getDrawable(R.drawable.course_progress_check_blue));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (MyViewPager) findViewById(R.id.page_container);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);
        viewPager.setPagingEnabled(false);

        //gonext 버튼
        //buttonGoNext = (Button)findViewById(R.id.buttonGoNext1_1_2);
        buttonGoNext = (Button)findViewById(R.id.buttonGoNext);
        buttonGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPressGoNext();
            }
        });
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Course1_2_1Step0();
                case 1:
                    return new Course1_2_1Step1();
                case 2:
                    return new Course1_2_1Step2();
                case 3:
                    return new Course1_2_1Step3();
                case 4:
                    return new Course1_2_1Step4();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return PageHelper.courseStepNum;
        }
    }

    //프래그먼트에서 발생한 다음으로 가기 버튼 이벤트 처리
    @Override
    public void onPressGoNext() {
        int thisPage = viewPager.getCurrentItem();

        if (thisPage < PageHelper.courseStepNum-1) {
            Toast.makeText(Course1_2_1Activity.this, "성공!", Toast.LENGTH_SHORT).show();
            viewPager.setCurrentItem(++thisPage);
            //지금 페이지 번호에 맞게 progress 배경색을 색칠해준다. 추후에는 색깔을 칠하던가 색깔있는 아이콘을 쓰던가 해야지
            PageHelper.setProgressColor(progressImageViewList, thisPage, getApplicationContext());
        }
        else
            Toast.makeText(Course1_2_1Activity.this, "마지막 단계입니다", Toast.LENGTH_SHORT).show();

    }

    public void onProgressImageClickListener (View v){
        int id = v.getId();
        int index = 0;
        switch (id){
            case R.id.course_progress0:
                viewPager.setCurrentItem(0);
                index = 0;
                break;
            case R.id.course_progress1:
                viewPager.setCurrentItem(1);
                index = 1;
                break;
            case R.id.course_progress2:
                viewPager.setCurrentItem(2);
                index = 2;
                break;
            case R.id.course_progress3:
                viewPager.setCurrentItem(3);
                index = 3;
                break;
            case R.id.course_progress4:
                viewPager.setCurrentItem(4);
                index = 4;
                break;
        }
        PageHelper.setProgressColor(progressImageViewList, index, getApplicationContext());
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        int thisPage = viewPager.getCurrentItem();


        //TODO 처음이면 종료하시겠습니까 팝업을 띄운다. 지금은 종료
        if (thisPage == 0) {
            super.onBackPressed();
        }
        else
            viewPager.setCurrentItem(--thisPage);
        PageHelper.setProgressColor(progressImageViewList, thisPage, getApplicationContext());
    }


}