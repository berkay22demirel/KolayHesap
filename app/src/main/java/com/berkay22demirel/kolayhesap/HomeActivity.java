package com.berkay22demirel.kolayhesap;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.berkay22demirel.kolayhesap.Enum.CategoryEnum;
import com.berkay22demirel.kolayhesap.Util.CommonUtils;

public class HomeActivity extends AppCompatActivity {

    CardView cardViewMath;
    CardView cardViewDateTime;
    CardView cardViewHealth;
    CardView cardViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setViewReferences();
        addViewListeners();
    }

    private void setViewReferences() {
        cardViewMath = findViewById(R.id.cardViewMath);
        cardViewDateTime = findViewById(R.id.cardViewDateTime);
        cardViewHealth = findViewById(R.id.cardViewHealth);
        cardViewColor = findViewById(R.id.cardViewColor);
    }

    private void addViewListeners() {
        final Intent intent = new Intent(HomeActivity.this, SubCategoriesActivity.class);
        final Bundle bundle = new Bundle();
        cardViewMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt(CommonUtils.CATEGORY_ID, CategoryEnum.MATH.getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        cardViewDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt(CommonUtils.CATEGORY_ID, CategoryEnum.DATE_TIME.getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        cardViewHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt(CommonUtils.CATEGORY_ID, CategoryEnum.HEALTH.getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        cardViewColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt(CommonUtils.CATEGORY_ID, CategoryEnum.COLOR.getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        MenuItem searchViewItem = menu.findItem(R.id.toolbar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                Toast.makeText(HomeActivity.this, " Ne Oldu", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(HomeActivity.this, newText + " Arandı", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_settings:
                Intent intentSettings = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(intentSettings);
                break;
            case R.id.toolbar_info:
                Intent intentInfo = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(intentInfo);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
