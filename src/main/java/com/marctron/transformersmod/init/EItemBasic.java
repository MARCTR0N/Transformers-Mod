package com.marctron.transformersmod.init;

public enum EItemBasic
{
    
    BULLET("bullet");

    public String name;
    public static final String[] allNames;

    static
    {
        allNames = new String[EItemBasic.values().length];
        for(EItemBasic e : EItemBasic.values())
            allNames[e.ordinal()] = e.name;
    }

    EItemBasic(String name)
    {
        this.name = name;
    }
}