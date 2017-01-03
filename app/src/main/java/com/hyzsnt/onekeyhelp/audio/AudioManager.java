package com.hyzsnt.onekeyhelp.audio;

import android.media.MediaRecorder;

import java.io.File;
import java.io.IOException;

public class AudioManager {
    private boolean isRecord = false;
    private boolean isPrepared;// 是否准备好了
    private MediaRecorder mMediaRecorder;

    private AudioManager() {
    }

    private static AudioManager mInstance;

    public synchronized static AudioManager getInstance() {
        if (mInstance == null)
            mInstance = new AudioManager();
        return mInstance;
    }

    public int startRecordAndFile() {
        //判断是否有外部存储设备sdcard
        if (AudioConfig.isSdcardExit()) {
            if (isRecord) {
                return ErrorCode.E_STATE_RECODING;
            } else {
                if (mMediaRecorder == null)
                    createMediaRecord();
                try {
                    mMediaRecorder.prepare();
                    mMediaRecorder.start();
                    // 让录制状态为true
                    isRecord = true;
                    // 准备结束
                    isPrepared = true;
                    // 已经准备好了，可以录制了
                    if (mListener != null) {
                        mListener.wellPrepared();
                    }

                    return ErrorCode.SUCCESS;
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return ErrorCode.E_UNKOWN;
                }
            }
        } else {
            return ErrorCode.E_NOSDCARD;
        }
    }

    /**
     * 回调函数，准备完毕，准备好后，button才会开始显示录音框
     *
     * @author nickming
     */
    public interface AudioStageListener {
        void wellPrepared();
    }

    public AudioStageListener mListener;

    public void setOnAudioStageListener(AudioStageListener listener) {
        mListener = listener;
    }


    // 获得声音的level
    public int getVoiceLevel(int maxLevel) {
        // mRecorder.getMaxAmplitude()这个是音频的振幅范围，值域是1-32767
        if (isPrepared) {
            try {
                // 取证+1，否则去不到7
                return maxLevel * mMediaRecorder.getMaxAmplitude() / 32768 + 1;
            } catch (Exception e) {
                // TODO Auto-generated catch block
            }
        }
        return 1;
    }

    // 取消,因为prepare时产生了一个文件，所以cancel方法应该要删除这个文件，
    // 这是与release的方法的区别
    public void cancel() {
        close();
        if (getRecordFilePath() != null) {
            File file = new File(getRecordFilePath());
            file.delete();
        }
    }

    public void stopRecordAndFile() {
        close();
    }

    public String getRecordFilePath() {
        return AudioConfig.getAACFilePath();
    }


    private void createMediaRecord() {
	     /* ①Initial：实例化MediaRecorder对象 */
        mMediaRecorder = new MediaRecorder();

        /* setAudioSource/setVedioSource*/
        //设置声音来源
        mMediaRecorder.setAudioSource(AudioConfig.AUDIO_INPUT);//设置麦克风

        /* 设置输出文件的格式：THREE_GPP/MPEG-4/RAW_AMR/Default
         * THREE_GPP(3gp格式，H263视频/ARM音频编码)、MPEG-4、RAW_AMR(只支持音频且音频编码要求为AMR_NB)
         */
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);

         /* 设置音频文件的编码：AAC/AMR_NB/AMR_MB/Default */
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

         /* 设置输出文件的路径 */
        File file = new File(AudioConfig.getAACPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        mMediaRecorder.setOutputFile(AudioConfig.getAACFilePath());
    }

    private void close() {
        if (mMediaRecorder != null) {
            isRecord = false;
            mMediaRecorder.stop();
            mMediaRecorder.release();
            mMediaRecorder = null;
        }
    }
}
