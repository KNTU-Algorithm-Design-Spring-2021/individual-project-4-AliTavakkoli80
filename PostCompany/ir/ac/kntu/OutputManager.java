package ir.ac.kntu;

import java.util.ArrayList;

public class OutputManager {
    public void showArray(ArrayList<ArrayList> arrayList){
        System.out.println("Result string will be : ");
        System.out.println(arrayList.toString());

    }
    public void showError(){
        System.out.println("Number of trucks are few ");

    }
}
