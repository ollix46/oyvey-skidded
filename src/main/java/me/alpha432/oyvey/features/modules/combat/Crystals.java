package net.masuno.mixin;

import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.masuno.MaceMixin;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1774;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1838;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_1774.class})
public class EndCrystalItemMixin {
    private class_243 getPlayerLookVec(class_1657 class_16572) {
        float f = (float)Math.PI / 180;
        float f2 = (float)Math.PI;
        float f3 = class_3532.method_15362((float)(-class_16572.method_36454() * f - f2));
        float f4 = class_3532.method_15374((float)(-class_16572.method_36454() * f - f2));
        float f5 = -class_3532.method_15362((float)(-class_16572.method_36455() * f));
        float f6 = class_3532.method_15374((float)(-class_16572.method_36455() * f));
        return new class_243((double)(f4 * f5), (double)f6, (double)(f3 * f5)).method_1029();
    }

    private class_243 getClientLookVec() {
        return this.getPlayerLookVec((class_1657)MaceMixin.b.field_1724);
    }

    private boolean isBlock(class_2248 class_22482, class_2338 class_23382) {
        return this.getBlockState(class_23382).method_26204() == class_22482;
    }

    private class_2680 getBlockState(class_2338 class_23382) {
        return MaceMixin.b.field_1687.method_8320(class_23382);
    }

    private boolean canPlaceCrystalServer(class_2338 class_23382) {
        class_2680 class_26802 = MaceMixin.b.field_1687.method_8320(class_23382);
        if (!class_26802.method_27852(class_2246.field_10540) && !class_26802.method_27852(class_2246.field_9987)) {
            return false;
        }
        class_2338 class_23383 = class_23382.method_10084();
        if (!MaceMixin.b.field_1687.method_22347(class_23383)) {
            return false;
        }
        double d = class_23383.method_10263();
        double d2 = class_23383.method_10264();
        double d3 = class_23383.method_10260();
        List list = MaceMixin.b.field_1687.method_8335(null, new class_238(d, d2, d3, d + 1.0, d2 + 2.0, d3 + 1.0));
        return list.isEmpty();
    }

    @Inject(method={"useOnBlock"}, at={@At(value="HEAD")}, cancellable=true)
    private void modifyDecrementAmount(class_1838 class_18382, CallbackInfoReturnable<class_1269> callbackInfoReturnable) {
        class_3965 class_39652;
        class_2338 class_23382;
        class_239 class_2392;
        class_243 class_2432;
        class_3965 class_39653;
        class_1799 class_17992 = MaceMixin.b.field_1724.method_6047();
        if (class_17992.method_31574(class_1802.field_8301) && (this.isBlock(class_2246.field_10540, (class_39653 = MaceMixin.b.field_1687.method_17742(new class_3959(class_2432 = MaceMixin.b.field_1724.method_33571(), class_2432.method_1019(this.getClientLookVec().method_1021(4.5)), class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)MaceMixin.b.field_1724))).method_17777()) || this.isBlock(class_2246.field_9987, class_39653.method_17777())) && (class_2392 = MaceMixin.b.field_1765) instanceof class_3965 && this.canPlaceCrystalServer(class_23382 = (class_39652 = (class_3965)class_2392).method_17777())) {
            class_18382.method_8041().method_7934(-1);
        }
    }
}
