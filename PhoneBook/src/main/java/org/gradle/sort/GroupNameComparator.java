package org.gradle.sort;

import java.util.Comparator;

public class GroupNameComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		int len1 = s1.length();
        int len2 = s2.length();
        int lim = Math.min(len1, len2);
        char v1[] = s1.toCharArray();
        char v2[] = s2.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                if(isKorean(c1)&&isKorean(c2)){
                	return c1-c2;
                } else if(isKorean(c1)&&!isKorean(c2)){
                	return -1;
                } else if(!isKorean(c1)&&isKorean(c2)){
                	return 1;
                } else {
                	if(isEnglish(c1)&&isEnglish(c2)){
                		return c1-c2;
                	} else if(isEnglish(c1)&&!isEnglish(c2)){
                		return -1;
                	} else if(!isEnglish(c1)&&isEnglish(c2)){
                		return 1;
                	} else {
                		return c1-c2;
                	}
                }
            }
            k++;
        }
        return len1 - len2;
	}
	
	private boolean isKorean(char ch){
		return ch>='가' && ch<='힣';
	}
	private boolean isEnglish(char ch){
		return (ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z');
	}
}
