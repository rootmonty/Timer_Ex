package badebaba.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start;
    EditText getvalue;
    TextView status;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button);
        getvalue = (EditText) findViewById(R.id.editText);
        status = (TextView) findViewById(R.id.status);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long seconds = Integer.parseInt(getvalue.getText().toString());
                timer = new CountDownTimer( seconds*1000 , 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        status.setText(""+(millisUntilFinished/1000));
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(getApplicationContext(),"Finished",Toast.LENGTH_LONG).show();
                    }
                };
                timer.start();
            }
        });





    }
}
