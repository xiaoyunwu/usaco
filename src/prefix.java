import java.io.*;
import java.lang.Integer;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Exchanger;
/*
ID: xiaoyun4
LANG: JAVA
TASK: prefix
*/

public class prefix {

    public static void print(boolean[] x){
        for(boolean m:x){
            if(m) {
                System.out.print(1);
            }else{
                System.out.print(0);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        ArrayList<String> prim = new ArrayList<String>();
        String line = f.readLine();
        while(!line.equals(".")) {
            //System.out.println(line);
            StringTokenizer st= new StringTokenizer(line);
            while(st.hasMoreTokens()){
                prim.add(st.nextToken());
            }
            line = f.readLine();
        }
        //String x = f.readLine();
        String compare = "";
        String nextLine = f.readLine();
        while(nextLine!=null){

            compare+=nextLine;
            nextLine = f.readLine();
        }

        boolean[] everything = new boolean[compare.length()];
        for(int i = 0; i<prim.size();i++){
            String primi = prim.get(i);
            //System.out.println(compare+" "+primi);
            outerloop:
            for(int j = 0; j<=compare.length()-primi.length();j++){
                System.out.println(compare.substring(j,j+primi.length())+" "+primi);
                if(compare.substring(j,j+primi.length()).equals(primi)){
                    for(int k = j ; k<j+primi.length();k++){
                        if(!everything[k]) {
                            everything[k] = true;
                        }else{
                            continue outerloop;
                        }
                    }
                }
                print(everything);
            }
        }
        //System.out.println(everything);
        //print(everything);


        //int max = 0;
        int sum = 0;
        for(boolean i :everything){
            if(i==true){
                sum++;
            }else{
                break;
            }
        }
        out.println(sum);


        //System.out.println(sum("010"));


        //int[] l = {0,1,0};
        //int[] k = {1,0,1};
        //ArrayList<confg> test = new ArrayList<confg>();
        //test.add(new confg(l,0));
        //test.add(new confg(k,0));
        //quicksort(0, 1,test);

        //System.out.println(everything.contains(x));









        //out.println(i);

        out.close();
        System.exit(0);



    }
}