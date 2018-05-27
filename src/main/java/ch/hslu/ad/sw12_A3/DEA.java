package ch.hslu.ad.sw12_A3;

public class DEA {

    public static boolean isWordLanguage(final String string){
        int currentState = 0;
        String [] stringArray = string.split("");
        String one = "1";
        String zero = "0";

        for (String s : stringArray) {
            switch (currentState){
                case 0:
                    if (s.equals(zero)){
                        currentState = 1;
                    } else {
                        return false;
                    }
                    break;
                case 1:
                    if (s.equals(one)){
                        currentState = 2;
                    }else {
                        return false;
                    }
                    break;
                case 2:
                    if (s.equals(one)){
                        currentState = 3;
                    }else if (s.equals(zero)) {
                        currentState = 4;
                    }
                    break;
                case 3:
                    if (s.equals(one)){
                        currentState = 2;
                    }else  {
                        return false;
                    }
                    break;
                case 4:
                    if (s.equals(one)){
                        currentState = 2;
                    }else {
                        return false;
                    }
                    break;
            }
        }
        return currentState == 4 || currentState == 1;
    }
}
