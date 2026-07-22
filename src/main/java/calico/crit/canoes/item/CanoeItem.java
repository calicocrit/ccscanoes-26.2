package calico.crit.canoes.item;

import calico.crit.canoes.entity.CanoeEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.function.Supplier;

public class CanoeItem extends Item {
    private final Supplier<EntityType<? extends CanoeEntity>> entityTypeSupplier;

    public CanoeItem(Supplier<EntityType<? extends CanoeEntity>> entityTypeSupplier, Properties properties) {
        super(properties);
        this.entityTypeSupplier = entityTypeSupplier;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult hit = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hit.getType() == HitResult.Type.MISS) {
            return InteractionResult.PASS;
        }
        Vec3 vec3 = player.getViewVector(1.0F);
        if (hit.getType() == HitResult.Type.BLOCK) {
            Vec3 vec32 = player.getEyePosition();
            double d0 = vec3.distanceToSqr(vec32);
            if (d0 > 9.0) {
                return InteractionResult.PASS;
            }
        }
        Vec3 spawnPos = hit.getLocation();
        if (!level.isClientSide()) {
            EntityType<? extends CanoeEntity> entityType = entityTypeSupplier.get();
            CanoeEntity entity = entityType.create(level, net.minecraft.world.entity.EntitySpawnReason.SPAWN_ITEM_USE);
            if (entity != null) {
                entity.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
                entity.setYRot(player.getYRot());
                level.addFreshEntity(entity);
                level.gameEvent(player, GameEvent.ENTITY_PLACE, spawnPos);
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.SUCCESS;
    }
}
