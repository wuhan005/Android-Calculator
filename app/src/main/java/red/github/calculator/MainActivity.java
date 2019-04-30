package red.github.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultBox, controlBox;
    private Number calResult = 0;
    private String nowControl = "";

    private Number num1, num2;

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, plus, minus, multiply, devide, equal;
    private Button[] numButtons = new Button[] {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
    private Integer[] buttonID = new Integer[] {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    private Button[] controlButtons = new Button[] {plus, minus, multiply, devide, equal};
    private Integer[] controlID = new Integer[] {R.id.plus, R.id.minus, R.id.multiply, R.id.devide, R.id.equal};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultBox = findViewById(R.id.ResultBox);
        this.resultBox.setText(this.calResult.toString());

        this.controlBox = findViewById(R.id.ControlBox);

        this.InitUI();
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

        // set the control buttons.
       for(int i = 0; i < 5; i++){
           this.controlButtons[i] = findViewById(this.controlID[i]);
           this.controlButtons[i].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    ControlButtonClicked(v.getId());
               }
           });
       }

    }

    private void ControlButtonClicked(Integer id){
        switch (id){
            case R.id.plus:
                this.nowControl = "plus";
                this.controlBox.setText("+");
                break;
            case R.id.minus:
                this.nowControl = "minus";
                this.controlBox.setText("-");
                break;
            case R.id.multiply:
                this.nowControl = "multiply";
                this.controlBox.setText("×");
                break;
            case R.id.devide:
                this.nowControl = "devide";
                this.controlBox.setText("÷");
                break;
            case R.id.equal:
                break;
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
