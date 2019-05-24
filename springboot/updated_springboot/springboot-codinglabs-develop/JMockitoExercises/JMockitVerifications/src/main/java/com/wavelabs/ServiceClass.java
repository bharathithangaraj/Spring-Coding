package com.wavelabs;

public class ServiceClass extends DaoClass {
    @Override protected boolean isRendered() {
        final boolean rendered = super.isRendered();
        if (! rendered) { generateHiddenFlag(); }
        return rendered;
    }

    protected void generateHiddenFlag() {
        System.out.println("real generateHiddenFlag() called");
    }
}
