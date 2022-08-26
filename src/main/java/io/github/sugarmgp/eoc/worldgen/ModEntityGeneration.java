package io.github.sugarmgp.eoc.worldgen;

import io.github.sugarmgp.eoc.handler.EntityHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

public class ModEntityGeneration {
    public static void onEntitySpawn(BiomeLoadingEvent event) {
        RegistryKey<Biome>[] biomes = new RegistryKey[]{
                Biomes.PLAINS,
                Biomes.SUNFLOWER_PLAINS,
                Biomes.SNOWY_TUNDRA,
                Biomes.FLOWER_FOREST,
                Biomes.ICE_SPIKES
        };
        addUseWhitelist(event, EntityHandler.entitySugarMGP.get(), 10, 1, 4, biomes);
    }

    //使用黑名单
    private static void addUseBlacklist(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes) {
        if (!Arrays.stream(biomes).map(RegistryKey::getLocation).map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()))) {
            addEntityToBiome(event, type, weight, minCount, maxCount);
        }
    }

    //使用白名单
    @SafeVarargs
    private static void addUseWhitelist(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes) {
        if (Arrays.stream(biomes).map(RegistryKey::getLocation).map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()))) {
            addEntityToBiome(event, type, weight, minCount, maxCount);
        }
    }

    //在群系生成该生物
    private static void addEntityToBiome(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getClassification());
        base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
    }
}
