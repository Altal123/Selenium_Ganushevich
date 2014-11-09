package primeNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeN {

    //public static void main(String[] args){
    @Test
    public void isPrimeTest() {
        Assert.assertEquals(isPrime(3), true);

    }

    @Test
    public void isPrime2Test() {
        Assert.assertEquals(isPrime(3), true);

    }

    public static boolean isPrime(int number){
//        int number = 13;
        boolean t = true;

            for(int i=2; i<number; i++){
                if(number % i == 0){
                    return false;
                }
            }
        return true;
        }
    }

//https://github.com/Altal123/gitpractice.git