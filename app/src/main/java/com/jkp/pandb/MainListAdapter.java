package com.jkp.pandb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jkp.pandb.VO.Article;

import java.util.ArrayList;

public class MainListAdapter extends BaseAdapter {

    private ArrayList<Article> articles = new ArrayList<Article>() ;


    @Override
    public int getCount() {
        return articles.size() ;
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_article, parent, false);
        }

/*

        final TextView title = (TextView) convertView.findViewById(R.id.title) ;
        final TextView Context = (TextView) convertView.findViewById(R.id.context);
        final TextView no = (TextView) convertView.findViewById(R.id.no);
        Button  DeletBtn = (Button) convertView.findViewById(R.id.btn_num);
*/

        final Article listViewItem = articles.get(position);

        // 아이템 내 각 위젯에 데이터 반영
       /* title.setText(listViewItem.getTitle());
        Context.setText(listViewItem.getContext());
        no.setText(listViewItem.getNo());
*/

       /* DeletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = listViewItem.getNo();
                ConnectServer(Integer.parseInt(test));

                Intent intent = new Intent(context,ScheduleActivity.class);
                context.startActivity(intent);

            }
        });*/


        //리스트뷰 클릭 이벤트
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Toast.makeText(context, (pos+1)+"번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();*/

            }});
        return convertView;
    }
    @Override
    public long getItemId(int position) {
        return position ;
    }


    @Override
    public Object getItem(int position) {
        return articles.get(position) ;
    }

    // 데이터값 넣어줌
    public void addVO(String title, String desc , String no) {

        /* ListVO item = new ListVO();

        item.setNo(no);
        item.setTitle(title);
        item.setContext(desc);

        listVO.add(item);*/

    }

   /* public void updateReceiptsList(ArrayList<ListVO> newlist) {
        listVO.clear();

        this.notifyDataSetChanged();
    }*/

}//MainListView