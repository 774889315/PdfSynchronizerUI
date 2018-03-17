package com.example.zdl.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class ReadingActivity extends AppCompatActivity {

    // 抽屉菜单对象
    private ActionBarDrawerToggle drawerbar;
    public DrawerLayout drawerLayout;
    private RelativeLayout main_left_drawer_layout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.reading_activity);

        initLayout();
        initEvent();
    }

    public void initLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        //设置菜单内容之外其他区域的背景色
        drawerLayout.setScrimColor(Color.argb(100, 200, 200, 200));

        //左边菜单
        main_left_drawer_layout = (RelativeLayout) findViewById(R.id.left_drawer_layout);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        refresh();
    }

    public void refresh()
    {
        recyclerView.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = getLayoutInflater().inflate(R.layout.mark_item, parent, false);
                ((MarkItem) view.findViewById(R.id.item)).setContent("123123");
                ((MarkItem) view.findViewById(R.id.item)).setInfo("20180316 - ZHN TEST");
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                if(position == 3)
                {
                    ((MarkItem) holder.itemView.findViewById(R.id.item)).setContent("测试一段长文字测试一段长文字测试一段长文字测试一段长文字");
                    ((MarkItem) holder.itemView.findViewById(R.id.item)).setInfo("20180316 TEST 20180316 20180316 20180316");
                }
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(ReadingActivity.this, 2));
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    //设置开关监听
    private void initEvent() {
        drawerbar = new ActionBarDrawerToggle(this, drawerLayout, R.mipmap.ic_launcher, R.string.open, R.string.close) {
            //菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            // 菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(drawerbar);
    }

    //显示左边的drawer
    public void openLeftLayout(View view) {
        if (drawerLayout.isDrawerOpen(main_left_drawer_layout)) {
            drawerLayout.closeDrawer(main_left_drawer_layout);
        } else {
            drawerLayout.openDrawer(main_left_drawer_layout);
        }
    }
}