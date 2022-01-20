package me.lucasgithuber.elementmanipulation.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.lucasgithuber.elementmanipulation.Items;
import me.lucasgithuber.elementmanipulation.elements.Elements;
import me.lucasgithuber.elementmanipulation.utils.DeconstructorGUI;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class EMDeconstructor extends DeconstructorGUI implements RecipeDisplayItem {

    public EMDeconstructor(ItemGroup c) {

        super(c, Items.EMDeconstructor, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.POWER_CRYSTAL, SlimefunItems.ELECTRIC_ORE_GRINDER_3, SlimefunItems.POWER_CRYSTAL,
                SlimefunItems.REINFORCED_PLATE, SlimefunItems.NUCLEAR_REACTOR, SlimefunItems.REINFORCED_PLATE,
                SlimefunItems.REINFORCED_PLATE, SlimefunItems.LARGE_CAPACITOR, SlimefunItems.REINFORCED_PLATE
        });
        this.setProcessingSpeed(1).setCapacity(256).setEnergyConsumption(128);

    }

    public void registerDefaultRecipes() {

        registerRecipe(4, new ItemStack[] {new ItemStack(Material.WATER_BUCKET)},
                new ItemStack[] {new ItemStack(Material.BUCKET),
                        new CustomItemStack(Elements.EMHydrogen, 2), new CustomItemStack(Elements.EMOxygen, 1)
                });

        registerRecipe(4, new ItemStack[] {new ItemStack(Material.CARROT)},
                new ItemStack[] {new CustomItemStack(Elements.EMCarbon, 20)
                });

        registerRecipe(4, new ItemStack[] {new ItemStack(Material.COCOA_BEANS)},
                new ItemStack[] {new CustomItemStack(Elements.EMCarbon, 7),
                        new CustomItemStack(Elements.EMHydrogen, 8)
                });

        registerRecipe(4, new ItemStack[] {new ItemStack(Material.NETHER_WART)},
                new ItemStack[] {new CustomItemStack(Elements.EMCarbon, 19),
                        new CustomItemStack(Elements.EMHydrogen, 14),

                });

        registerRecipe(4, new ItemStack[] {new ItemStack(Material.POTATO)},
                new ItemStack[] {new CustomItemStack(Elements.EMCarbon, 6),
                        new CustomItemStack(Elements.EMHydrogen, 10),
                        new CustomItemStack(Elements.EMNitrogen,1)
                });

        registerRecipe(4, new ItemStack[] {new ItemStack(Material.PUMPKIN_SEEDS)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMHydrogen, 3),
                        new CustomItemStack(Elements.EMOxygen, 2),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.SWEET_BERRIES)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMHydrogen, 12),
                        new CustomItemStack(Elements.EMOxygen, 12),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.WHEAT_SEEDS)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMCarbon, 3),
                        new CustomItemStack(Elements.EMOxygen, 3),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.APPLE)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMHydrogen, 5),
                        new CustomItemStack(Elements.EMCarbon, 5),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.BEETROOT_SEEDS)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMHydrogen, 8),
                        new CustomItemStack(Elements.EMCarbon, 12),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.BONE)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMCalcium, 6),
                        new CustomItemStack(Elements.EMOxygen, 6),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.GOLD_INGOT)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMAu, 8),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.INK_SAC)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMCarbon, 4),
                        new CustomItemStack(Elements.EMHydrogen, 12),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.REDSTONE, 64)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMCopper, 8),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.LAPIS_LAZULI, 64)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMSodium, 8),
                        new CustomItemStack(Elements.EMCalcium, 8),
                        new CustomItemStack(Elements.EMSilicon, 4),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.MELON_SEEDS, 64)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMHydrogen, 6),
                        new CustomItemStack(Elements.EMCarbon, 4),
                        new CustomItemStack(Elements.EMOxygen, 2),
                });
        registerRecipe(4, new ItemStack[] {new ItemStack(Material.POISONOUS_POTATO, 64)},
                new ItemStack[] {
                        new CustomItemStack(Elements.EMHydrogen, 5),
                        new CustomItemStack(Elements.EMCarbon, 5),
                        new CustomItemStack(Elements.EMOxygen, 2),
                        new CustomItemStack(Elements.EMOxygen, 2),
                });



    }
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 8);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(recipe.getInput()[0]);

            for (ItemStack output : recipe.getOutput()) {
                displayRecipes.add(output);
                displayRecipes.add(new ItemStack(Material.AIR));
            }

            displayRecipes.add(new ItemStack(Material.AIR));
        }

        return displayRecipes;
    }
    @Override
    public ItemStack getProgressBar() {
        return new CustomItemStack(Material.EMERALD, "Deconstructing");
    }
    @Nonnull
    @Override
    public String getMachineIdentifier() {
        return "EM_DECONSTRUCTOR";
    }
    @Override
    public String getInventoryTitle() {
        return "&8Deconstructor";
    }
    @Override
    public int getCapacity() {
        return 256;
    }

    @Override
    public int getEnergyConsumption() {
        return 128;
    }

    @Override
    public int getSpeed() {
        return 1;
    }
        };
