package com.hyzsnt.onekeyhelp.audio;

/**
 * Created by 14369 on 2016/12/15.
 */

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AudioConfig {
	//音频输入-麦克风
	public final static int AUDIO_INPUT = MediaRecorder.AudioSource.MIC;

	//录音输出文件
	private static String AUDIO_AAC_FILENAME = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".aac";

	/**
	 * 判断是否有外部存储设备sdcard
	 *
	 * @return true | false
	 */
	public static boolean isSdcardExit() {
		if (Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
			return true;
		else
			return false;
	}

	/**
	 * 获取编码后的AAC格式音频文件路径
	 *
	 * @return
	 */
	public static String getAACFilePath() {
		String mAudioAMRPath = "";
		if (isSdcardExit()) {
			mAudioAMRPath = getAACPath() + AUDIO_AAC_FILENAME;
		}
		return mAudioAMRPath;
	}

	public static String getAACPath() {
		String mAudioAMRPath = "";
		if (isSdcardExit()) {
			String fileBasePath = Environment.getExternalStorageDirectory().getAbsolutePath();
			mAudioAMRPath = fileBasePath + "/OneKeyHelp/aac/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/";
		}
		return mAudioAMRPath;
	}

	/**
	 * 获取文件大小
	 *
	 * @param path,文件的绝对路径
	 * @return
	 */
	public static long getFileSize(String path) {
		File mFile = new File(path);
		if (!mFile.exists())
			return -1;
		return mFile.length();
	}
}
