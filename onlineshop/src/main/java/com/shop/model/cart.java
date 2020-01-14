package com.shop.model;

import java.util.ArrayList;
import java.util.Date;

public class cart {
    private int cartid;
    private ArrayList includes;

    public cart(int cartid, ArrayList includes) {
        this.cartid = cartid;
        this.includes = includes;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public ArrayList getIncludes() {
        return includes;
    }

    public void setIncludes(ArrayList includes) {
        this.includes = includes;
    }
}
