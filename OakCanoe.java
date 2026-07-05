// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class OakCanoe<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "oakcanoe"), "main");
	private final ModelPart bone2;
	private final ModelPart bone;

	public OakCanoe(ModelPart root) {
		this.bone2 = root.getChild("bone2");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(88, 84).addBox(-12.075F, 3.0F, -13.0F, 12.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-13.075F, 5.0F, -47.0F, 14.0F, 3.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offset(6.075F, 17.5F, 24.0F));

		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(88, 97).addBox(-5.0F, 0.0F, -12.0F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 49).addBox(-5.0F, -2.0F, -32.0F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
		.texOffs(44, 84).addBox(-5.0F, -2.0F, 1.0F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -16.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(74, 49).addBox(-5.0F, -2.0F, -32.0F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
		.texOffs(0, 84).addBox(-5.0F, -2.0F, 1.0F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, -16.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 101).addBox(-5.0F, -1.0F, -12.0F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -48.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.3F, 26.0F, 11.05F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(38, 101).addBox(-2.0F, 1.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1779F, -0.4952F, 0.0322F));

		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 101).addBox(-0.9655F, -3.9041F, -0.6932F, 2.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, -12.0F, -1.35F, 0.1779F, -0.4952F, 0.0322F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}