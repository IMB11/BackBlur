package com.mineblock11.blur;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RangeConstraint;
import io.wispforest.owo.ui.core.Color;
import org.jetbrains.annotations.Range;

@Modmenu(modId = "back-blur")
@Config(name = "back-blur", wrapperName = "BlurConfig")
public class BlurConfigWrapper {
    @RangeConstraint(min = 1, max = 32)
    public int quality = 3;
    @RangeConstraint(min = 1, max = 32)
    public int strength = 5;
    public Color tintColor = Color.BLACK;
    @RangeConstraint(min = 0.0f, max = 1.0f)
    public float tintStrength = 0.0f;
}
