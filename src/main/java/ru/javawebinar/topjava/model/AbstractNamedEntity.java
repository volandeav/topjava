package ru.javawebinar.topjava.model;

public abstract class AbstractNamedEntity extends AbstractBaseEntity{
    protected String Name;

    public AbstractNamedEntity(Integer id, String name) {
        super(id);
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return super.toString()+ "; Name='" + Name ;
    }
}
