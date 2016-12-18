package com.hyzsnt.onekeyhelp.module.release.activity;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.audio.AudioManager;
import com.hyzsnt.onekeyhelp.audio.ErrorCode;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

public class VoiceReleaseActivity extends BaseActivity implements View.OnTouchListener {

    private static final String PUBLISH = "publish";
    private static final String PUBLISHDYNAMIC = "publishDynamic";
    List<String> p;
    @BindView(R.id.talk_voice_icon)
    CircleImageView mTalkVoiceIcon;
    @BindView(R.id.talker_nickname)
    TextView mTalkerNickname;
    @BindView(R.id.release_time)
    TextView mReleaseTime;
    @BindView(R.id.voice)
    ImageView mVoice;
    @BindView(R.id.delete_voice)
    TextView mDeleteVoice;
    @BindView(R.id.release_voice)
    Button mReleaseVoice;
    @BindView(R.id.press)
    ImageButton ivbtn_press;
    @BindView(R.id.cancel_release_voice)
    TextView tv_cancel_release;
    private String lat;
    private String lon;

    private AudioManager mAudioManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_voice_release;
    }

    @Override
    protected void initData() {
        //用户的经纬度
        lat = Double.toString(App.getLocation().getLatitude());
        Log.d("lat", lat);
        lon = Double.toString(App.getLocation().getLongitude());
        Log.d("lon", lon);
    }

    @Override
    protected void initListener() {
        super.initListener();
        ivbtn_press.setOnTouchListener(this);
    }


    @OnClick({R.id.cancel_release_voice, R.id.delete_voice, R.id.release_voice})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_release_voice:
                finish();
                break;
            case R.id.delete_voice:
                break;
            case R.id.release_voice:
                String nickName = mTalkerNickname.getText().toString();
                p = new ArrayList<>();
                p.add("4");
                p.add(lat);
                p.add(lon);
                p.add(nickName);
                p.add("-1");
                p.add("");
                HttpUtils.post(PUBLISH, PUBLISHDYNAMIC, p, new JsonResponseHandler() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.d("语音", response);
                    }
                });
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("1111111", "11111111");
                startRecord();
                break;
            case MotionEvent.ACTION_UP:
                stopRecord();
                break;
            default:
                break;
        }
        return false;
    }

    private void stopRecord() {
        mAudioManager.stopRecordAndFile();
        String path = mAudioManager.getRecordFilePath();
        Log.d("录制完成", path);
        Toast.makeText(VoiceReleaseActivity.this, "录制完成" + path, Toast.LENGTH_SHORT).show();
//        File file = new File(path);

    }

    public void startRecord() {
        mAudioManager = AudioManager.getInstance();
        int code = mAudioManager.startRecordAndFile();
        Toast.makeText(VoiceReleaseActivity.this, "code:" + ErrorCode.getErrorInfo(this, code), Toast.LENGTH_SHORT).show();
    }
}
