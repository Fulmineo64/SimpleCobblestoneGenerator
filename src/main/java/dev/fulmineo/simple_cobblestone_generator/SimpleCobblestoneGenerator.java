package dev.fulmineo.simple_cobblestone_generator;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandlerType;
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
	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID,"group")).icon(() -> new ItemStack(Registries.ITEM.get(new Identifier(MOD_ID,"generator_tier1")))).build();

	public static final int[] TIERS = {32, 16, 8, 4, 1};

	// Screens

    public static final ScreenHandlerType<CobblestoneGeneratorScreenHandler> SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(MOD_ID, "generator"), CobblestoneGeneratorScreenHandler::new);

    @Override
    public void onInitialize() {
		CobblestoneGeneratorsInit.init();
    }

	public static void info(String message){
        LOGGER.log(Level.INFO, message);
    }
}