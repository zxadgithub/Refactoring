package com.zxa.refactor.chapter1;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/7/29 15:33
 */

public class MainClass {

    public static void main(String[] args) {
        // 三部影片
        Movie movie1 = new Movie("复仇者联盟", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("超能陆战队", Movie.CHILDREN);
        Movie movie3 = new Movie("澳门风云", Movie.REGULAR);

        //两名顾客
        Customer customer1 = new Customer("Jack");
        Customer customer2 = new Customer("Stary");

        //顾客租约
        Rental rental1 = new Rental(movie1, 5);
        Rental rental2 = new Rental(movie2, 3);
        Rental rental3 = new Rental(movie3, 3);
        customer1.addRentals(rental1);
        customer1.addRentals(rental2);
        customer2.addRentals(rental2);
        customer2.addRentals(rental3);

        String statement1 = customer1.statement();
        String statement2 = customer2.statement();
        System.out.println(statement1);
        System.out.println("-----------------------");
        System.out.println(statement2);

    }
}