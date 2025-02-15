package hexagonnico.reworkedmetals.content.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Armor item override need to apply custom attributes.
 * 
 * @author Nico
 */
public class ModArmorItem extends ArmorItem {
    
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    private final boolean piglinsNeutral;
    
    /**
     * Puts custom attributes in map
     * @param material ModArmorMaterials
     * @param slot EquipmentSlotType
     * @param properties Item.Properties
     */
    public ModArmorItem(ModArmorMaterials material, EquipmentSlotType slot, Item.Properties properties) {
        super(material, slot, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(super.getDefaultAttributeModifiers(slot));
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier("Movement speed", material.getSpeedModifier(), AttributeModifier.Operation.MULTIPLY_BASE));
        this.attributeModifiers = builder.build();
        this.piglinsNeutral = material.isGold();
    }
    
    @Override // Applies attribute modifiers
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot) {
        return slot == this.slot ? this.attributeModifiers : super.getDefaultAttributeModifiers(slot);
    }
    
    @Override // If this is a gold armor
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.piglinsNeutral;
    }
}
