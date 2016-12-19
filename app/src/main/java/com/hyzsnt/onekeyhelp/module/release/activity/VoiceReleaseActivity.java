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

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private String mPath;


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
                String mVoice1="";
                String nickName = mTalkerNickname.getText().toString();
                File file = new File(mPath);
                if (file.exists()) {
                    BufferedInputStream bis = null;
                    ByteArrayOutputStream baos = null;
                    try {
                        baos = new ByteArrayOutputStream();
                        bis = new BufferedInputStream(new FileInputStream(file));
                        int len = 0;
                        byte[] bytes = new byte[1024 * 4];
                        while ((len = bis.read(bytes)) != -1) {
                            baos.write(bytes, 0, len);
                            Log.d("33333", baos + "");
                            baos.flush();
                        }
                        mVoice1 = baos.toString();
                        byte[] data = baos.toByteArray();
                        String str = new String(data);
                        Log.d("2222222", str);
                        Log.d("1111111111", mVoice1);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (baos != null) {
                            try {
                                baos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (bis != null) {
                                try {
                                    bis.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }

                p = new ArrayList<>();
                p.add("4");
                p.add(lat);
                p.add(lon);
                p.add(nickName);
                p.add("-1");
                p.add(mVoice1);
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
        mPath = mAudioManager.getRecordFilePath();
        Log.d("录制完成", mPath);
        Toast.makeText(VoiceReleaseActivity.this, "录制完成" + mPath, Toast.LENGTH_SHORT).show();


    }

    public void startRecord() {
        mAudioManager = AudioManager.getInstance();
        int code = mAudioManager.startRecordAndFile();
        Toast.makeText(VoiceReleaseActivity.this, "code:" + ErrorCode.getErrorInfo(this, code), Toast.LENGTH_SHORT).show();
    }
}
