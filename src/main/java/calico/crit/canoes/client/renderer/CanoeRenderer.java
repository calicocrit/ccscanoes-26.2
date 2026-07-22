package calico.crit.canoes.client.renderer;

import calico.crit.canoes.entity.CanoeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

import java.util.function.Function;
import net.minecraft.client.model.geom.ModelPart;

public class CanoeRenderer extends EntityRenderer<CanoeEntity, CanoeRenderState> {
    private final EntityModel<CanoeRenderState> model;
    private final Identifier texture;

    public CanoeRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation layer, Identifier texture,
            Function<ModelPart, EntityModel<CanoeRenderState>> modelFactory) {
        super(ctx);
        this.model = modelFactory.apply(ctx.bakeLayer(layer));
        this.texture = texture;
        this.shadowRadius = 0.8F;
    }

    @Override
    public CanoeRenderState createRenderState() {
        return new CanoeRenderState();
    }

    @Override
    public void extractRenderState(CanoeEntity entity, CanoeRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yRot = entity.getYRot();
        state.hurtDir = entity.getHurtDir();
        state.hurtTime = (float) entity.getHurtTime() - partialTick;
        state.damageTime = entity.getDamage();
        state.bubbleAngle = entity.getBubbleAngle(partialTick);
        state.rowingTimeLeft = entity.getRowingTime(0, partialTick);
        state.rowingTimeRight = entity.getRowingTime(1, partialTick);
    }

    @Override
    public void submit(CanoeRenderState state, PoseStack poseStack, SubmitNodeCollector collector,
            net.minecraft.client.renderer.state.level.CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.translate(0.0, 1.85, 0.0);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - state.yRot));
        if (state.hurtTime > 0.0F) {
            poseStack.mulPose(Axis.XP.rotationDegrees(
                    Mth.sin(state.hurtTime) * state.hurtTime * state.damageTime / 10.0F * (float) state.hurtDir));
        }
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        model.setupAnim(state);
        collector.submitModel(model, state, poseStack, texture, state.lightCoords, OverlayTexture.NO_OVERLAY,
                state.outlineColor, null);
        poseStack.popPose();
        super.submit(state, poseStack, collector, camera);
    }
}
