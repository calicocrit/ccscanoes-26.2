package calico.crit.canoes.entity;

import calico.crit.canoes.CCsCanoes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.function.Supplier;

public class CanoeEntity extends AbstractBoat {

    public CanoeEntity(EntityType<? extends CanoeEntity> type, Level level) {
        super(type, level, getDropForType(type));
    }

    private static Supplier<Item> getDropForType(EntityType<?> type) {
        if (type == CCsCanoes.SPRUCE_CANOE.get()) {
            return () -> CCsCanoes.SPRUCE_CANOE_ITEM.get();
        }
        return () -> CCsCanoes.OAK_CANOE_ITEM.get();
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
        super.checkFallDamage(y, onGround, state, pos);
        if (this.level() instanceof ServerLevel serverLevel && onGround && this.fallDistance > 3.0F) {
            this.kill(serverLevel);
            this.destroyCanoeDrops(serverLevel);
        }
    }

    private void destroyCanoeDrops(ServerLevel level) {
        if (this.getType() == CCsCanoes.SPRUCE_CANOE.get()) {
            this.spawnAtLocation(level, new ItemStack(Blocks.SPRUCE_PLANKS, 3));
            this.spawnAtLocation(level, new ItemStack(Items.STICK, 2));
        } else {
            this.spawnAtLocation(level, new ItemStack(Blocks.OAK_PLANKS, 3));
            this.spawnAtLocation(level, new ItemStack(Items.STICK, 2));
        }
    }

    @Override
    protected double rideHeight(EntityDimensions dimensions) {
        return 0.11F;
    }

    @Override
    protected int getMaxPassengers() {
        return 1;
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float partialTick) {
        float yawRads = -this.getYRot() * (float) (Math.PI / 180.0);
        double zOffset = -0.75;
        double x = Math.sin(yawRads) * zOffset;
        double z = Math.cos(yawRads) * zOffset;
        return new Vec3(x, 0.32, z);
    }
}
