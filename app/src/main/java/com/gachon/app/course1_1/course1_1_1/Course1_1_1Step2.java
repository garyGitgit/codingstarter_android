package com.gachon.app.course1_1.course1_1_1;


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

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
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
public class Course1_1_1Step2 extends Fragment {
    //항상 추가
    View root; // 부모 액티비티
    ViewFactoryCS viewFactory;

    //layout
    FrameLayout[] textCard = new FrameLayout[4];
    RelativeLayout[] cardCover = new RelativeLayout[4];
    int size = 4;
    int numCards = 3;
    MyViewPager[] viewPagers = new MyViewPager[numCards];
    //ViewPager[] viewPagers = new ViewPager[numCards];
    MainPagerAdapter[] pagerAdapters = new MainPagerAdapter[numCards];
    int currentCardNum = 0;

    // Required empty public constructor
    public Course1_1_1Step2() {}


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


        //header text 설정
        viewFactory.createHeaderCard("변수를 어떻게 사용할까?", new int[]{0, 0, 0, PageHelper.headerCardMargin});

        Activity parentActivity = getActivity();

        viewPagers[0] = new MyViewPager(getContext());
        viewPagers[0].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //MainPagerAdapter pagerAdapter = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,PageHelper.defaultMargin}, viewPager, slideCard_linear);
        pagerAdapters[0] = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,PageHelper.defaultMargin}, viewPagers[0]);
        viewFactory.addCardOnSlideCard("1. 변수의 타입을 정한다", pagerAdapters[0], parentActivity);
        viewFactory.addCardOnSlideCard("int : 정수형 (예. 1, 100, 478)", pagerAdapters[0], parentActivity);
        viewFactory.addCardOnSlideCard("float : 실수형 (예. 1.0, 100.1, 478.23)", pagerAdapters[0], parentActivity);
        viewFactory.addCardOnSlideCard("char : 문자형 (예. '1', 'a', 'K', '-')", pagerAdapters[0], parentActivity);
        viewFactory.addCardOnSlideCard(PageHelper.endingString, pagerAdapters[0], parentActivity);
//

        viewPagers[1] = new MyViewPager(getContext());
        viewPagers[1].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        pagerAdapters[1] = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,PageHelper.defaultMargin}, viewPagers[1]);

        viewFactory.addCardOnSlideCard("2. 변수 이름을 정한다", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard("변수 이름을 지을 때는 몇 가지 규칙이 있다.", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard("(1) 영어 알파벳 대소문자 또는 대소문자+숫자", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard("(2) 첫 글자는 반드시 알파벳 대소문자", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard("(3) 특수문자는 '_' 만 가능(이 특수문자는 첫 글자로도 쓸 수 있다)", pagerAdapters[1], parentActivity);
        viewFactory.addCardOnSlideCard(PageHelper.endingString, pagerAdapters[1], parentActivity);


        viewPagers[2] = new MyViewPager(getContext());
        viewPagers[2].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        pagerAdapters[2] = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,PageHelper.defaultMargin}, viewPagers[2]);

        viewFactory.addCardOnSlideCard("3. 세미콜론(;)", pagerAdapters[2], parentActivity);
        viewFactory.addCardOnSlideCard("세미콜론(;)은 프로그램 한 줄의 끝을 의미한다.", pagerAdapters[2], parentActivity);
        viewFactory.addCardOnSlideCard("세미콜론이 없으면 에러가 난다.", pagerAdapters[2], parentActivity);
        viewFactory.addCardOnSlideCard(PageHelper.endingString, pagerAdapters[2], parentActivity);


//        //space 추가
        viewFactory.addSpace(0.5f);
        ImageButton goNext = (ImageButton)root.findViewById(R.id.goNext);
        ImageButton goPrev= (ImageButton)root.findViewById(R.id.goPrevious);

        goNext.setOnClickListener(new ContentPageListener(3, viewPagers, pagerAdapters, getActivity()));
        goPrev.setOnClickListener(new ContentPageListener(2, viewPagers, pagerAdapters, getActivity()));
        //image button

//        goNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int thisPage = viewPagers[currentCardNum].getCurrentItem();
//                //pageradapter 를 동해서 page 의 갯수를 가져온다
//                int pageNum = pagerAdapters[currentCardNum].getCount();
//                if (thisPage < pageNum-1) {
//                    viewPagers[currentCardNum].setCurrentItem(++thisPage);
//                }
//                else{
//
//                    //만약에 마지막 카드라면 다음 페이지로 넘어감
//                    if(currentCardNum == numCards-1){
//                        Toast.makeText(getActivity().getApplicationContext(), "next", Toast.LENGTH_SHORT).show();
//                        ViewFactoryCS.onGoNext onGoNext = (ViewFactoryCS.onGoNext)getActivity();
//                        onGoNext.onPressNext();
//                    }
//                    //그렇지 않으면 다음 카드로 넘어감
//                    else currentCardNum++;
//                }
//
//            }
//        });
//
//        goPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int thisPage = viewPagers[currentCardNum].getCurrentItem();
//
//                if (thisPage == 0) {
//                    //가장 첫번째 카드면 go previous
//                    if(currentCardNum == 0){
//                        ViewFactoryCS.onGoPrevious onGoPrev= (ViewFactoryCS.onGoPrevious)getActivity();
//                        onGoPrev.onPressPrev();
//                    }
//                    //아니면 이전 카드로 이동
//                    else{
//                        currentCardNum--;
//                    }
//                }
//                //0 페이지 이상일 떄는 하나씩 페이지를 뒤로 돌리고
//                else{
//                    viewPagers[currentCardNum].setCurrentItem(--thisPage);
//                }
//
//            }
//        });

//
//        //카드 추가, 카드로 덮기
//        for(int i = 0 ; i < size; i++){
//            //card 커버 로드
//            cardCover[i] = new RelativeLayout(getContext());
//            inflater.inflate(R.layout.cardcover, cardCover[i]);
//            //카드 눌렀을 때 카드 사라지기
//            textCard[i].setTag(i);
//            textCard[i].setOnClickListener(new onCardClicked());
//            //card 로 덮기
//            textCard[i].addView(cardCover[i]);
//        }

    }



    @Override
    public void onPause() {
        super.onPause();
        //화면이 넘어갔을 떄 카드들을 모두 처음으로 초기화시켜준다
        for(int i = 0; i < numCards; i++ ){
            viewPagers[i].setCurrentItem(0);
        }
        //현재 카드를 초기화 시킨다
        currentCardNum = 0;
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    class onCardClicked implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int tag = ((Integer)v.getTag());
            switch (tag){
                case 0:
                    YoYo.with(Techniques.FadeOut).duration(PageHelper.cardOpenDelay).playOn(cardCover[0]);
                    break;
                case 1:
                    YoYo.with(Techniques.FadeOut).duration(PageHelper.cardOpenDelay).playOn(cardCover[1]);
                    break;
                case 2:
                    YoYo.with(Techniques.FadeOut).duration(PageHelper.cardOpenDelay).playOn(cardCover[2]);
                    break;
                case 3:
                    YoYo.with(Techniques.FadeOut).duration(PageHelper.cardOpenDelay).playOn(cardCover[3]);
                    break;
            }
        }
    }
}
