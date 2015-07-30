package org.fenixedu.demo.domain;

public class Todo extends Todo_Base {

    public Todo() {
        super();
    }

    public void delete() {
        setBennu(null);
        super.deleteDomainObject();
    }
}
