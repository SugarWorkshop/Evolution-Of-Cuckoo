package io.github.sugarmgp.eoc.handler;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.entity.EntitySugarMGP;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeHandler {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, EOC.MODID);
    public static final RegistryObject<EntityType<EntitySugarMGP>> entitySugarMGP = ENTITY_TYPES.register("sugarmgp", () -> EntityType.Builder.create(EntitySugarMGP::new, EntityClassification.CREATURE).size(0.6F, 1.8F).build("sugarmgp"));
}
