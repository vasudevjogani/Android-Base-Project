package com.vj.baseproject.util.helper;


public class RetrofitUtils {

    public static okhttp3.RequestBody getStringBody(String value) {
        return okhttp3.RequestBody.create(okhttp3.MediaType.parse("text/plain"), value);
    }

    public static okhttp3.MultipartBody.Part getGifPart(String key, @androidx.annotation.Nullable java.io.File imageFile) {
        if (imageFile != null) {
            return okhttp3.MultipartBody.Part.createFormData(key, imageFile.getName(), okhttp3.RequestBody.create(okhttp3.MediaType.parse("image/gif"), imageFile));
        }
        return null;
    }

    public static okhttp3.MultipartBody.Part getImagePart(String key, @androidx.annotation.Nullable java.io.File imageFile) {
        if (imageFile != null) {
            return okhttp3.MultipartBody.Part.createFormData(key, imageFile.getName(), getImageBody(imageFile));
        }
        return null;
    }

    public static okhttp3.MultipartBody.Part getStringPart(String key, String value) {
        return okhttp3.MultipartBody.Part.createFormData(key, value);
    }

    public static okhttp3.RequestBody getImageBody(java.io.File imageFile) {
        return okhttp3.RequestBody.create(okhttp3.MediaType.parse("image/*"), imageFile);
    }

    public static okhttp3.MultipartBody.Part getEmptyImagePart(String key) {
        return okhttp3.MultipartBody.Part.createFormData(key, "image", getStringBody(""));
    }
}
