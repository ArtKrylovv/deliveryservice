package com.practical;

public class Main {

    public static void main(String[] args) {

        //invoking objects
        // address
        Address artAddress = new Address("sawtelle", "VA", false);
        Address oxanaAddress = new Address("main", "CA", true);
        Address storeAddress1 = new Address("linkoln", "CA", false);
        Address elonAddress = new Address("electric", "CA", false);
        Address storeAddress2 = new Address("barrington", "CA", false);

        // Customer, Recipient, Employee Classes can be implemented as Child Classes of Person Class
        // customer
        Customer customer1 = new Customer("Art", "Krylov", artAddress);

        // recipient
        Recipient recipient1 = new Recipient("Oxana", "Krylova", oxanaAddress);

        // employee
        Employee employee = new Employee("Elon", "Musk", elonAddress, "CEO");

        // parcel
        int[] package1Dimensions = {5, 5, 5};
        Parcel parcel1 = new Parcel("sneakers", 3, package1Dimensions);


        // order
        Order order1 = new Order(parcel1, customer1, recipient1, oxanaAddress);

        // price
        Price price1 = new Price(Discount.BUSINESS_DISCOUNT);

        // store
        Store store1 = new Store(storeAddress1);
        Store store2 = new Store(storeAddress2);

        // calling custom methods on objects
        // calculating package volume
        System.out.println(parcel1.getVolume());

        // calculating price
        System.out.println(price1.getPrice(order1));

        // getting number of stores (calculated based on # of objects created)
        System.out.println(Store.getNumberOfStores());

        // getting localAddress value (initialized based on State value)
        System.out.println(artAddress.getLocalAddress());
        System.out.println(oxanaAddress.getLocalAddress());
    }

}
