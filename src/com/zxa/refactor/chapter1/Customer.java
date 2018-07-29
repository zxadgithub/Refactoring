package com.zxa.refactor.chapter1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Description:
 * @Author: zhangxin_an
 * @CreateDate: 2018/7/29 15:30
 */
public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Vector<Rental> getRentals() {
        return rentals;
    }

    public void addRentals(Rental rental) {
        this.rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPointers = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        String result = "Rental Records for " + getName() + "\n";

        while (rentalEnumeration.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentalEnumeration.nextElement();

            // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDayRented() > 2) {
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDayRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDayRented() > 3) {
                        thisAmount += (each.getDayRented() - 3) * 1.5;
                    }
                    break;
            }

            // add frequent renter points
            frequentRenterPointers++;
            // add bonus for two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
                frequentRenterPointers++;
            }

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;

        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPointers + " frequent renter points";
        return result;
    }
}

