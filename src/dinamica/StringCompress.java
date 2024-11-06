package dinamica;

import java.nio.charset.StandardCharsets;

public class StringCompress {


    public static void main(String[] args) {
        StringCompress sc = new StringCompress();
        String result = sc.compressedString("mrm");
        System.out.println("result = " + result);
    }


    public String compressedString(String word) {
        String result = "";

        for(Character c: word.toCharArray()){
              int lenght = word.length();
              word = word.replace(c+"", "");
              int change = lenght - word.length();
              if(change/9>0){
                  for(int i=0; i<change/9;i++){
                      result+= 9+""+c ;
                  }
              }
              if(change%9 > 0){

                  String append = change%9+""+c;
                  if(result.contains(c+"")){
                    int firstIndex = result.indexOf(c);
                    if(result.indexOf(firstIndex-1) < 9){

                    }
                  }

              }

        }

        return result;
    }

}
