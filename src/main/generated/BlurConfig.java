package com.mineblock11.blur;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class BlurConfig extends ConfigWrapper<com.mineblock11.blur.BlurConfigWrapper> {

    private final Option<java.lang.Integer> quality = this.optionForKey(new Option.Key("quality"));
    private final Option<java.lang.Integer> strength = this.optionForKey(new Option.Key("strength"));
    private final Option<io.wispforest.owo.ui.core.Color> tintColor = this.optionForKey(new Option.Key("tintColor"));
    private final Option<java.lang.Float> tintStrength = this.optionForKey(new Option.Key("tintStrength"));

    private BlurConfig() {
        super(com.mineblock11.blur.BlurConfigWrapper.class);
    }

    private BlurConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(com.mineblock11.blur.BlurConfigWrapper.class, janksonBuilder);
    }

    public static BlurConfig createAndLoad() {
        var wrapper = new BlurConfig();
        wrapper.load();
        return wrapper;
    }

    public static BlurConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new BlurConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public int quality() {
        return quality.value();
    }

    public void quality(int value) {
        quality.set(value);
    }

    public int strength() {
        return strength.value();
    }

    public void strength(int value) {
        strength.set(value);
    }

    public io.wispforest.owo.ui.core.Color tintColor() {
        return tintColor.value();
    }

    public void tintColor(io.wispforest.owo.ui.core.Color value) {
        tintColor.set(value);
    }

    public float tintStrength() {
        return tintStrength.value();
    }

    public void tintStrength(float value) {
        tintStrength.set(value);
    }




}

