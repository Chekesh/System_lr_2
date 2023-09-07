import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int min37=10000;
        int max73=0;
        String  chislo;
        try (BufferedReader reader = new BufferedReader(new FileReader("17-342.txt"))){ // делаем проход про фыйлу
            int number;
            while ((chislo=reader.readLine())!=null){ // в цикле находим минимальное кратное 37
                number=Integer.parseInt(chislo);      // и максимальное краиное 73
                if(number<min37 && number%37==0){
                    min37 = number;
                }
                if(number>max73 && number%73==0){
                    max73 = number;
                }
            }
            System.out.println(max73);
            System.out.println(min37);
        }
        catch (IOException ex){    // обработка ошибки
            System.out.println(ex.getMessage());
        }

        int chislo_1=0;
        int sh=0;
        int min_sum=20000;
        int sum=0;
        boolean naprav;
        if(min37<max73){ // смотрим какое число больше и от этого юудет завить по какому пути мы пойдём
            naprav = true;
        }
        else{
            naprav = false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("17-342.txt"))){ // снова идём по списку
            int chislo_2=chislo_1;
            while ((chislo=reader.readLine())!=null){
                chislo_1 = Integer.parseInt(chislo);
                if (naprav){ // если минимальное кратное 37 меньше макмимальному кратному 73
                    if ((min37 < chislo_1 && chislo_1 < max73) && !(min37 < chislo_2 && chislo_2 < max73)) {
                        sh++;                       //в случае нахождениея в промежутке 1 числа
                        sum = chislo_1 + chislo_2;
                        if (sum < min_sum) {
                            min_sum = sum;
                        }
                    }
                    if ((min37 < chislo_2 && chislo_2 < max73) && !(min37 < chislo_1 && chislo_1 < max73)) {
                        sh++;                       //в случае нахождениея в промежутке 2 числа
                        sum = chislo_1 + chislo_2;
                        if (sum < min_sum) {
                            min_sum = sum;
                        }
                    }
                }
                else {  // если  макмимальное кратноме 73 меньше минимальному кратному 37
                    if ((max73 < chislo_1 && chislo_1 < min37) && !(max73 < chislo_2 && chislo_2 < min37)) {
                        sh++;                             //в случае нахождениея в промежутке 1 числа
                        sum = chislo_1 + chislo_2;
                        if (sum < min_sum) {
                            min_sum = sum;
                        }
                    }
                    if ((max73 < chislo_2 && chislo_2 < min37) && !(max73 < chislo_1 && chislo_1 < min37)) {
                        sh++;                          //в случае нахождениея в промежутке 2 числа
                        sum = chislo_1 + chislo_2;
                        if (sum < min_sum) {
                            min_sum = sum;
                        }
                    }
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Колличество пар: " +sh);
        System.out.println("минимальная сумма: " + min_sum);
    }
}