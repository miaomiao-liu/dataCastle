package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.gimpy.FishEyeGimpyRenderer;
import cn.edu.swpu.cins.dataCastle.service.VerifyCodeService;
import cn.edu.swpu.cins.dataCastle.util.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by miaomiao on 17-10-6.
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Autowired
    JedisAdapter jedisAdapter;

    private static final int captchaExpires = 3 * 60;
    private static final int captchaW = 200;
    private static final int captchaH = 60;

    @Override
    public byte[] getVerifyCode(HttpServletResponse response) {

        String uuid = UUID.randomUUID().toString();

        Captcha captcha = new Captcha.Builder(captchaW, captchaH)
                .addText().addBackground(new GradiatedBackgroundProducer(Color.ORANGE, Color.WHITE))
                .gimp(new FishEyeGimpyRenderer())
                .build();

        System.out.println("验证码为    " + captcha.getAnswer());
        //将验证码以<key,value>形式缓存到redis
        jedisAdapter.setex(uuid, captchaExpires, captcha.getAnswer());
        //将验证码key，及验证码的图片返回
        response.addHeader("captcha-code", uuid);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
            //写图片
            ImageIO.write(captcha.getImage(), "png", bao);
            return bao.toByteArray();//获取内存缓冲中的数据

        } catch (IOException e) {
            return null;
        }
    }
}
