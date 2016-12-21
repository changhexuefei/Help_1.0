package com.hyzsnt.onekeyhelp.module.user.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hyzsnt.onekeyhelp.R;
import com.hyzsnt.onekeyhelp.base.BaseActivity;
import com.hyzsnt.onekeyhelp.http.Api;
import com.hyzsnt.onekeyhelp.http.HttpUtils;
import com.hyzsnt.onekeyhelp.http.response.JsonResponseHandler;
import com.hyzsnt.onekeyhelp.module.home.bean.MDate;
import com.hyzsnt.onekeyhelp.module.home.resovle.Resovle;
import com.hyzsnt.onekeyhelp.utils.InPutUtils;
import com.hyzsnt.onekeyhelp.utils.JsonUtils;
import com.hyzsnt.onekeyhelp.utils.SPUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class AddContactActivity extends BaseActivity {
	
	private static final int OPEN_CONTACTS = 0;
	@BindView(R.id.et_add_contact_name)
	EditText mEtAddContactName;
	@BindView(R.id.et_add_contact_phone)
	EditText mEtAddContactPhone;
	@BindView(R.id.et_add_contact_note)
	EditText mEtAddContactNote;
	private String mUid;
	
	@Override
	protected int getLayoutId() {
		return R.layout.activity_add_contact;
	}
	
	@Override
	protected void initData() {
		String userDetail = (String) SPUtils.get(this, "userDetail", "");
		ArrayList<MDate> userInfo = Resovle.getUserInfo(userDetail);
		mUid = userInfo.get(0).getmInfo().getUserInfoInfo().getUid();
	}
	
	@OnClick({R.id.iv_add_contact_back, R.id.iv_add_contact_finish})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.iv_add_contact_back:
				finish();
				break;
			case R.id.iv_add_contact_finish:
				addContact();
				break;
		}
	}

	/**
	 * 添加联系人
	 */
	private void addContact() {
		List<String> params = new ArrayList<>();
		String phone = mEtAddContactPhone.getText().toString();
		if ((!TextUtils.isEmpty(mUid)) && InPutUtils.isMobilePhone(phone)) {
			params.add(mUid);
			params.add(phone);
		} else {
			Toast.makeText(AddContactActivity.this, "手机号码不正确！", Toast.LENGTH_SHORT).show();
			return;
		}
		HttpUtils.post(Api.USER, Api.User.ADDEMERGLINKER, params, new JsonResponseHandler() {
			@Override
			public void onError(Call call, Exception e, int id) {
				Toast.makeText(AddContactActivity.this, "网络连接失败！", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(String response, int id) {
				if (JsonUtils.isSuccess(response)) {
					try {
						JSONObject object = new JSONObject(response);
						String res = object.getString("res");
						if ("1".equals(res)) {
							Toast.makeText(AddContactActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}

				} else {
					Toast.makeText(AddContactActivity.this, "请求错误：" + JsonUtils.getErrorMessage(response), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			ContentResolver reContentResolverol = getContentResolver();
			Uri contactData = data.getData();
			Cursor cursor = managedQuery(contactData, null, null, null, null);
			cursor.moveToFirst();
			String userName = cursor.getString(cursor
					.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)).replaceAll("\\s*", "");
			String contactId = cursor.getString(cursor
					.getColumnIndex(ContactsContract.Contacts._ID));
			Cursor p = reContentResolverol.query(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "
							+ contactId, null, null);
			while (p.moveToNext()) {
				String userPhone = p.getString(p
						.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replaceAll("\\s*", "");
				Log.e("TAG", "phone:" + userPhone + "name:" + userName);
				mEtAddContactName.setText(userName);
				mEtAddContactPhone.setText(userPhone);
			}
		}
	}

	public void chooseContact(View view) {
		startActivityForResult(new Intent(Intent.ACTION_PICK,
				ContactsContract.Contacts.CONTENT_URI), OPEN_CONTACTS);
	}
}
