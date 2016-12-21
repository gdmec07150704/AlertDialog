package cn.edu.gdmec.s07150704.alertdialog;


import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);

        Button btn1= (Button) findViewById(R.id.button1);
        Button btn2= (Button) findViewById(R.id.button2);
        Button btn3= (Button) findViewById(R.id.button3);
        Button btn4= (Button) findViewById(R.id.button4);
        Button btn5= (Button) findViewById(R.id.button5);
        Button btn6= (Button) findViewById(R.id.button6);
        Button btn7= (Button) findViewById(R.id.button7);

        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);

    }
    private void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定要退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener lis1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){

                }
            }
        };

        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"退出",lis1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        dialog.show();

    }
    private void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_info);

        DialogInterface.OnClickListener lis2= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="杜甫很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="杜甫很闲";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="杜甫无所谓";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",lis2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"很闲",lis2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",lis2);
        dialog.show();
    }
    private void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("输入的");
        dialog.setMessage("请输入获奖感言");
        dialog.setIcon(android.R.drawable.ic_dialog_dialer);

        final EditText et1=new EditText(this);
        dialog.setView(et1);

        DialogInterface.OnClickListener lis3= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你的感言："+et1.getText().toString());
            }
        };

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis3);
        dialog.show();
    }
    private void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener lis4= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bSelect,lis4);
        dialog=builder.create();
        dialog.setTitle("多选框");
        DialogInterface.OnClickListener lis41= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis41);
        dialog.show();
    }
    private void dialog5(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener lis5= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<bSelect.length;i++){
                    if(i!=which){
                        bSelect[i]=false;
                    }else{
                        bSelect[i]=true;
                    }
                }
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,lis5);
        dialog=builder.create();
        dialog.setTitle("单选");
        DialogInterface.OnClickListener lis51= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis51);
        dialog.show();

    }
    private void dialog6(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener lis6= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了"+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,lis6);
        dialog=builder.create();
        dialog.setTitle("列表");

        DialogInterface.OnClickListener lis61= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialg, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis61);
        dialog.show();
    }
    private void dialog7(){
        LayoutInflater li=getLayoutInflater();
        View layout=li.inflate(R.layout.diydialog,null);
        final EditText et1=(EditText) layout.findViewById(R.id.textView1);

        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);

        DialogInterface.OnClickListener lis7= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+et1.getText().toString());
            }
        };

        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis7);
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"取消",lis7);
        dialog.show();
    }
}
