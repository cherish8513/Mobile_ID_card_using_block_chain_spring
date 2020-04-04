package com.trashteam.tool;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Random;
//개인키 생성
@Component
public class GenerateKey {
    private int length;
    private String privateKey;

    public GenerateKey(){
        length = 10;
    }

    public String getPrivateKey(){
        privateKey = getRandomString(length);
        return privateKey;
    }

    private static String getRandomString(int length)
    {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();

        String string ="0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
        String chars[] = string.split(",");

        for (int i=0 ; i<length; i++)
            buffer.append(chars[random.nextInt(chars.length)]);
        return buffer.toString();
    }
}