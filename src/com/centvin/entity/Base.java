package com.centvin.entity;

import java.sql.ResultSet;

/**
 * Created by vinco on 15-4-3.
 * Base entity class.
 */
abstract public class Base implements Cloneable{
    abstract public void setData(ResultSet resultSet);

    @Override
    public Base clone() throws CloneNotSupportedException {
        Base b = (Base) super.clone();

        return b;
    }
}
