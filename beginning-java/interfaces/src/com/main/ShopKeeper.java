package com.main;

public class ShopKeeper extends Person implements Seller {
    public ShopKeeper(String name) {
        super(name);
    }

    @Override
    public String chat() {
        return "Hi, I am a Shop Keeper!";
    }

    @Override
    public void sellGoods() {
        //TODO: Implement selling goods method
    }
}
