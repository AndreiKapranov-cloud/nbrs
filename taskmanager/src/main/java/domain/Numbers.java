package domain;

public class Numbers {

    private int number;
    public int getNumber(){
        return this.number;
    }
    public void setNumber(int number){
        if(number > -2147483648 && number <2147483647)
            this.number = number;
    }
}


