package com.calorie.calc.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.StrictMode;

import com.calorie.calc.R;

public class ShareHandler {
    public static void send(Context context, String url)
    {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Intent shareIntent;
       /* String path;
        File dir = new File(context.getExternalFilesDir (Environment.DIRECTORY_PICTURES), "greentuber.jpg");
        FileOutputStream fOut = null;
        try {
            dir.createNewFile();
            fOut = new FileOutputStream(dir);
            icon.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        path=dir.getAbsolutePath();*/
      //  Uri bmpUri = Uri.parse("file://"+path);
        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     //   shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);


        shareIntent.putExtra(Intent.EXTRA_TEXT,context.getString(R.string.share1) +
                url +
                context.getString(R.string.share3) +  "\n"  +" https://play.google.com/store/apps/details?id=" +context.getPackageName());
        shareIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(shareIntent,"Share with"));
    }
    private static void sendCode(Context context, String code)
    {
        Bitmap originalBItmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.share);
        Bitmap mutableBitmap = originalBItmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(mutableBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize((int) (19 * 10));
        paint.setTextScaleX(1.1f);
        paint.setStrokeWidth(2.0f);
        Rect bounds = new Rect();
        paint.getTextBounds(code, 0, code.length(), bounds);
        int x = (mutableBitmap.getWidth())/2-bounds.width()/2 ;
        int y = mutableBitmap.getHeight()/10*9 ;
        canvas.drawText(code, x , y , paint);
       // send(context,mutableBitmap,code);

    }
}
