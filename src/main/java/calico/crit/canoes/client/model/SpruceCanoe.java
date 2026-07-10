package calico.crit.canoes.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.Identifier;

public class SpruceCanoe extends EntityModel<EntityRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("ccscanoes", "sprucecanoe"), "main");

	public SpruceCanoe(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(2, 88).addBox(-12.075F, 3.0F, -13.0F, 12.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(3, 2).addBox(-13.075F, 5.0F, -47.0F, 14.0F, 3.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offset(6.075F, 17.5F, 24.0F));

		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 101).addBox(-5.0F, 0.0F, -12.0F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 51).addBox(-5.0F, -2.0F, -32.0F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
		.texOffs(98, 86).addBox(-5.0F, -2.0F, 1.0F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -16.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(74, 51).addBox(-5.0F, -2.0F, -32.0F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
		.texOffs(50, 86).addBox(-5.0F, -2.0F, 1.0F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, -16.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(38, 103).addBox(-5.0F, -1.0F, -12.0F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -48.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.3F, 26.0F, 11.05F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(78, 103).addBox(-2.0F, 1.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1779F, -0.4952F, 0.0322F));

		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(71, 104).addBox(-0.9655F, -3.9041F, -0.6932F, 2.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, -12.0F, -1.35F, 0.1779F, -0.4952F, 0.0322F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(EntityRenderState state) {
	}
}
