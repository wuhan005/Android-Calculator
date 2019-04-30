package red.github.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultBox;
    private Number calResult = 0;

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button[] numButtons = new Button[] {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
    private Integer[] buttonID = new Integer[] {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultBox = findViewById(R.id.ResultBox);
        this.resultBox.setText(this.calResult.toString());

        this.InitUI();
        System.out.println("okokok");
    }

    private void InitUI(){
        // set the buttons to the view.
        for(int i = 0; i < 10; i++){
            this.numButtons[i] = findViewById(this.buttonID[i]);
            this.numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NumButtonClicked(v.getId());
                }
            });
        }
    }

    private void NumButtonClicked(Integer id){
        for(int i = 0; i < 10; i++){
            if(this.buttonID[i].equals(id)){
                String result = calResult.toString();

                if(result.length() >= 8){
                    return;
                }

                result += String.valueOf(i);
                this.calResult = Integer.valueOf(result);
                this.resultBox.setText(this.calResult.toString());
            }
        }
    }
}
