package CalculatorTest;

import java.util.TreeMap;

public class ConverterR {

    TreeMap<Character,Integer> rimKeyMap = new TreeMap<>();
    TreeMap<Integer,String> aKeyMap = new TreeMap<>();


     public ConverterR() {

         rimKeyMap.put('I',1);
         rimKeyMap.put('V',5);
         rimKeyMap.put('X',10);

         aKeyMap.put(10, "X");
         aKeyMap.put(9, "IX");
         aKeyMap.put(5, "V");
         aKeyMap.put(4, "IV");
         aKeyMap.put(1, "I");
     }


     public boolean isRim(String str){
         return rimKeyMap.containsKey(str.charAt(0));
     }


     public String intToRim (int num){
         java.lang.String rim = "";
         int arab;
         do{
             arab = aKeyMap.floorKey(num);
             rim += aKeyMap.get(arab);
             num -= arab;
         }while (num != 0);
         return rim;

     }


     public int rimToInt (String s){
         int e = s.length() -1;
         char[] a = s.toCharArray();
         int arab;
         int result = rimKeyMap.get(a[e]);
         for (int i = e -1; i >= 0; i--){
             arab = rimKeyMap.get(a[i]);
             if(arab<rimKeyMap.get(a[i])){
                 result -= arab;
             }else{
                 result += arab;
             }
         }
         return result;
     }
}

