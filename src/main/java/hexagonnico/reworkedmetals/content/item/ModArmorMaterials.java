package hexagonnico.reworkedmetals.content.item;

import hexagonnico.reworkedmetals.registry.ItemsRegistry;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

/**
 * Armor tier enum.
 * @author Nico
 */
public enum ModArmorMaterials implements IArmorMaterial {
    COPPER("copper", 15, new int[] {1, 4, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 1.0f, 0.0f, 0.0f, Ingredient.of(ItemsRegistry.COPPER_INGOT.get()), false),
    BRONZE("bronze", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, 0.0f, Ingredient.of(ItemsRegistry.BRONZE_INGOT.get()), false),
    IRON("iron", 20, new int[] {2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 1.0f, 0.0f, 0.0f, Ingredient.of(Items.IRON_INGOT), false),
    STEEL("steel", 33, new int[] {3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, 0.0f, Ingredient.of(ItemsRegistry.STEEL_INGOT.get()), false),
    GILDED_NETHERITE("gilded_netherite", 25, new int[] {3, 6, 7, 2}, 22, SoundEvents.ARMOR_EQUIP_NETHERITE, 1.0f, 0.1f, 0.0f, Ingredient.of(Items.NETHERITE_INGOT), true),
    DIAMONDED_NETHERITE("diamonded_netherite", 37, new int[] {3, 6, 8, 3}, 12, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, 0.3f, -0.05f, Ingredient.of(Items.NETHERITE_INGOT), false);
    
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionForSlot;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final float speedModifier;
    private final Ingredient repairMaterial;
    private final boolean isGold;
    
    ModArmorMaterials(String name, int durability, int[] protection, int enchantment, SoundEvent sound, float toughness, float knockbackResistance, float speed, Ingredient repairMaterial, boolean isGold) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.protectionForSlot = protection;
        this.enchantmentValue = enchantment;
        this.equipSound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.speedModifier = speed;
        this.repairMaterial = repairMaterial;
        this.isGold = isGold;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return BASE_DURABILITY[slot.getIndex()] * this.durabilityMultiplier;
    }
    
    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        return this.protectionForSlot[slot.getIndex()];
    }
    
    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }
    
    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
    
    @Override
    public float getToughness() {
        return this.toughness;
    }
    
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
    
    public float getSpeedModifier() {
        return this.speedModifier;
    }
    
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial;
    }
    
    public boolean isGold() {
        return this.isGold;
    }
}
