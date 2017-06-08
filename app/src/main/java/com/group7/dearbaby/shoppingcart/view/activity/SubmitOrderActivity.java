package com.group7.dearbaby.shoppingcart.view.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.group7.dearbaby.R;
import com.group7.dearbaby.me.model.bean.UserAddressInfo;
import com.group7.dearbaby.shoppingcart.model.bean.CreateOrder;
import com.group7.dearbaby.shoppingcart.model.utils.MySiyao;
import com.group7.dearbaby.utils.GsonUtils;
import com.group7.dearbaby.utils.SharedPreferenceUtils2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/24 19:41
 */

public class SubmitOrderActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.tv_promotion_notice_show)
    TextView tvPromotionNoticeShow;
    @BindView(R.id.iv_promotion_notice_close)
    ImageView ivPromotionNoticeClose;
    @BindView(R.id.tv_cart2_no_delivery)
    TextView tvCart2NoDelivery;
    @BindView(R.id.tv_cart2_delivery_user)
    TextView tvCart2DeliveryUser;
    @BindView(R.id.tv_cart2_delivery_phone)
    TextView tvCart2DeliveryPhone;
    @BindView(R.id.tv_cart2_delivery_address)
    TextView tvCart2DeliveryAddress;
    @BindView(R.id.ll_cart2_delivery)
    LinearLayout llCart2Delivery;
    @BindView(R.id.tv_cart2_support_pick)
    TextView tvCart2SupportPick;
    @BindView(R.id.iv_cart2_delivery_arrow)
    ImageView ivCart2DeliveryArrow;
    @BindView(R.id.rl_cart2_delivery)
    RelativeLayout rlCart2Delivery;
    @BindView(R.id.tv_cart2_delivery_id_number)
    TextView tvCart2DeliveryIdNumber;
    @BindView(R.id.et_cart2_delivery_id_num)
    EditText etCart2DeliveryIdNum;
    @BindView(R.id.ll_cart2_delivery_id_number)
    RelativeLayout llCart2DeliveryIdNumber;
    @BindView(R.id.solv_cart2)
    View solvCart2;
    @BindView(R.id.tv_pay_name)
    TextView tvPayName;
    @BindView(R.id.tv_cart2_pay_select)
    TextView tvCart2PaySelect;
    @BindView(R.id.tv_pay_msg)
    TextView tvPayMsg;
    @BindView(R.id.iv_pay)
    ImageView ivPay;
    @BindView(R.id.ll_cart2_pay_mode)
    RelativeLayout llCart2PayMode;
    @BindView(R.id.tv_pay_interest)
    TextView tvPayInterest;
    @BindView(R.id.tv_pay_periods)
    TextView tvPayPeriods;
    @BindView(R.id.rl_pay_periods)
    RelativeLayout rlPayPeriods;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    @BindView(R.id.tv_coupon_amount)
    TextView tvCouponAmount;
    @BindView(R.id.tv_coupon_prompt)
    TextView tvCouponPrompt;
    @BindView(R.id.tv_coupon_prompt1)
    TextView tvCouponPrompt1;
    @BindView(R.id.iv_coupon_arrow)
    ImageView ivCouponArrow;
    @BindView(R.id.rl_coupon)
    RelativeLayout rlCoupon;
    @BindView(R.id.tv_card)
    TextView tvCard;
    @BindView(R.id.tv_card_amount)
    TextView tvCardAmount;
    @BindView(R.id.tv_card_prompt)
    TextView tvCardPrompt;
    @BindView(R.id.tv_card_prompt1)
    TextView tvCardPrompt1;
    @BindView(R.id.iv_card_arrow)
    ImageView ivCardArrow;
    @BindView(R.id.rl_card)
    RelativeLayout rlCard;
    @BindView(R.id.tv_cloudDiamond)
    TextView tvCloudDiamond;
    @BindView(R.id.cb_cloudDiamond)
    CheckBox cbCloudDiamond;
    @BindView(R.id.rl_cloudDiamond)
    RelativeLayout rlCloudDiamond;
    @BindView(R.id.tv_invoice_text)
    TextView tvInvoiceText;
    @BindView(R.id.rl_invoice)
    RelativeLayout rlInvoice;
    @BindView(R.id.tv_others_pay)
    TextView tvOthersPay;
    @BindView(R.id.cb_others_pay)
    ImageView cbOthersPay;
    @BindView(R.id.rl_others_pay)
    RelativeLayout rlOthersPay;
    @BindView(R.id.tv_protocol)
    TextView tvProtocol;
    @BindView(R.id.cb_protocol)
    ImageView cbProtocol;
    @BindView(R.id.rl_protocol)
    RelativeLayout rlProtocol;
    @BindView(R.id.tv_product_price)
    TextView tvProductPrice;
    @BindView(R.id.tv_discount_price)
    TextView tvDiscountPrice;
    @BindView(R.id.rl_discount)
    RelativeLayout rlDiscount;
    @BindView(R.id.tv_energy_price)
    TextView tvEnergyPrice;
    @BindView(R.id.rl_energy_price)
    RelativeLayout rlEnergyPrice;
    @BindView(R.id.tv_ship_price)
    TextView tvShipPrice;
    @BindView(R.id.tv_tax_price)
    TextView tvTaxPrice;
    @BindView(R.id.rl_tax_price)
    RelativeLayout rlTaxPrice;
    @BindView(R.id.ll_inner)
    LinearLayout llInner;
    @BindView(R.id.sv_root)
    ScrollView svRoot;
    @BindView(R.id.tv_cart2_pop_delivery_address)
    TextView tvCart2PopDeliveryAddress;
    @BindView(R.id.rl_cart2_pop_address)
    RelativeLayout rlCart2PopAddress;
    @BindView(R.id.tv_cart2_total_price)
    TextView tvCart2TotalPrice;
    @BindView(R.id.tv_cart2_submit)
    TextView tvCart2Submit;
    @BindView(R.id.rl_order_submit)
    RelativeLayout rlOrderSubmit;
    /**
     * 用于拼接订单信息
     */

    // 商户PID
    public static final String PARTNER = "2088901305856832";
    // 商户收款账号
    public static final String SELLER = "8@qdbaiu.com";
    public static String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }
    /**
     * create the order info. 创建订单信息
     *
     */
    public static String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }
    /**
     * 模拟加签
     */
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM" +
            "/KCxg/OIj6er2GEig0DOkHqBSzEPHGigMbTXP1k2nrxEHeE59xOOuy" +
            "ovQH/A1LgbuVKyOac3uAN4GXIBEoozRVzDhu5dobeNm48BPcpYSAfvN3K" +
            "/5GLacvJeENqsiBx8KufM/9inlHaDRQV7WhX1Oe2ckat1EkdHwxxQgc" +
            "36NhAgMBAAECgYEAwn3sWpq6cUR65LD8h9MIjopTImTlpFjgz72bhsHD" +
            "ZK6A+eJDXcddrwh7DI34t/0IBqu+QEoOc/f0fIEXS9hMwTvFY59XG7M8" +
            "M6SdeaAbemrGmZ1IdD6YDmpbQFHn2ishaYF0YDZIkBS3WLDFrtk/efaar" +
            "BCpGAVXeEiVQE4LewECQQD5W1rpkq+dHDRzzdtdi1bJ479wun5CfmVDV" +
            "b2CJH7Iz0t8zyp/iEVV2QELnxZMphmoSzKaLXutTTj2OImpzCtRAkEA1" +
            "VMxG6nQq9NkU51H1+I3mlUXRZ0XeFA1GFJ7xWpNRAVhEWlDz2zy9v/g" +
            "X+RFpNC3f5uznycas70Xp78ew43TEQJAZFFqi9mlqTF1sLk67bFnIyX" +
            "rGPEOZrXvC13tNfR0xVkQZ4/46wHp0xXQo9pG4GNaoyhNnVV7EkelCPn" +
            "J+HPZYQJAQh6T9QgQZoGR8hyovPAf3dUL7oa/VIo/urcuJ8VIB5JHQNdI" +
            "rk0NjaNHj1E4iNosVgATj3vWWel9IIArb99QkQJAKvfm78lwnImtg5IM6" +
            "04hdn/Wu1XF8tpxsKLWcnfchMr0bM9rCmKmhAY+wdmqSyPZRiNb1QaaaD" +
            "TqJxLy6AnQ+Q==";
    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content
     *            待签名订单信息
     */
    public static String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }
    public static String getTotalInfo(String orderInfo, String signInfo){
        //拼装最终的支付信息
        StringBuffer sb = new StringBuffer(orderInfo);
        sb.append("&sign=\"");
        sb.append(signInfo);
        sb.append("\"&");
        sb.append(getSignType());
        final String payInfo = sb.toString();//获得最终的支付信息
        return payInfo;
    }
    /**
     * get the sign type we use. 获取签名方式
     *
     */
    public static String getSignType() {
        return "sign_type=\"RSA\"";
    }

    public static String getSignInfo(String orderInfo){
        String sign = sign(orderInfo);
        //通过URLEncoder进行编码
        try {
            sign = URLEncoder.encode(sign, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sign;
    }
    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     *
     */
    /**
     * 支付宝支付业务：入参app_id
     */
    public static final String APPID = "";

    /**
     * 支付宝账户登录授权业务：入参pid值
     */
    public static final String PID = "2017052307321911";
    /**
     * 支付宝账户登录授权业务：入参target_id值
     */
    public static final String TARGET_ID = "";

    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /**
     * 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1
     */
    public static final String RSA2_PRIVATE = MySiyao.SiYao;


    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
                        switch (msg.what) {
                                case SDK_PAY_FLAG: {
                                      PayResult payResult = new PayResult((String) msg.obj);
                                        /**
                                          * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                                          * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                                          * docType=1) 建议商户依赖异步通知
                                          */
                                        String resultInfo = payResult.getResult();// 同步返回需要验证的信息


                                        String resultStatus = payResult.getResultStatus();
                                        // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                                        if (TextUtils.equals(resultStatus, "9000")) {
                                                 Toast.makeText(SubmitOrderActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                                             } else {
                                                 // 判断resultStatus 为非"9000"则代表可能支付失败
                                                 // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                                                 if (TextUtils.equals(resultStatus, "8000")) {
                                                        Toast.makeText(SubmitOrderActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();


                                                    } else {
                                                        // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                                                        Toast.makeText(SubmitOrderActivity.this, "支付失败", Toast.LENGTH_SHORT).show();


                                                    }
                                           }
                                       break;
                                    }
                              default:
                                       break;
                            }
                    }



    };
    private CreateOrder co;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);
        ButterKnife.bind(this);
        inidClicklitener();
       String order= getIntent().getStringExtra("order");
        co = GsonUtils.jsonToBean(order, CreateOrder.class);
        String receiveInfo=(String)  SharedPreferenceUtils2.
                get(this,"receiveInfo", "");
        if(!TextUtils.isEmpty(receiveInfo)){
            UserAddressInfo userInfo = GsonUtils.jsonToBean(receiveInfo, UserAddressInfo.class);
            tvCart2DeliveryUser.setText(userInfo.getReceiveName());
            tvCart2DeliveryPhone.setText(userInfo.getReceivePhone());
            tvCart2DeliveryAddress.setText(userInfo.getReceiveAddress());
        }


    }

    private void inidClicklitener() {
        tvCart2Submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cart2_submit:
                if (TextUtils.isEmpty(PID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
                    new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialoginterface, int i) {
                                    //
                                    finish();
                                }
                            }).show();
                    return;
                }

                /**
                 * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
                 * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
                 * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
                 *
                 * orderInfo的获取必须来自服务端；
                 */
                boolean rsa2 = (RSA2_PRIVATE.length() > 0);
                Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
              //  params.put("seller_id","15830843320");
