package net.grinner117.grinnersmobs.perks;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class DamageRes4_Perk extends ArmorItem {
    public DamageRes4_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);

    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 3,false, false, true));
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componets, TooltipFlag flag){
        if(Screen.hasShiftDown()){
            componets.add(Component.literal("Damage Resistance 4").withStyle(ChatFormatting.DARK_AQUA));
        } else{
            componets.add(Component.literal("Shift Right click for more Info").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(stack, level, componets,flag);
    }
}