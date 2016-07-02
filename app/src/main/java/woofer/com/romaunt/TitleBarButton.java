package woofer.com.romaunt;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * Created by YOURFATHERME on 2016/5/17.
 */
public class TitleBarButton extends RelativeLayout {

    private TextView tvContent;
    private ImageView ivImg;

    private LayoutParams ivParams;
    private LayoutParams tvParams;

    private Context context;

    private final static int TYPE_IMG = 0;
    private final static int TYPE_TEXT = 1;

    public TitleBarButton(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {
        tvContent = new TextView(context);
        ivImg = new ImageView(context);

        tvContent.setGravity(Gravity.CENTER);
    }

    private void initParams(int type) {
        if (type == TYPE_IMG && ivParams == null) {
            ivParams = new LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            addView(ivImg, ivParams);
        }
        if (type == TYPE_TEXT && tvParams == null) {
            tvParams = new LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            addView(tvContent, tvParams);
        }
    }

    public void setImageResource(int resId) {
        if (resId == 0) {
            return;
        }
        initParams(TYPE_IMG);
        ivImg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ivImg.setBackgroundColor(Color.parseColor("#00000000"));
        ivImg.setImageResource(resId);
        this.setText("");
    }

    public void setText(CharSequence text) {
        initParams(TYPE_TEXT);
        tvContent.setText(text);
        this.setImageResource(0);
    }

    public void setTextColor(int color) {
        initParams(TYPE_TEXT);
        tvContent.setTextColor(color);
    }

    public void setTextSize(float size) {
        initParams(TYPE_TEXT);
        tvContent.setTextSize(size);
    }

}
