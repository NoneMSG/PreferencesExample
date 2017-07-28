package com.example.preferencesexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CheckBox)findViewById( R.id.checkbox_duration )).
                setOnCheckedChangeListener( this );
        ((ToggleButton)findViewById( R.id.togglebutton_notitication )).
                setOnCheckedChangeListener( this );
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int viewId = buttonView.getId();
        if( viewId == R.id.togglebutton_notitication ){
            if( isChecked == true ) {
                findViewById( R.id.layout_settings_detail).
                        setVisibility(View.VISIBLE);
                findViewById( R.id.layout_settings_desc ).
                        setVisibility(View.GONE);
            } else {
                findViewById( R.id.layout_settings_detail).
                        setVisibility(View.GONE);
                findViewById( R.id.layout_settings_desc ).
                        setVisibility(View.VISIBLE);

            }
        } else if( viewId == R.id.checkbox_duration ) {
            findViewById( R.id.layout_starttime).
                setClickable( isChecked );
            findViewById( R.id.layout_starttime).
                setEnabled( isChecked );

            findViewById( R.id.layout_endtime).
                    setClickable( isChecked );
            findViewById( R.id.layout_endtime).
                    setEnabled( isChecked );
        } else {
            System.out.println( "checked:" + viewId );
        }
    }
}
