package com.gachon.app.course1_1.course1_1_2;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gachon.app.R;
import com.gachon.app.helper.ContentPageListener;
import com.gachon.app.helper.MainPagerAdapter;
import com.gachon.app.helper.MyViewPager;
import com.gachon.app.helper.PageHelper;
import com.gachon.app.helper.ViewFactoryCS;


/**
 * course 1-1 데이터 타입 / 변수 / 초기화
 * step 1 : 신발장을 통한 비유
 */
public class Course1_1_2Step2 extends Fragment {
    //항상 추가
    View root; // 부모 액티비티
    ViewFactoryCS viewFactory;

    //layout
    int size = 3;
    FrameLayout[] textCard = new FrameLayout[size];
    RelativeLayout[] cardCover = new RelativeLayout[size];

    int numCards = 2;
    //final ViewPager[] viewPagers = new ViewPager[numCards];
    MyViewPager[] viewPagers = new MyViewPager[numCards];
    MainPagerAdapter[] pagerAdapters = new MainPagerAdapter[numCards];
    int currentCardNum = 0;


    // Required empty public constructor
    public Course1_1_2Step2() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //항상 추가
        root = inflater.inflate(R.layout.fragment_g_step2, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //최상단 루트 레이아웃
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.fragment_g_step2);
        viewFactory = new ViewFactoryCS(layout);

//        viewFactory.addSpace(0.5f);

//        //카드 생성
//        for (int i = 0; i < size; i ++){
//            textCard[i] = viewFactory.createCard(1.0f, new int[]{0,0,0, PageHelper.defaultMargin});
//        }
//
//        //텍스트 생성
//        viewFactory.addSimpleText("변수의 초기화\n" +
//                "변수를 선언하면서 초기화를 할 수 있다.\n" +
//                "int num = 1;", 18, textCard[0]);
//
//        viewFactory.addSimpleText("변수 값 재할당\n" +
//                "처음에 할당했던 값을 바꿀 수 있다. 이 때, 다시 선언해주지 않아도 된다.\n" +
//                "int num = 1;\n" +
//                "num = 2;\n" +
//                "현재 num 에 들어있는 값은 2", 18, textCard[1]);
//
//        viewFactory.addSimpleText("데이터 타입과 변수\n" +
//                "변수를 생성할 때 선언한 데이터 타입과 값은 일치해야한다.\n" +
//                "정수형 변수 = 정수값, 실수형 변수 = 실수값, 문자형 변수 = 문자값\n" +
//                "<더 알아보기>", 18, textCard[2]);
//
//        ///inflate
//        LayoutInflater inflater = (LayoutInflater) root.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//
//        //카드 추가, 카드로 덮기
//        for (int i = 0; i < size; i++) {
//            //card 커버 로드
//            cardCover[i] = new RelativeLayout(getContext());
//            inflater.inflate(R.layout.cardcover, cardCover[i]);
//            //카드 눌렀을 때 카드 사라지기
//            textCard[i].setTag(i);
//            textCard[i].setOnClickListener(new onCardClicked());
//            //card 로 덮기
//            textCard[i].addView(cardCover[i]);
//        }

        //header text 설정
        viewFactory.createHeaderCard("변수의 초기화", new int[]{0, 0, 0, PageHelper.headerCardMargin});

        viewPagers[0] = new MyViewPager(getContext());
        viewPagers[0].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        pagerAdapters[0] = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,PageHelper.defaultMargin}, viewPagers[0]);

        Activity parentActivity = getActivity();
        viewFactory.addCardOnSlideCard("변수의 초기화", pagerAdapters[0], parentActivity);
        viewFactory.addCardOnSlideCard("처음에 할당했던 값을 바꿀 수 있다. 이 때, 다시 선언해주지 않아도 된다", pagerAdapters[0], parentActivity);
        viewFactory.addCardOnSlideCard("(예시) int num = 1;", pagerAdapters[0], parentActivity);
        viewFactory.addCardOnSlideCard(PageHelper.endingString, pagerAdapters[0], parentActivity);


        viewPagers[1] = new MyViewPager(getContext());
        viewPagers[1].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        pagerAdapters[1] = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,0}, viewPagers[1]);

        viewFactory.addCardOnSlideCard("변수 값 재할당", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard("한 번 할당한 값을 새로 할당할 수 있다", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard("(예시) int num = 1;\nnum = 2;", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard("이 때, num 에 저장되어있는 값은 2 이다", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard(PageHelper.endingString, pagerAdapters[1], parentActivity);


        //공간추가
        viewFactory.addSpace(0.5f);

        /* 페이지 넘어가는 버튼 */
        ImageButton goNext = (ImageButton) root.findViewById(R.id.goNext);
        ImageButton goPrev = (ImageButton) root.findViewById(R.id.goPrevious);
        goNext.setOnClickListener(new ContentPageListener(3, viewPagers, pagerAdapters, getActivity()));
        goPrev.setOnClickListener(new ContentPageListener(2, viewPagers, pagerAdapters, getActivity()));
    }
}
