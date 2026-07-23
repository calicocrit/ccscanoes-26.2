package calico.crit.canoes.client.model;

import calico.crit.canoes.client.renderer.CanoeRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public abstract class CanoeModel extends EntityModel<CanoeRenderState> {
	protected final ModelPart bone;

	public CanoeModel(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
	}

	@Override
	public void setupAnim(CanoeRenderState state) {
		super.setupAnim(state);
		this.bone.resetPose();
		this.bone.xRot += state.paddleXRot;
		this.bone.yRot += state.paddleYRot;
		this.bone.zRot += state.paddleZRot;
	}

	public record CanoeTextureOffsets(
			int bone2Box1U, int bone2Box1V,
			int bone2Box2U, int bone2Box2V,
			int r1U, int r1V,
			int r2Box1U, int r2Box1V,
			int r2Box2U, int r2Box2V,
			int r3Box1U, int r3Box1V,
			int r3Box2U, int r3Box2V,
			int r4U, int r4V,
			int r5U, int r5V,
			int r6U, int r6V) {
	}

	public static LayerDefinition createCanoeLayer(CanoeTextureOffsets offsets) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create()
				.texOffs(offsets.bone2Box1U(), offsets.bone2Box1V())
				.addBox(-12.075F, 3.0F, -13.0F, 12.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(offsets.bone2Box2U(), offsets.bone2Box2V())
				.addBox(-13.075F, 5.0F, -47.0F, 14.0F, 3.0F, 46.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.075F, 17.5F, 24.0F));

		bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create()
				.texOffs(offsets.r1U(), offsets.r1V())
				.addBox(-5.0F, 0.0F, -12.0F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create()
				.texOffs(offsets.r2Box1U(), offsets.r2Box1V())
				.addBox(-5.0F, -2.0F, -32.0F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
				.texOffs(offsets.r2Box2U(), offsets.r2Box2V())
				.addBox(-5.0F, -2.0F, 1.0F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0F, -16.0F, 0.0F, 0.0F, -1.5708F));

		bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create()
				.texOffs(offsets.r3Box1U(), offsets.r3Box1V())
				.addBox(-5.0F, -2.0F, -32.0F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
				.texOffs(offsets.r3Box2U(), offsets.r3Box2V())
				.addBox(-5.0F, -2.0F, 1.0F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.0F, 0.0F, -16.0F, 0.0F, 0.0F, -1.5708F));

		bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create()
				.texOffs(offsets.r4U(), offsets.r4V())
				.addBox(-5.0F, -1.0F, -12.0F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -48.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-10.3F, 26.0F, 11.05F, 0.3491F, 0.0F, 0.0F));

		bone.addOrReplaceChild("cube_r5", CubeListBuilder.create()
				.texOffs(offsets.r5U(), offsets.r5V())
				.addBox(-2.0F, 1.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1779F, -0.4952F, 0.0322F));

		bone.addOrReplaceChild("cube_r6", CubeListBuilder.create()
				.texOffs(offsets.r6U(), offsets.r6V())
				.addBox(-0.9655F, -3.9041F, -0.6932F, 2.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.1F, -12.0F, -1.35F, 0.1779F, -0.4952F, 0.0322F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
}
