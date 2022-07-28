package com.vj.baseproject.util.helper;




public class Utils {

    public static String getVersionName(android.content.Context context) {
        try {
            android.content.pm.PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (easyadapter.dc.com.library.BuildConfig.DEBUG)
                return "Version " + pInfo.versionName + " (" + getVersionCode(pInfo) + ")" + "- debug";
            else
                return "Version " + pInfo.versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getVersionCode(android.content.pm.PackageInfo packageInfo) {

        int versionCode;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            versionCode = (int) packageInfo.getLongVersionCode(); // avoid huge version numbers and you will be ok
        } else {
            //noinspection deprecation
            versionCode = packageInfo.versionCode;
        }
        return String.valueOf(versionCode);
    }
}
