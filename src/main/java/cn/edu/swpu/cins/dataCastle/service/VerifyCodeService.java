package cn.edu.swpu.cins.dataCastle.service;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by miaomiao on 17-10-6.
 */
public interface VerifyCodeService {

    byte[] getVerifyCode(HttpServletResponse response);
}
