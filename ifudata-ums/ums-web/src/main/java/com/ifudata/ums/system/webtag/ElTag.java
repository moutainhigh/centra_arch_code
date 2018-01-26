package com.ifudata.ums.system.webtag;

public class ElTag {
    /**
     * 分转元
     * @param fen
     * @return
     * @author moubd
     */
    public static String fenToYuan(String fen){   
        long temp = Long.parseLong(fen);
        long mod= temp%100;
        if(temp>=0){
            if(mod<10){
                return temp/100+".0"+temp%100;
            }else if(mod==0){
                return temp/100+".00";
            }else{
                return temp/100+"."+temp%100;
            }  
        }else{
            temp = temp*-1;
            if(mod<0){
                mod = mod*-1;
            }
            if(mod<10){
                return "-"+temp/100+".0"+temp%100;
            }else if(mod==0){
                return "-"+temp/100+".00";
            }else{
                return "-"+temp/100+"."+temp%100;
            } 
        }
    }
    /**
     * 元转分
     * @param yuan
     * @return
     * @author moubd
     */
    public static String yuanToFen(String yuan){
        String temp = yuan.replace(".", "");
        return Long.parseLong(temp)+"";
    }
    
    /**
     * 分转元，分形式如： 800.00
     * @param fen
     * @author lixc
     * @return
     */
    public static String fenToYuan2(String fen){
    	if(fen.indexOf(".") != -1){
    		String tempFen = fen.substring(0,fen.indexOf("."));
    		return fenToYuan(tempFen);
    	}else{
    		return fenToYuan(fen);
    	}
    }
    
    /**
     * 厘转元
     * @param li
     * @author lixc
     * @return
     */
    public static String liToYuan(String li){
        long temp = Long.parseLong(li);
        long mod= temp%1000;
        if(mod<100 && mod>0){
            return temp/1000+".0"+temp%1000;
        }else if(mod==0){
            return temp/1000+".00";
        }else{
            return temp/1000+"."+temp%1000;
        } 
    }
    
}
