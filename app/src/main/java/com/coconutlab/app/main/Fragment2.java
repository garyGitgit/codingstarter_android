package com.coconutlab.app.main;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.coconutlab.app.R;
import com.coconutlab.app.helper.GroupRankAdapter;
import com.coconutlab.app.helper.UserManager;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

/*
fragment2 : 2번째 페이지
 */
public class Fragment2 extends Fragment implements MainActivity.onFragmentMessageReceived {

    //String[] testList = {"a","b","c","d","e"};
    ArrayList<ParseObject> groupLists = new ArrayList<>();
    View root;
    Context rootContext;

    ArrayAdapter<Object> adapter;
    ListView listview;

    //상위랭킹 팀이름을 저장한다
    public static String[] top3 = new String[3];

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO : 시작할 때  progress bar 가 떠서 로딩중임을 알린다

        root = inflater.inflate(R.layout.fragment_fragment2, container, false);
        rootContext = root.getContext();

        adapter = new ArrayAdapter<>(rootContext, android.R.layout.simple_list_item_1, groupLists.toArray());

        listview = (ListView) root.findViewById(R.id.group_rank_list) ;


        //쿼리전송할 때, points 에 따라서 내림차순으로 정렬이 되게 query 를 보냄
        ParseQuery<ParseObject> orderedQeury = new ParseQuery<ParseObject>("Groups");
        orderedQeury.orderByDescending("points");
        //가져오는 갯수 제한 100에서 10000으로 확장
        orderedQeury.setLimit(UserManager.MAX_USER_LIMIT);
        //Parse 를 통해서 group들 가져오기
        ParseQuery<ParseObject> query = orderedQeury;
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> groups, ParseException e) {
                if(groups == null){
                    Toast.makeText(getContext(), "error : groups이 null", Toast.LENGTH_SHORT).show();
                    return;
                }
                //object 의 갯수를 계산한다
                //Log.e("gary", "number of objects : " + Integer.toString(groups.size()));

                //해당 class 의 모든 object 들에 대해서 토스트 메시지로 확인한다
                int rank = 1;
                int i = 0;
                for (ParseObject group : groups) {
                    if (e == null) {
                        //username 으로 밖에 못 가져온다 (getString 으로 하니까 안가져와짐)
                        Log.e("gary", "getString group name : " + group.get("name"));
                        Log.e("gary", "getString group point : " + group.getNumber("points"));
                        //상위 랭크 3개까지만 저장한다
                        if(i < 3)
                            top3[i++] = (String)group.get("name");
                        groupLists.add(group);
                    }
                }
                //TODO : 리스트 뷰를 모두 세팅하면 progress 를 종료한다
                //adapter 설정을 해준다
                GroupRankAdapter groupRankAdapter = new GroupRankAdapter(rootContext, R.layout.rank_row, groupLists);
                listview.setAdapter(groupRankAdapter);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //뷰 설정
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onMessageReceived(byte[] receivedData) {
    }
}
