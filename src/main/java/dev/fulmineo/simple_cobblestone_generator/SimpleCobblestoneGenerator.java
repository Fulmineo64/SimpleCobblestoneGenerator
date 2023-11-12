package dev.fulmineo.simple_cobblestone_generator;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.fulmineo.simple_cobblestone_generator.init.CobblestoneGeneratorsInit;
import dev.fulmineo.simple_cobblestone_generator.screen.CobblestoneGeneratorScreenHandler;

public class SimpleCobblestoneGenerator implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger();

    // Identifiers

    public static final String MOD_ID = "simple_cobblestone_generator";

	public static final int[] TIERS = {32, 16, 8, 4, 1};

	// Screens

    public static final ScreenHandlerType<CobblestoneGeneratorScreenHandler> SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(MOD_ID, "generator"), CobblestoneGeneratorScreenHandler::new);
	
    // Item groups

	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "group"));


    @Override
    public void onInitialize() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder().displayName(Text.translatable("itemGroup.simple_cobblestone_generator.group")).icon(() -> new ItemStack(Registries.ITEM.get(new Identifier(MOD_ID,"generator_tier1")))).build());
		CobblestoneGeneratorsInit.init();
    }

	public static void info(String message){
        LOGGER.log(Level.INFO, message);
    }
}