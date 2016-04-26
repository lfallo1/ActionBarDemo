package com.training.lfallon.actionbardemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.training.lfallon.actionbardemo.R;
import com.training.lfallon.actionbardemo.fragments.BasicFragment;

public class MainActivity extends AppCompatActivity implements BasicFragment.BasicFragmentListener {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        MenuItem showItemGroup = menu.findItem(R.id.activity_main_menuShowGroup);
        menu.setGroupEnabled(R.id.activity_main_menuGroup, showItemGroup.isChecked());
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.isCheckable()){
            item.setChecked(!item.isChecked());
        }

        if(item.getItemId() == R.id.activity_main_menuShowGroup){
//            menu.setGroupVisible(R.id.activity_main_menuGroup, item.isChecked());
            menu.setGroupEnabled(R.id.activity_main_menuGroup, item.isChecked());
        }

        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onFragmentInteraction(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
