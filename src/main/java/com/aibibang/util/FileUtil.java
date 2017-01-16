package com.aibibang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 
* @author: Truman.P.Du 
* @since: 2016年11月25日 下午8:28:14 
* @version: v1.0
* @description:
*/
public class FileUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 /**  
     * 读取文件创建时间  
     */    
    public static String getCreateTime(String filePath){       
        String strTime = null; 
        InputStream is=null;
        Process p=null;
        try {    
           p = Runtime.getRuntime().exec("cmd /C dir "             
                    + filePath    
                    + "/tc" );    
            is = p.getInputStream();     
            BufferedReader br = new BufferedReader(new InputStreamReader(is));               
            String line;    
            while((line = br.readLine()) != null){    
                if(line.endsWith(".txt")){    
                    strTime = line.substring(0,17);    
                    break;    
                }                               
             }
            
        } catch (IOException e) {    
            //e.printStackTrace();    
        } finally{
        	try {
				is.close();
				p.destroy();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
        	
        }
        System.out.println("创建时间    " + strTime);   
        return strTime;  
    }    
}
