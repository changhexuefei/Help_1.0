package com.hyzsnt.onekeyhelp.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hyzsnt.onekeyhelp.module.stroll.bean.CircleType;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/18.
 */

public class DbUtils extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	private Context mContext;

	public DbUtils(Context context) {
		super(context, "circletag.db", null, 1);
		mContext = context;
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		this.db = db;
		db.execSQL("create table circletags(_id integer primary key autoincrement, tagid varchar,tagdes varchar,tagname varchar)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	//插入方法
	public Boolean insert(CircleType.ListEntry tags){
		//获取SQLiteDatabase实例
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("tagid",tags.getTagid());
		values.put("tagdes",tags.getTagdesc());
		values.put("tagname",tags.getTagname());
		//插入数据库中
		long l = db.insert("circletags", null, values);
		if(l>-1){
			return true;
		}
		db.close();
		return  false;
	}

	//查询方法
	public CircleType.ListEntry query(String tagid){
		SQLiteDatabase db = getReadableDatabase();
		//获取Cursor
		Cursor c = db.query("circletags",null,"tagid=?",new String[]{tagid},null,null,null,null);
		CircleType.ListEntry list = null;
		while (c.moveToNext()){
			list = new CircleType.ListEntry(c.getString(c.getColumnIndex("tagdes")),c.getString(c.getColumnIndex("tagid")),c.getString(c.getColumnIndex("tagname")));
		}
		c.close();
		return list;

	}
	//查询方法
	public ArrayList<CircleType.ListEntry> queryall(){
		SQLiteDatabase db = getReadableDatabase();
		//获取Cursor
		Cursor c = db.query("circletags",null,null,null,null,null,null,null);
		ArrayList<CircleType.ListEntry> list = new ArrayList<>();
		while (c.moveToNext()){
			list.add(new CircleType.ListEntry(c.getString(c.getColumnIndex("tagdes")),c.getString(c.getColumnIndex("tagid")),c.getString(c.getColumnIndex("tagname"))));
		}
		c.close();
		return list;

	}

	//根据唯一标识_id  来删除数据
	public void delete(int id){
		SQLiteDatabase db = getWritableDatabase();
		db.delete("circletags", "_id=?", new String[]{String.valueOf(id)});
	}


	//更新数据库的内容
	public void update(ContentValues values, String whereClause, String[]whereArgs){
		SQLiteDatabase db = getWritableDatabase();
		db.update("circletags", values, whereClause, whereArgs);
	}

	//关闭数据库
	public void close(){
		if(db != null){
			db.close();
		}
	}
}