//                if (co!=null)
//             params.put("out_trade_no",co.getId());
//
//             params.put("subject","零食商品");
//params.put("body","热锅零食，好好的食品都放坏了");
           //     params.put("notify_url","\"" + "http://notify.msp.hk/notify.htm" + "\"");

             //   params.put("service","\"mobile.securitypay.pay\"");

             //   params.put("total_fee",""+0.1);
//
//                params.put("payment_type","\"1\"");
//                params.put("_input_charset","\"utf-8\"");
//                params.put("it_b_pay","\"30m\"");
//
//                params.put("return_url","\"m.alipay.com\"");
                // 设置未付款交易的超时时间
                // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
                // 取值范围：1m～15d。
                // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
                // 该参数数值不接受小数点，如1.5h，可转换为90m。
               // orderInfo += "&it_b_pay=\"30m\"";

                // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
                // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

                // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
              //  orderInfo += "&return_url=\"m.alipay.com\"";
                String orderInfo = getOrderInfo("测试的商品", "该测试商品的详细描述", "0.01");


                /**
             * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
             */
                      String sign = sign(orderInfo);
                       try {
                           /**
                             * 仅需对sign 做URL编码
                             */
                           sign = URLEncoder.encode(sign, "UTF-8");
                       } catch (UnsupportedEncodingException e) {
                           e.printStackTrace();
                       }


               /**
             110  * 完整的符合支付宝参数规范的订单信息
             111  */
                        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();


                        Runnable payRunnable = new Runnable() {


          @Override
  public void run() {
                                   // 构造PayTask 对象
                                   PayTask alipay = new PayTask(SubmitOrderActivity.this);
                                   // 调用支付接口，获取支付结果
                                   String result = alipay.pay(payInfo, true);


                                   Message msg = new Message();
                                   msg.what = SDK_PAY_FLAG;
                                   msg.obj = result;
                                   mHandler.sendMessage(msg);
                               }
        };


               // 必须异步调用
                       Thread payThread = new Thread(payRunnable);
                       payThread.start();

        }
    }
}
