package compp.cumulus.traveleverywhre.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.bean.UpimgBean;
import compp.cumulus.traveleverywhre.p.UpheadportaiP;
import compp.cumulus.traveleverywhre.v.Upheadportaiv;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UpheadportraitActivity extends BaseActity<Upheadportaiv, UpheadportaiP> implements Upheadportaiv {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.zhanwei)
    ImageView mZhanwei;
    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.wancheng)
    TextView mWancheng;
    private PopupWindow mPopupWindow;
    private static final int CAMERA_CODE = 100;
    private static final int ALBUM_CODE = 200;
    private static final String TAG = UpsignatureActivity.class.getName();
    private Bitmap mbitmap;
    private File mFile;
    private Uri mImageUri;
    @Override
    protected UpheadportaiP initPretener() {
        return new UpheadportaiP();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_upheadportrait;
    }

    @Override
    protected void initView() {
        mTo.setTitle("");
        setSupportActionBar(mTo);
        String img = getIntent().getStringExtra("img");
        Glide.with(this).load(img).into(mImg);
    }

    @OnClick({R.id.back, R.id.zhanwei, R.id.wancheng})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.zhanwei:
                initPop();
                break;
            case R.id.wancheng:
                Intent intent = new Intent(this, PersonalActivity.class);
                startActivity(intent);
                finish();
                mZhanwei.setVisibility(View.VISIBLE);
                mWancheng.setVisibility(View.GONE);
                break;
        }
    }

    private void initPop() {
        mPopupWindow = new PopupWindow();
        final View inflate = LayoutInflater.from(this).inflate(R.layout.pop, null, false);
        mPopupWindow.setContentView(inflate);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(mZhanwei, Gravity.BOTTOM, 1000, 1000);
        inflate.findViewById(R.id.pai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paizhao();
                mPopupWindow.dismiss();

            }
        });
        inflate.findViewById(R.id.xuanzhe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePick();
                mPopupWindow.dismiss();
            }
        });
        inflate.findViewById(R.id.quxiao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();

            }
        });
        inflate.findViewById(R.id.ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        mPopupWindow.showAtLocation(mImg, Gravity.CENTER, 0, 0);
    }

    private void takePick() {//相册Sd卡权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openAlbum();
            mZhanwei.setVisibility(View.GONE);
            mWancheng.setVisibility(View.VISIBLE);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
        }
    }
    private void Paizhao() {
        //打开相机
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
            openCamera();
            mZhanwei.setVisibility(View.GONE);
            mWancheng.setVisibility(View.VISIBLE);
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},100);
        }
    }

    //打开相册
    private void openAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, ALBUM_CODE);
    }
    //开启相机
    private void openCamera() {
        //1.创建空白文件
        mFile = new File(getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
        if (!mFile.exists()){
            try {
                mFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //2.将File文件转换为Uri路径
        //适配7.0
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mImageUri = Uri.fromFile(mFile);
        } else {
            //第二个参数要和清单文件中的配置保持一致
            mImageUri = FileProvider.getUriForFile(this, "com.baidu.upload.provider", mFile);
        }
        //3.启动相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);//将拍照图片存入mImageUri
        startActivityForResult(intent, CAMERA_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == 100){
                openCamera();
            }else if (requestCode == 200) {
                openAlbum();
            }
        }
    }

    private void uploadFile(File mFile) {
        String url = "http://yun918.cn/study/public/file_upload.php";

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), mFile);

        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "H1808B")
                .addFormDataPart("file", mFile.getName(), requestBody)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: "+e.getMessage() );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();
                Gson gson = new Gson();
                    final UpimgBean upLoadBean = gson.fromJson(string, UpimgBean.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (upLoadBean!=null){
                            if (upLoadBean.getCode()==200){
                                Toast.makeText(UpheadportraitActivity.this,upLoadBean.getRes(),Toast.LENGTH_SHORT).show();

                                Glide.with(UpheadportraitActivity.this).load(upLoadBean.getData().getUrl()).into(mImg);
                                Log.e(TAG, "run: "+upLoadBean.getData().getUrl() );
                            }else{
                                Toast.makeText(UpheadportraitActivity.this,upLoadBean.getRes(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_CODE){//拍照

                //显示拍照后的图片
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(mImageUri));
                    mImg.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                //文件上传
                uploadFile(mFile);
            }else if (requestCode == ALBUM_CODE) {//相册

                //1.获取相册中选中的图片的URi路径
                Uri imageUri= data.getData();

                //显示相册中选中的图片
                  try {
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                    mImg.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    mbitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                    mImg.setImageBitmap(mbitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
