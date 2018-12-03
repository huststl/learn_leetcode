package com.huststl.year18.dec.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode 30 Substring with Concatenation of All Words  难度（easy)
public class Main030 {

    public List<Integer> findSubstring(String s,String[] words){

        List<Integer> list = new ArrayList<Integer>();

        if(s==null || s.length() == 0 || words == null || words.length==0){
            return list;
        }

        int sLen = s.length(),wLen = words[0].length(),wsLen = words.length;

        if(sLen < wLen * wsLen)
            return list;

        Map<String,Integer> map = new HashMap<>();//记录words中的每一个字符串的数目
        for(String word:words){
            if(map.containsKey(word))
                map.put(word,map.get(word)+1);

            else
                map.put(word,1);
        }

        for(int i=0;i<wLen;i++){
            int left = i,right = i,window = 0;//窗口的大小和左右边界

            while (right +(wsLen - window) * wLen <= sLen && right+wLen <= sLen){
                String cur = s.substring(right,right+wLen);

                if(map.containsKey(cur)){
                    int cnt = map.get(cur);//当前字符串的个数
                    window++;  //包含当前字符串，窗口大小+1
                    if(cnt > 0){
                        map.put(cur, cnt-1);
                    }else { //map当前字符串个数为0，说明出现重复字符串
                        String removed = s.substring(left,left+wLen);//从窗口左边开始移除字符串

                        while (!removed.equals(cur)){
                            map.put(removed,map.get(removed) + 1);
                            left+= wLen;
                            window--;
                            removed = s.substring(left,left+wLen);
                        }

                        left += sLen;

                        window--;
                    }
                    if(window == sLen){  //窗口大小等于数组长度，匹配成功
                        list.add(left);
                    }
                }else {

                    //恢复map

                    window = 0;

                    while (left<right){
                        String removed = s.substring(left,left+wLen);
                        map.put(removed,map.get(removed)+1);
                        left += wLen;
                    }

                    left+=wLen;//左边跳过当前这一位不匹配的字符串
                }
                right += wLen;//窗口往右拓展一个字符串的长度


            }

            //恢复map
            while (left < right){
                String removed = s.substring(left,left+wLen);
                map.put(removed,map.get(removed) + 1);
                left += wLen;
            }
        }
        return list;

    }
}
