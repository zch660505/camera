package com.seu.magiccamera.dao;

import android.util.Log;

import com.seu.magiccamera.MyApplication;
import com.seu.magiccamera.model.User;

import java.util.List;

/**
 * Created by sunyajie on 2018/12/22.
 */

public class DaoUtils {
    private static DaoUtils daoUtils;
    DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), "hlq.db", null);
    private DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
    private DaoSession daoSession = daoMaster.newSession();
    private UserDao userDao = daoSession.getUserDao();


    private DaoUtils() {

    }

    public static DaoUtils getInstance() {
        if (daoUtils == null) {
            synchronized (DaoUtils.class) {
                if (daoUtils == null) {
                    daoUtils = new DaoUtils();
                }
            }
        }

        return daoUtils;
    }

    /**
     * 获取StudentDao
     */
    public UserDao getStuDao() {


        return userDao;
    }

    public boolean insertDao(String phoneNum, String pwd) {

        DaoUtils.getInstance().getStuDao().insert(new User(phoneNum, pwd));
        return true;
    }

    public boolean queryDao(String phoneNum, String pwd) {

        Log.d("zch", "queryDao: shuru " + phoneNum + "    " + pwd);

        List<User> list = userDao.queryBuilder().where(UserDao.Properties.PhoneNum.eq(phoneNum)).list();

        if (list.size() < 1) {
            return false;
        }

        for (User user : list) {
            Log.d("zch", "queryDao: " + "  phoneNum = " + user.getPhoneNum() + "  pwd = " + user.getPwd());
            if (user.getPwd().equals(pwd)) {
                return true;
            }
        }

        return false;
    }
}
