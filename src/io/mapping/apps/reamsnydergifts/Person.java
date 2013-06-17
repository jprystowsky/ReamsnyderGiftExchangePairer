package io.mapping.apps.reamsnydergifts;


public interface Person {
    public String getName();

    public Person setName(String n);

    public Person getPartner();

    public Person setPartner(Person p);

    public Person getPair();

    public Person setPair(Person p);

    public Boolean getWasPaired();

    public Person setWasPaired(Boolean b);

}
