package com.hyzsnt.onekeyhelp.module.release.activity;

import android.Manifest;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.app.App;
import com.hyzsnt.onekeyhelp.audio.AudioRecordButton;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.module.release.media.MediaManager;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.LogUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;
import com.hyzsnt.onekeyhelp.utils.ToastUtils;

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
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;




@RuntimePermissions
public class VoiceReleaseActivity extends BaseActivity {

    List<String> params;
    @BindView(R.id.talk_voice_icon)
    CircleImageView mTalkVoiceIcon;
    @BindView(R.id.talker_nickname)
    TextView mTalkerNickname;
    @BindView(R.id.release_time)
    TextView mReleaseTime;
    @BindView(R.id.play_voice)
    Button play_voice;
    @BindView(R.id.delete_voice)
    TextView mDeleteVoice;
    @BindView(R.id.release_voice)
    Button mReleaseVoice;
    @BindView(R.id.btn_release_record)
    AudioRecordButton mBtnReleaseRecord;
    private String lat;
    private String lon;
    private String mUid;
    private String mRecordPath;
    private boolean isPlaying;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_voice_release;
    }

    @Override
    protected void initData() {
        VoiceReleaseActivityPermissionsDispatcher.initPermissionWithCheck(this);
        String userDetail = (String) SPUtils.get(this, "userDetail", "");
        ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
        mUid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
        //用户的经纬度
        lat = Double.toString(App.getLocation().getLatitude());
        lon = Double.toString(App.getLocation().getLongitude());
        initPermission();
    }


    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO})
    protected void initPermission() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        VoiceReleaseActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtnReleaseRecord.setAudioFinishRecorderListener(new AudioRecordButton.AudioFinishRecorderListener() {
            @Override
            public void onFinished(float seconds, String filePath) {
                mRecordPath = filePath;
            }
        });
    }

    @OnClick({R.id.play_voice, R.id.cancel_release_voice, R.id.delete_voice, R.id.release_voice})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_release_voice:
                finish();
                break;
            case R.id.delete_voice:
                if (TextUtils.isEmpty(mRecordPath)) {
                    ToastUtils.showShort(this, "还没录音呢！");
                    return;
                } else {
                    File file = new File(mRecordPath);
                    if (file.exists()) {
                        file.delete();
                    }
                    mRecordPath = "";
                }
                break;
            case R.id.play_voice:
                if (TextUtils.isEmpty(mRecordPath)) {
                    ToastUtils.showShort(this, "还没录音呢！");
                    return;
                }
                if (isPlaying) {
                    MediaManager.pause();
                    return;
                }
                isPlaying = true;
				/*ToastUtils.showShort(this, mRecordPath);
				MediaManager.playSound(AudioConfig.getAACFilePath(), new MediaPlayer.OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						isPlaying = false;
					}
				});*/

                try {
                    MediaPlayer   player  =   new MediaPlayer();
                    player.setDataSource(mRecordPath);
                    LogUtils.e(mRecordPath);
                    player.prepare();
                    player.start();
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            isPlaying = false;
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }




                break;
            case R.id.release_voice:
                releaseVoice();
                break;
        }
    }

    //发布语音的方法
    private void releaseVoice() {
        if (TextUtils.isEmpty(mRecordPath)) {
            ToastUtils.showShort(this, "还没录音呢！");
            return;
        }
        String mVoice = Base64.encodeToString(fileToByte(mRecordPath), 1);
        params = new ArrayList<>();
        params.add(mUid);
        params.add(lat);
        params.add(lon);
        params.add("");
        params.add("-1");
        params.add(mVoice);
        HttpUtils.post(Api.PUBLISH, Api.Publish.PUBLISHDYNAMIC, params, new JsonResponseHandler() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.e("onError:" + e.getMessage());
                ToastUtils.showShort(VoiceReleaseActivity.this, "发布失败！");
            }

            @Override
            public void onSuccess(String response, int id) {
                Log.d("onSuccess", response);
                if (JsonUtils.isSuccess(response)) {
                    LogUtils.e("语音发布成功");
                    ToastUtils.showShort(VoiceReleaseActivity.this, "发布成功");
                    finish();
                } else {
                    LogUtils.e("Error:" + JsonUtils.getErrorMessage(response));
                    Toast.makeText(VoiceReleaseActivity.this, "发布语音失败！" + JsonUtils.getErrorMessage(response), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private byte[] fileToByte(String path) {
        File file = new File(path);
        ByteArrayOutputStream baos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int i = 0;
                while ((i = bis.read(buf)) != -1) {
                    baos.write(buf, 0, buf.length);
                }
                baos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    baos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    bis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return baos == null ? null : baos.toByteArray();
    }

}
