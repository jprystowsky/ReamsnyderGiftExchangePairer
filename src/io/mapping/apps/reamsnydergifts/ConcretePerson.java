package io.mapping.apps.reamsnydergifts;

public class ConcretePerson implements Person {

    private String mName;
    private Person mPartner;
    private Person mPair;
    private boolean mWasPaired;

    public static Person newPerson(String name) {
        return new ConcretePerson(name);
    }

    public static void partnerMutually(Person p1, Person p2) {
        p1.setPartner(p2);
        p2.setPartner(p1);
    }

    public ConcretePerson() {
    }

    private ConcretePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public Person setName(String name) {
        this.mName = name;
        return this;
    }

    @Override
    public Person getPartner() {
        return mPartner;
    }

    @Override
    public Person setPartner(Person partner) {
        if (partner != this.mPair) {
            this.mPartner = partner;
        }
        return this;
    }

    @Override
    public Person getPair() {
        return this.mPair;
    }

    @Override
    public Person setPair(Person pair) {
        if (pair != this.mPartner) {
            this.mPair = pair;
            pair.setWasPaired(Boolean.TRUE);
        }
        return this;
    }

    @Override
    public Boolean getWasPaired() {
        return mWasPaired;
    }

    @Override
    public Person setWasPaired(Boolean wasPaired) {
        this.mWasPaired = wasPaired;
        return this;
    }

    public boolean isPaired() {
        return this.mPair != null;
    }

    @Override
    public String toString() {
        return String.format("%s is assigned %s", this.mName, this.mPair.getName());
    }

}
