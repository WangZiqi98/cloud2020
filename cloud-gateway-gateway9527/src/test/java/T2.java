import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
//        ZonedDateTime zbj=ZonedDateTime.now();
//        System.out.println(zbj);

//        String today= DateUtil.today();
//        System.out.println(today);

//        BufferedInputStream in = FileUtil.getInputStream("d:/test.txt");
//        BufferedOutputStream out = FileUtil.getOutputStream("d:/test2.txt");
//        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);


//        String content = "王子奇";
//
////随机生成密钥
//        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
//
////构建
//        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
//
////加密
//        byte[] encrypt = aes.encrypt(content);
////解密
//        byte[] decrypt = aes.decrypt(encrypt);
//
////加密为16进制表示
//        String encryptHex = aes.encryptHex(content);
////解密为字符串
//        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
//        System.out.println(encryptHex);
//        System.out.println(decryptStr);

//        final File[] ds = FileUtil.ls("D:/");
////        for (File file : ds) {
////            System.out.println(file.getPath());
////        }

        String template = "{}爱{}，就像老鼠爱大米";
        String str = StrUtil.format(template, "我hha ", "你hha "); //str -> 我爱你，就像老鼠爱大米
        System.out.println(str);

        }

    }

