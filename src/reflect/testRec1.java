package reflect;
import collection.Hero;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class testRec1 {
    public static void main(String[] args) {
        List<String> ls = getList("E:\\JavaProject\\javatest\\src\\reflect\\hero.config");
        APHero ap =(APHero) getHero(ls,0);
        ADHero ad = (ADHero)getHero(ls,2);
        try{
            Method m = ap.getClass().getMethod("setName", String.class);
            m.invoke(ap,ls.get(1));
            m.invoke(ad,ls.get(3));
            Method att = ap.getClass().getMethod("attackHero", Hero.class);
            att.invoke(ad,ap);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static List<String> getList(String pathName){
        List<String> ls = new ArrayList<>();
        File file = new File(pathName);
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ){
            String line=null;
            while((line=br.readLine())!=null){
                ls.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ls;
    }
    public static Hero getHero(List<String> ls,int index){
        Hero h=null;
        try{
            Class<?> pclass = Class.forName(ls.get(index));
            Constructor<?> c = pclass.getConstructor();
            h = (Hero) c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return h;
    }
}
