package com.coconutlab.app.course2_1.course2_1_1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.coconutlab.app.R;
import com.coconutlab.app.helper.ViewFactoryCS;


/**
 * A simple {@link Fragment} subclass.
 */
public class Course2_1_1Step3 extends Fragment {

    View root;
    ViewFactoryCS viewFactory;

    public Course2_1_1Step3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_g_step3, container, false);
        return root;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //최상단 루트 레이아웃
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.fragment_g_step3);
        viewFactory = new ViewFactoryCS(layout);

//        //문제 카드
//        LinearLayout questionCard = viewFactory.createCard(0.0f, Color.WHITE, false, new int[]{0,0,0, PageHelper.defaultMargin});
//        viewFactory.addSimpleText("Q. 다음 연산의 예상되는 결과 값은?", 20, questionCard);
//
//        //문제 입력 카드
//        TableLayout answerCard = viewFactory.createTableCard(1.0f, Color.WHITE, new int[]{0,0,0,10});
//
//        //문제 추가
//        View[] rowViews;
//
//        rowViews = new View[]{
//                viewFactory.createWidget("TextView", new String[]{"12  *  4  =  "}),
//                viewFactory.createWidget("EditText", new String[]{"답을 입력하세요"})
//        };
//        viewFactory.addRow(rowViews, answerCard);
//
//        rowViews = new View[]{
//                viewFactory.createWidget("TextView", new String[]{"10  /  3  =  "}),
//                viewFactory.createWidget("EditText", new String[]{"답을 입력하세요"})
//        };
//        viewFactory.addRow(rowViews , answerCard);
//
//        rowViews  = new View[]{
//                viewFactory.createWidget("TextView", new String[]{"7  %  2  =  "}),
//                viewFactory.createWidget("EditText", new String[]{"답을 입력하세요"})
//        };
//        viewFactory.addRow(rowViews , answerCard);
//
//        rowViews  = new View[]{
//                viewFactory.createWidget("TextView", new String[]{"1  ==  1  =  "}),
//                viewFactory.createWidget("EditText", new String[]{"true 또는 false"})
//        };
//        viewFactory.addRow(rowViews , answerCard);
//
//        rowViews  = new View[]{
//                viewFactory.createWidget("TextView", new String[]{"(num  =  1)  =  "}),
//                viewFactory.createWidget("EditText", new String[]{"true 또는 false"})
//        };
//        viewFactory.addRow(rowViews , answerCard);
//
//        //사용자 입력 블록 카드
//        TableLayout tableCard = viewFactory.createTableCard(0.0f, Color.WHITE, new int[]{0,0,0,PageHelper.defaultMargin});
//
//        //테이블카드를 꽉 채우도록 함
//        tableCard.setStretchAllColumns(true);
//
//        //새로고침, 제출하기 버튼 추가
//        Button buttonRefresh = (Button) viewFactory.createWidget("Button", new String[]{""});
//        buttonRefresh.setBackground(getResources().getDrawable(android.R.drawable.ic_menu_delete));
//        Button buttonSubmit = (Button) viewFactory.createWidget("Button", new String[]{""});
//        buttonRefresh.setBackground(getResources().getDrawable(android.R.drawable.ic_media_play));
//        View[] buttons= new View[]{ buttonRefresh, buttonSubmit};
//        viewFactory.addRow(buttons, tableCard);
//
//        //새로고침 버튼 누르면 editText 모두 제거
//        buttonRefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        //제출하기를 누르면 editText 에 있는 값들이 resultCard 에 보여짐
//        buttonSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });



    }
}
