package red.github.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultBox, controlBox;
    private Integer calResult = 0;
    private Boolean switchNum = false;
    private String nowControl = "";
    private Boolean First = true;

    private Integer num1 = 0, num2 = 0, temp = 0, nowNum = 1;

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, plus, minus, multiply, devide, equal, AC;
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

        this.AC = findViewById(R.id.AC);

        this.AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calResult = 0;
                switchNum = false;
                nowControl = "";
                First = true;
                resultBox.setText(calResult.toString());
                controlBox.setText("");
            }
        });

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


        if(nowNum == 1){
            this.num1 = this.calResult;
            this.nowNum = 2;
        }else{
            this.num2 = this.calResult;
            this.nowNum = 1;
        }


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
                if(this.switchNum == true){
                    this.switchNum = false;
                    this.num2 = this.temp;
                }

                break;
        }

        if(!this.switchNum && !this.First && num2 != null){
            switch (this.nowControl){
                case "plus":
                    this.calResult = this.num1 + this.num2;
                    break;
                case "minus":
                    this.calResult = this.num1 - this.num2;
                    break;
                case "multiply":
                    this.calResult = this.num1 * this.num2;
                    break;
                case "devide":
                    this.calResult = this.num1 / this.num2;
                    break;
            }

            this.num1 = this.calResult;
            this.temp = this.num2;  //used by equal.
            this.num2 = null;
            this.nowNum = 1;
            this.resultBox.setText(this.calResult.toString());

//            this.controlBox.setText("");
        }
        this.switchNum = true;

        this.First = false;
    }

    private void NumButtonClicked(Integer id){
        for(int i = 0; i < 10; i++){
            if(this.buttonID[i].equals(id)){

                // empty the value.
                if(this.switchNum){
                    this.calResult = 0;
                    this.switchNum = false;
                }

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
