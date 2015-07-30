package org.fenixedu.demo.domain;

import org.fenixedu.bennu.core.domain.Bennu;
import org.joda.time.DateTime;

import pt.ist.fenixframework.Atomic;

public class Todo extends Todo_Base {

    public Todo(String text) {
        super();
        setText(text);
        setBennu(Bennu.getInstance());
    }

    @Atomic
    public void delete() {
        setBennu(null);
        super.deleteDomainObject();
    }

    public void toggle() {
        setCompleted(getCompleted() == null ? new DateTime() : null);
    }
}
