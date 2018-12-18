package com.huststl.year18.dec.day18;

import java.util.*;

//leetcode 49  Group Anagrams ---- java 难度（medium)
public class Main049 {

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> list = new ArrayList<List<String>>();
        int len = strs.length;

        if(len < 1)
            return list;

        Map<String,List<String>> map = new HashMap<String,List<String>>();

        String tmp = "";
        for(int i=0;i<len;i++){
            tmp = strs[i];

            char[] arrayOfString = tmp.toCharArray();

            Arrays.sort(arrayOfString);

            tmp = new String(arrayOfString);

            if(map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }else {
                List<String> item = new ArrayList<String>();
                item.add(strs[i]);
                map.put(tmp,item);
            }
        }

        for(List<String> value:map.values()){
            list.add(value);
        }

        return list;
    }

}
