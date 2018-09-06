package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.vaadin.external.jsoup.Jsoup;
import com.vaadin.external.jsoup.nodes.Document;
import com.vaadin.external.jsoup.nodes.Element;
import com.vaadin.external.jsoup.select.Elements;

import static util.alias.Print.*;

public class TranslateUtil{
	 private final static String PreUrl="http://www.baidu.com/s?wd=";                        //百度搜索URL
	 private final static String TransResultStartFlag="<span class=\"op_dict_text2\">";      //翻译开始标签
	 private final static String TransResultEndFlag="</span>"; 
	 /**
	  * 中文翻译成英文
	  * @param urlString
	  * @return
	  * @throws Exception
	  */
	 public static String getTranslateResult(String urlString) throws Exception {    //传入要搜索的单词
	        URL url = new URL(PreUrl+urlString+"翻译");            //生成完整的URL
	        // 打开URL
	        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	        // 得到输入流，即获得了网页的内容
	        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	        String preLine="";
	        String line;
	        int flag=1;
	        // 读取输入流的数据，并显示
	        String content="";          //翻译结果
	        while ((line = reader.readLine()) != null) {            //获取翻译结果的算法
	            if(preLine.indexOf(TransResultStartFlag)!=-1&&line.indexOf(TransResultEndFlag)==-1){
	                content+=line.replaceAll("　| ", "")+"\n";   //去电源代码上面的半角以及全角字符
	                flag=0;
	            }
	            if(line.indexOf(TransResultEndFlag)!=-1){
	                flag=1;
	            }
	            if(flag==1){
	                preLine=line;
	            }
	        }
	       
	        return content.substring(content.indexOf(">")+1, content.indexOf("</a"));//返回翻译结果
	    }
	/* public static String getTranslateResult(String urlString) throws Exception {    //传入要搜索的单词
	       Document doc=Jsoup.connect(PreUrl+urlString).get();
	       System.out.println(doc);
	       Elements element=doc.select(".op_dict_text2 a");
	       if(element.size()>0){
	    	  return element.get(0).text();
	       }
	       return null;
	    }*/
	 
}
